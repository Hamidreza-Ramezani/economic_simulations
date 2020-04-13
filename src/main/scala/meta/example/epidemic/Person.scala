package meta.example.epidemic

import meta.deep.runtime.Actor
import meta.example.epidemic.Location.Location
import meta.example.epidemic.State.State
import meta.example.epidemic.Status.Status

import scala.collection.mutable.ListBuffer
import meta.example.epidemic.Utils.prob2Bool
import squid.quasi.lift

class Person extends Actor {
  //class Person(var age: Int, var incubationTime: Float, var state: State, var location: Location, var status: Status) extends Actor {
  var age: Int = 1
  var timeOfInfection: Int = -1
  var state: State = null
  var location: Location = null
  var status: Status = null
  //  var state: State = State.Susceptible
  //  var location: Location = Location.atWork
  //  var status: Status = Status.student

//    val incubationTime: Double = 5.1
//    val infectiousTime: Int = 10;

  val incubationTime: Int = 5
  val infectiousTime: Int = 12;

  var exposedHourCount: Long = 0;
  var infectiousHourCount: Long = 0;

  var householdConnections: ListBuffer[Person] = ListBuffer[Person]();
  var schoolConnections: ListBuffer[Person] = ListBuffer[Person]();
  var workConnections: ListBuffer[Person] = ListBuffer[Person]();

  def updateCurrentLocation(step: Int): Unit = {
    val currentTime: Int = step % Epidemic.stepsPerDay;
    val dayCount: Int = (step / Epidemic.stepsPerDay) % 7;
    //todo on sunday and saturday, every body should be at home
    if (dayCount == 0 || dayCount == 6) {
      // do something
    }
    if (currentTime >= 21 || currentTime <= 8) {
      this.location = Location.atHome;
    }
    else {
      if (this.status == Status.other) {
        //flip a coin and set it to home or community
        if (prob2Bool(0.5)) {
          this.location = Location.atHome;
        } else {
          this.location = Location.inCommunity;
        }
      }
      else {
        if (currentTime >= 9 && currentTime <= 17) {
          //check the status and update the location
          if (status == Status.student) {
            this.location = Location.atSchool;
          } else {
            this.location = Location.atWork;
          }
        }
        else {
          //flip a coin and set it to home or community
          if (prob2Bool(0.5)) {
            this.location = Location.atHome;
          } else {
            this.location = Location.inCommunity;
          }
        }
      }
    }
  }

  //  def getHomeConnections(): String = {
  //    var homeConnectionsStr: String = "home connections are: \n";
  //    householdConnections.toList.foreach(person => homeConnectionsStr += "id: " + person.id.toString + "\n")
  //    homeConnectionsStr;
  //  }
  //
  //  def getSchoolConnections(): String = {
  //    var schoolConnectionsStr: String = "school connections are: \n";
  //    schoolConnections.toList.foreach(person => schoolConnectionsStr += "id: " + person.id.toString + "\n")
  //    schoolConnectionsStr;
  //  }
  //
  //  def getWorkConnections(): String = {
  //    var workConnectionsStr: String = "school connections are: \n";
  //    workConnections.toList.foreach(person => workConnectionsStr += "id: " + person.id.toString + "\n")
  //    workConnectionsStr;
  //  }

  def addToHomeConnections(person: Person): Unit = {
    this.householdConnections += person;
  }

  def addToSchoolConnections(person: Person): Unit = {
    this.schoolConnections += person;
  }

  def addToWorkConnections(person: Person): Unit = {
    this.workConnections += person;
  }

  //TODO fix the bug
  def individual_disease_progression() {
    if (this.state == State.Exposed && this.exposedHourCount < (incubationTime * Epidemic.hoursPerDay)) {
      this.exposedHourCount += 1;
    }

    else if (this.state == State.Exposed && this.exposedHourCount == (incubationTime * Epidemic.hoursPerDay)) {
      this.state = State.Infectious;
    }

    else if (this.state == State.Infectious && this.infectiousHourCount < (infectiousTime * Epidemic.hoursPerDay)) {
      this.infectiousHourCount += 1;
    }

    else if (this.state == State.Infectious && this.infectiousHourCount == (infectiousTime * Epidemic.hoursPerDay)) {
      this.state = State.Recovered;
    }
  }

  def meet(person: Person, simTime: Int): Unit = {
    if (this.state == State.Susceptible) {
      if (person.state == State.Infectious) {
        this.state = State.Exposed;
        this.timeOfInfection = simTime;
      }
    }
    else if (this.state == State.Infectious) {
      if (person.state == State.Susceptible) {
        person.state = State.Exposed;
        person.timeOfInfection = simTime;
      }
    }
  }

  def setStatus(status: Status): Unit = {
    this.status = status;
  }

  def setState(state: State): Unit = {
    this.state = state;
  }

  override def toString = s"Person(id=$id, timeOfInfection=$timeOfInfection, state=$state, location=$location, status=$status)"
}
