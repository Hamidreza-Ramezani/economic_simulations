package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.goods.Item
import squid.quasi.lift
import scala.collection.mutable.Queue

@lift
class Cashier extends Actor{

  // we need a global object (supermarket's member) that is
  // a collection (Queue) to keep toBeScannedItems


  //customers should have a requestItem method that indicates they want that item
  //what this method does is adding that item to toBeScannedItems and change the state of
  //the item from onDisplay to onConveyor

  //scanItems should change the status of items from onConveyor to isPurchased


  def scanItems(queue: Queue[Item]): Unit ={
    //val item: Item = queue.deque()
    //call those methods (buyItems)
  }

  def main(): Unit = {
    while (true) {
//      scanItems(toBeScannedItems)
      waitTurns(1)
    }
  }



}