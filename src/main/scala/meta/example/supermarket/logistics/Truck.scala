package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.worldmap.WorldTrait
import squid.quasi.lift

import scala.util.Random

@lift
class Truck(var supermarket: SupermarketTrait, var world: WorldTrait) extends TruckTrait {


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


  def checkIfThereIsOrderFromManufacturer(): Unit = {
    truckState = relaxing
    while (truckState != receivedOrderFromManufacturer) {
      SpecialInstructions.waitTurns(1)
    }
    println("---------------------------------------------------------------------------------------------------")
    println("truck received an order from the manufacturer")
    println("---------------------------------------------------------------------------------------------------")
    writer.write("truck received an order from the manufacturer" + "\n")
  }

  def doTransport(): Unit = {
    //todo changing the constructor of item class. it probably should not take supermarket and section
    truckState = isDriving
    storage.keys.toList.foreach { itemStr =>
      var queue = storage(itemStr)
      queue.toList.foreach(item => {
        item.supermarket = supermarket
        item.section = supermarket.warehouse.filter(_.sectionName == item.category).head
      })
    }
    if (storage.filterKeys(k => storage(k).nonEmpty).nonEmpty) {
    }
  }

  def unloadTruck(): Unit = {
    println("---------------------------------------------------------------------------------------------------")
    println("The truck transported the food")
    println("---------------------------------------------------------------------------------------------------")
    writer.write("The truck transported the food")
    truckState = unloadingTruck
    storage.keys.toList.foreach { itemStr =>
      var queue = storage(itemStr)
      while (queue.nonEmpty) {
        var item = queue.dequeue()
        supermarket.storage += item
        item.state.loadInStorage
        //ok, lets think how to add items into supermarket
        //we need to add it to a list so that the employee has access to that list
        //then change the employee code base
        // TODO add the item into supermarket: done,
        //  changing the state of the item: done
        //        supermarket.itemsRecentlyOrdered = false
      }
    }
  }

  def main(): Unit = {
    setInitialPosition(Random.nextInt(world.width), Random.nextInt(world.height))
    world.addActor(this)
    writer = new PrintWriter(new FileWriter(new File("m/agentTruck" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      if (timer % 7 == 0) {
        if (timer != 0) {
          move(world, supermarket)
          SpecialInstructions.waitTurns(1)
          comeBackToInitialPoint(world)
        }
      }

      //todo truck should wait as long as manufacturer does not notify them
      checkIfThereIsOrderFromManufacturer()
      doTransport()
      SpecialInstructions.waitTurns(1)
      unloadTruck()
      SpecialInstructions.waitTurns(1)
    }
  }
}