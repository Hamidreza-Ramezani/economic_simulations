package meta.example.supermarket.auction

import scala.collection.mutable


sealed trait AuctionPolicy {
  var rangeDiscountMap: mutable.Map[MyRange, Double] = mutable.Map()
}

case object Policy1 extends AuctionPolicy {
  rangeDiscountMap += (new MyRange(0.5, 0.75) -> 0.25)
  rangeDiscountMap += (new MyRange(0.25, 0.5) -> 0.5)
  rangeDiscountMap += (new MyRange(0.0, 0.25) -> 0.75)
}