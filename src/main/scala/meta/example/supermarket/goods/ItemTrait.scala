package meta.example.supermarket.goods

import meta.deep.runtime.Actor
import meta.example.supermarket.{SectionTrait, SupermarketTrait}
import meta.example.supermarket.utils.to2Dec
import meta.example.supermarket.worldmap.WorldTrait

trait Item extends Actor {

  var world: WorldTrait
  val name: String
  val price: Double
  val priceUnit: Int
  val discount: Double
  val stock: Int

  val category: String
  val freshUntil: Int
  val visibility: Double

  //  var name: String
  //  var price: Double
  //  var priceUnit: Int
  //  var discount: Double
  //  var stock: Int
  //
  //  var category: String
  //  var freshUntil: Int
  //  var visibility: Double

  var age: Int = 0
  var state: ItemState = ItemState()
  var supermarket: SupermarketTrait
  var section: SectionTrait

  //  override def setInitialPosition(x: Int, y: Int): Unit = {
  //    world.coordinates_flattened.foreach {
  //      tile =>
  //        tile.actors.foreach {
  //          actor =>
  //            if (actor.getClass.getSimpleName == "Supermarket") {
  //              this.initialXPosition = actor.initialXPosition
  //              this.initialYPosition = actor.initialYPosition
  //            }
  //        }
  //    }
  //    currentXPosition = initialXPosition
  //    currentYPosition = initialYPosition
  //
  //    //    this.xPosition = supermarket.xPosition
  //    //    this.yPosition = supermarket.yPosition
  //  }


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
    //    println(f"Item id:$id%-5s Name:$name%-20s Category:$category%-15s Age:$age%-3s Freshness:${to2Dec(1 - 1.0 * age / freshUntil)}%-5s State:${state.get}")
    if (state.get != "inFarm" && state.get != "inManufacturer" && state.get != "inTruck") {
      println(f"Item id:$id%-5s Name:$name%-20s Category:$category%-15s Age:$age%-3s Freshness:${to2Dec(1 - 1.0 * age / freshUntil)}%-5s State:${state.get} ${supermarket.id}")
    }
    else {
      println(f"Item id:$id%-5s Name:$name%-20s Category:$category%-15s Age:$age%-3s Freshness:${to2Dec(1 - 1.0 * age / freshUntil)}%-5s State:${state.get}")
    }

  }

  override def toString: String = {
    if (state.get != "inFarm" && state.get != "inManufacturer" && state.get != "inTruck") {
      return f"Item id:$id%-5s Name:$name%-20s Category:$category%-15s Age:$age%-3s Freshness:${to2Dec(1 - 1.0 * age / freshUntil)}%-5s State:${state.get} ${supermarket.id}"
    }
    else {
      return f"Item id:$id%-5s Name:$name%-20s Category:$category%-15s Age:$age%-3s Freshness:${to2Dec(1 - 1.0 * age / freshUntil)}%-5s State:${state.get}"
    }
  }

  def cleanExpired(): Unit = {
    if (state.onDisplay) {
      discard
      itemInfo
      section.shelves(name).popLeft
      section.recordWaste(category, priceUnit)
      section.isInvalids += id
      supermarket.isInvalids += id
    } else if (state.isConsumed) {
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
    assert(state.isExpired)
    discard
    itemInfo
    section.recordWaste(category, wastedAmount)
    section.isInvalids += id
    supermarket.isInvalids += id
  }
}
