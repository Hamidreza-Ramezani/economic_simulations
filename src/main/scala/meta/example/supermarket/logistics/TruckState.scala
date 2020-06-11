package meta.example.supermarket.logistics

sealed trait TruckState {

}


case object relaxing extends TruckState
case object receivedOrderFromManufacturer extends TruckState
case object isDriving extends TruckState
case object unloadingTruck extends TruckState