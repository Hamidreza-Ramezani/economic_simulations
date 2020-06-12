package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.{Item, newItemsMap}
import squid.quasi.lift

import scala.collection.mutable

@lift
class Manufacturer(var truck: TruckTrait, var supermarket: SupermarketTrait) extends ManufacturerTrait {


//  override def getFreeSpace(item: String): Int = {
//    capacity - supermarket.warehouse.filter(_.sectionName == newItemsMap.categoryMap(item)).head.shelves(item).size
//  }

  def checkIfThereIsOrderFromSupermarket(): Unit = {
    manufacturerState = chilling
    while (manufacturerState != receivedOrderFromSupermarket) {
      SpecialInstructions.waitTurns(1)
    }
    println("---------------------------------------------------------------------------------------------------")
    println("manufacturer received an order from the supermarket")
    writer.write("manufacturer received an order from the supermarket" + "\n")
  }


  def checkIfThereIsUpdateFromFarmer(): Unit = {
    manufacturerState = waitingForFarmer
    while (manufacturerState != receivedNoticeFromFarmer) {
      SpecialInstructions.waitTurns(1)
    }
    println("---------------------------------------------------------------------------------------------------")
    println("manufacturer received an update from the farmer")
    println("---------------------------------------------------------------------------------------------------")
    writer.write("manufacturer received an update from the farmer" + "\n")
  }

  def giveOrderToFarmer(): Unit = {

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
    writer = new PrintWriter(new FileWriter(new File("m/agentManufacturer" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      //todo manufacturer should wait as long as farmer does not notify them
      checkIfThereIsOrderFromSupermarket()
      checkIfThereIsUpdateFromFarmer()
      processFood()
      SpecialInstructions.waitTurns(1)
      loadTruck()
      SpecialInstructions.waitTurns(5)
    }
  }
}