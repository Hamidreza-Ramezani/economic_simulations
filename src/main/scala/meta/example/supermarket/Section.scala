package meta.example.supermarket

import java.io.{File, PrintWriter}
import meta.classLifting.SpecialInstructions
import squid.quasi.lift

@lift
class Section(var sectionName: String) extends SectionTrait {
  def main(): Unit = {
    writer = new PrintWriter(new File("m/section" + sectionName))
    while (true) {
      SpecialInstructions.waitTurns(1)
    }
  }
}
