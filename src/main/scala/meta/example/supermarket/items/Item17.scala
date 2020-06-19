package meta.example.supermarket.goods

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.worldmap.WorldTrait
import meta.example.supermarket.{SectionTrait, Supermarket, SupermarketTrait}
import squid.quasi.lift

import scala.util.Random

/* Auto generated from genItems */

@lift
class Item17(var supermarket: SupermarketTrait, var section: SectionTrait, var world: WorldTrait) extends Item with Kitkat {
  //var age: Int = 0

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
