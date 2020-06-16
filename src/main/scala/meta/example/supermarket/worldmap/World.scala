package meta.example.supermarket.worldmap

import meta.deep.runtime.Actor
import scala.collection.mutable.ListBuffer

class World(width: Int, height: Int) {

  var coordinates: Array[Array[Tile]] = Array.ofDim[Tile](width, height)
  val tiles: ListBuffer[Tile] = new ListBuffer[Tile]()
  for (i <- 0 until width) {
    for (j <- 0 until height) {
      coordinates(i)(j) = new Tile(i, j)
      tiles += coordinates(i)(j)
    }
  }

  //    def addEntity(actor: Actor): Unit = {
  //      val x = actor.xPosition();
  //      val y = actor.yPosition();
  //      coordinates(x)(y).addEntity(actor);
  //    }

  def setTileType(x: Int, y: Int, myType: String): Unit = {
    coordinates(x)(y).setType(myType)
  }

  def getTiles(): ListBuffer[Tile] = {
    new ListBuffer[Tile]
  }

  def getEntities(): ListBuffer[Actor] = {
    val entities: ListBuffer[Actor] = new ListBuffer[Actor]()
    coordinates.foreach {
      row =>
        row.foreach {
          tile => entities.append(tile.entities: _*)
        }
    }
    entities
  }
}

//object World{
//
//}