package meta.example.supermarket.logistics

import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.Item

import scala.collection.mutable

trait FarmerTrait extends Actor {

  var supermarket: SupermarketTrait
  var cap: Int = supermarket.shelfCapacity
  //  var cap: Int = 5
  var crops: mutable.Queue[Item] = new mutable.Queue[Item]
  var farmerState: FarmerState = doNothing
  var manufacturer: ManufacturerTrait

}
