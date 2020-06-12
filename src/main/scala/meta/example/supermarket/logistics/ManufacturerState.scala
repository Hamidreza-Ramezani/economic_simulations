package meta.example.supermarket.logistics

sealed  trait ManufacturerState {

}

case object chilling extends ManufacturerState
case object waitingForFarmer extends ManufacturerState
case object receivedNoticeFromFarmer extends ManufacturerState
case object receivedOrderFromSupermarket extends ManufacturerState
case object isProcessing extends ManufacturerState
case object loadedTruck extends ManufacturerState

