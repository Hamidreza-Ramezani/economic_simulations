package meta.example.supermarket.goods

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.{Section, SectionTrait, Supermarket, SupermarketTrait}
import squid.quasi.lift

/* Auto generated from genItems */

@lift
class Item1(var supermarket: SupermarketTrait,var section: SectionTrait) extends Item with Eggplant {

//  var section = supermarket.warehouse.filter(_.sectionName == "Vegetable").head

  def main(): Unit = {
    while (age < freshUntil && !state.isConsumed) {
      itemInfo
      SpecialInstructions.waitTurns(1)
      age = age + 1
    }
    cleanExpired()
  }
}
