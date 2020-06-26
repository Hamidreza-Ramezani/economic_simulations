package meta.example.supermarket.goods

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import meta.example.supermarket.worldmap.WorldTrait
import meta.example.supermarket.{SectionTrait, Supermarket, SupermarketTrait}
import squid.quasi.lift

import scala.util.Random

/* Auto generated from genItems */

@lift
class Item14(var supermarket: SupermarketTrait, var section: SectionTrait, var world: WorldTrait) extends Item with Pork {
  //var age: Int = 0

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
//    setInitialPosition(Random.nextInt(world.width), Random.nextInt(world.height))
//    world.addActor(this)

    while (age < freshUntil && !state.isConsumed) {
      itemInfo
      SpecialInstructions.waitTurns(1)
      age = age + 1
    }
    cleanExpired()
  }
}
