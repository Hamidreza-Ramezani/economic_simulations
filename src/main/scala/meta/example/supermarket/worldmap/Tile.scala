package meta.example.supermarket.worldmap

import meta.deep.runtime.Actor
import scala.collection.mutable.ListBuffer

sealed trait TileType;

case object PrivateProperty extends TileType;

case object Street extends TileType;


class Tile(xPos: Int, yPos: Int) {
  var tileType: TileType = PrivateProperty
  var actors: ListBuffer[Actor] = new ListBuffer[Actor]
  var parent: Tile = null
  var g_cost = 0
  var h_cost = 0
  var f_cost = 0


  def setParent(parent: Tile): Unit = {
    this.parent = parent
  }

  def setFCost(): Unit = {
    f_cost = g_cost + h_cost
  }

  def setGCost(): Unit = {
    g_cost = parent.g_cost + 1
  }

  def setHCost(goal: Tile): Unit = {
    h_cost = manhattanDistanceFrom(goal)
  }

  def getX(): Int = {
    xPos
  }

  def getY(): Int = {
    yPos
  }

  def setType(myType: TileType): Unit = {
    this.tileType = myType
  }

  def getType: TileType = {
    tileType
  }

  def addActor(actor: Actor): Unit = {
    actors += actor
  }

  def removeActor(actor: Actor): Unit = {
    actors -= actor
  }

  def manhattanDistanceFrom(tile: Tile): Int = {
    val xDifference = (this.xPos - tile.getX()).abs
    val yDifference = (this.yPos - tile.getY()).abs
    val distance: Int = xDifference + yDifference
    distance
  }


  override def toString = {
    var str = "                "
    //    str += "\n"
    //    str += "x: " + getX() + " y: " + getY()
    str += "\n"
    //    str +=  s"${BLUE}" + tileType.toString
    if (tileType == PrivateProperty) {
      str += "..........\n"
      str += "..........\n"
      str += "..........\n"
      str += "..........\n"
      str += "..........\n"
    }
    //    str += tileType.toString
    //    str += "\n"
    actors.foreach {
      actor =>
        str += actor.agentName + " id: " + actor.id + " \n"
    }
    str += "\n \n \n \n"
    str
  }

  def toString2 = {
    var str = "tile x: " + getX() + " y: " + getY()
    str += "\n"
    str += tileType.toString
    str += "\n"
    actors.foreach {
      actor =>
        str += actor.agentName + " id: " + actor.id + " \n"
    }
    str
  }

  def toString3 = {
    var str = "tile x: " + getX() + " y: " + getY()
//    var str = "tile x: " + getX() + " y: " + getY() + "\n"
    str
  }
}