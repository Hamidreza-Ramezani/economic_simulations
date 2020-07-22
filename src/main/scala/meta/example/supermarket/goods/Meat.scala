package meta.example.supermarket.goods

import meta.example.supermarket.granularity

/* Auto generated from genGoods
 Please adjust file categories for modification
 */

trait Meat {
  val category: String = "Meat"
  val freshUntil: Int = 16 * granularity.hour
  val visibility: Double = 0.8
}

trait Chicken extends Meat {
  val name: String = "Chicken"
//  val price: Double = 15.0
  val priceUnit: Int = 1000
  val discount: Double = 0.0
  val stock: Int = 3
}

trait Beef extends Meat {
  val name: String = "Beef"
//  val price: Double = 35.0
  val priceUnit: Int = 1000
  val discount: Double = 0.0
  val stock: Int = 3
}

trait Pork extends Meat {
  val name: String = "Pork"
//  val price: Double = 25.0
  val priceUnit: Int = 1000
  val discount: Double = 0.0
  val stock: Int = 3
}

trait Lamb extends Meat {
  val name: String = "Lamb"
//  val price: Double = 45.0
  val priceUnit: Int = 1000
  val discount: Double = 0.0
  val stock: Int = 3
}

trait Bacon extends Meat {
  val name: String = "Bacon"
//  val price: Double = 25.0
  val priceUnit: Int = 1000
  val discount: Double = 0.0
  val stock: Int = 3
}
