package meta.example.supermarket.worldmap

import meta.deep.runtime.Actor
import scala.collection.mutable.ListBuffer

class Tile(xPos: Int, yPos: Int) {
  var myType: String = ""
  var entities: ListBuffer[Actor] = new ListBuffer[Actor]

  def setType(myType: String): Unit = {
    this.myType = myType
  }

  def getType: String = {
    myType
  }

  def addEntity(actor: Actor): Unit = {
    entities += actor
  }

  def removeEntity(actor: Actor): Unit = {
    entities -= actor
  }
}