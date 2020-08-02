package meta.example.supermarket.people

import meta.deep.runtime.Actor
import meta.example.supermarket.logistics.{Farmer, FarmerTrait, ManufacturerTrait, TruckTrait}
import meta.example.supermarket.worldmap.WorldTrait
import meta.example.supermarket.{Section, SectionTrait, Supermarket, SupermarketTrait}

trait EmployeeTrait extends Actor {
  var state: EmployeeState = walkingAround
  var section: SectionTrait
  var manufacturer: ManufacturerTrait
  var supermarket: SupermarketTrait
  var truck: TruckTrait = null
  var world: WorldTrait

  /**
    * the employee's initial position is specified based on supermarket's initial position, though it can be set another
    * value and require employee to move from his/her home to supermarket.
    * @param world the world object contain all agents
    * @param x This method is overridden. That is why it must have the same signature as the
    *          parent functionIn the parent function. Here, this parameter is not used.
    * @param y This method is overridden. That is why it must have the same signature as the
    *          parent functionIn the parent function. Here, this parameter is not used.
    */

  override def setInitialPosition(world: WorldTrait, x: Int, y: Int): Unit = {
    this.initialXPosition = supermarket.initialXPosition
    this.initialYPosition = supermarket.initialYPosition
    currentXPosition = initialXPosition
    currentYPosition = initialYPosition
    oldXPosition = initialXPosition
    oldYPosition = initialYPosition
  }

  override def toString = s"Employee id ${id}  "

}
