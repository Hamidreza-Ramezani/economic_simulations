package meta.example.supermarket.goods

import meta.example.supermarket.granularity

/* Auto generated from genGoods
 Please adjust file categories for modification
 */

trait Snack {
  val category: String = "Snack"
  val freshUntil: Int = 100 * granularity.hour
  val visibility: Double = 1.0
}

trait Kitkat extends Snack {
  val name: String = "Kitkat"
//  val price: Double = 3.5
  val priceUnit: Int = 300
  val discount: Double = 0.0
  val stock: Int = 10
}

trait Ferraro extends Snack {
  val name: String = "Ferraro"
//  val price: Double = 5.0
  val priceUnit: Int = 250
  val discount: Double = 0.0
  val stock: Int = 10
}

trait DarkChocolate extends Snack {
  val name: String = "DarkChocolate"
//  val price: Double = 1.8
  val priceUnit: Int = 100
  val discount: Double = 0.0
  val stock: Int = 10
}

trait WhiteChocolate extends Snack {
  val name: String = "WhiteChocolate"
//  val price: Double = 1.8
  val priceUnit: Int = 100
  val discount: Double = 0.0
  val stock: Int = 10
}
