package meta.example.supermarket.people

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.goods.{Item, onDisplay}
import meta.example.supermarket.logistics.{ManufacturerTrait, loadedTruck, unloadingTruck}
import meta.example.supermarket.worldmap.WorldTrait
import meta.example.supermarket.{SectionTrait, SupermarketTrait}
import squid.quasi.lift

import scala.collection.mutable.ListBuffer
import scala.util.Random

@lift
class Employee(var supermarket: SupermarketTrait, var section: SectionTrait, var manufacturer: ManufacturerTrait, var world: WorldTrait) extends EmployeeTrait {


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


  def orderItems(): Unit = {
    //calling farmer
    //    println("---------------------------------------------------------------------------------------------------")
    //        println("Employee's Actor id " + id + " ordered some items")
    //    println("Employee's Actor id " + id + " is waiting for the truck")
    //    println("---------------------------------------------------------------------------------------------------")
    //        writer.write("Employee's Actor id " + id + " ordered some items" + "\n")
    //    writer.write("Employee's Actor id " + id + " is waiting for the truck" + "\n")
    state = reFillingShelves
    //    farmer.farmerState = receivedRequestFromSupermarket
    //    manufacturer.manufacturerState = receivedOrderFromSupermarket
    //    SpecialInstructions.waitTurns(1)
    while (manufacturer.manufacturerState != loadedTruck) {
      SpecialInstructions.waitTurns(1)
    }
    //    truck = manufacturer.trucks.filter(truck => truck.supermarket == this.supermarket).head
    while (truck.truckState != unloadingTruck) {
      println("---------------------------------------------------------------------------------------------------")
      println("Employee's Actor id " + id + " is waiting for the truck id " + truck.id)
      println("---------------------------------------------------------------------------------------------------")
      writer.write("Employee's Actor id " + id + " is waiting for the truck id " + truck.id + "\n")
      SpecialInstructions.waitTurns(1)
    }
  }

  def addSupply(): Unit = {
    supermarket.storage.toList.foreach { item =>
      section.shelves(item.name, item.brand) += item
      item.state = onDisplay
      writer.write("Employee's Actor id " + id + " Add new actor! name: " + item.name + "\n")
    }
    supermarket.storage = new ListBuffer[Item]()
    //    check if the number of items in supermarket is full
    if (section.isNotFull()) {
      orderItems()
      state = reFillingShelves
      supermarket.storage.toList.foreach { item =>
        section.shelves(item.name, item.brand) += item
        item.state = onDisplay
        writer.write("Employee's Actor id " + id + " Add new actor! name: " + item.name + "\n")
      }
      supermarket.storage = new ListBuffer[Item]()
    }




    //employee has to make sure that the items are arrived
    //employee should check a variable in while true loop
    //    while (truck.truckState != unloadingTruck) {
    //      println("Employee's Actor id " + id + " is waiting for the truck")
    //      writer.write("Employee's Actor id " + id + " is waiting for the truck" + "\n")
    //      SpecialInstructions.waitTurns(1)
    //    }
    //    while (supermarket.itemsRecentlyOrdered) {
    //      println("Employee's Actor id " + id + " is waiting for the truck")
    //      writer.write("Employee's Actor id " + id + " is waiting for the truck" + "\n")
    //      SpecialInstructions.waitTurns(1)
    //    }

    //    section.articleNames.toList.foreach(
    //      itemStr => List.tabulate(getFreeSpace(itemStr))(n => n).foreach(_ => {
    //            val new_item: Item = genNewItem(newItemsMap.itemMap(itemStr))
    //        section.shelves(itemStr) += new_item.asInstanceOf[Item]
    //        writer.write("Employee's Actor id " + id + " Add new actor! name: " + itemStr + "\n")
    //      })
    //    )
  }

  def shuffleShelves(): Unit = {
    //todo: add delay for the customers
    //Supermarket.store.warehouse.foreach(shelf => shelf._2.itemDeque.)
    state = shufflingShelves
    writer.write("\n")
    println()
    writer.write("Employee's Actor id " + id + " is shuffling the shelves")
    println("Employee's Actor id " + id + " is shuffling the shelves")
    writer.write("\n")
    println()

    section.shelves.toList.foreach(shelf => shelf._2.shuffle(section.sectionShufflingPolicy))
  }

  def main(): Unit = {
    while (!supermarket.isPositionsFixed) {
      state = reFillingShelves
      SpecialInstructions.waitTurns(1)
    }
    setInitialPosition(world, Random.nextInt(world.width), Random.nextInt(world.height))
    world.addActor(this)

    writer = new PrintWriter(new FileWriter(new File("m/agentEmployee" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      writer.write("\n")
      println()
      writer.write("Employee's Actor id " + id + " is refilling the shelves")
      println("Employee's Actor id " + id + " is refilling the shelves")
      writer.write("\n")
      println()

      addSupply()
      waitTurns(1)
      state = walkingAround
      writer.write("\n" + "Employee's Actor id " + id + " refilled the shelves" + "\n")
      println()
      println("Employee's Actor id " + id + " refilled the shelves")
      println()
      waitTurns(10)
    }
  }
}