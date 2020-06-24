package meta.example.supermarket

import java.io.{File, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.worldmap.{PrivateProperty, Street, WorldTrait}
import squid.quasi.lift

import scala.collection.mutable.ListBuffer
import scala.util.Random

@lift
class Supermarket(var warehouse: ListBuffer[SectionTrait], var world: WorldTrait) extends SupermarketTrait {
  //  var employees: ListBuffer[EmployeeTrait] = warehouse.map(_.employee)


  def main(): Unit = {
    var randomWidth = Random.nextInt(world.width)
    var randomHeight = Random.nextInt(world.height)
    while (world.coordinates(randomHeight)(randomWidth).tileType != PrivateProperty) {
      randomWidth = Random.nextInt(world.width)
      randomHeight = Random.nextInt(world.height)
    }
    setInitialPosition(randomWidth, randomHeight)
    world.addActor(this)
    writer = new PrintWriter(new File("m/agentSupermarket" + id))
    writer.write("\n\n" + "timer: " + timer + "\n\n")
    while (true) {
      warehouse.toList.foreach(section => section.shelves.toList.foreach(shelf => writer.write("\n\n" + shelf._1 + "\n\n" + shelf._2.toString)))
      SpecialInstructions.waitTurns(1)
    }
  }
}