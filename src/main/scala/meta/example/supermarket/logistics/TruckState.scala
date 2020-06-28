package meta.example.supermarket.logistics

sealed trait TruckState {

}


case object relaxed extends TruckState
case object receivedOrderFromManufacturer extends TruckState
case object isDriving extends TruckState
case object unloadingTruck extends TruckState