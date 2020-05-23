package meta.example.supermarket.goods

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.granularity
import squid.quasi.lift

/* Auto generated from genItems */

@lift
class Meat(override var name: String, override var price: Double, override var priceUnit: Int,
           override var discount: Double, override var stock: Int) extends Item {

  var category: String = "Meat"
  var freshUntil: Int = 15 * granularity.hour
  var visibility: Double = 0.8


  def main(): Unit = {
    while (age < freshUntil && !state.isConsumed) {
      itemInfo
      SpecialInstructions.waitTurns(1)
      age = age + 1
    }
    cleanExpired()
  }
}
