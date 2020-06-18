package meta.example.supermarket.worldmap

import meta.deep.runtime.Actor
import scala.collection.mutable.ListBuffer

trait WorldTrait extends Actor {

  var width: Int
  var height: Int

  val coordinates: Array[Array[Tile]] = Array.ofDim[Tile](width, height)
  val coordinates_copy: Array[Array[Tile]] = coordinates.clone()
  var tiles: ListBuffer[Tile] = new ListBuffer[Tile]()

  for (i <- 0 until width) {
    for (j <- 0 until height) {
      coordinates(i)(j) = new Tile(i, j)
      tiles += coordinates(i)(j)
    }
  }

  override def setInitialPosition(x: Int, y: Int): Unit = {
    this.xPosition = 0
    this.yPosition = 0
  }

  def addEntity(actor: Actor): Unit = {
    val x = actor.xPosition
    val y = actor.yPosition
    coordinates(x)(y).addEntity(actor)
  }

  def removeOldEntity(actor: Actor): Unit = {
    val x = actor.oldXPosition
    val y = actor.oldYPosition
    coordinates(x)(y).removeEntity(actor)
  }

  def updateMap(actor: Actor): Unit = {
    removeOldEntity(actor)
    addEntity(actor)
    val coordinates_copy = coordinates.clone()
    tiles = coordinates_copy.flatten.to[ListBuffer]
  }

  def setTileType(x: Int, y: Int, myType: String): Unit = {
    coordinates(x)(y).setType(myType)
  }

  def getTiles: ListBuffer[Tile] = {
    tiles
  }

  def getEntities: ListBuffer[Actor] = {
    val entities: ListBuffer[Actor] = new ListBuffer[Actor]()
    coordinates.foreach {
      row =>
        row.foreach {
          tile => entities.append(tile.entities: _*)
        }
    }
    entities
  }


  override def toString = {
    var s = ""
    tiles.foreach {
      tile =>
        s += "x: " + tile.getX() + " y: " + tile.getY() + "\n" + tile.toString
    }
    s
  }
}
