import com.typesafe.scalalogging.Logger
import meta.deep.runtime.{Actor, Message}
import meta.example.supermarket.goods.onDisplay
import meta.example.supermarket.worldmap.WorldTrait
import meta.example.supermarket.{SupermarketTrait, granularity}
import org.apache.log4j.BasicConfigurator

import scala.collection.mutable.ListBuffer

object supermarketSimulation extends App {

  //  var actors: Array[Actor] = Array()
  var actors: List[Actor] = List()
  var messages: List[Message] = List()
  var timer: Int = 0
  var until: Int = 10 * granularity.hour
  val memUnit: Int = 1024 // KB
  val runtime = Runtime.getRuntime
  BasicConfigurator.configure()
  val logger = Logger("Root")
  var supermarkets: ListBuffer[SupermarketTrait] = new ListBuffer[SupermarketTrait]
  var worldMap: WorldTrait = _

  def init(): Unit = {
    //    actors = generated.InitData.initActors.to[Array]
    actors = generated.InitData.initActors
  }

  def collect(current_time: Int): Unit = {
    meta.deep.runtime.Actor.newActors.foreach(i => i.timer = current_time)
    actors = actors ::: meta.deep.runtime.Actor.newActors.toList
    meta.deep.runtime.Actor.newActors.clear()
  }

  def main(): Unit = {
    init()
    for (i <- actors.indices) {
      if (actors(i).getClass.getSimpleName == "Supermarket") {
        supermarkets += actors(i).asInstanceOf[SupermarketTrait]
      }
    }
    val start = System.nanoTime()


    while (timer <= until) {
      println("TIMER", timer)
      for (i <- actors.indices) {
        if (actors(i).writer != null) {
          actors(i).writer.write(actors(i).getString())
          actors(i).writer.flush()
        }
      }
      val mx = messages.groupBy(_.receiverId)
      // remove invalid actors
      supermarkets.foreach {
        supermarket =>
          while (supermarket.isInvalids.nonEmpty) {
            val toRemove = supermarket.isInvalids.dequeue()
            actors = actors.filter(_.id != toRemove)
          }
      }
      for (i <- actors.indices) {
        if (actors(i).getClass.getSimpleName == "Farmer") {
          actors(i).cleanSendMessage.addReceiveMessages(mx.getOrElse(actors(i).id, List())).run_until(timer)
        }
      }
      collect(timer)
      actors = actors.map { a => {
        a.cleanSendMessage
          .addReceiveMessages(mx.getOrElse(a.id, List()))
          .run_until(timer)
      }
      }
      messages = actors.flatMap(_.getSendMessages)
      timer += 1
    }
    for (i <- actors.indices) {
      if (actors(i).writer != null) {
        actors(i).writer.close()
      }
    }
    val end = System.nanoTime()
    val consumed = end - start
    println("Time consumed", consumed)
  }
  main()
}