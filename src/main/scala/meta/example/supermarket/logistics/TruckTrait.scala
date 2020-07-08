package meta.example.supermarket.logistics

import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.Item
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable

trait TruckTrait extends Actor {

  var world: WorldTrait
  var supermarket: SupermarketTrait = null
//  var manufacturer:ManufacturerTrait = null
  var truckState: TruckState = relaxed

  override def setInitialPosition(worldTrait: WorldTrait, x: Int, y: Int): Unit = {
    world.coordinates_flattened.foreach {
      tile =>
        tile.actors.foreach {
          manufacturer =>
            if (manufacturer.getClass.getSimpleName == "Manufacturer") {
              this.initialXPosition = manufacturer.initialXPosition
              this.initialYPosition = manufacturer.initialYPosition
            }
        }
    }
    currentXPosition = initialXPosition
    currentYPosition = initialYPosition
    oldXPosition = initialXPosition
    oldYPosition = initialYPosition
  }


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

}
