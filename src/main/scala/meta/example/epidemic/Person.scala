package meta.example.epidemic

import meta.deep.runtime.Actor
import meta.example.epidemic.Location.Location
import meta.example.epidemic.State.State
import meta.example.epidemic.Status.Status
import scala.collection.mutable.ListBuffer

class Person extends Actor {
  val age: Int;
  val incubationTime: Float;
  var timeOfInfection: Int = -1;
  var state: State;
  var location: Location;
  var householdConnections: ListBuffer[Person];
  var schoolConnections: ListBuffer[Person];
  var workConnections: ListBuffer[Person];
  var status: Status;

  def updateCurrentLocation(step: Int): Unit = {
    var currentTime: Int = step % Epidemic.stepsPerDay;
    if (currentTime >= 21 || currentTime <= 8) {
      this.location = Location.atHome;
      return;
    }

  }


}
