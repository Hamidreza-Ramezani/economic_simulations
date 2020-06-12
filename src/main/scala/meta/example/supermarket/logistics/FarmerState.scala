package meta.example.supermarket.logistics

sealed trait FarmerState {

}

case object doNothing extends FarmerState
case object receivedRequestFromSupermarket extends FarmerState
case object receivedRequestFromManufacturer extends FarmerState
case object isFarming extends FarmerState
case object sendProductsToManufacturer extends FarmerState