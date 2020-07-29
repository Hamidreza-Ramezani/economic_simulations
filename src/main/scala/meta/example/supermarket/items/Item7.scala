package meta.example.supermarket.goods


import meta.classLifting.SpecialInstructions
import meta.example.supermarket.worldmap.WorldTrait
import meta.example.supermarket.{SectionTrait, SupermarketTrait}
import squid.quasi.lift

/* Auto generated from genItems */

@lift
class Item7 (var supermarket: SupermarketTrait, var section: SectionTrait, var world: WorldTrait, var brand: Brand, var price: Double) extends Item with Celery 
{

  /**
    * the item's step function
    */
  def main(): Unit = {
    while (age < freshUntil && (state != isConsumed)) {
      itemInfo
      SpecialInstructions.waitTurns(1)
      age = age + 1
    }
    cleanExpired()
  }
}


