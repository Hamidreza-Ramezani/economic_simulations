package meta.example.supermarket

import java.io.{File, PrintWriter}
import meta.classLifting.SpecialInstructions
import squid.quasi.lift

@lift
class Section(var sectionName: String,var sectionShufflingPolicy: ShufflingPolicy) extends SectionTrait {



  def main(): Unit = {
    writer = new PrintWriter(new File("m/section" + sectionName))
    while (true) {
      //      shelves.toList.foreach(shelf => writer.write("\n\n" + shelf._1 + "\n\n" + shelf._2.toString))
      SpecialInstructions.waitTurns(1)
    }
  }
}
