package meta.example.supermarket.people

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.Supermarket
import meta.example.supermarket.goods.Item
import squid.quasi.lift

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Queue}

@lift
class Cashier extends CashierTrait {

  def scanItems(queue: mutable.Queue[ListBuffer[Item]]): Unit = {
    var isFirstBasket: Boolean = true
    var customerBasket: ListBuffer[Item] = ListBuffer[Item]()
    var j: Int = 0
    while (queue.nonEmpty && j < numOfBasketsHandledInOneStep) {
      customerBasket = queue.dequeue()
      var i: Int = 0
      while (i < customerBasket.size) {
        if (isFirstBasket) {
          isFirstBasket = false
          //TODO double check to see if this wait statement is essential
          //          waitTurns(1)
        }
        var item = customerBasket(i)
        //      customerBasket -= item
        item.state.purchase
        i = i + 1
      }
      writer.write("Cashier's Actor id " + id + " scanned the customer's basket with size " + customerBasket.size + "\n")
      j = j + 1
      isFirstBasket = true
    }

    // println("Customer's Actor id " + id + " is waiting")

    //    if (queue.isEmpty) {
    //      isFirstBasket = true
    //    } else {
    //      isFirstBasket = false
    //    }
  }

  def main(): Unit = {
    writer = new PrintWriter(new FileWriter(new File("m/agent" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      scanItems(toBeScannedItems)
      waitTurns(1)
    }
  }
}