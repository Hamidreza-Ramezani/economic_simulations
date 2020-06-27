package meta.example.supermarket.logistics

import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.{Item, newItemsMap}
import meta.example.supermarket.worldmap.WorldTrait
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

trait ManufacturerTrait extends Actor {

  var world: WorldTrait
  var manufacturerState: ManufacturerState = idle
  var truck: TruckTrait
//  var supermarket: SupermarketTrait
  var supermarkets: ListBuffer[SupermarketTrait]
  canMove = false

  //  var capacity: Int = supermarket.shelfCapacity

  var storage: mutable.Map[String, mutable.Queue[Item]] = mutable.Map(
    "Squash" -> new mutable.Queue[Item],
    "Cabbage" -> new mutable.Queue[Item],
    "Broccoli" -> new mutable.Queue[Item],
    "Eggplant" -> new mutable.Queue[Item],
    "Potato" -> new mutable.Queue[Item],
    "Celery" -> new mutable.Queue[Item],
    "Cucumber" -> new mutable.Queue[Item],
    "Tomato" -> new mutable.Queue[Item],
    "Onion" -> new mutable.Queue[Item],
    "Carrots" -> new mutable.Queue[Item],
    "Mushroom" -> new mutable.Queue[Item]
  )

  def getFreeSpace(): mutable.Map[String, Int] = {
    var aggregatedMap: mutable.Map[String, Int] = mutable.Map().withDefaultValue(0)
    supermarkets.toList.foreach {
      supermarket => aggregatedMap = aggregatedMap ++ getFreeSpace(supermarket).map { case (k, v) => k -> (v + aggregatedMap.getOrElse(k, 0)) }
    }
    aggregatedMap
  }


  def getFreeSpace(supermarket: SupermarketTrait): mutable.Map[String, Int] = {
    var inventoryList: mutable.Map[String, Int] = mutable.Map()
    newItemsMap.itemMap_test.keys.toList.foreach {
      itemStr => inventoryList += (itemStr -> getFreeSpace(supermarket, itemStr))
    }
    inventoryList
  }

  def getFreeSpace(supermarket: SupermarketTrait, item: String): Int = {
    supermarket.shelfCapacity - supermarket.warehouse.filter(_.sectionName == newItemsMap.categoryMap(item)).head.shelves(item).size
  }
}