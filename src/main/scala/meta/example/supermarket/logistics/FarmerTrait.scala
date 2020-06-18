package meta.example.supermarket.logistics

import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.Item
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable

trait FarmerTrait extends Actor {


  var world: WorldTrait
  //  var supermarket: SupermarketTrait
  //  var capacity: Int = supermarket.shelfCapacity
  //  var cap: Int = 5
  var crops: mutable.Queue[Item] = new mutable.Queue[Item]
  var farmerState: FarmerState = doNothing
  var manufacturer: ManufacturerTrait

  def getFreeSpace(item: String): Int = {
    manufacturer.getFreeSpace(item)
    //    5
  }

}
