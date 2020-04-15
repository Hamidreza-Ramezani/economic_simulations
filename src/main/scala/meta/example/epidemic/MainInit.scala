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
  //  var agents: ListBuffer[Person] = ListBuffer[Person]()
  //  var students: ListBuffer[Person] = ListBuffer[Person]()
  //  var employees: ListBuffer[Person] = ListBuffer[Person]()
  //  var families: ListBuffer[ListBuffer[Person]] = ListBuffer[ListBuffer[Person]]()
  //  var schools: ListBuffer[ListBuffer[Person]] = ListBuffer[ListBuffer[Person]]()
  //  var workPlaces: ListBuffer[ListBuffer[Person]] = ListBuffer[ListBuffer[Person]]()


  def main(): List[Actor] = {
    var agents: ListBuffer[Person] = ListBuffer[Person]()
    var students: ListBuffer[Person] = ListBuffer[Person]()
    var employees: ListBuffer[Person] = ListBuffer[Person]()
    var families: ListBuffer[ListBuffer[Person]] = ListBuffer[ListBuffer[Person]]()
    var schools: ListBuffer[ListBuffer[Person]] = ListBuffer[ListBuffer[Person]]()
    var workPlaces: ListBuffer[ListBuffer[Person]] = ListBuffer[ListBuffer[Person]]()

    for (i <- 0 until populationSize) {
      var person: Person = new Person
      agents += person
      person.state = Susceptible
    }
    var agentsCopy1 = agents.clone();
    for (i <- 0 until initialNumberOfInfected) {
      var person = selectRandomly(agentsCopy1.toList)
      person.state = Exposed
      person.timeOfInfection = 0
      person.infectedBy = 0
      person.infectedAt = "seed"
      agentsCopy1 -= person
    }
    //for the whole people, initialize their home connections
    //pick 20% of samples and set their status to student, then initialize their schoolConnections
    //pick 75% of samples and set their status to employees, then initialize their workConnections
    var agentsCopy2 = agents.clone();
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

      val household_copy1 = household.clone()
      var household_copy2 = household.clone()
      household_copy1.toList.foreach { person1 =>
        household_copy2 -= person1
        household_copy2.toList.foreach { person2 =>
          person1.householdConnections += person2;
        }
        household_copy2 = household_copy1.clone()
      }
      household.clear()
    }
    agents = agentsCopy2.clone()

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
    agents = agentsCopy2.clone()

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
      val workPlace_copy1 = workPlace.clone()
      var workPlace_copy2 = workPlace.clone()
      workPlace_copy1.foreach { employee1 =>
        workPlace_copy2 -= employee1
        workPlace_copy2.foreach { employee2 =>
          employee1.workConnections += employee2;
        }
        workPlace_copy2 = workPlace_copy1.clone()
      }
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
      var school_copy1 = school.clone()
      var school_copy2 = school.clone()
      school_copy1.toList.foreach { student1 =>
        school_copy2 -= student1
        school_copy2.toList.foreach { student2 =>
          student1.schoolConnections += student2
        }
        school_copy2 = school_copy1.clone()
      }

      school.clear();
    }
    students = students_copy.clone()
    var listOfActors = agents.clone()
    listOfActors.toList
  }


}
