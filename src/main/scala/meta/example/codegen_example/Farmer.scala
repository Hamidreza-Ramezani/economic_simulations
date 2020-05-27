package meta.example.codegen_example

import meta.classLifting.SpecialInstructions._
import meta.deep.runtime.Actor
import squid.quasi.lift

@lift
class Farmer() extends Actor {
  var happiness: Int = 1: Int
  var peers: List[Farmer] = List[Farmer]()
  var market: Market = null: Market

  def notifyPeers(): Unit = {
    peers.foreach { p =>
      p.tell(this, happiness)
    }
  }

  def tell(actor: Actor, h: Int): Unit = {
    happiness = happiness - h
  }

  def main(): Unit = {
    while (true) {
      println("I am sending a message to market to sell 500 units")
      val testResult = market.sell2(500)
      println("I received market's reply")
//      println("TEST_VAR", testResult)
      waitTurns(1)
    }
  }

}
