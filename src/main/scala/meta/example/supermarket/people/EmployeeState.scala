package meta.example.supermarket.people

sealed trait EmployeeState

case object walkingAround extends EmployeeState

case object reFillingShelves extends EmployeeState

case object shufflingShelves extends EmployeeState
