package meta.example.supermarket.logistics

import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.{Brand, Item, global}
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

trait ManufacturerTrait extends Actor {

  var world: WorldTrait
  var manufacturerState: ManufacturerState = idle
  var trucks: ListBuffer[TruckTrait]
  var supermarkets: ListBuffer[SupermarketTrait]
  var numberOfDifferentBrands = 3

  canMove = false
  var isPositionsFixed: Boolean = false

  override def setInitialPosition(world: WorldTrait, x: Int, y: Int): Unit = {
    if (!isPositionsFixed) {
      this.initialXPosition = x
      this.initialYPosition = y
      currentXPosition = initialXPosition
      currentYPosition = initialYPosition
      oldXPosition = initialXPosition
      oldYPosition = initialYPosition
      world.coordinates(y)(x).hasOwner = true
      isPositionsFixed = true
    }
  }

  var storage: mutable.Map[(String, Brand), mutable.Queue[Item]] = mutable.Map()
  global.priceMap.keys.foreach {
    pair =>
      val itemNum = pair._1
      val itemBrand = pair._2
      val itemName: String = global.itemNameToID.map(_.swap).getOrElse(itemNum, "")
      storage += ((itemName, itemBrand) -> new mutable.Queue[Item])
  }

  def numberOfItemsSupermarketNeeds(supermarket: SupermarketTrait): Int = {
    var inventoryList: mutable.Map[(String, Brand), Int] = getFreeSpace(supermarket)
    val result = inventoryList.foldLeft(0)(_ + _._2)
    result
  }

  def getFreeSpace(): mutable.Map[(String, Brand), Int] = {
    var aggregatedMap: mutable.Map[(String, Brand), Int] = mutable.Map().withDefaultValue(0)
    supermarkets.toList.foreach {
      supermarket => aggregatedMap = aggregatedMap ++ getFreeSpace(supermarket).map { case (k, v) => k -> (v + aggregatedMap.getOrElse(k, 0)) }
    }
    aggregatedMap
  }

  def getFreeSpace(supermarket: SupermarketTrait): mutable.Map[(String, Brand), Int] = {
    var inventoryList: mutable.Map[(String, Brand), Int] = mutable.Map()
    global.priceMap.keys.toList.foreach {
      pair =>
        var itemNum = pair._1
        var itemBrand = pair._2
        var itemName: String = global.itemNameToID.map(_.swap).getOrElse(itemNum, "")
        inventoryList += ((itemName,itemBrand) -> getFreeSpace(supermarket, (itemName, itemBrand)))
    }
    inventoryList
  }

  def getFreeSpace(supermarket: SupermarketTrait, itemTuple: (String, Brand)): Int = {
    supermarket.shelfCapacity - supermarket.warehouse.filter(_.sectionName == global.categoryMap(itemTuple._1)).head.shelves(itemTuple).size
  }
}