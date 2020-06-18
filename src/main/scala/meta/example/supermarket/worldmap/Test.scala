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
//    worldMap.addEntity(john)
//    worldMap.addEntity(mary)
//    for (i <- 0 until mapWidth) {
//      worldMap.setTileType(i, 4, "forest")
//    }
//    //I think the world map should  have a list of characters.
//    actors.foreach(actor => println("actor id: " + actor.id + "\n"))
//    println("\n" + actors.size + " characters in play\n\n")
//    val tileList: ListBuffer[Tile] = worldMap.getTiles
//    tileList.foreach { tile =>
//      println(tile + " type: " + tile.getType + " entities: " + tile.entities + "\n" );
//    }
//    println("\n" + tileList.size + " tiles in play")
//  }
//
//  main()
//}