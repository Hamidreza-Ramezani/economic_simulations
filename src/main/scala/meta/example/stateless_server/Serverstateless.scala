package meta.example.stateless_server

import meta.deep.runtime.Actor
import squid.quasi.lift
import meta.classLifting.SpecialInstructions._

import scala.util.Random.nextInt

@lift
class Serverstateless extends Actor {
  def getNumber(): Int = {
    nextInt(1000)
  }
  def main(): Unit = {
    while (true) {
      handleMessages()
      waitTurns(1)
    }
  }
}
