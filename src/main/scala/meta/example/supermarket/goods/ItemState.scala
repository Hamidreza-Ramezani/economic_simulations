package meta.example.supermarket.goods

final case class ItemState(
                            var inFarm: Boolean = true,
                            var inManufacturer: Boolean = false,
                            var inTruck: Boolean = false,
                            var inStorage: Boolean = false,
                            var onDisplay: Boolean = false,
                            var inBasket: Boolean = false,
                            var isPurchased: Boolean = false,
                            var isExpired: Boolean = false,
                            var isDiscarded: Boolean = false,
                            var isConsumed: Boolean = false) {

  def get: String = {
    if (inFarm) {
      "inFarm"
    }
    else if (inManufacturer) {
      "inManufacturer"
    }
    else if (inTruck) {
      "inTruck"
    }
    else if (inStorage) {
      "inStorage"
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

  def loadInManufacturer: Unit = {
    isDiscarded = false
    inManufacturer = true
    onDisplay = false
    isConsumed = false
    inFarm = false
  }

  def loadInTruck: Unit = {
    inManufacturer = false
    inTruck = true
    isDiscarded = false
    onDisplay = false
    isConsumed = false
    inFarm = false
  }

  def loadInStorage: Unit = {
    inManufacturer = false
    inTruck = false
    inStorage = true
    isDiscarded = false
    onDisplay = false
    isConsumed = false
    inFarm = false
  }

  def loadInShelves: Unit = {
    inManufacturer = false
    inTruck = false
    inStorage = false
    onDisplay = true
    isDiscarded = false
    isConsumed = false
    inFarm = false
  }

  def discard: Unit = {
    isDiscarded = true
    inStorage = false
    onDisplay = false
    isConsumed = false
    inFarm = false
    inTruck = false

  }

  def expire: Unit = {
    isExpired = true
    isDiscarded = false
    isConsumed = false
    inStorage = false
    inFarm = false
    inTruck = false

  }

  def addToBasket: Unit = {
    isPurchased = false
    inBasket = true
    onDisplay = false
    isDiscarded = false
    isExpired = false
    inFarm = false
    inStorage = false
    inTruck = false

  }

  def purchase: Unit = {
    inStorage = false
    isPurchased = true
    onDisplay = false
    isDiscarded = false
    inFarm = false
    isExpired = false
    inTruck = false

  }

  def consume: Unit = {
    inFarm = false
    inStorage = false
    isConsumed = true
    onDisplay = false
    isDiscarded = false
    isExpired = false
    inTruck = false

  }
}
