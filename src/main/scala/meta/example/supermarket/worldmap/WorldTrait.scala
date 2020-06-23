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
      coordinates(j)(i) = new Tile(i, j)
      coordinates_flattened += coordinates(j)(i)
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
    coordinates(y)(x).addActor(actor)
  }

  def removeOldActor(actor: Actor): Unit = {
    val x = actor.oldXPosition
    val y = actor.oldYPosition
    coordinates(y)(x).removeActor(actor)
  }

  def updateMap(actor: Actor): Unit = {
    removeOldActor(actor)
    addActor(actor)
    val coordinates_copy = coordinates.clone()
    coordinates_flattened = coordinates_copy.flatten.to[ListBuffer]
  }

  def setTileType(x: Int, y: Int, myType: String): Unit = {
    coordinates(y)(x).setType(myType)
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
    val coordinates_copy: Array[Array[Tile]] = coordinates.clone()
    val data: Array[Array[String]] = coordinates_copy.map(row => row.map(tile => tile.toString))
    val range1: Array[Int] = coordinates_copy.indices.toArray
    val indicesArray: Array[Array[String]] = Array(range1.map(entry => entry.toString)).transpose

    for (i <- data.indices) {
      data(i) = indicesArray(i) ++ data(i)
    }
    //    val dataWithIndices: Array[Array[String]] = indicesArray ++ data

    val range2: Array[Int] = coordinates_copy(0).indices.toArray
    var headers: Array[String] = range2.map(entry => entry.toString)
    headers = Array("") ++ headers
    str = FlipTable.of(headers, data)
    //    coordinates_flattened.foreach {
    //      tile =>
    //        str += "x: " + tile.getX() + " y: " + tile.getY() + "\n" + tile.toString
    //    }
    str
  }
}
