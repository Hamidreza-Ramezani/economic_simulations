package meta.example.supermarket

import java.io.{File, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.worldmap.WorldTrait
import squid.quasi.lift

import scala.util.Random

@lift
class Section(var sectionName: String,var sectionShufflingPolicy: ShufflingPolicy, var world: WorldTrait) extends SectionTrait {


  def main(): Unit = {
    writer = new PrintWriter(new File("m/agentSection" + sectionName + id))
    setInitialPosition(Random.nextInt(world.width), Random.nextInt(world.height))
    world.addEntity(this)

    while (true) {
      //      shelves.toList.foreach(shelf => writer.write("\n\n" + shelf._1 + "\n\n" + shelf._2.toString))
      SpecialInstructions.waitTurns(1)
    }
  }
}
