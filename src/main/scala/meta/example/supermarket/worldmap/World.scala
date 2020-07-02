package meta.example.supermarket.worldmap

import meta.classLifting.SpecialInstructions
import squid.quasi.lift

@lift
class World(var width: Int, var height: Int) extends WorldTrait {

  def main(): Unit = {
    //    writer.write("\n\n" + "timer: " + timer + "\n\n")
    while (true) {
      writer.write(this.toString)
      SpecialInstructions.waitTurns(1)
    }
  }
}