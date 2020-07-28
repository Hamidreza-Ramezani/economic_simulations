package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.inStorage
import meta.example.supermarket.worldmap.{Down, Left, Right, Tile, Up, Utils, WorldTrait}
import squid.quasi.lift

import scala.collection.mutable.ListBuffer
import scala.util.Random

@lift
class Truck(var world: WorldTrait) extends TruckTrait {

  override def comeBackInitialPoint(world: WorldTrait): Unit = {
    writer.write("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")

    moveOneStep(world, initialXPosition, initialYPosition)

    writer.write("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  }

  override def move(world: WorldTrait, target: Actor): Unit = {
    writer.write("agent id " + id + " name: " + agentName + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + " name: " + agentName + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")

    moveOneStep(world, target.currentXPosition, target.currentYPosition)

    writer.write("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
  }

  def moveOneStep(world: WorldTrait, targetXPosition: Int, targetYPosition: Int): Unit = {
    if (canMove) {
      var path: ListBuffer[Tile] = Utils.getPath(world, world.coordinates(currentYPosition)(currentXPosition), world.coordinates(targetYPosition)(targetXPosition))
      path.toList.foreach {
        tile =>
          if (currentXPosition < tile.getX()) {
            SpecialInstructions.waitTurns(1)
            move(world, Right)
          }
          if (currentXPosition > tile.getX()) {
            SpecialInstructions.waitTurns(1)
            move(world, Left)
          }
          if (currentYPosition < tile.getY()) {
            SpecialInstructions.waitTurns(1)
            move(world, Down)
          }
          if (currentYPosition > tile.getY()) {
            SpecialInstructions.waitTurns(1)
            move(world, Up)
          }
      }
    }
  }

  def checkIfThereIsOrderFromManufacturer(): Unit = {
    truckState = relaxed
    while (truckState != receivedOrderFromManufacturer) {
      SpecialInstructions.waitTurns(1)
    }
    println("---------------------------------------------------------------------------------------------------")
    println("truck id " + id + " received an order from the manufacturer")
    println("---------------------------------------------------------------------------------------------------")
    writer.write("truck id " + id + " received an order from the manufacturer" + "\n")
  }

  def doTransport(): Unit = {
    //todo changing the constructor of item class. it probably should not take supermarket and section
    truckState = isDriving
    storage.keys.toList.foreach { pair =>
      var queue = storage(pair)
      queue.toList.foreach(item => {
        item.supermarket = supermarket
        item.section = supermarket.warehouse.filter(_.sectionName == item.category).head
      })
    }
//    if (storage.filterKeys(k => storage(k).nonEmpty).nonEmpty) {
//    }
    move(world, supermarket)
  }

  def unloadTruck(): Unit = {
    println("---------------------------------------------------------------------------------------------------")
    println("The truck id " + id + " unloaded the items")
    println("---------------------------------------------------------------------------------------------------")
    writer.write("The truck id" + id + " unloaded the items")
    truckState = unloadingTruck
    storage.keys.toList.foreach { pair =>
      var queue = storage(pair)
      while (queue.nonEmpty) {
        var item = queue.dequeue()
        supermarket.storage += item
        item.state = inStorage
        item.owner = supermarket

      }
    }
  }

  def main(): Unit = {

    //    world.coordinates_flattened.toList.foreach {
    //      tile =>
    //        tile.actors.toList.foreach {
    //          manufacturer =>
    //            if (manufacturer.getClass.getSimpleName == "Manufacturer") {
    //            this.manufacturer = manufacturer.asInstanceOf[ManufacturerTrait]
    //            }
    //        }
    //    }
    //    while (!manufacturer.isPositionsFixed) {
    //      SpecialInstructions.waitTurns(1)
    //    }
    setInitialPosition(world, Random.nextInt(world.width), Random.nextInt(world.height))
    world.addActor(this)
    writer = new PrintWriter(new FileWriter(new File("m/agentTruck" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      checkIfThereIsOrderFromManufacturer()
      doTransport()
      SpecialInstructions.waitTurns(1)
      unloadTruck()
      SpecialInstructions.waitTurns(1)
      comeBackInitialPoint(world)
    }
  }
}