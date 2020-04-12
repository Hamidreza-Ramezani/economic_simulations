package meta.example.epidemic

import meta.example.epidemic.Utils.selectRandomly
import scala.collection.mutable.ListBuffer

class Epidemic {
}

object Epidemic {
  var agents: ListBuffer[Person] = ListBuffer[Person]()
  var students: ListBuffer[Person] = ListBuffer[Person]()
  var employees: ListBuffer[Person] = ListBuffer[Person]()
  var families: ListBuffer[ListBuffer[Person]] = ListBuffer[ListBuffer[Person]]()
  var schools: ListBuffer[ListBuffer[Person]] = ListBuffer[ListBuffer[Person]]()
  var workPlaces: ListBuffer[ListBuffer[Person]] = ListBuffer[ListBuffer[Person]]()

  val stepsPerDay: Int = 24;
  val hoursPerDay: Int = 24;
  val meetingAtSchoolProb = 0.01
  val meetingAtHomeProb = 0.01
  val meetingAtWorkProb = 0.01
  val populationSize = 10000
  val initialNumberOfInfected = 2
  val period = 6000

  def getRandomHouseholdSize(): Int = {
    var list: ListBuffer[Int] = ListBuffer()
    val percentageOfSizeOne = 30;
    val percentageOfSizeTwo = 35;
    val percentageOfSizeThree = 16;
    val percentageOfSizeFour = 14;
    val percentageOfSizeFive = 5;
    for (i <- 0 until percentageOfSizeOne) {
      list += 1
    }
    for (i <- 0 until percentageOfSizeTwo) {
      list += 2
    }
    for (i <- 0 until percentageOfSizeThree) {
      list += 3
    }
    for (i <- 0 until percentageOfSizeFour) {
      list += 4
    }
    for (i <- 0 until percentageOfSizeFive) {
      list += 5
    }
    val randomNumber = selectRandomly(list.toList);
    randomNumber;
  }

  def getRandomSchoolSize(): Int = {
    var list: ListBuffer[Int] = ListBuffer()
    val percentageOfSizeTen = 30;
    val percentageOfSizeTwenty = 35;
    val percentageOfSizeThirty = 16;
    val percentageOfSizeForty = 14;
    val percentageOfSizeFifty = 5;
    for (i <- 0 until percentageOfSizeTen) {
      list += 10
    }
    for (i <- 0 until percentageOfSizeTwenty) {
      list += 20
    }
    for (i <- 0 until percentageOfSizeThirty) {
      list += 30
    }
    for (i <- 0 until percentageOfSizeForty) {
      list += 40
    }
    for (i <- 0 until percentageOfSizeFifty) {
      list += 50
    }
    val randomNumber = selectRandomly(list.toList);
    randomNumber;
  }

  def getRandomWorkplaceSize(): Int = {
    var list: ListBuffer[Int] = ListBuffer()
    val percentageOfSizeTen = 30;
    val percentageOfSizeTwenty = 35;
    val percentageOfSizeThirty = 16;
    val percentageOfSizeForty = 14;
    val percentageOfSizeFifty = 5;
    for (i <- 0 until percentageOfSizeTen) {
      list += 10
    }
    for (i <- 0 until percentageOfSizeTwenty) {
      list += 20
    }
    for (i <- 0 until percentageOfSizeThirty) {
      list += 30
    }
    for (i <- 0 until percentageOfSizeForty) {
      list += 40
    }
    for (i <- 0 until percentageOfSizeFifty) {
      list += 50
    }
    val randomNumber = selectRandomly(list.toList);
    randomNumber;
  }


  def addAllHomeConnections(people: ListBuffer[Person]): Unit = {
    val people_copy1 = people
    var people_copy2 = people
    people_copy1.foreach { person1 =>
      people_copy2 -= person1
      people_copy2.foreach { person2 =>
        person1.addToHomeConnections(person2)
      }
      people_copy2 = people_copy1
    }
  }

  def addAllSchoolConnections(groupOfStudents: ListBuffer[Person]): Unit = {
    val groupOfStudents_copy1 = groupOfStudents
    var groupOfStudents_copy2 = groupOfStudents
    groupOfStudents_copy1.foreach { student1 =>
      groupOfStudents_copy2 -= student1
      groupOfStudents_copy2.foreach { student2 =>
        student1.addToSchoolConnections(student2)
      }
      groupOfStudents_copy2 = groupOfStudents_copy1
    }
  }

  def addAllWorkConnections(colleagues: ListBuffer[Person]): Unit = {
    val colleagues_copy1 = colleagues
    var colleagues_copy2 = colleagues
    colleagues_copy1.foreach { employee1 =>
      colleagues_copy2 -= employee1
      colleagues_copy2.foreach { employee2 =>
        employee1.addToSchoolConnections(employee2)
      }
      colleagues_copy2 = colleagues_copy1
    }
  }
}
