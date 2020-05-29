package meta.example.supermarket.goods_updated

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.granularity
import squid.quasi.lift

/* Auto generated from genItems */

@lift
class Vegetable(override var name: String, override var price: Double, override var priceUnit: Int,
                override var discount: Double, override var stock: Int) extends Item {

  var category: String = "Vegetable"
  var freshUntil: Int = 5 * granularity.hour
  var visibility: Double = 1.0


  def main(): Unit = {
    while (age < freshUntil && !state.isConsumed) {
      itemInfo
      SpecialInstructions.waitTurns(1)
      age = age + 1
    }
    cleanExpired()
  }
}