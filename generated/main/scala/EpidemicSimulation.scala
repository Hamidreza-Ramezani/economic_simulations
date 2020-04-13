import meta.deep.runtime.{Actor, Message}
import meta.example.epidemic.{Epidemic, Location}
import meta.example.epidemic.Location._
import meta.example.epidemic.Epidemic._
import meta.example.epidemic.State._
import meta.example.epidemic.Status._
import meta.example.epidemic.Epidemic.{agents, meetingAtHomeProb, meetingAtSchoolProb, meetingAtWorkProb}
import meta.example.epidemic.Utils.{prob2Bool, writeToFile}

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

//  def runSimulation(time_step: Int): Unit = {
//    agents.foreach { person =>
//      person.updateCurrentLocation(time_step)
//    }
//    var currentTime = time_step % 24;
//    if (currentTime > 8) {
//
//      agents.foreach { person1 =>
//        person1.location match {
//          case Location.atHome => {
//            person1.householdConnections.foreach { person2 =>
//              if (person2.location == atHome) {
//                if (prob2Bool(meetingAtHomeProb)) {
//                  person1.meet(person2, time_step);
//                }
//              }
//
//            }
//          }
//
//          case Location.atSchool => {
//            person1.schoolConnections.foreach { person2 =>
//              if (person2.location == atSchool) {
//                if (prob2Bool(meetingAtSchoolProb)) {
//                  person1.meet(person2, time_step);
//                }
//              }
//            }
//          }
//          case Location.atWork => {
//            person1.workConnections.foreach { person2 =>
//              if (person2.location == atWork) {
//                if (prob2Bool(meetingAtWorkProb)) {
//                  person1.meet(person2, time_step);
//                }
//              }
//            }
//          }
//          case _ =>
//
//          //TODO: write for in community
//        }
//      }
//    }
//    agents.foreach(person => person.individual_disease_progression())
//    // print all agents information
//    //      peopleInfo += "time: " + time_step.toString + "\n";
//    //      agents.foreach(person => peopleInfo += person.toString + "\n")
//
//    var numberOfInfectious = 0;
//    var numberOfInfected = 0;
//    var numberOfCriticalCare = 0;
//    var numberOfRecovered = 0;
//    var numberOfSusceptible = 0;
//
//    //		if (time_step % 24 == 0){
//    //			stat += "time: " + to_string(time_step) + " number of infectious people: ";
//    //			for (auto &person : agents) {
//    //				if (person->currentState == Infectious){
//    //					a ++;
//    //				}
//    //			}
//    //			stat += to_string(a) + "\n";
//    //		}
//    //		stat += "time: " + to_string(time_step) + " number of infectious people: ";
//
//    agents.foreach { person =>
//      if (person.state == Infectious) {
//        numberOfInfectious += 1;
//        numberOfInfected += 1;
//      } else if (person.state == Exposed) {
//        numberOfInfected += 1;
//      } else if (person.state == Recovered) {
//        numberOfRecovered += 1;
//      } else {
//        numberOfSusceptible += 1;
//      }
//    }
//    numberOfCriticalCare = numberOfInfected / 20;
//    numberOfInfectiousInfo += numberOfInfectious.toString + "\n";
//    numberOfInfectedInfo += numberOfInfected.toString + "\n";
//    numberOfCriticalCareInfo += numberOfCriticalCare.toString + "\n";
//    numberOfRecoveredInfo += numberOfRecovered.toString + "\n";
//    numberOfSusceptibleInfo += numberOfSusceptible.toString + "\n";
//    //    time_step += 1;
//
//  }

  def main(): Unit = {
    init()
    val start = System.nanoTime()

    while (timer <= until) {
      println("TIMER", timer)
      //      collect(timer)
      val mx = messages.groupBy(_.receiverId)

      //      runSimulation(timer)

      actors = actors.map { a => {
        a.cleanSendMessage
          .addReceiveMessages(Random.shuffle(mx.getOrElse(a.id, List())))
          .run_until(timer)
      }
      }
      messages = actors.flatMap(_.getSendMessages).toList
      timer += 1
    }
    //    writeToFile(peopleInfo, "PeopleInfo");
    //    writeToFile(numberOfInfectiousInfo, "numberOfInfectiousInfo.csv");
    //    writeToFile(numberOfInfectedInfo, "numberOfInfectedInfo.csv");
    //    writeToFile(numberOfCriticalCareInfo, "numberOfCriticalCareInfo.csv");
    //    writeToFile(numberOfRecoveredInfo, "numberOfRecoveredInfo.csv");
    //    writeToFile(numberOfSusceptibleInfo, "numberOfSusceptibleInfo.csv");

    val end = System.nanoTime()
    val consumed = end - start
    println("Time consumed", consumed)
  }

  main()
}
