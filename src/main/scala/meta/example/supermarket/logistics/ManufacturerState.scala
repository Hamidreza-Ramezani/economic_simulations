package meta.example.supermarket.logistics

sealed  trait ManufacturerState {

}

/**
  * when there is no order from supermarkets.
  */
case object idle extends ManufacturerState

/**
  * when manufacturer placed an order to farmer already and waited for him/her to produce the food.
  */
case object waitingForFarmer extends ManufacturerState


/**
  * when manufacturer received an update from farmer which means foods are produced and manufacturer only needs to
  * process and package them.
  */
case object receivedNoticeFromFarmer extends ManufacturerState


/**
  * the manufacturer's state while it processes the foods.
  */
case object isProcessing extends ManufacturerState

/**
  * manufacturer state after loading the trucks.
  */
case object loadedTruck extends ManufacturerState

