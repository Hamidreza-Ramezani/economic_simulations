package meta.example.supermarket.logistics

import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.{Brand, Item, global}
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable

trait TruckTrait extends Actor {

  var world: WorldTrait
  var supermarket: SupermarketTrait = null
  var manufacturer: ManufacturerTrait = null
  var truckState: TruckState = relaxed

  /**
    * Truck's initial position is specified based on the manufacturer's position, thoguh it can be something else.
    *
    * @param worldTrait the world object contain all agents
    * @param x          This method is overridden. That is why it must have the same signature as the
    *                   parent functionIn the parent function. Here, this parameter is not used.
    * @param y          This method is overridden. That is why it must have the same signature as the
    *                   parent functionIn the parent function. Here, this parameter is not used.
    */
  override def setInitialPosition(worldTrait: WorldTrait, x: Int, y: Int): Unit = {
    world.coordinates_flattened.foreach {
      tile =>
        tile.actors.foreach {
          manufacturer =>
            if (manufacturer.getClass.getSimpleName == "Manufacturer") {
              this.initialXPosition = manufacturer.initialXPosition
              this.initialYPosition = manufacturer.initialYPosition
            }
        }
    }
    currentXPosition = initialXPosition
    currentYPosition = initialYPosition
    oldXPosition = initialXPosition
    oldYPosition = initialYPosition
  }

  var storage: mutable.Map[(String, Brand), mutable.Queue[Item]] = mutable.Map()
  global.priceMap.keys.foreach {
    pair =>
      val itemNum = pair._1
      val itemBrand = pair._2
      val itemName: String = global.itemNameToID_test.map(_.swap).getOrElse(itemNum, "")
      storage += ((itemName, itemBrand) -> new mutable.Queue[Item])
  }
}