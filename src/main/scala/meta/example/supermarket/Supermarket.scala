package meta.example.supermarket

import java.io.{File, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.worldmap.{PrivateProperty, WorldTrait}
import squid.quasi.lift

import scala.collection.mutable.ListBuffer
import scala.util.Random

@lift
class Supermarket(var warehouse: ListBuffer[SectionTrait], var world: WorldTrait) extends SupermarketTrait {

  def main(): Unit = {
    warehouse.toList.foreach{
      section =>
        section.supermarket = this
    }
    var randomWidth = Random.nextInt(world.width)
    var randomHeight = Random.nextInt(world.height)
    while (world.coordinates(randomHeight)(randomWidth).tileType != PrivateProperty || world.coordinates(randomHeight)(randomWidth).hasOwner) {
      randomWidth = Random.nextInt(world.width)
      randomHeight = Random.nextInt(world.height)
    }
    setInitialPosition(world, randomWidth, randomHeight)
    world.addActor(this)
    writer = new PrintWriter(new File("m/agentSupermarket" + id))
    writer.write("\n\n" + "timer: " + timer + "\n\n")
    while (true) {
      warehouse.toList.foreach(section => section.shelves.toList.foreach(shelf => writer.write("\n\n" + shelf._1 + "\n\n" + shelf._2.toString)))
      SpecialInstructions.waitTurns(1)
    }
  }
}