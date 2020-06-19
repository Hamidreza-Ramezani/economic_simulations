//package meta.example.supermarket.worldmap
//
//import meta.deep.runtime.Actor
//import scala.collection.mutable.ListBuffer
//
//object Test extends App {
//  def main(): Unit = {
//    val mapWidth = 5
//    val mapHeight = 5
//    val worldMap = new World(mapWidth, mapHeight)
//    val john = new Actor()
//    val mary = new Actor()
//    john.setInitialPosition(0, 0)
//    mary.setInitialPosition(1, 4)
//    val actors: ListBuffer[Actor] = new ListBuffer[Actor]
//    actors += john
//    actors += mary
//    worldMap.addActor(john)
//    worldMap.addActor(mary)
//    val tile1: Tile = new Tile(4,7)
//    val tile2: Tile = new Tile(2,12)
//    println("the distance of tile1 from tile2 is: ")
//    println(tile1.manhattanDistanceFrom(tile2))
//    println()
//    println()
//
//
//    //    for (i <- 0 until mapWidth) {
//    //      worldMap.setTileType(i, 4, "forest")
//    //    }
//    //I think the world map should  have a list of characters.
//    actors.foreach(actor => println("actor id: " + actor.id + "\n"))
//    println("\n" + actors.size + " characters in play\n\n")
//    val tileList: ListBuffer[Tile] = worldMap.getTiles
//    tileList.foreach { tile =>
//      println(tile + " type: " + tile.getType + " entities: " + tile.actors + "\n");
//    }
//    println("\n" + tileList.size + " tiles in play")
//  }
//
//  main()
//}