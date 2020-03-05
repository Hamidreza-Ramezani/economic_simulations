package meta.example.traffic_light_example

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import squid.quasi.lift

@lift
class TrafficLight() extends Actor {
  var state: Int = 0
  var turn: String = "driver"

  def toggle(): String = {
    if (state == 0) {
      state = 1
      turn = "passenger"
    }
    else {
      state = 0
      turn = "driver"
    }
    turn
  }

  def init(): Unit = {
    println("Driver is crossing the road")
    //    println("Re-initialize the traffic light!")
    state = 0
    turn = "driver"
  }

  def main(): Unit = {
    while (true) {
      //      if(state == 0){
      //        println("Driver is crossing the road")
      //      }
      //
      //      else{
      //        println("Passenger is crossing the road")
      //      }

      //      SpecialInstructions.handleMessages()
      SpecialInstructions.waitTurns(1)
    }
  }
}