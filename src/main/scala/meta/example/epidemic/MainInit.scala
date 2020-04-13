package meta.example.epidemic

import meta.deep.runtime.Actor
import meta.example.epidemic.Epidemic._
import meta.example.epidemic.State._
import meta.example.epidemic.Status._
import meta.example.epidemic.Utils._
import squid.quasi.lift

import scala.collection.mutable.ListBuffer

@lift
class MainInit {

  def main(): List[Actor] = {

    var agents: ListBuffer[Person] = ListBuffer[Person]()
    for (i <- 0 until populationSize) {
      var person: Person = new Person
      agents += person
      //      person.setState(Susceptible)
      person.state = Susceptible
    }
    for (i <- 0 until initialNumberOfInfected) {
      var person = selectRandomly(agents.toList)
      //      person.setState(Exposed)
      person.state = Exposed
      person.timeOfInfection = 0
      person.infectedBy = 0
      person.sourceOfInfection = "seed"
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
      randomStudent.status = student
    }

    //employees
    for (j <- 0 until numOfEmployees) {
      var randomEmployee = selectRandomly(agents.toList)
      agents -= randomEmployee
      employees += randomEmployee
      randomEmployee.status = employee
    }

    //others
    while (agents.nonEmpty) {
      var person = selectRandomly(agents.toList)
      agents -= person
      person.status = other
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

    var listOfActors = agents.clone()
    listOfActors.toList
  }


}
