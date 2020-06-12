package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}
import meta.classLifting.SpecialInstructions
import meta.example.supermarket.SupermarketTrait
import squid.quasi.lift

@lift
class Truck(var supermarket: SupermarketTrait) extends TruckTrait {



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
    writer = new PrintWriter(new FileWriter(new File("m/agentTruck" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      //todo truck should wait as long as manufacturer does not notify them
      checkIfThereIsOrderFromManufacturer()
      doTransport()
      SpecialInstructions.waitTurns(1)
      unloadTruck()
      SpecialInstructions.waitTurns(1)
    }
  }
}