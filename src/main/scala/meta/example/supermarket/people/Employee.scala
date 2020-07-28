package meta.example.supermarket.people

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.auction.{AuctionPolicy, Policy1}
import meta.example.supermarket.goods.{Item, global, onDisplay}
import meta.example.supermarket.logistics.{ManufacturerTrait, loadedTruck, unloadingTruck}
import meta.example.supermarket.utils.utilities.to2Dec
import meta.example.supermarket.worldmap.{Down, Left, Right, Tile, Up, Utils, WorldTrait}
import meta.example.supermarket.{SectionTrait, SupermarketTrait}
import squid.quasi.lift

import scala.collection.mutable.ListBuffer
import scala.math.BigDecimal
import scala.util.Random

@lift
class Employee(var supermarket: SupermarketTrait, var section: SectionTrait, var manufacturer: ManufacturerTrait, var world: WorldTrait) extends EmployeeTrait {


  override def comeBackInitialPoint(world: WorldTrait): Unit = {
    writer.write("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")

    move2(world, initialXPosition, initialYPosition)

    writer.write("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  }

  override def move(world: WorldTrait, target: Actor): Unit = {
    writer.write("agent id " + id + " name: " + agentName + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + " name: " + agentName + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")

    move2(world, target.currentXPosition, target.currentYPosition)

    writer.write("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
  }

  def move2(world: WorldTrait, targetXPosition: Int, targetYPosition: Int): Unit = {
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

  def updatePrices(auctionPolicy: AuctionPolicy): Unit = {
    if (supermarket.auctionEnabled) {
      section.shelves.toList.foreach {
        shelf =>
          shelf._2.itemsList.toList.foreach {
            item =>
              val freshness = to2Dec(1 - 1.0 * item.age / item.freshUntil)
              var newDiscount: Double = 0.0
              var newPrice: Double = item.price
              auctionPolicy.rangeDiscountMap.toList.foreach {
                pair =>
                  if (pair._1.contain(freshness)) {
                    newDiscount = pair._2
                  }
              }
              //            if (freshness < 0.75 && freshness > 0.5) {
              //              newDiscount = 0.25
              //              isDiscountUpdated = true
              //            }
              //            else if (freshness < 0.5 && freshness > 0.25) {
              //              newDiscount = 0.5
              //              isDiscountUpdated = true
              //            }
              //            else if (freshness < 0.25 && freshness > 0.0) {
              //              newDiscount = 0.75
              //              isDiscountUpdated = true
              //            }


              if (newDiscount != item.discount) {
                val itemNum: String = global.itemNameToID_test.getOrElse(item.name, "")
                newPrice = global.priceMap((itemNum, item.brand)) * (1 - newDiscount)
                val roundedNewPrice = BigDecimal(newPrice).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
                writer.write("The discount of item " + item.name + " id: " + item.id + " is changed from: " + item.discount + " to " + newDiscount + "\n")
                writer.write("The price of item " + item.name + " id: " + item.id + " is changed from: " + item.price + " to " + roundedNewPrice + "\n")
                item.discount = newDiscount
                item.price = roundedNewPrice
              }
          }
      }

    }

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
      updatePrices(Policy1)
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