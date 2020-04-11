package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.Supermarket
import meta.example.supermarket.goods.Item
import squid.quasi.lift
import scala.collection.mutable.{ListBuffer, Queue}

@lift
class Cashier extends Actor {

  //  var numOfBasketsHandledInOneStep: Int = _numOfBasketsHandledInOneStep
  var numOfBasketsHandledInOneStep: Int = 1

  def setNumOfBasketHandledInOneStep(numOfBasketsHandledInOneStep: Int): Unit = {
    this.numOfBasketsHandledInOneStep = numOfBasketsHandledInOneStep
  }

  var isFirstBasket: Boolean = true

  def scanItems(queue: Queue[ListBuffer[Item]]): Unit = {
    var customerBasket: ListBuffer[Item] = ListBuffer[Item]()
    var j: Int = 0
    while (queue.size > 0 && j < numOfBasketsHandledInOneStep) {
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
      j = j + 1
      //      isFirstBasket = true
    }

    // println("Customer's Actor id " + id + " is waiting")

    if (queue.size == 0) {
      isFirstBasket = true
    } else {
      isFirstBasket = false
    }
  }

  def main(): Unit = {
    while (true) {
      scanItems(Supermarket.store.toBeScannedItems)
      waitTurns(1)
    }
  }
}