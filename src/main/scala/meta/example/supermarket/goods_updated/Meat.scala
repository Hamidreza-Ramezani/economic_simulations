package meta.example.supermarket.goods_updated

import meta.classLifting.SpecialInstructions
//import meta.example.supermarket.goods.Item
import meta.example.supermarket.granularity
import squid.quasi.lift

/* Auto generated from genItems */

@lift
class Meat(override var name: String, override var price: Double, override var priceUnit: Int,
           override var discount: Double, override var stock: Int) extends ItemTrait_updated {

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
