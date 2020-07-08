package meta.example.supermarket.people

sealed trait EmployeeState

case object walkingAround extends EmployeeState

case object reFillingShelves extends EmployeeState

case object shufflingShelves extends EmployeeState


//final case class EmployeeState(var walkingAround: Boolean = true,
//                               var reFillingShelves: Boolean = false,
//                               var shufflingShelves: Boolean = false) {
//
//  //  def get: String = {
//  //    if (walkingAround) {
//  //      "walkingAround"
//  //    }
//  //    else if (reFillingShelves) {
//  //      "reFillingShelves"
//  //    }
//  //    else if (shufflingShelves) {
//  //      "shufflingShelves"
//  //    }
//  //    else throw new IllegalArgumentException
//  //  }
//
//  def walkAround: Unit = {
//    walkingAround = true
//    reFillingShelves = false
//    shufflingShelves = false
//  }
//
//  def refillShelves: Unit = {
//    walkingAround = false
//    reFillingShelves = true
//    shufflingShelves = false
//  }
//
//  def shuffleShelves: Unit = {
//    walkingAround = false
//    reFillingShelves = false
//    shufflingShelves = true
//  }
//
//
//}
