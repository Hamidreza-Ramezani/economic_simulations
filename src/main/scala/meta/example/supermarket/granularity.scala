package meta.example.supermarket


/**
  * in order to change the granularity, freshUntil, waitTurn of customers, waitTurn of Employees, and
  * until in supermarketsimulation class must be changed
  */
object granularity extends Enumeration {

  type granularity = Int

  val day = 1
  val hour = 24
  val minute = 1440
}
