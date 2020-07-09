package meta.example.supermarket

import java.io.{File, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import meta.example.supermarket.worldmap.WorldTrait
import squid.quasi.lift

import scala.util.Random

@lift
class Section(var sectionName: String,var sectionShufflingPolicy: ShufflingPolicy, var world: WorldTrait) extends SectionTrait {

  override def comeBackToInitialPoint(world: WorldTrait): Unit = {
    writer.write("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")

    move(world, initialXPosition, initialYPosition)
    SpecialInstructions.waitTurns(1)

    writer.write("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  }

  override def move(world: WorldTrait, target: Actor): Unit = {
    writer.write("agent id " + id + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")

    move(world, target.currentXPosition, target.currentYPosition)
    SpecialInstructions.waitTurns(1)

    writer.write("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
  }


  def main(): Unit = {
    writer = new PrintWriter(new File("m/agentSection" + sectionName + id))
//    setInitialPosition(Random.nextInt(world.width), Random.nextInt(world.height))
//    world.addActor(this)

    while (true) {
      //      shelves.toList.foreach(shelf => writer.write("\n\n" + shelf._1 + "\n\n" + shelf._2.toString))
      SpecialInstructions.waitTurns(1)
    }
  }
}