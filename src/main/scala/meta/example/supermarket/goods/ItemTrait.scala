package meta.example.supermarket.goods

import meta.deep.runtime.Actor
import meta.example.supermarket.people.People
import meta.example.supermarket.utils.utilities.to2Dec
import meta.example.supermarket.worldmap.WorldTrait
import meta.example.supermarket.{SectionTrait, SupermarketTrait}

trait Item extends Actor {

  var world: WorldTrait
  var price: Double
  var brand: Brand
  var owner: Actor = null
  val name: String
  val priceUnit: Int
  var discount: Double
  val stock: Int
  val category: String
  val freshUntil: Int
  val visibility: Double
  var age: Int = 0
  var state: ItemState = inFarm
  var supermarket: SupermarketTrait
  var section: SectionTrait



  // need to explicitly pass the itemstate as a parameter
  def updateState(newState: ItemState): Unit = {
    newState match {
      case isPurchased => state = isPurchased
      case isDiscarded => state = isDiscarded
      case isConsumed => state = isConsumed
      case isExpired => state = isExpired
      case _ => throw new IllegalArgumentException
    }
  }

  def expire: Unit = {
    updateState(isExpired)
    if(owner.isInstanceOf[People]){
      owner.asInstanceOf[People].fridge.rmExpired(name)
    }
  }

  def discard: Unit = {
    updateState(isDiscarded)
    owner.writer.write("Item id: " + id + " is expired and discarded" + "\n")
    owner.writer.flush()
  }

  def purchase: Unit = {
    updateState(isPurchased)
  }

  def consume: Unit = {
    updateState(isConsumed)
  }

  def itemInfo: Unit = {
    println(f"Item id:$id%-15s Name:$name%-15s Brand:$brand%-15s price:$price%-15s Category:$category%-15s Age:$age%-15s Freshness:${to2Dec(1 - 1.0 * age / freshUntil)}%-15s State:${state}%-15s OwnerID:${owner.id} ")
  }

  override def toString: String = {
    f"Item id:$id%-15s Name:$name%-15s Brand:$brand%-15s price:$price%-15s Category:$category%-15s Age:$age%-15s Freshness:${to2Dec(1 - 1.0 * age / freshUntil)}%-15s State:${state}%-15s OwnerID:${owner.id}"
  }

  def cleanExpired(): Unit = {
    if (state == onDisplay) {
      discard
      itemInfo
      section.shelves((name, brand)).popLeft
      section.recordWaste(category, priceUnit)
      section.isInvalids += id
      supermarket.isInvalids += id
    } else if (state == isConsumed) {
      itemInfo
      section.isInvalids += id
      //      supermarket.isInvalids += id
    } else {
      expire
      itemInfo
    }
  }

  // fridge calls popleft to remove the expired first. No need to do it here
  def cleanExpired(wastedAmount: Int): Unit = {
    assert(state == isExpired)
    discard
    itemInfo
    section.recordWaste(category, wastedAmount)
    section.isInvalids += id
    supermarket.isInvalids += id
  }
}
