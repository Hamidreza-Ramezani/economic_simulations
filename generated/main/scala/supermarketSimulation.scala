import meta.deep.runtime.{Actor, Message}
import meta.example.supermarket.{SectionTrait, SupermarketTrait, granularity}
import com.typesafe.scalalogging.Logger
import meta.example.supermarket.people.{CashierTrait, EmployeeTrait}
import org.apache.log4j.BasicConfigurator
import meta.example.supermarket.worldmap.World

import scala.util.Random

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
  var supermarket: SupermarketTrait = _
  val mapWidth = 10
  val mapHeight = 10
  val worldMap = new World(mapWidth, mapHeight)


  def init(): Unit = {
    //    actors = generated.InitData.initActors.to[Array]
    actors = generated.InitData.initActors
  }

  def collect(current_time: Int): Unit = {
    meta.deep.runtime.Actor.newActors.foreach(i => i.timer = current_time)
    actors = actors ::: meta.deep.runtime.Actor.newActors.toList
    meta.deep.runtime.Actor.newActors.toList.foreach(actor => worldMap.addEntity(actor))
    meta.deep.runtime.Actor.newActors.clear()
  }

  def main(): Unit = {
    init()
    for (i <- actors.indices) {
      if (actors(i).getClass.getSimpleName == "Supermarket") {
        supermarket = actors(i).asInstanceOf[SupermarketTrait]
      }
    }

    for (i <- actors.indices) {
      if (actors(i).getClass.getSimpleName == "Section") {
        actors(i).asInstanceOf[SectionTrait].supermarket = supermarket
      }
    }

    for (i <- actors.indices) {
      actors(i).setInitialPosition(Random.nextInt(mapWidth), Random.nextInt(mapHeight))
      worldMap.addEntity(actors(i))
    }

    for (i <- actors.indices) {
      if (actors(i).getClass.getSimpleName == "Employee") {
        supermarket.employees += actors(i).asInstanceOf[EmployeeTrait]
      } else if (actors(i).getClass.getSimpleName == "Cashier") {
        supermarket.cashier = actors(i).asInstanceOf[CashierTrait]
      }
    }

    val start = System.nanoTime()
    while (timer <= until) {
      println("TIMER", timer)
      for (i <- actors.indices) {
        if (actors(i).writer != null) {
          actors(i).writer.write("\n \n" + "timer: " + timer + "\n \n")
          actors(i).writer.write("\n \n" + "position: x = " + actors(i).xPosition + "  y = " + actors(i).yPosition + "\n \n")
          actors(i).writer.flush()
        }
      }
      //      collect(timer)
      val mx = messages.groupBy(_.receiverId)
      // remove invalid actors
      while (supermarket.isInvalids.nonEmpty) {
        val toRemove = supermarket.isInvalids.dequeue()
        actors = actors.filter(_.id != toRemove)
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
