package meta.example.supermarket.logistics

sealed trait TruckState {

}

/**
  * when there is no otder
  */
case object relaxed extends TruckState

/**
  * when there is an order
  */
case object receivedOrderFromManufacturer extends TruckState

/**
  * when the truck is on the way
  */
case object isDriving extends TruckState

/**
  * when truck is unloaded
  */
case object empltyTruck extends TruckState