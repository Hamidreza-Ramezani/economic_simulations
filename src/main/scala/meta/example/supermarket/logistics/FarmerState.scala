package meta.example.supermarket.logistics

sealed trait FarmerState {

}

case object doNothing extends FarmerState
case object isFarming extends FarmerState
case object sentProductsToManufacturer extends FarmerState