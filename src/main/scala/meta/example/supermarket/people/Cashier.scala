package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.Supermarket
import meta.example.supermarket.goods.Item
import squid.quasi.lift

import scala.collection.mutable.{ListBuffer, Queue}

@lift
class Cashier extends Actor {

  //we need a global object (supermarket's member) that is
  // a collection (Queue) to keep toBeScannedItems

  //customers should have a addToCart method that indicates they want that item
  //what this method does is adding that item to toBeScannedItems and change the state of
  //the item from onDisplay to onCart

  //when the cashier scanned the item, its state can be changed to isScanned or isPurchased
  //scanItems should change the status of items from onConveyor to isPurchased

  var flag: Boolean = false
  def scanItems(queue: Queue[ListBuffer[Item]]): Unit = {
    var customerBasket: ListBuffer[Item] = ListBuffer[Item]()
    if (queue.size > 0){
      customerBasket = queue.dequeue()
    }
    var i: Int = 0
    while (i < customerBasket.size) {
      //here the cashier needs to pop one basket from the toBeScannedItems
      // when all items for the basket are specified, basket should be
      // added to the toBeScannedItems
      // this queue should contain baskets instead of single items

      //if it is the first element please wait
      //      waitTurns(1)
      // in each time that the customer wants to buy, we should have sth like this
      if (!flag) {
        flag = true
        waitTurns(1)
      }
      var item = customerBasket(i)
//      customerBasket -= item
      item.state.purchase
      i = i + 1
      //      println(s"Item ${item.name} is scanned! " + item.id)
    }
    flag = false
  }

  def main(): Unit = {
    while (true) {

      scanItems(Supermarket.store.toBeScannedItems)
      waitTurns(1)
    }
  }
}