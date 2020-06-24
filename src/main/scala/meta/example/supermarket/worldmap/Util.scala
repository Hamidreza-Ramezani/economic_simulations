package meta.example.supermarket.worldmap

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Util {

  def floodFill(array: Array[Array[Tile]], startX: Int, startY: Int): mutable.ListBuffer[Tile] = {
    val visited: ListBuffer[Tile] = new ListBuffer[Tile]
    val stack = mutable.Stack[Tile]()
    stack.push(array(startY)(startX))

    while (stack.nonEmpty) {
      var currentTile = stack.pop()
      if (!visited.contains(currentTile)) {
        visited += currentTile
        val connectedNeighbors:ListBuffer[Tile] = addValidNeighborsToStack(array, currentTile.getX(), currentTile.getY())
        connectedNeighbors.foreach(tile => stack.push(tile))
      }
    }
    visited
  }

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
     if (currentTile.getX() != worldCols -1) {
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
     if (currentTile.getY() !=  worldRows - 1 ) {
      var bottomNeighbor: Tile = array(y + 1)(x)
      if (bottomNeighbor.tileType == currentTile.tileType) {
        connectedNeighbors += bottomNeighbor
      }
    }
    connectedNeighbors
  }

}
