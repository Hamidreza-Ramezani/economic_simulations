package meta.example.supermarket.goods

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.{SectionTrait, Supermarket, SupermarketTrait}
import squid.quasi.lift

/* Auto generated from genItems */

@lift
class Item27( var supermarket: SupermarketTrait,var section: SectionTrait) extends Item with Bread {
  //var age: Int = 0

  def main(): Unit = {
    while(age < freshUntil && !state.isConsumed) {
        itemInfo
        SpecialInstructions.waitTurns(1)
        age = age + 1
    }
    cleanExpired()
  }
}
