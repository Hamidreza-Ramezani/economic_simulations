package meta.example.supermarket.worldmap

import meta.deep.runtime.Actor
import scala.collection.mutable.ListBuffer

class Tile(xPos: Int, yPos: Int) {
  var tileType: String = ""
  var actors: ListBuffer[Actor] = new ListBuffer[Actor]

  def getX(): Int = {
    xPos
  }

  def getY(): Int = {
    yPos
  }

  def setType(myType: String): Unit = {
    this.tileType = myType
  }

  def getType: String = {
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
        str += "\n"
    actors.foreach {
      actor =>
        str += actor.agentName + " id: " + actor.id + " \n"
    }
    str += "\n \n \n \n"
    str
  }
}