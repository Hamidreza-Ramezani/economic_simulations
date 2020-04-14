package meta.example.epidemic

import meta.deep.runtime.Actor.AgentId
import meta.example.epidemic.Utils._
import meta.example.epidemic.Epidemic._
import meta.example.epidemic.State._
import meta.example.epidemic.Status._
import meta.example.epidemic.Location._

import scala.collection.mutable.ListBuffer

object Main {

  def main(args: Array[String]): Unit = {
    initialize_simulation()
    run_simulation()
  }

  def initialize_simulation(): Unit = {
    for (i <- 0 until populationSize) {
      var person: Person = new Person
      agents += person
      person.setState(Susceptible)
    }
    for (i <- 0 until initialNumberOfInfected) {
      var person = selectRandomly(agents.toList)
      person.setState(Exposed)
      person.timeOfInfection = 0
      person.infectedBy = 0
      person.infectedAt = "seed"

    }
    //for the whole people, initialize their home connections
    //pick 20% of samples and set their status to student, then initialize their schoolConnections
    //pick 75% of samples and set their status to employees, then initialize their workConnections
    val agentsCopy = agents.clone();
    var household: ListBuffer[Person] = ListBuffer[Person]()
    var workPlace: ListBuffer[Person] = ListBuffer[Person]()
    var school: ListBuffer[Person] = ListBuffer[Person]()

    //initializing all households
    while (agents.nonEmpty) {
      var i = myMin(getRandomHouseholdSize(), agents.size)
      for (j <- 0 until i) {
        var person = selectRandomly(agents.toList)
        household += person
        agents -= person
      }
      families += household.clone()
      addAllHomeConnections(household)
      household.clear()
    }
    agents = agentsCopy.clone()

    //set status randomly
    val numOfStudents = agents.size / 5;
    val numOfEmployees = agents.size * 3 / 4;

    //students
    for (j <- 0 until numOfStudents) {
      var randomStudent = selectRandomly(agents.toList)
      agents -= randomStudent
      students += randomStudent
      randomStudent.setStatus(student)
    }

    //employees
    for (j <- 0 until numOfEmployees) {
      var randomEmployee = selectRandomly(agents.toList)
      agents -= randomEmployee
      employees += randomEmployee
      randomEmployee.setStatus(employee);
    }

    //others
    while (agents.nonEmpty) {
      var person = selectRandomly(agents.toList)
      agents -= person
      person.setStatus(other)
    }
    agents = agentsCopy.clone()

    //initializing all workplaces
    var employees_copy = employees.clone();
    while (employees.nonEmpty) {
      var i = myMin(getRandomWorkplaceSize(), employees.size)
      for (j <- 0 until i) {
        var person = selectRandomly(employees.toList)
        workPlace += person
        employees -= person
      }
      workPlaces += workPlace.clone()
      addAllWorkConnections(workPlace)
      workPlace.clear()
    }
    employees = employees_copy.clone()

    //initializing all schools
    var students_copy = students.clone()
    while (students.nonEmpty) {
      var i = myMin(getRandomSchoolSize(), students.size)
      for (j <- 0 until i) {
        var person = selectRandomly(students.toList)
        school += person
        students -= person
      }
      schools += school.clone()
      addAllSchoolConnections(school);
      school.clear();
    }
    students = students_copy.clone()

    //write topologies to file
    //    writeHouseholdsToFile(families, "family");
    //    writeSchoolsToFile(schools, "school");
    //    writeWorkplacesToFile(workPlaces, "workplace");
  }

  def run_simulation(): Unit = {
    //    writeHouseholdsToFile(families, "family");
    //    writeSchoolsToFile(schools, "school");
    //    writeWorkplacesToFile(workPlaces, "workplace");
    var time_step = 0;
    var peopleInfo = "";
    var numberOfInfectiousInfo = "";
    var numberOfInfectedInfo = "";
    var numberOfCriticalCareInfo = "";
    var numberOfRecoveredInfo = "";
    var numberOfSusceptibleInfo = "";

    //the location of everybody should be specified
    while (time_step < period) {
      agents.foreach { person =>
        person.updateCurrentLocation(time_step)
      }
      var currentTime = time_step % 24;
      if (currentTime > 8) {

        agents.foreach { person1 =>
          person1.location match {
            case Location.atHome => {
              person1.householdConnections.foreach { person2 =>
                if (person2.location == atHome) {
                  if (prob2Bool(meetingAtHomeProb)) {
                    person1.meet(person2, time_step);
                  }
                }

              }
            }

            case Location.atSchool => {
              person1.schoolConnections.foreach { person2 =>
                if (person2.location == atSchool) {
                  if (prob2Bool(meetingAtSchoolProb)) {
                    person1.meet(person2, time_step);
                  }
                }
              }
            }
            case Location.atWork => {
              person1.workConnections.foreach { person2 =>
                if (person2.location == atWork) {
                  if (prob2Bool(meetingAtWorkProb)) {
                    person1.meet(person2, time_step);
                  }
                }
              }
            }
            case _ =>

            //TODO: write for in community
          }
        }
      }
      agents.foreach(person => person.individual_disease_progression())
      // print all agents information
      //      peopleInfo += "time: " + time_step.toString + "\n";
      //      agents.foreach(person => peopleInfo += person.toString + "\n")

      var numberOfInfectious = 0;
      var numberOfInfected = 0;
      var numberOfCriticalCare = 0;
      var numberOfRecovered = 0;
      var numberOfSusceptible = 0;

      //		if (time_step % 24 == 0){
      //			stat += "time: " + to_string(time_step) + " number of infectious people: ";
      //			for (auto &person : agents) {
      //				if (person->currentState == Infectious){
      //					a ++;
      //				}
      //			}
      //			stat += to_string(a) + "\n";
      //		}
      //		stat += "time: " + to_string(time_step) + " number of infectious people: ";

      agents.foreach { person =>
        if (person.state == Infectious) {
          numberOfInfectious += 1;
          numberOfInfected += 1;
        } else if (person.state == Exposed) {
          numberOfInfected += 1;
        } else if (person.state == Recovered) {
          numberOfRecovered += 1;
        } else {
          numberOfSusceptible += 1;
        }
      }
      numberOfCriticalCare = numberOfInfected / 20;
      numberOfInfectiousInfo += numberOfInfectious.toString + "\n";
      numberOfInfectedInfo += numberOfInfected.toString + "\n";
      numberOfCriticalCareInfo += numberOfCriticalCare.toString + "\n";
      numberOfRecoveredInfo += numberOfRecovered.toString + "\n";
      numberOfSusceptibleInfo += numberOfSusceptible.toString + "\n";
      time_step += 1;
    }
    //    writeToFile(peopleInfo, "PeopleInfo");
    writeToFile(numberOfInfectiousInfo, "numberOfInfectiousInfo.csv");
    writeToFile(numberOfInfectedInfo, "numberOfInfectedInfo.csv");
    writeToFile(numberOfCriticalCareInfo, "numberOfCriticalCareInfo.csv");
    writeToFile(numberOfRecoveredInfo, "numberOfRecoveredInfo.csv");
    writeToFile(numberOfSusceptibleInfo, "numberOfSusceptibleInfo.csv");
  }


}
