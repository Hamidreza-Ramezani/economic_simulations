package meta.example.traffic_light_example

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import squid.quasi.lift

@lift
class Driver() extends Actor {
  var trafficLight: TrafficLight = null

  def wait_to_cross(): Unit = {
    if (trafficLight.state == 1) {
      trafficLight.toggle()
      println("Driver is crossing the road")
    }
    else {
      println("Driver is crossing the road")
    }
  }

  def main(): Unit = {
    while (true) {
      wait_to_cross()
      SpecialInstructions.waitTurns(1)
    }
  }
}
