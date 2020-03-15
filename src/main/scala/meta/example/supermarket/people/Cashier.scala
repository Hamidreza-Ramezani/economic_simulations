package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.Supermarket
import meta.example.supermarket.goods.Item
import squid.quasi.lift
import scala.collection.mutable.{ListBuffer, Queue}

@lift
class Cashier extends Actor {

  val numOfBasketsHandledInOneStep: Int = 2
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
          waitTurns(1)
        }
        var item = customerBasket(i)
        //      customerBasket -= item
        item.state.purchase
        i = i + 1
      }
      j = j + 1
      //      isFirstBasket = true
    }
    if (queue.size == 0) {
      isFirstBasket = true
    } else{
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