package meta.example.supermarket.people

import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.Item
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

trait CashierTrait extends Actor {

  var world: WorldTrait
  var numOfBasketsHandledInOneStep: Int = 1
  var toBeScannedItems: mutable.Queue[ListBuffer[Item]] = new mutable.Queue[ListBuffer[Item]]()
  var supermarket: SupermarketTrait


  override def setInitialPosition(world: WorldTrait, x: Int, y: Int): Unit = {
    this.initialXPosition = supermarket.initialXPosition
    this.initialYPosition = supermarket.initialYPosition
    currentXPosition = initialXPosition
    currentYPosition = initialYPosition


    //    world.coordinates_flattened.foreach {
    //      tile =>
    //        tile.actors.foreach {
    //          actor =>
    //            if (actor.getClass.getSimpleName == "Supermarket") {
    //              this.initialXPosition = actor.initialXPosition
    //              this.initialYPosition = actor.initialYPosition
    //            }
    //        }
    //    }
    //    currentXPosition = initialXPosition
    //    currentYPosition = initialYPosition
  }





  def setNumOfBasketHandledInOneStep(numOfBasketsHandledInOneStep: Int): Unit = {
    this.numOfBasketsHandledInOneStep = numOfBasketsHandledInOneStep
  }

  override def toString = s"Cashier id ($id)   "
}
