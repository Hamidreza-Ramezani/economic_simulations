package meta.example.epidemic

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import meta.deep.runtime.Actor.AgentId
import meta.example.epidemic.Epidemic.{agents, meetingAtHomeProb, meetingAtSchoolProb, meetingAtWorkProb}
import meta.example.epidemic.Location._
import meta.example.epidemic.State._
import meta.example.epidemic.Status._
import scala.collection.mutable.ListBuffer
import meta.example.epidemic.Utils.prob2Bool
import squid.quasi.lift

@lift
class Person extends Actor {
  //class Person(var age: Int, var incubationTime: Float, var state: State, var location: Location, var status: Status) extends Actor {
  var age: Int = 1
  var timeOfInfection: Int = -1
  var infectedBy: AgentId = -1
  var infectedAt: String = "none"
  var state: State = null
  var location: Location = null
  var status: Status = null

  //  val incubationTime: Double = 5.1
  //  val infectiousTime: Int = 10;

  val incubationTime: Int = 2
  val infectiousTime: Int = 3;

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
    if (this.state == State.Exposed) {
      if (this.exposedHourCount < (incubationTime * Epidemic.hoursPerDay)) {
        exposedHourCount = exposedHourCount + 1;
      }
      else {
        this.state = State.Infectious;
      }
    }

    else if (this.state == State.Infectious) {
      if (this.infectiousHourCount < (infectiousTime * Epidemic.hoursPerDay)) {
        infectiousHourCount = infectiousHourCount + 1
      }
      else {
        this.state = State.Recovered;
      }
    }
  }

  def meet(person: Person, simTime: Int): Unit = {
    if (this.state == State.Susceptible) {
      if (person.state == State.Infectious) {
        this.state = State.Exposed;
        this.timeOfInfection = simTime;
        this.infectedBy = person.id
        this.infectedAt = this.location
      }
    }
    else if (this.state == State.Infectious) {
      if (person.state == State.Susceptible) {
        person.state = State.Exposed;
        person.timeOfInfection = simTime;
        person.infectedBy = this.id
        person.infectedAt = person.location
      }
    }
  }

  def setStatus(status: Status): Unit = {
    this.status = status;
  }

  def setState(state: State): Unit = {
    this.state = state;
  }


  override def toString = s"Person(id=$id, timeOfInfection=$timeOfInfection, infectedBy=$infectedBy, InfectedAt=$infectedAt, state=$state, location=$location, status=$status)"


  def main(): Unit = {
    while (true) {
      updateCurrentLocation(timer)
      var currentTime = timer % 24;
      if (currentTime > 8) {
        if (location == atHome) {
          this.householdConnections.toList.foreach { person2 =>
            if (person2.location == atHome) {
              if (prob2Bool(meetingAtHomeProb)) {
                this.meet(person2, timer);
              }
            }
          }
        }
        else if (location == atSchool) {
          this.schoolConnections.toList.foreach { person2 =>
            if (person2.location == atSchool) {
              if (prob2Bool(meetingAtSchoolProb)) {
                this.meet(person2, timer);
              }
            }
          }
        }
        else if (location == atWork) {
          this.workConnections.toList.foreach { person2 =>
            if (person2.location == atWork) {
              if (prob2Bool(meetingAtWorkProb)) {
                this.meet(person2, timer);
              }
            }
          }
        }
      }
      this.individual_disease_progression()
      SpecialInstructions.waitTurns(1)
    }
  }


}
