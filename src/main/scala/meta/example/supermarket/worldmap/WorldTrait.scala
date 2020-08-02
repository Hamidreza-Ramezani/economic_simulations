package meta.example.supermarket.worldmap

import java.io.{File, PrintWriter}
import scala.util.control.Breaks._
import meta.deep.runtime.Actor
import scala.collection.mutable.ListBuffer
import com.jakewharton.fliptables.FlipTable
import scala.util.Random

trait WorldTrait extends Actor {
  var width: Int
  var height: Int
  val coordinates: Array[Array[Tile]] = Array.ofDim[Tile](height, width)
  //  val coordinates_copy: Array[Array[Tile]] = coordinates.clone()
  var coordinates_flattened: ListBuffer[Tile] = new ListBuffer[Tile]()
  var streets: ListBuffer[Tile] = new ListBuffer[Tile]
  var properties: ListBuffer[Tile] = new ListBuffer[Tile]
  var requiredNumberOfProperties: Int = 10
  writer = new PrintWriter(new File("m/agentWorldMap" + id))

  for (i <- 0 until width) {
    for (j <- 0 until height) {
      coordinates(j)(i) = new Tile(i, j)
      coordinates_flattened += coordinates(j)(i)
      coordinates(j)(i).world = this
      if (Random.nextInt(100) > 50) {
        setTileType(i, j, Street)
        streets += coordinates(j)(i)
      }
      else {
        properties += coordinates(j)(i)
      }
    }
  }
  writer.write("Before flood fill algorithm:\n")
  writer.write(this.toString)
  initializeTileType()
  writer.write("\nafter flood fill algorithm:\n")
  writer.write(this.toString)


  override def getString(): String = {
    "\n \n" + "timer: " + timer + "\n \n"
  }


  /**
    * this function changes the configuration of the world map to make sure that all streets are
    * connected and none of the properties are landlocked
    */
  def initializeTileType(): Unit = {
    breakable {
      while (true) {
        //if (no PP is in a deadlock position)
        //choose randomly one of the streets and do the flood fill
        //List of all streets vs List of connected streets, then break else change those PPs into Street
        if (properties.size < requiredNumberOfProperties) {
          throw CustomException("the number of available properties is too low")
        }
        properties.foreach {
          property =>
            if (numberOfStreetNeighbors(property) == 0) {
              property.setType(Street)
              properties -= property
              streets += property
              //              println(property.toString2 + "changed to street")
              writer.write(property.toString2 + "changed to street\n\n\n")
            }
        }
        var randomStreet: Tile = streets(Random.nextInt(streets.size - 1))
        val connectedTiles = Utils.floodFill(coordinates, randomStreet.getX(), randomStreet.getY())
        if (connectedTiles.size == streets.size) {
          break()
        }
        var randomProperty: Tile = properties(Random.nextInt(properties.size - 1))
        randomProperty.setType(Street)
        properties -= randomProperty
        streets += randomProperty
        //        println(randomProperty.toString2 + "changed to street")
        writer.write(randomProperty.toString2 + "changed to street\n\n\n")
        while (properties.size < requiredNumberOfProperties) {
          randomStreet = streets(Random.nextInt(streets.size - 1))
          randomStreet.setType(PrivateProperty)
          streets -= randomStreet
          properties += randomStreet
          //          println(randomStreet.toString2 + "changed to property")
          writer.write(randomStreet.toString2 + "changed to property\n\n\n")
          //          throw CustomException("the number of available properties is too low")
        }
      }
    }
  }

  /**
    *
    * @param tile
    * @return number of the neighbors of the tile tha is passed as the parameter whose type is street.
    */
  def numberOfStreetNeighbors(tile: Tile): Int = {
    var connectedStreetNeighbors: ListBuffer[Tile] = new ListBuffer[Tile]
    val worldRows: Int = coordinates.length
    val worldCols: Int = coordinates(0).length
    // tile is in left column
    if (tile.getX() != 0) {
      var leftNeighbor: Tile = coordinates(tile.getY())(tile.getX() - 1)
      if (leftNeighbor.tileType == Street) {
        connectedStreetNeighbors += leftNeighbor
      }
    }
    // Entity is in right column
    if (tile.getX() != worldCols - 1) {
      var rightNeighbor: Tile = coordinates(tile.getY())(tile.getX() + 1)
      if (rightNeighbor.tileType == Street) {
        connectedStreetNeighbors += rightNeighbor
      }
    }
    // Entity is in top row
    if (tile.getY() != 0) {
      var topNeighbor: Tile = coordinates(tile.getY() - 1)(tile.getX())
      if (topNeighbor.tileType == Street) {
        connectedStreetNeighbors += topNeighbor
      }
    }
    // Entity is in bottom row
    if (tile.getY() != worldRows - 1) {
      var bottomNeighbor: Tile = coordinates(tile.getY() + 1)(tile.getX())
      if (bottomNeighbor.tileType == Street) {
        connectedStreetNeighbors += bottomNeighbor
      }
    }
    connectedStreetNeighbors.size
  }

  /**
    * this fuction does not have meaning for the world map itself.
    *
    * @param worldTrait
    * @param x
    * @param y
    */
  override def setInitialPosition(worldTrait: WorldTrait, x: Int, y: Int): Unit = {
    this.initialXPosition = 0
    this.initialYPosition = 0
    currentXPosition = initialXPosition
    currentYPosition = initialYPosition
    oldXPosition = initialXPosition
    oldYPosition = initialYPosition

  }

  /**
    *
    * @param tile
    * @param goal
    * @return list of the neighbors of the tile tha is passed as the parameter whose type is street along with the
    *         goal tile.
    */
  def getStreetNeighbors(tile: Tile, goal: Tile): ListBuffer[Tile] = {
    var neighbors: ListBuffer[Tile] = new ListBuffer[Tile]
    val worldRows: Int = coordinates.length
    val worldCols: Int = coordinates(0).length
    if (tile.getX() != 0) {
      var leftNeighbor = coordinates(tile.getY())(tile.getX() - 1)
      if (leftNeighbor.tileType != PrivateProperty || leftNeighbor == goal) {
        neighbors += leftNeighbor
      }
    }
    if (tile.getX() != worldCols - 1) {
      var rightNeighbor = coordinates(tile.getY())(tile.getX() + 1)
      if (rightNeighbor.tileType != PrivateProperty || rightNeighbor == goal) {
        neighbors += rightNeighbor
      }
    }
    if (tile.getY() != 0) {
      var upNeighbor = coordinates(tile.getY() - 1)(tile.getX())
      if (upNeighbor.tileType != PrivateProperty || upNeighbor == goal) {
        neighbors += upNeighbor
      }
    }
    if (tile.getY() != worldRows - 1) {
      var downNeighbor = coordinates(tile.getY() + 1)(tile.getX())
      if (downNeighbor.tileType != PrivateProperty || downNeighbor == goal) {
        neighbors += downNeighbor
      }
    }
    neighbors
  }

  /**
    * adding an actor to the world map
    *
    * @param actor
    */
  def addActor(actor: Actor): Unit = {
    //todo: shall we use initial positions?
    val x = actor.currentXPosition
    val y = actor.currentYPosition
    coordinates(y)(x).addActor(actor)
  }

  /**
    * removing an actor to the world map
    *
    * @param actor
    */
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

  def setTileType(x: Int, y: Int, myType: TileType): Unit = {
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
