package meta.example.supermarket.goods_updated

import meta.deep.runtime.Actor
import meta.example.supermarket.{Supermarket, SupermarketTrait}
import meta.example.supermarket.utils.to2Dec

trait Item extends Actor {

  var name: String
  var price: Double
  var priceUnit: Int
  var discount: Double
  var stock: Int

  var category: String
  var freshUntil: Int
  var visibility: Double

  var age: Int = 0
  var state: ItemState = ItemState()
  var supermarket: SupermarketTrait = null

  // need to explicitly pass the itemstate as a parameter
  def updateState(newState: String, itemState: ItemState): Unit = {
    newState match {
      case "isPurchased" => itemState.purchase
      case "isDiscarded" => itemState.discard
      case "isConsumed" => itemState.consume
      case "isExpired" => itemState.expire
      case _ => throw new IllegalArgumentException
    }
  }

  def expire: Unit = {
    updateState("isExpired", state)
  }

  def discard: Unit = {
    updateState("isDiscarded", state)
  }

  def purchase: Unit = {
    updateState("isPurchased", state)
  }

  def consume: Unit = {
    updateState("isConsumed", state)
  }

  def itemInfo: Unit = {
    println(f"Item id:$id%-5s Name:$name%-20s Category:$category%-15s Age:$age%-3s Freshness:${to2Dec(1 - 1.0 * age / freshUntil)}%-5s State:${state.get}")
  }

  override def toString: String = {
    f"Item id:$id%-5s Name:$name%-20s Category:$category%-15s Age:$age%-3s Freshness:${to2Dec(1 - 1.0 * age / freshUntil)}%-5s State:${state.get}"
  }

  def cleanExpired(): Unit = {
    if (state.onDisplay) {
      discard
      itemInfo
      supermarket.warehouse(name).popLeft
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

  // fridge calls popleft to remove the expired first. No need to do it here
  def cleanExpired(wastedAmount: Int): Unit = {
    assert(state.isExpired)
    discard
    itemInfo
    supermarket.recordWaste(category, wastedAmount)
    supermarket.isInvalids += id
  }
}