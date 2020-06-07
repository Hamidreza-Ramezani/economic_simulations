package meta.example.supermarket.worldmap

import meta.deep.runtime.Actor

import scala.collection.mutable.ListBuffer

class World(width: Int, height: Int) {

  var  coordinates= Array.ofDim[Tile](width, height)

//  for(int i = 0; i<width; i++){
//    for(int j = 0; j<height; j++){
//      coordinates[i][j] = new Tile(i,j);
//      tiles.add(coordinates[i][j]);
//    }
//  }
//
//  val tiles: ListBuffer[Tile] = new ListBuffer[Tile]();
//
//  def addEntity(e: Actor): Unit = {
//    x = e.getX();
//    y = e.getY();
//    coordinates[x][y].addEntity(e);
//  }

  def setTileType(x: Int, y: Int, kind: String):Unit = {
    coordinates(x,y).setType(kind);
  }
  def  getTiles(): ListBuffer[Tile] = {
    new ListBuffer[Tile]
  }

   def getEntities():List<Entity>{
    List<Entity> entities = new ArrayList<>();
    for(Tile[] row: coordinates){
      for(Tile tile: row){
        entities.addAll(tile.entities);
      }
    }
  }
}
