package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.Supermarket
import meta.example.supermarket.goods.Item
import squid.quasi.lift
import scala.collection.mutable.{ListBuffer, Queue}

@lift
class Cashier extends Actor {
  var isFirstItemInBasket: Boolean = true

  def scanItems(queue: Queue[ListBuffer[Item]]): Unit = {
    var customerBasket: ListBuffer[Item] = ListBuffer[Item]()
    if (queue.size > 0) {
      customerBasket = queue.dequeue()
    }
    var i: Int = 0
    while (i < customerBasket.size) {
      if (isFirstItemInBasket) {
        isFirstItemInBasket = false
        waitTurns(1)
      }
      var item = customerBasket(i)
      //      customerBasket -= item
      item.state.purchase
      i = i + 1
      //      println(s"Item ${item.name} is scanned! " + item.id)
    }
    isFirstItemInBasket = true
  }

  def main(): Unit = {
    while (true) {
      scanItems(Supermarket.store.toBeScannedItems)
      waitTurns(1)
    }
  }
}