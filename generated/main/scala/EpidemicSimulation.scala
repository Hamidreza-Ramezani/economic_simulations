import java.io.{File, PrintWriter}

import meta.deep.runtime.{Actor, Message}
import meta.example.epidemic.{Epidemic, Location, Person}
import meta.example.epidemic.Location._
import meta.example.epidemic.Epidemic._
import meta.example.epidemic.State._
import meta.example.epidemic.Status._
import meta.example.epidemic.Epidemic.{agents, meetingAtHomeProb, meetingAtSchoolProb, meetingAtWorkProb}
import meta.example.epidemic.Utils.{prob2Bool, writeToFile}

import scala.collection.mutable.ListBuffer
import scala.util.Random

object EpidemicSimulation extends App {

  var actors: List[Actor] = List()
  var messages: List[Message] = List()
  var timer: Int = 0
  var until: Int = Epidemic.period

  var numberOfInfectiousInfo = "";
  var numberOfInfectedInfo = "";
  var numberOfCriticalCareInfo = "";
  var numberOfRecoveredInfo = "";
  var numberOfSusceptibleInfo = "";


  def init(): Unit = {
    actors = generated.InitData.initActors
  }

  def collect(current_time: Int): Unit = {
    meta.deep.runtime.Actor.newActors.map(i => i.timer = current_time)
    actors = actors ::: meta.deep.runtime.Actor.newActors.toList
    meta.deep.runtime.Actor.newActors.clear()
  }

  def writeToFile(data: String, name: String): Unit = {
    val writer = new PrintWriter(new File("epidemic_generated/" + name))
    writer.write(data)
    writer.close()
  }

  def writeWorkplacesToFile(data: ListBuffer[ListBuffer[Person]], name: String): Unit = {
    var str: String = "";
    data.toList.foreach { colleagues =>
      str += "workplace: \n";
      colleagues.toList.foreach { person =>
        str += "id: " + person.id.toString + "\t";
      }
      str += "\n \n \n";
    }
    val writer = new PrintWriter(new File("epidemic_generated/" + name))
    writer.write(str)
    writer.close()
  }

  def writeSchoolsToFile(data: ListBuffer[ListBuffer[Person]], name: String): Unit = {
    var str: String = "";
    data.toList.foreach { group =>
      str += "school: \n";
      group.toList.foreach { person =>
        str += "id: " + person.id.toString + "\t";
      }
      str += "\n \n \n";
    }
    val writer = new PrintWriter(new File("epidemic_generated/" + name))
    writer.write(str)
    writer.close()
  }

  def writeHouseholdsToFile(data: ListBuffer[ListBuffer[Person]], name: String): Unit = {
    var str: String = "";
    data.toList.foreach { family =>
      str += "family: \n";
      family.toList.foreach { person =>
        str += "id: " + person.id.toString + "\t";
      }
      str += "\n \n \n";
    }
    val writer = new PrintWriter(new File("epidemic_generated/" + name))
    writer.write(str)
    writer.close()
  }

//  override def toString = s"Person(id=$id, timeOfInfection=$timeOfInfection, infectedBy=$infectedBy, InfectedAt=$sourceOfInfection, state=$state, location=$location, status=$status)"


  def main(): Unit = {
    init()
    val start = System.nanoTime()
    var peopleInfo = "";
    var numberOfInfectiousInfo = "";
    var numberOfInfectedInfo = "";
    var numberOfCriticalCareInfo = "";
    var numberOfRecoveredInfo = "";
    var numberOfSusceptibleInfo = "";

    while (timer <= until) {
      var numberOfInfectious = 0;
      var numberOfInfected = 0;
      var numberOfCriticalCare = 0;
      var numberOfRecovered = 0;
      var numberOfSusceptible = 0;

      println("TIMER", timer)
      //      collect(timer)
      val mx = messages.groupBy(_.receiverId)


      actors = actors.map { a => {
        a.cleanSendMessage
          .addReceiveMessages(Random.shuffle(mx.getOrElse(a.id, List())))
          .run_until(timer)
      }
      }

//      peopleInfo += "time: " + timer.toString + "\n";
//      actors.foreach { person =>
//        if (person.isInstanceOf[generated.Person]) {
//          peopleInfo += s"Person(id=${person.asInstanceOf[generated.Person].id}, " +
//            s"timeOfInfection=${person.asInstanceOf[generated.Person].timeOfInfection}," +
//            s" infectedBy=${person.asInstanceOf[generated.Person].infectedBy}," +
//            s" InfectedAt=${person.asInstanceOf[generated.Person].infectedAt}," +
//            s" state=${person.asInstanceOf[generated.Person].state}," +
//            s" location=${person.asInstanceOf[generated.Person].location}," +
//            s" status=${person.asInstanceOf[generated.Person].status})" + "\n"
//        }
//      }


      actors.foreach { person =>
        if (person.isInstanceOf[generated.Person]) {
          if (person.asInstanceOf[generated.Person].state == Infectious) {
            numberOfInfectious += 1;
            numberOfInfected += 1;
          } else if (person.asInstanceOf[generated.Person].state == Exposed) {
            numberOfInfected += 1;
          } else if (person.asInstanceOf[generated.Person].state == Recovered) {
            numberOfRecovered += 1;
          } else {
            numberOfSusceptible += 1;
          }
        }
      }

      numberOfCriticalCare = numberOfInfected / 20;
      numberOfInfectiousInfo += numberOfInfectious.toString + "\n";
      numberOfInfectedInfo += numberOfInfected.toString + "\n";
      numberOfCriticalCareInfo += numberOfCriticalCare.toString + "\n";
      numberOfRecoveredInfo += numberOfRecovered.toString + "\n";
      numberOfSusceptibleInfo += numberOfSusceptible.toString + "\n";
      messages = actors.flatMap(_.getSendMessages).toList
      timer += 1
    }
//    writeToFile(peopleInfo, "PeopleInfo");
    writeToFile(numberOfInfectiousInfo, "numberOfInfectiousInfo.csv");
    writeToFile(numberOfInfectedInfo, "numberOfInfectedInfo.csv");
    writeToFile(numberOfCriticalCareInfo, "numberOfCriticalCareInfo.csv");
    writeToFile(numberOfRecoveredInfo, "numberOfRecoveredInfo.csv");
    writeToFile(numberOfSusceptibleInfo, "numberOfSusceptibleInfo.csv");

    val end = System.nanoTime()
    val consumed = end - start
    println("Time consumed", consumed)
  }

  main()
}
