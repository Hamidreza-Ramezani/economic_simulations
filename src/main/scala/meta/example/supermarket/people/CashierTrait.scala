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

  override def setInitialPosition(x: Int, y: Int): Unit = {
    world.coordinates_flattened.foreach {
      tile =>
        tile.actors.foreach {
          supermarket =>
            if (supermarket.getClass.getSimpleName == "Supermarket") {
              this.initialXPosition = supermarket.initialXPosition
              this.initialYPosition = supermarket.initialYPosition
            }
        }
    }
    currentXPosition = initialXPosition
    currentYPosition = initialYPosition
  }


  def setNumOfBasketHandledInOneStep(numOfBasketsHandledInOneStep: Int): Unit = {
    this.numOfBasketsHandledInOneStep = numOfBasketsHandledInOneStep
  }

}
