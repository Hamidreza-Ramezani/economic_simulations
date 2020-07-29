package meta.example.supermarket.logistics

import meta.deep.runtime.Actor
import meta.example.supermarket.goods.{Brand, Item, global}
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable

trait FarmerTrait extends Actor {
  var world: WorldTrait
  var crops: mutable.Queue[Item] = new mutable.Queue[Item]
  var farmerState: FarmerState = doNothing
  var manufacturer: ManufacturerTrait

  /**
    *
    * @return a map whose keys are tuple of item names and brand like (eggplant,TerraSuisse) and its values are
    *         integers indicating the number of items manufacturer ordered. For example, a possible key value pair is
    *         ((Potato, Aha), 20) which means manufacturer needs 20 potatos of Aha.
    */
  def getFreeSpace(): mutable.Map[(String, Brand), Int] = {
    manufacturer.getFreeSpace()
  }

  /**
    *
    * @param itemName the item's name like milk
    * @param brand    the brand like Optigal
    * @return the number of items manufacturer ordered for that particular item
    */
  def getFreeSpace(itemName: String, brand: Brand): Int = {
    manufacturer.getFreeSpace()((itemName, brand))
  }
}