package meta.example.supermarket.goods


sealed trait ItemState;

/**
  * this first step for any product
  */
case object inFarm extends ItemState

/**
  * the second step for products
  */
case object inManufacturer extends ItemState

/**
  * the third step for products
  */
case object inTruck extends ItemState

/**
  * the forth step of the pipleline which products go throguh.
  * inStorage means the item is in the supermarket's storage, but it is
  * not shown to customers yet.
  */
case object inStorage extends ItemState

/**
  * the fifth step of the pipleline which products go throguh.
  * customers have access and can buy the items whose status is onDisplay
  *
  */
case object onDisplay extends ItemState

/**
  * the sixth step of the pipleline which products go throguh.
  * Having a status of inBasket means a customer plans to buy the item and he/she already added it into their
  * shopping basket; however, they have not yet purchased the item.
  */
case object inBasket extends ItemState

/**
  * the seventh step of the pipleline which products go throguh
  * if the customer pays for the item and it is scanned by the cashier, its state would change to isPurchased .
  */
case object isPurchased extends ItemState


/**
  * the eighth step of the pipleline which products which are not consumed go throguh
  * if the freshhness of an item hits 0.0, it goes into isExpired state.
  */
case object isExpired extends ItemState

/**
  * the last step of the pipleline which products which are not consumed go throguh
  * it is assumed that if an item is expired, it will not be discarded right away, i.e., there is a
  * delay between an item gets expired and is discarded.
  */
case object isDiscarded extends ItemState

/**
  * the eighth step of the pipleline which products which are consumed go throguh
  * if an item which is already bought by a customer is consumed, its state beocmes isConsumed
  */
case object isConsumed extends ItemState
