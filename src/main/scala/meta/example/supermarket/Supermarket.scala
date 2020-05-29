package meta.example.supermarket

import java.io.{File, PrintWriter}
import meta.classLifting.SpecialInstructions
import squid.quasi.lift

@lift
class Supermarket extends SupermarketTrait {

  def main(): Unit = {
    writer = new PrintWriter(new File("m/supermarket"))
    while (true) {
      SpecialInstructions.waitTurns(1)
    }
  }
}
