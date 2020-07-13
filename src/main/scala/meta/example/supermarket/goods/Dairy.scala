package meta.example.supermarket.goods

import meta.example.supermarket.granularity

/* Auto generated from genGoods
 Please adjust file categories for modification
 */

trait Dairy {
  val category: String = "Dairy"
  val freshUntil: Int = 7 * granularity.hour
  val visibility: Double = 0.8
}

trait Milk extends Dairy {
  val name: String = "Milk"
//  val price: Double = 2.0
  val priceUnit: Int = 1000
  val discount: Double = 0.0
  val stock: Int = 3
}

trait Yogurt extends Dairy {
  val name: String = "Yogurt"
//  val price: Double = 1.0
  val priceUnit: Int = 50
  val discount: Double = 0.0
  val stock: Int = 3
}

trait Cheese extends Dairy {
  val name: String = "Cheese"
//  val price: Double = 5.0
  val priceUnit: Int = 200
  val discount: Double = 0.0
  val stock: Int = 3
}

trait Cream extends Dairy {
  val name: String = "Cream"
//  val price: Double = 1.0
  val priceUnit: Int = 50
  val discount: Double = 0.0
  val stock: Int = 3
}

trait Egg extends Dairy {
  val name: String = "Egg"
//  val price: Double = 3.0
  val priceUnit: Int = 250
  val discount: Double = 0.0
  val stock: Int = 3
}
