package meta.example.supermarket.goods

import meta.example.supermarket.granularity

/* Auto generated from genGoods
 Please adjust file categories for modification
 */

trait Grain {
  val category: String = "Grain"
  val freshUntil: Int = 50 * granularity.hour
  val visibility: Double = 0.6
}

trait Cereal extends Grain {
  val name: String = "Cereal"
//  val price: Double = 4.0
  val priceUnit: Int = 1000
  var discount: Double = 0.0
  val stock: Int = 4
}

trait Oatmeal extends Grain {
  val name: String = "Oatmeal"
//  val price: Double = 4.0
  val priceUnit: Int = 1000
  var discount: Double = 0.0
  val stock: Int = 4
}

trait Rice extends Grain {
  val name: String = "Rice"
//  val price: Double = 2.0
  val priceUnit: Int = 1000
  var discount: Double = 0.0
  val stock: Int = 4
}

trait Noodles extends Grain {
  val name: String = "Noodles"
//  val price: Double = 3.0
  val priceUnit: Int = 1000
  var discount: Double = 0.0
  val stock: Int = 4
}

trait Spaghetti extends Grain {
  val name: String = "Spaghetti"
//  val price: Double = 1.5
  val priceUnit: Int = 1000
  var discount: Double = 0.0
  val stock: Int = 4
}

trait Pasta extends Grain {
  val name: String = "Pasta"
//  val price: Double = 1.5
  val priceUnit: Int = 1000
  var discount: Double = 0.0
  val stock: Int = 4
}

trait Bread extends Grain {
  val name: String = "Bread"
//  val price: Double = 1.5
  val priceUnit: Int = 1000
  var discount: Double = 0.0
  val stock: Int = 4
}
