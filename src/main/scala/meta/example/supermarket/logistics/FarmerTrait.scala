package meta.example.supermarket.logistics

import meta.deep.runtime.Actor
import meta.example.supermarket.goods.{Item, newItemsMap}
import meta.example.supermarket.worldmap.WorldTrait
import scala.collection.mutable

trait FarmerTrait extends Actor {
  var world: WorldTrait
  var crops: mutable.Queue[Item] = new mutable.Queue[Item]
  var farmerState: FarmerState = doNothing
  var manufacturer: ManufacturerTrait

  def getFreeSpace(): mutable.Map[String, Int] = {
    manufacturer.getFreeSpace()
  }

  def getFreeSpace(item: String): Int = {
    manufacturer.getFreeSpace()(item)
  }
}