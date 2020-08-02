package meta.example.supermarket.worldmap

import util.control.Breaks._
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * utilities, used in world package
  */
object Utils {

  /**
    * this algorithm finds all connected tiles to a tile whose types are the same.
    *
    * @param array  the 2d array (usually the world map)
    * @param startX the concerned tile
    * @param startY the concerned tile
    * @return list of same-typed tiles(their type is the same as this tile) that there is a path from this
    *         tile and them.
    */
  def floodFill(array: Array[Array[Tile]], startX: Int, startY: Int): mutable.ListBuffer[Tile] = {
    val visited: ListBuffer[Tile] = new ListBuffer[Tile]
    val stack = mutable.Stack[Tile]()
    stack.push(array(startY)(startX))

    while (stack.nonEmpty) {
      var currentTile = stack.pop()
      if (!visited.contains(currentTile)) {
        visited += currentTile
        val connectedNeighbors: ListBuffer[Tile] = addValidNeighborsToStack(array, currentTile.getX(), currentTile.getY())
        connectedNeighbors.foreach(tile => stack.push(tile))
      }
    }
    visited
  }

  /**
    * gets neighobrs of a tile whose type is the same as this tile
    *
    * @param array
    * @param x
    * @param y
    * @return list of the neighobrs whose type is the same as this tile
    */
  def addValidNeighborsToStack(array: Array[Array[Tile]], x: Int, y: Int): ListBuffer[Tile] = {

    var connectedNeighbors: ListBuffer[Tile] = new ListBuffer[Tile]
    val currentTile: Tile = array(y)(x)

    val worldRows: Int = array.length
    val worldCols: Int = array(0).length
    // Entity is in left column
    if (currentTile.getX() != 0) {
      var leftNeighbor: Tile = array(y)(x - 1)
      if (leftNeighbor.tileType == currentTile.tileType) {
        connectedNeighbors += leftNeighbor
      }
    }
    // Entity is in right column
    if (currentTile.getX() != worldCols - 1) {
      var rightNeighbor: Tile = array(y)(x + 1)
      if (rightNeighbor.tileType == currentTile.tileType) {
        connectedNeighbors += rightNeighbor
      }
    }
    // Entity is in top row
    if (currentTile.getY() != 0) {
      var topNeighbor: Tile = array(y - 1)(x)
      if (topNeighbor.tileType == currentTile.tileType) {
        connectedNeighbors += topNeighbor
      }
    }
    // Entity is in bottom row
    if (currentTile.getY() != worldRows - 1) {
      var bottomNeighbor: Tile = array(y + 1)(x)
      if (bottomNeighbor.tileType == currentTile.tileType) {
        connectedNeighbors += bottomNeighbor
      }
    }
    connectedNeighbors
  }

  /**
    * the A star algorithm
    *
    * @param world
    * @param source
    * @param goal
    * @return the parent map. the keys are children and values are parents.
    */
  def AStar(world: WorldTrait, source: Tile, goal: Tile): mutable.Map[Tile, Tile] = {
    var open: ListBuffer[Tile] = new ListBuffer[Tile]
    var closed: ListBuffer[Tile] = new ListBuffer[Tile]
    var parentMap: mutable.Map[Tile, Tile] = mutable.Map()
    var gCost: mutable.Map[Tile, Int] = mutable.Map()
    var hCost: mutable.Map[Tile, Int] = mutable.Map()
    var fCost: mutable.Map[Tile, Int] = mutable.Map()
    world.coordinates_flattened.foreach {
      tile =>
        parentMap += (tile -> tile)
        gCost += (tile -> 0)
        hCost += (tile -> tile.manhattanDistanceFrom(goal))
        fCost += (tile -> hCost(tile))
    }
    open += source
    while (true) {
      var currentTile = pickPromisingTile(open, fCost)
      open -= currentTile
      closed += currentTile
      if (currentTile == goal) {
        return parentMap
      }
      world.getStreetNeighbors(currentTile, goal).foreach {
        neighbor =>
          breakable {
            if (closed.contains(neighbor)) {
              break()
            }
            else {
              val neighborNewFCost = gCost(currentTile) + 1 + hCost(neighbor)
              if (neighborNewFCost < fCost(neighbor) || !open.contains(neighbor)) {
                parentMap(neighbor) = currentTile
                gCost(neighbor) = gCost(currentTile) + 1
                fCost(neighbor) = gCost(neighbor) + hCost(neighbor)
                if (!open.contains(neighbor)) {
                  open += neighbor
                }
              }
            }
          }
      }
    }
    parentMap
  }

  /**
    * the tile which has the lowest cost in the open list of the A* algorithm
    *
    * @param openListBuffer
    * @param fCost
    * @return the tile
    */
  def pickPromisingTile(openListBuffer: ListBuffer[Tile], fCost: mutable.Map[Tile, Int]): Tile = {
    var promisingTile: Tile = openListBuffer.head
    if (openListBuffer.nonEmpty) {
      openListBuffer.foreach {
        tile =>
          if (fCost(tile) < fCost(promisingTile)) {
            promisingTile = tile
          }
      }
    }
    promisingTile
  }


  /**
    * making a list of a map of (tile -> tile). It is used in A star algorithm.
    * @param world
    * @param source
    * @param goal
    * @return
    */
  def getPath(world: WorldTrait, source: Tile, goal: Tile): ListBuffer[Tile] = {
    var parentMap = AStar(world, source, goal)
    var path: ListBuffer[Tile] = new ListBuffer[Tile]
    var currentTile = goal
    while (currentTile != source) {
      path += currentTile
      currentTile = parentMap(currentTile)
    }
    path = path.reverse
    path
  }
}