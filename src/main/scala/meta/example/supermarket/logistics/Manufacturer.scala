package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}
import meta.classLifting.SpecialInstructions
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.Item
import meta.example.supermarket.worldmap.{PrivateProperty, WorldTrait}
import squid.quasi.lift
import scala.collection.mutable
import scala.util.Random

@lift
class Manufacturer(var truck: TruckTrait, var supermarket: SupermarketTrait, var world: WorldTrait) extends ManufacturerTrait {


  def placeOrderToFarmer(): Unit = {
//    manufacturerState = idle
//    SpecialInstructions.waitTurns(30)
    manufacturerState = waitingForFarmer
    //    while (manufacturerState != receivedOrderFromSupermarket) {
    //      SpecialInstructions.waitTurns(1)
    //    }
    println("---------------------------------------------------------------------------------------------------")
    println("manufacturer ordered some food")
    writer.write("manufacturer ordered some food" + "\n")
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
    println("---------------------------------------------------------------------------------------------------")
    println("The manufacturer processed the food")
    println("---------------------------------------------------------------------------------------------------")
    writer.write("The manufacturer processed the food")
    manufacturerState = loadedTruck
    truck.truckState = receivedOrderFromManufacturer
    storage.keys.toList.foreach { itemStr =>
      val queue = storage(itemStr)
      while (queue.nonEmpty) {
        var item = queue.dequeue()
        truck.storage.getOrElse(item.name, new mutable.Queue[Item]) += item
        item.state.loadInTruck
      }
    }
  }

  def main(): Unit = {
    var randomWidth = Random.nextInt(world.width)
    var randomHeight = Random.nextInt(world.height)
    while (world.coordinates(randomHeight)(randomWidth).tileType != PrivateProperty) {
      randomWidth = Random.nextInt(world.width)
      randomHeight = Random.nextInt(world.height)
    }
    setInitialPosition(randomWidth, randomHeight)
    world.addActor(this)
    writer = new PrintWriter(new FileWriter(new File("m/agentManufacturer" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      placeOrderToFarmer()
      checkIfThereIsUpdateFromFarmer()
      processFood()
      SpecialInstructions.waitTurns(1)
      loadTruck()
      manufacturerState = idle
      SpecialInstructions.waitTurns(30)
//      SpecialInstructions.waitTurns(1)
    }
  }
}