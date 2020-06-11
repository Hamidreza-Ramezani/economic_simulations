package meta.example.supermarket.logistics

sealed trait FarmerState {

}

case object doNothing extends FarmerState
case object receivedOrderFromSupermarket extends FarmerState
case object isFarming extends FarmerState
case object sendOrderToManufacturer extends FarmerState