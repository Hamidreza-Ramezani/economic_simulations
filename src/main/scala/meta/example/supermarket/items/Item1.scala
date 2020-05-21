package meta.example.supermarket.goods

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.utils.randElement
import squid.quasi.lift

/* Auto generated from genItems */

@lift
class Item1(override var name: String, override var price: Double, override var priceUnit: Int,
            override var discount: Double, override var stock: Int)
  extends Item with Vegetable {

  def main(): Unit = {

    while (age < freshUntil && !state.isConsumed) {
      itemInfo
      SpecialInstructions.waitTurns(1)
      age = age + 1
    }
    cleanExpired()
  }
}
