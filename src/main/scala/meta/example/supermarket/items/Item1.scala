package meta.example.supermarket.goods

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.worldmap.WorldTrait
import meta.example.supermarket.{Section, SectionTrait, Supermarket, SupermarketTrait}
import squid.quasi.lift

import scala.util.Random

/* Auto generated from genItems */

@lift
class Item1(var supermarket: SupermarketTrait,var section: SectionTrait,var world: WorldTrait) extends Item with Eggplant {

//  var section = supermarket.warehouse.filter(_.sectionName == "Vegetable").head

  def main(): Unit = {
    setInitialPosition(Random.nextInt(world.width), Random.nextInt(world.height))
    world.addActor(this)

    while (age < freshUntil && !state.isConsumed) {
      itemInfo
      SpecialInstructions.waitTurns(1)
      age = age + 1
    }
    cleanExpired()
  }
}
