package meta.example.supermarket.goods

import meta.classLifting.SpecialInstructions
import squid.quasi.lift

/* Auto generated from genItems */

@lift
class Item28 (override var name: String, override var price: Double, override var priceUnit: Int,
              override var discount: Double, override var stock: Int)
  extends Item with Dairy {
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
