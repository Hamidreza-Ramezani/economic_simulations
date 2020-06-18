package meta.example.supermarket.people

import meta.deep.runtime.Actor
import meta.example.supermarket.goods.Item
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

trait CashierTrait extends Actor {

  var world: WorldTrait
  var numOfBasketsHandledInOneStep: Int = 1
  var toBeScannedItems: mutable.Queue[ListBuffer[Item]] = new mutable.Queue[ListBuffer[Item]]()

  def setNumOfBasketHandledInOneStep(numOfBasketsHandledInOneStep: Int): Unit = {
    this.numOfBasketsHandledInOneStep = numOfBasketsHandledInOneStep
  }

}
