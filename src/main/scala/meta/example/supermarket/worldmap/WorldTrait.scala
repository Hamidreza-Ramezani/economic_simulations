package meta.example.supermarket.worldmap

import meta.deep.runtime.Actor
import scala.collection.mutable.ListBuffer
import com.jakewharton.fliptables.FlipTable

trait WorldTrait extends Actor {
  var width: Int
  var height: Int
  val coordinates: Array[Array[Tile]] = Array.ofDim[Tile](height, width)
  //  val coordinates_copy: Array[Array[Tile]] = coordinates.clone()
  var coordinates_flattened: ListBuffer[Tile] = new ListBuffer[Tile]()

  for (i <- 0 until width) {
    for (j <- 0 until height) {
      coordinates(height - 1 - j)(i) = new Tile(i, j)
      coordinates_flattened += coordinates(height - 1 - j)(i)
    }
  }

  override def setInitialPosition(x: Int, y: Int): Unit = {
    this.initialXPosition = 0
    this.initialYPosition = 0
    currentXPosition = initialXPosition
    currentYPosition = initialYPosition
  }

  def addActor(actor: Actor): Unit = {
    //todo: shall we use initial positions?
    val x = actor.currentXPosition
    val y = actor.currentYPosition
    coordinates(height - 1 - y)(x).addActor(actor)
  }

  def removeOldActor(actor: Actor): Unit = {
    val x = actor.oldXPosition
    val y = actor.oldYPosition
    coordinates(height - 1 - y)(x).removeActor(actor)
  }

  def updateMap(actor: Actor): Unit = {
    removeOldActor(actor)
    addActor(actor)
    val coordinates_copy = coordinates.clone()
    coordinates_flattened = coordinates_copy.flatten.to[ListBuffer]
  }

  def setTileType(x: Int, y: Int, myType: String): Unit = {
    coordinates(height - 1 - y)(x).setType(myType)
  }

  def getTiles: ListBuffer[Tile] = {
    coordinates_flattened
  }

  def getActors: ListBuffer[Actor] = {
    val actors: ListBuffer[Actor] = new ListBuffer[Actor]()
    coordinates.foreach {
      row =>
        row.foreach {
          tile => actors.append(tile.actors: _*)
        }
    }
    actors
  }

  override def toString = {
    var str = ""
    var coordinates_copy: Array[Array[Tile]] = coordinates.clone()
    val data: Array[Array[String]] = coordinates_copy.map(row => row.map(tile => tile.toString))
    //    val range: Array[Int] = coordinates_copy.indices.toArray
    val range: Array[Int] = coordinates_copy(0).indices.toArray
    val headers: Array[String] = range.map(entry => entry.toString)

    str = FlipTable.of(headers, data)
    //    coordinates_flattened.foreach {
    //      tile =>
    //        str += "x: " + tile.getX() + " y: " + tile.getY() + "\n" + tile.toString
    //    }
    str
  }
}
