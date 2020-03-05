package meta.example.traffic_light_example

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import squid.quasi.lift


@lift
class Passenger() extends Actor{

  var trafficLight: TrafficLight = null

  def wait_to_cross():Unit = {
    if(trafficLight.state == 0){
      println("passenger asks to cross the road!")
      trafficLight.toggle()
      println("Passenger is crossing the road")
      //      SpecialInstructions.waitTurns(1)
    }
    else{
      println("Passenger is crossing the road")
    }
  }

  def main(): Unit = {
    while(true) {

      //TODO should be a random function


      val rnd = new scala.util.Random
      val r = rnd.nextInt(3)
      if (r == 1 || r == 3){
        wait_to_cross()
      }
      SpecialInstructions.waitTurns(1)

    }
  }


}
