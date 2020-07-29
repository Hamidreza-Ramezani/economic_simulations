package meta.example.supermarket.goods_updated

import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.utils.utilities

trait ItemTrait_updated extends Actor {

  var name: String
  var price: Double
  var priceUnit: Int
  var discount: Double
  var stock: Int
  var category: String
  var freshUntil: Int
  var visibility: Double
  var age: Int = 0
  var state: ItemState_updated = ItemState_updated()
  var supermarket: SupermarketTrait = null


  def expire: Unit = {
    state.expire
  }

  def discard: Unit = {
    state.discard
  }

  def purchase: Unit = {
    state.purchase
  }

  def consume: Unit = {
    state.consume
  }

  def itemInfo: Unit = {
    println(f"Item id:$id%-5s Name:$name%-20s Category:$category%-15s Age:$age%-3s Freshness:${utilities.to2Dec(1 - 1.0 * age / freshUntil)}%-5s State:${state.get}")
  }

  override def toString: String = {
    f"Item id:$id%-5s Name:$name%-20s Category:$category%-15s Age:$age%-3s Freshness:${utilities.to2Dec(1 - 1.0 * age / freshUntil)}%-5s State:${state.get}"
  }

  /**
    * This function removes the items which are expired from shelves. It also adds them into isInvalids list. This
    * list is used in the simulation driver code to update actors list.
    */
  def cleanExpired(): Unit = {
    if (state.onDisplay) {
      discard
      itemInfo
      //todo: need to uncomment the below line
      //      supermarket.warehouse(name).popLeft
      supermarket.recordWaste(category, priceUnit)
      supermarket.isInvalids += id
    } else if (state.isConsumed) {
      itemInfo
      supermarket.isInvalids += id
    } else {
      expire
      itemInfo
    }
  }

  /**
    * This function is called if an item is expired inside the consumer's fridge
    *
    * @param wastedAmount the amount of the product which is wasted in gram
    */
  def cleanExpired(wastedAmount: Int): Unit = {
    assert(state.isExpired)
    discard
    itemInfo
    supermarket.recordWaste(category, wastedAmount)
    supermarket.isInvalids += id
  }
}