import java.io.{File, PrintWriter}

import meta.deep.runtime.{Actor, Message}
import meta.example.supermarket.{Supermarket, granularity}
import com.typesafe.scalalogging.Logger
import org.apache.log4j.BasicConfigurator

object supermarketSimulation extends App {

  //  var actors: Array[Actor] = Array()
  var actors: List[Actor] = List()
  var messages: List[Message] = List()
  var timer: Int = 0
  var until: Int = 10 * granularity.hour
  val shelfCapacity: Int = 10
  //  val unitLoad: Int = 5 //
  val memUnit: Int = 1024 // KB
  val runtime = Runtime.getRuntime
  BasicConfigurator.configure()
  val logger = Logger("Root")

  def init(): Unit = {
    //    actors = generated.InitData.initActors.to[Array]
    actors = generated.InitData.initActors
  }

  def collect(current_time: Int): Unit = {
    meta.deep.runtime.Actor.newActors.map(i => i.timer = current_time)
    actors = actors ::: meta.deep.runtime.Actor.newActors.toList
    meta.deep.runtime.Actor.newActors.clear()
  }

  val writer = new PrintWriter(new File("output.log"))

  def main(): Unit = {
    //    println(this.getClass.getClassLoader)
    init()
    val start = System.nanoTime()
    while (timer <= until) {
      val start_it = System.nanoTime()
      println("TIMER", timer)
      collect(timer)
      val mx = messages.groupBy(_.receiverId)
      // remove invalid actors
      while (Supermarket.store.isInvalids.size > 0) {
        val toRemove = Supermarket.store.isInvalids.dequeue()
        actors = actors.filter(_.id != toRemove)
      }
      //      addSupply

      for (i <- 0 to actors.length -1 ){
        if (actors(i).getClass.getName == "generated.Employee"){
          actors(i).cleanSendMessage.addReceiveMessages(mx.getOrElse(actors(i).id, List())).run_until(timer)
        }
      }
//      actors(10).cleanSendMessage.addReceiveMessages(mx.getOrElse(actors(10).id, List())).run_until(timer)
      actors = actors.map { a => {
        a.cleanSendMessage
          .addReceiveMessages(mx.getOrElse(a.id, List()))
          .run_until(timer)
      }
      }
      messages = actors.flatMap(_.getSendMessages).toList
      timer += 1
      //      println(Supermarket.store.isInvalids)
      writer.write("Timer " + (timer - 1) + " time: " + (System.nanoTime() - start_it) + " mem: " + (runtime.totalMemory - runtime.freeMemory) / memUnit + "\n")
    }
    writer.close()
    val end = System.nanoTime()
    val consumed = end - start
    println("Time consumed", consumed)
  }

  main()
}
