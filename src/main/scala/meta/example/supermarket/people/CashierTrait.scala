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


  /**
    * the cashier's initial position is specified based on supermarket's initial position, though it can be set another
    * value and require cashier to move from his/her home to supermarket.
    * @param world the world object contain all agents
    * @param x This method is overridden. That is why it must have the same signature as the
    *          parent functionIn the parent function. Here, this parameter is not used.
    * @param y This method is overridden. That is why it must have the same signature as the
    *          parent functionIn the parent function. Here, this parameter is not used.
    */
  override def setInitialPosition(world: WorldTrait, x: Int, y: Int): Unit = {
    this.initialXPosition = supermarket.initialXPosition
    this.initialYPosition = supermarket.initialYPosition
    currentXPosition = initialXPosition
    currentYPosition = initialYPosition
    oldXPosition = initialXPosition
    oldYPosition = initialYPosition
  }


  /**
    * setter function for the numOfBasketsHandledInOneStep attribute. numOfBasketsHandledInOneStep specifies the number
    * of baskets cashier can scan in one time step.
    * @param numOfBasketsHandledInOneStep
    */
  def setNumOfBasketHandledInOneStep(numOfBasketsHandledInOneStep: Int): Unit = {
    this.numOfBasketsHandledInOneStep = numOfBasketsHandledInOneStep
  }

  override def toString = s"Cashier id ($id)   "
}