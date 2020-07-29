package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.{Brand, Item, inTruck, global}
import meta.example.supermarket.worldmap.{PrivateProperty, WorldTrait}
import squid.quasi.lift

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

@lift
class Manufacturer(var trucks: ListBuffer[TruckTrait], var supermarkets: ListBuffer[SupermarketTrait], var world: WorldTrait) extends ManufacturerTrait {


  /**
    * manufacturer orders items by changing its state. Farmer checks manufacturer state in a busy wait loop (which should
    * be changed due to performance)
    */
  def placeOrderToFarmer(): Unit = {
    manufacturerState = waitingForFarmer
    println("---------------------------------------------------------------------------------------------------")
    println("manufacturer ordered some food to the farmer")
    writer.write("manufacturer ordered some food to the farmer" + "\n")
  }

  /**
    * Manufacturer checks its state in a busy wait loop (which should be changed due to performance). Farmer is the one
    * who changes manufacturer state and when farmer changes it, this loop would be broken.
    */
  def checkIfThereIsUpdateFromFarmer(): Unit = {
    while (manufacturerState != receivedNoticeFromFarmer) {
      SpecialInstructions.waitTurns(1)
    }
    println("---------------------------------------------------------------------------------------------------")
    println("manufacturer received an update from the farmer")
    println("---------------------------------------------------------------------------------------------------")
    writer.write("manufacturer received an update from the farmer" + "\n")
  }

  /**
    * After receiving foods from farmer, manufacturer processes and packages them. Here, some delay
    * statements can be added.
    */
  def processFood(): Unit = {
    manufacturerState = isProcessing
    //    storage.keys.toList.foreach { pair =>
    //      val queue = storage(pair)
    //      queue.toList.foreach(_ => {
    //      })
    //    }
    //    if (storage.filterKeys(k => storage(k).nonEmpty).nonEmpty) {
    //      println("The manufacturer processed the food")
    //      writer.write("The manufacturer processed the food")
    //    }
  }

  /**
    * after processing and packaging, manufacturer loads the truck so that it delivers the items to supermarket.
    */
  def loadTruck(): Unit = {
    //in the list of supermarkets, we should find a supermarket that lacks some items
    //randomly choose a truck
    //assign that supermarket to that truck
    //load the truck based on the supermarket's needs

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
          storage.keys.toList.foreach { pair =>
            val queue = storage(pair)
            val itemName: String = pair._1
            val itemBrand: Brand = pair._2
            var numberOfItems = getFreeSpace(supermarket)((itemName, itemBrand))
            while (numberOfItems > 0 && queue.nonEmpty) {
              numberOfItems = numberOfItems - 1
              var item = queue.dequeue()
              randomTruck.storage.getOrElse((item.name, item.brand), new mutable.Queue[Item]) += item
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

  /**
    * manufacturer's step function.
    */
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
    }
  }
}