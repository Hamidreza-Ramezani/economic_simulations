package meta.example.supermarket.goods


sealed trait ItemState;


case object inFarm extends ItemState

case object inManufacturer extends ItemState

case object inTruck extends ItemState

case object inStorage extends ItemState

case object onDisplay extends ItemState

case object inBasket extends ItemState

case object isPurchased extends ItemState

case object isExpired extends ItemState

case object isDiscarded extends ItemState

case object isConsumed extends ItemState
