package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.{Item, inTruck}
import meta.example.supermarket.worldmap.{PrivateProperty, WorldTrait}
import squid.quasi.lift

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

@lift
class Manufacturer(var trucks: ListBuffer[TruckTrait], var supermarkets: ListBuffer[SupermarketTrait], var world: WorldTrait) extends ManufacturerTrait {

  def placeOrderToFarmer(): Unit = {
    //    manufacturerState = idle
    //    SpecialInstructions.waitTurns(30)
    manufacturerState = waitingForFarmer
    //    while (manufacturerState != receivedOrderFromSupermarket) {
    //      SpecialInstructions.waitTurns(1)
    //    }
    println("---------------------------------------------------------------------------------------------------")
    println("manufacturer ordered some food to the farmer")
    writer.write("manufacturer ordered some food to the farmer" + "\n")
  }

  def checkIfThereIsUpdateFromFarmer(): Unit = {
    //    manufacturerState = waitingForFarmer
    while (manufacturerState != receivedNoticeFromFarmer) {
      SpecialInstructions.waitTurns(1)
    }
    println("---------------------------------------------------------------------------------------------------")
    println("manufacturer received an update from the farmer")
    println("---------------------------------------------------------------------------------------------------")
    writer.write("manufacturer received an update from the farmer" + "\n")
  }

  def processFood(): Unit = {
    manufacturerState = isProcessing
    storage.keys.toList.foreach { itemStr =>
      val queue = storage(itemStr)
      queue.toList.foreach(_ => {
      })
    }
    //    if (storage.filterKeys(k => storage(k).nonEmpty).nonEmpty) {
    //      println("The manufacturer processed the food")
    //      writer.write("The manufacturer processed the food")
    //    }
  }

  def loadTruck(): Unit = {
    //in the list of supermarkets, we should find a supermarket that lacks some items
    //randomly choose a truck
    //assign that supermarket to that truck's supermarket attribute
    //load the truck from part of the manufacturer's storage
    //that part should be based on the supermarket's needs

    supermarkets.toList.foreach {
      supermarket =>
        if (numberOfItemsSupermarketNeeds(supermarket) > 0) {
          writer.write("supermarket id" + supermarket.id + " whole needs: " + numberOfItemsSupermarketNeeds(supermarket) + " items\n")
          var randomTruck = trucks.head
          while (randomTruck.truckState != relaxed) {
            if (trucks.filter(truck => truck.truckState == relaxed).size == 0) {
              SpecialInstructions.waitTurns(1)
            }
            val randomNumber = Random.nextInt(trucks.size)
            randomTruck = trucks(randomNumber)
          }
          randomTruck.supermarket = supermarket
          writer.write("truck " + randomTruck.id + " is assigned to go to supermarket" + supermarket.id + "\n")
          println("truck " + randomTruck.id + " is assigned to go to supermarket" + supermarket.id)
          supermarket.employees.toList.foreach {
            employee =>
              employee.truck = randomTruck
          }
          randomTruck.truckState = receivedOrderFromManufacturer
          storage.keys.toList.foreach { itemStr =>
            val queue = storage(itemStr)
            var numberOfItems = getFreeSpace(supermarket)(itemStr)
            //            var numberOfItems = getFreeSpace(supermarket)(itemStr) * numberOfDifferentBrands
            while (numberOfItems > 0 && queue.nonEmpty) {
              numberOfItems = numberOfItems - 1
              var item = queue.dequeue()
              randomTruck.storage.getOrElse(item.name, new mutable.Queue[Item]) += item
              item.state = inTruck
            }
          }
        }
    }
    println("---------------------------------------------------------------------------------------------------")
    println("The manufacturer processed the food")
    println("---------------------------------------------------------------------------------------------------")
    writer.write("The manufacturer processed the food")
    manufacturerState = loadedTruck
  }

  def main(): Unit = {
    trucks.toList.foreach {
      truck =>
        truck.manufacturer = this
    }
    var randomWidth = Random.nextInt(world.width)
    var randomHeight = Random.nextInt(world.height)
    while (world.coordinates(randomHeight)(randomWidth).tileType != PrivateProperty || world.coordinates(randomHeight)(randomWidth).hasOwner) {
      randomWidth = Random.nextInt(world.width)
      randomHeight = Random.nextInt(world.height)
    }
    setInitialPosition(world, randomWidth, randomHeight)
    world.addActor(this)
    writer = new PrintWriter(new FileWriter(new File("m/agentManufacturer" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      placeOrderToFarmer()
      checkIfThereIsUpdateFromFarmer()
      processFood()
      SpecialInstructions.waitTurns(1)
      loadTruck()
      SpecialInstructions.waitTurns(1)
      manufacturerState = idle
      SpecialInstructions.waitTurns(29)
      //      SpecialInstructions.waitTurns(1)
    }
  }
}