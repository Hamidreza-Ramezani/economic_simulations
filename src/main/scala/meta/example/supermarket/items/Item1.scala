package meta.example.supermarket.goods

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.utils.randElement
import squid.quasi.lift

/* Auto generated from genItems */

@lift
class Item1(override val name: String, override val price: Double, override val priceUnit: Int,
            override val discount: Double, override val stock: Int,
            override val category: String, override val freshUntil: Int,
            override val visibility: Double)
  extends Item(name, price, priceUnit, discount, stock, category, freshUntil, visibility) {

  def main(): Unit = {

    while (age < freshUntil && !state.isConsumed) {
      itemInfo
      SpecialInstructions.waitTurns(1)
      age = age + 1
    }
    cleanExpired()
  }
}
