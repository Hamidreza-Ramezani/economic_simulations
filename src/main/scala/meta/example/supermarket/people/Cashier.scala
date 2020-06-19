package meta.example.supermarket.people

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions.waitTurns
import meta.example.supermarket.goods.Item
import meta.example.supermarket.worldmap.WorldTrait
import squid.quasi.lift

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Queue}
import scala.util.Random

@lift
class Cashier(var world: WorldTrait) extends CashierTrait {
  var isFirstBasket: Boolean = true


  def scanItems(queue: mutable.Queue[ListBuffer[Item]]): Unit = {
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
    setInitialPosition(Random.nextInt(world.width), Random.nextInt(world.height))
    world.addActor(this)

    writer = new PrintWriter(new FileWriter(new File("m/agentCashier" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      scanItems(toBeScannedItems)
      waitTurns(1)
    }
  }
}