package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.Supermarket
import squid.quasi.lift


@lift
class Employee extends Actor {
  def main(): Unit = {
    while (true) {
      Supermarket.store.addSupply
      waitTurns(1)
    }
  }
}


