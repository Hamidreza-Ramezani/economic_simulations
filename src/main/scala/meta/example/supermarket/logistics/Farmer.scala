package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}
import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import meta.example.supermarket.goods.{Item, Item1, Item10, Item11, Item12, Item13, Item14, Item15, Item16, Item17, Item18, Item19, Item2, Item20, Item21, Item22, Item23, Item24, Item25, Item26, Item27, Item28, Item29, Item3, Item30, Item31, Item32, Item4, Item5, Item6, Item7, Item8, Item9, newItemsMap}
import squid.quasi.lift
import scala.collection.mutable

@lift
class Farmer(var manufacturer: ManufacturerTrait) extends Actor {

  //  var cap = manufacturer.truck.supermarket.shelfCapacity
  var cap = 4
  var crops: mutable.Queue[Item] = new mutable.Queue[Item]

  def getFreeSpace(item: String): Int = {
    cap - manufacturer.storage.getOrElse(item, new mutable.Queue[Item]).size
  }

  def sendToManufacturer(): Unit = {
    while (crops.nonEmpty) {
      val item = crops.dequeue()
      manufacturer.storage.getOrElse(item.name, new mutable.Queue[Item]) += item
      item.state.inManufacturer
    }
  }

  def doFarming(): Unit = {
    writer.write("\n")
    println()
    writer.write("Farmer's Actor id " + id + " is farming")
    println("Farmer's Actor id " + id + " is farming")
    writer.write("\n")
    println()
    newItemsMap.itemMap.keys.toList.foreach(
      itemStr => List.tabulate(getFreeSpace(itemStr))(n => n).foreach(_ => {
        val new_item: Item = produce(newItemsMap.itemMap(itemStr))
        crops += new_item

        //        manufacturer.storage.getOrElse(itemStr, new ListBuffer[Item]) += new_item
        //change the state of items
        writer.write("Farmer's Actor id " + id + " produced new item! name: " + itemStr + "\n")
      })
    )
  }


  def produce(itemId: String): Item = {
    val index: Int = Integer.parseInt(itemId.replaceAll("Item", ""))
    var item: Item = null
    if (index == 32) item = new Item32(null, null)
    else if (index == 31) item = new Item31(null, null)
    else if (index == 30) item = new Item30(null, null)
    else if (index == 29) item = new Item29(null, null)
    else if (index == 28) item = new Item28(null, null)
    else if (index == 27) item = new Item27(null, null)
    else if (index == 26) item = new Item26(null, null)
    else if (index == 25) item = new Item25(null, null)
    else if (index == 24) item = new Item24(null, null)
    else if (index == 23) item = new Item23(null, null)
    else if (index == 22) item = new Item22(null, null)
    else if (index == 21) item = new Item21(null, null)
    else if (index == 20) item = new Item20(null, null)
    else if (index == 19) item = new Item19(null, null)
    else if (index == 18) item = new Item18(null, null)
    else if (index == 17) item = new Item17(null, null)
    else if (index == 16) item = new Item16(null, null)
    else if (index == 15) item = new Item15(null, null)
    else if (index == 14) item = new Item14(null, null)
    else if (index == 13) item = new Item13(null, null)
    else if (index == 12) item = new Item12(null, null)
    else if (index == 11) item = new Item11(null, null)
    else if (index == 10) item = new Item10(null, null)
    else if (index == 9) item = new Item9(null, null)
    else if (index == 8) item = new Item8(null, null)
    else if (index == 7) item = new Item7(null, null)
    else if (index == 6) item = new Item6(null, null)
    else if (index == 5) item = new Item5(null, null)
    else if (index == 4) item = new Item4(null, null)
    else if (index == 3) item = new Item3(null, null)
    else if (index == 2) item = new Item2(null, null)
    else if (index == 1) item = new Item1(null, null)
    else println("Illegal Argument Exception")
    item
    //TODO : exception handling cannot be lifted. fix this later.
    // else throw new IllegalArgumentException
  }

  def main(): Unit = {
    writer = new PrintWriter(new FileWriter(new File("m/agent" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      //TODO maybe changing this
      doFarming()
      sendToManufacturer()
      SpecialInstructions.waitTurns(1)
    }
  }
}