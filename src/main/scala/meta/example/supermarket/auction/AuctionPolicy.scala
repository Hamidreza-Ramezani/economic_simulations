package meta.example.supermarket.auction

import scala.collection.mutable

/**
  * This is a trait for auctions. The only data attribute in this trait is rangeDiscountMap. The map's key is a range of
  * real number and the values are discounts.
  * If the item's freshness is in the MyRange the map's value would be the discount
  * which is applied for the item. For example, consider a potato's freshness is decreasing gradually.
  * If policy1 is used, as soon as the potato's freshhness becomes less than 0.75, a discount of 0.25 would be applied
  * ,i.e., its price becomes 3/4 of the fresh potato. Then, as long as the potato's freshness is more than 0.5, the
  * price will not be changed. When the freshness becomes less than 0.5, the discount would be changed to 0.5, i.e.,
  * the price of that potato gets half of the fresh potato and so on. One can define other policies such as policy1 only
  * by specifying the rangesDiscountMap.
  */
sealed trait AuctionPolicy {
  var rangeDiscountMap: mutable.Map[MyRange, Double] = mutable.Map()
}

case object Policy1 extends AuctionPolicy {
  rangeDiscountMap += (new MyRange(0.5, 0.75) -> 0.25)
  rangeDiscountMap += (new MyRange(0.25, 0.5) -> 0.5)
  rangeDiscountMap += (new MyRange(0.0, 0.25) -> 0.75)
}