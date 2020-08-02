package meta.example.supermarket.people

sealed trait EmployeeState

/**
  * when he/she does not refill or shuffle any shelf
  */
case object walkingAround extends EmployeeState

/**
  * when the employee refills the shelves
  */
case object reFillingShelves extends EmployeeState

/**
  * when the employee shuffles the shelves.
  */
case object shufflingShelves extends EmployeeState
