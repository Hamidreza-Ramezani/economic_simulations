package meta.example.supermarket.goods

import java.io.InvalidClassException

final case class ItemState(var onDisplay: Boolean = true,
                           var inBasket: Boolean = false,
                           var isPurchased: Boolean = false,
                           var isExpired: Boolean = false,
                           var isDiscarded: Boolean = false,
                           var isConsumed: Boolean = false) {

  def get: String = {
    if (onDisplay) {
      "onDisplay"
    }
    else if (isDiscarded) {
      "isDiscarded"
    }
    else if (isExpired) {
      "isExpired"
    }
    else if (isConsumed) {
      "isConsumed"
    }
    else if (isPurchased) {
      "isPurchased"
    }
    else if (inBasket) {
      "inBasket"
    }
    else throw new IllegalArgumentException
  }

  def discard: Unit = {
    isDiscarded = true
    onDisplay = false
    isConsumed = false
  }

  def expire: Unit = {
    isExpired = true
    isDiscarded = false
    isConsumed = false
  }

  def addToBasket: Unit = {
    isPurchased = false
    inBasket = true
    onDisplay = false
    isDiscarded = false
    isExpired = false
  }

  def purchase: Unit = {
    isPurchased = true
    onDisplay = false
    isDiscarded = false
    isExpired = false
  }

  def consume: Unit = {
    isConsumed = true
    onDisplay = false
    isDiscarded = false
    isExpired = false
  }
}
