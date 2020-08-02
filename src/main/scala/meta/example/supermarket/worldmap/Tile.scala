package meta.example.supermarket.worldmap

import meta.deep.runtime.Actor
import scala.collection.mutable.ListBuffer

/**
  * the type of the tile
  */
sealed trait TileType;

/**
  * resindential tiles. Tiles like the customer's home, supermarket, farm, manufacturer, and so on are private properties.
  * agents can not pass through private properties in the world map.
  */
case object PrivateProperty extends TileType;

/**
  * non-resindential tiles. agents can pass through streets in the world map.
  */
case object Street extends TileType;

/**
  * each square of the world map is considered a tile.
  *
  * @param xPos the x coordinate of the tile
  * @param yPos the y coordinate of the tile
  */
class Tile(xPos: Int, yPos: Int) {
  var tileType: TileType = PrivateProperty
  var actors: ListBuffer[Actor] = new ListBuffer[Actor]
  var world: WorldTrait = null
  var hasOwner: Boolean = false

  /**
    * the distance considering the obstacles in the map and is found by A* algorithm
    *
    * @param tile the goal
    * @return the length of the path from the origin and destination
    */
  def actualDistanceFrom(tile: Tile): Int = {
    var path: ListBuffer[Tile] = Utils.getPath(world, world.coordinates(yPos)(xPos), world.coordinates(tile.getY())(tile.getX()))
    path.length
  }

  /**
    * the distance that is found by ignoring the obstacles
    *
    * @param tile the goal
    * @return the manhattan distance of two tiles
    */
  def manhattanDistanceFrom(tile: Tile): Int = {
    val xDifference = (this.xPos - tile.getX()).abs
    val yDifference = (this.yPos - tile.getY()).abs
    val distance: Int = xDifference + yDifference
    distance
  }

  /**
    * getter for the x position
    *
    * @return
    */
  def getX(): Int = {
    xPos
  }

  /**
    * getter for the y position
    *
    * @return
    */
  def getY(): Int = {
    yPos
  }

  /**
    * setter for the tile type
    *
    * @param myType
    */
  def setType(myType: TileType): Unit = {
    this.tileType = myType
  }

  /**
    * getter for the tile type
    *
    * @return
    */
  def getType: TileType = {
    tileType
  }

  /**
    * adding an actor to the this tile
    *
    * @param actor
    */
  def addActor(actor: Actor): Unit = {
    actors += actor
  }

  /**
    * removing an actor from the this tile
    *
    * @param actor
    */
  def removeActor(actor: Actor): Unit = {
    actors -= actor
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