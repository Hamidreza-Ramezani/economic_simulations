package meta.example.supermarket.goods

import meta.deep.runtime.Actor
import meta.example.supermarket.people.People
import meta.example.supermarket.utils.utilities.to2Dec
import meta.example.supermarket.worldmap.WorldTrait
import meta.example.supermarket.{SectionTrait, SupermarketTrait}

/**
  * This is an interface which includes the methods and attributes which are common to all items.
  */
trait Item extends Actor {

  var world: WorldTrait
  var price: Double
  var brand: Brand
  var owner: Actor = null //at first the owner of items is farmer. Then it changes to manufacturer. Finally, the owener would be the supermarket.
  val name: String
  val priceUnit: Int
  var discount: Double
  val stock: Int
  val category: String
  val freshUntil: Int
  val visibility: Double
  var age: Int = 0
  var state: ItemState = inFarm
  var supermarket: SupermarketTrait // the supermarket which has the item
  var section: SectionTrait // the section this item belongs to


  def expire: Unit = {
    state = isExpired
    if (owner.isInstanceOf[People]) {
      owner.asInstanceOf[People].fridge.rmExpired(name)
    }
  }

  def discard: Unit = {
    state = isDiscarded
    owner.writer.write("Item id: " + id + " is expired and discarded" + "\n")
    owner.writer.flush()
  }

  def purchase: Unit = {
    state = isPurchased
  }

  def consume: Unit = {
    state = isConsumed
  }

  def itemInfo: Unit = {
    println(f"Item id:$id%-15s Name:$name%-15s Brand:$brand%-15s price:$price%-15s Category:$category%-15s Age:$age%-15s Freshness:${to2Dec(1 - 1.0 * age / freshUntil)}%-15s State:${state}%-15s OwnerID:${owner.id} ")
  }

  override def toString: String = {
    f"Item id:$id%-15s Name:$name%-15s Brand:$brand%-15s price:$price%-15s Category:$category%-15s Age:$age%-15s Freshness:${to2Dec(1 - 1.0 * age / freshUntil)}%-15s State:${state}%-15s OwnerID:${owner.id}"
  }

  /**
    * This function removes the items which are expired from shelves. It also adds them into isInvalids list. This
    * list is used in the simulation driver code to update actors list.
    */
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

  /**
    * This function is called if an item is expired inside the consumer's fridge
    *
    * @param wastedAmount the amount of the product which is wasted in gram
    */
  def cleanExpired(wastedAmount: Int): Unit = {
    assert(state == isExpired)
    discard
    itemInfo
    section.recordWaste(category, wastedAmount)
    section.isInvalids += id
    supermarket.isInvalids += id
  }
}