package meta.example.supermarket.logistics

sealed  trait ManufacturerState {

}

case object chilling extends ManufacturerState
case object receivedOrderFromFarmer extends ManufacturerState
case object isProcessing extends ManufacturerState
case object sendOrderToTruck extends ManufacturerState

