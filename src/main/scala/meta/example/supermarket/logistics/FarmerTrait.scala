package meta.example.supermarket.logistics

import meta.deep.runtime.Actor
import meta.example.supermarket.goods.{Brand, Item, newItemsMap}
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable

trait FarmerTrait extends Actor {
  var world: WorldTrait
  var crops: mutable.Queue[Item] = new mutable.Queue[Item]
  var farmerState: FarmerState = doNothing
  var manufacturer: ManufacturerTrait

  def getFreeSpace(): mutable.Map[(String,Brand), Int] = {
    manufacturer.getFreeSpace()
  }

  def getFreeSpace(itemName: String, brand:Brand): Int = {
    manufacturer.getFreeSpace()((itemName,brand))
  }
}