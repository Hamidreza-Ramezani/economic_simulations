package meta.example.supermarket.logistics

import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.{Item, newItemsMap}
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable

trait ManufacturerTrait extends Actor {

  var world: WorldTrait
  var manufacturerState: ManufacturerState = idle
  var truck: TruckTrait
  var supermarket: SupermarketTrait
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

  def getFreeSpace(item: String): Int = {
    supermarket.shelfCapacity - supermarket.warehouse.filter(_.sectionName == newItemsMap.categoryMap(item)).head.shelves(item).size
  }
}