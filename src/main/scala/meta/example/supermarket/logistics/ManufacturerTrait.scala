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

  /**
    *
    * @param world the world object which includes the manufacturer.
    * @param x     the x coordinate of initial position for the manufacturer.
    * @param y     the y coordinate of initial position for the manufacturer.
    */
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

  /**
    * map's keys are tuple of item names and brands like (potato,Aha) and the values are queues of that item. The item
    * which is produced sooner, will be added to this queue ahead of others. Here the map is just initialized with all
    * items can be found in the global maps in global singleton object and empty queues.
    */
  var storage: mutable.Map[(String, Brand), mutable.Queue[Item]] = mutable.Map()
  global.priceMap.keys.foreach {
    pair =>
      val itemNum = pair._1
      val itemBrand = pair._2
      val itemName: String = global.itemNameToID_test.map(_.swap).getOrElse(itemNum, "")
      storage += ((itemName, itemBrand) -> new mutable.Queue[Item])
  }

  /**
    *
    * @param supermarket The supermarket which places an order to manufacturer.
    * @return The overall number of items requested by the supermarket.
    */
  def numberOfItemsSupermarketNeeds(supermarket: SupermarketTrait): Int = {
    var inventoryList: mutable.Map[(String, Brand), Int] = getFreeSpace(supermarket)
    val result = inventoryList.foldLeft(0)(_ + _._2)
    result
  }

  /**
    *
    * @return a map whose keys are tuple of item names and brand like (eggplant,TerraSuisse) and its values are
    *         integers indicating the number of items all supermarkets ordered. For example, a possible key value pair
    *         is ((Potato, Aha), 20) which means the whole demand of supermarkets for potatos of Aha is 20 ,i.e.,
    *         Supermarket1 asked for 8 Aha potatos, supermarket2 asked for 9, and supermarket3 asked for 3 items.
    */
  def getFreeSpace(): mutable.Map[(String, Brand), Int] = {
    var aggregatedMap: mutable.Map[(String, Brand), Int] = mutable.Map().withDefaultValue(0)
    supermarkets.toList.foreach {
      supermarket => aggregatedMap = aggregatedMap ++ getFreeSpace(supermarket).map { case (k, v) => k -> (v + aggregatedMap.getOrElse(k, 0)) }
    }
    aggregatedMap
  }


  /**
    *
    * @param supermarket
    * @return a map whose keys are tuple of item names and brand like (eggplant,TerraSuisse) and its values are
    *         integers indicating the number of items which the supermarket ordered. For example, a possible
    *         key value pair is ((Potato, Aha), 20) which means the supermarket needs 20 potatos of Aha.
    *
    */
  def getFreeSpace(supermarket: SupermarketTrait): mutable.Map[(String, Brand), Int] = {
    var inventoryList: mutable.Map[(String, Brand), Int] = mutable.Map()
    global.priceMap.keys.toList.foreach {
      pair =>
        var itemNum = pair._1
        var itemBrand = pair._2
        var itemName: String = global.itemNameToID_test.map(_.swap).getOrElse(itemNum, "")
        inventoryList += ((itemName, itemBrand) -> getFreeSpace(supermarket, (itemName, itemBrand)))
    }
    inventoryList
  }


  /**
    *
    * @param supermarket
    * @param itemTuple like (potato,optigal)
    * @return an integer represents the number of items which the supermarket ordered.
    */
  def getFreeSpace(supermarket: SupermarketTrait, itemTuple: (String, Brand)): Int = {
    supermarket.shelfCapacity - supermarket.warehouse.filter(_.sectionName == global.categoryMap(itemTuple._1)).head.shelves(itemTuple).size
  }
}