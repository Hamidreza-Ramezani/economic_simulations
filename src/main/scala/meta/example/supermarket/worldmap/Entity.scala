//package meta.example.supermarket.worldmap
//
//import scala.collection.mutable.ListBuffer
//import scala.util.Random
//
//class Entity(var xPosition: Int, var yPosition: Int, canMove: Boolean) {
//  var world: Array[Array[Tile]] = new World(10, 10).coordinates
//
//  def move(): Unit = {
//    if (canMove) {
//      //      Entity[][] world = world.coordinates();
//      val worldRows: Int = world(0).length
//      val worldCols: Int = world.length;
//      val randomInt: Random = new Random();
//      var directionOptions: ListBuffer[Int] = new ListBuffer[Int]
//      directionOptions += 1
//      directionOptions += 2
//      directionOptions += 3
//      directionOptions += 4
//      /*
//       * 1 = move up		3 = move down
//       * 2 = move right	4 = move left
//       */
//      // Entity is in left column
//      if (this.xPosition == 0) {
//        directionOptions -= 4
//      }
//      // Entity is in right column
//      else if (this.xPosition == worldCols) {
//        directionOptions -= 2
//      }
//      // Entity is in top row
//      if (this.yPosition == 0) {
//        directionOptions -= 1
//      }
//      // Entity is in bottom row
//      else if (this.yPosition == worldRows) {
//        directionOptions -= 3
//      }
//      val randomMove = directionOptions(randomInt.nextInt(directionOptions.size))
//      randomMove match {
//        case 1 => this.yPosition = this.yPosition - 1
//        case 2 => this.xPosition = this.xPosition + 1
//        case 3 => this.yPosition = this.yPosition + 1
//        case 4 => this.xPosition = this.xPosition - 1
//      }
//    }
//  }
//}