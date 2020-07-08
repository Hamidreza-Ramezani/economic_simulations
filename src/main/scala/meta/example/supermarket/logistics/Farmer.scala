package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}
import meta.classLifting.SpecialInstructions
import meta.example.supermarket.goods._
import meta.example.supermarket.worldmap._
import squid.quasi.lift
import scala.collection.mutable
import scala.util.Random

@lift
class Farmer(var manufacturer: ManufacturerTrait, var world: WorldTrait) extends FarmerTrait {

  //  override def comeBackToInitialPoint(world: WorldTrait): Unit = {
  //    writer.write("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  //    println("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  //
  //    move(world, initialXPosition, initialYPosition)
  //    SpecialInstructions.waitTurns(1)
  //
  //    writer.write("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  //    println("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  //  }
  //
  //  override def move(world: WorldTrait, target: Actor): Unit = {
  //    writer.write("agent id " + id + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  //    println("agent id " + id + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
  //
  //    move(world, target.currentXPosition, target.currentYPosition)
  //    SpecialInstructions.waitTurns(1)
  //
  //    writer.write("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  //    println("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
  //  }


  def checkIfThereIsOrderFromManufacturer(): Unit = {
    farmerState = doNothing
    //    while (farmerState != receivedRequestFromManufacturer) {
    //      SpecialInstructions.waitTurns(1)
    //    }
    while (manufacturer.manufacturerState != waitingForFarmer) {
      SpecialInstructions.waitTurns(1)
    }
    println("---------------------------------------------------------------------------------------------------")
    println("farmer received an order from the manufacturer")
    writer.write("farmer received an order from the manufacturer" + "\n")
  }

  def sendToManufacturer(): Unit = {
    while (crops.nonEmpty) {
      val item = crops.dequeue()
      manufacturer.storage.getOrElse(item.name, new mutable.Queue[Item]) += item
      item.state = inManufacturer
    }
    farmerState = sendProductsToManufacturer
    manufacturer.manufacturerState = receivedNoticeFromFarmer
    println("---------------------------------------------------------------------------------------------------")
    println("farmer sent the crops to the manufacturer")
    println("---------------------------------------------------------------------------------------------------")
    writer.write("farmer sent the crops to the manufacturer" + "\n")
  }

  def doFarming(): Unit = {
    farmerState = isFarming
    println("Farmer's Actor id " + id + " is farming")
    println("---------------------------------------------------------------------------------------------------")
    println()
    writer.write("\n" + "Farmer's Actor id " + id + " is farming" + "\n")
    newItemsMap.itemMap_test.keys.toList.foreach(
      itemStr => List.tabulate(getFreeSpace(itemStr))(n => n).foreach(_ => {
        val new_item: Item = produce(newItemsMap.itemMap_test(itemStr))
        crops += new_item
        writer.write("Farmer's Actor id " + id + " produced new item! name: " + itemStr + "\n")
      })
    )
  }

  def produce(itemId: String): Item = {
    val index: Int = Integer.parseInt(itemId.replaceAll("Item", ""))
    var item: Item = null
    if (index == 32) item = new Item32(null, null, world)
    else if (index == 31) item = new Item31(null, null, world)
    else if (index == 30) item = new Item30(null, null, world)
    else if (index == 29) item = new Item29(null, null, world)
    else if (index == 28) item = new Item28(null, null, world)
    else if (index == 27) item = new Item27(null, null, world)
    else if (index == 26) item = new Item26(null, null, world)
    else if (index == 25) item = new Item25(null, null, world)
    else if (index == 24) item = new Item24(null, null, world)
    else if (index == 23) item = new Item23(null, null, world)
    else if (index == 22) item = new Item22(null, null, world)
    else if (index == 21) item = new Item21(null, null, world)
    else if (index == 20) item = new Item20(null, null, world)
    else if (index == 19) item = new Item19(null, null, world)
    else if (index == 18) item = new Item18(null, null, world)
    else if (index == 17) item = new Item17(null, null, world)
    else if (index == 16) item = new Item16(null, null, world)
    else if (index == 15) item = new Item15(null, null, world)
    else if (index == 14) item = new Item14(null, null, world)
    else if (index == 13) item = new Item13(null, null, world)
    else if (index == 12) item = new Item12(null, null, world)
    else if (index == 11) item = new Item11(null, null, world)
    else if (index == 10) item = new Item10(null, null, world)
    else if (index == 9) item = new Item9(null, null, world)
    else if (index == 8) item = new Item8(null, null, world)
    else if (index == 7) item = new Item7(null, null, world)
    else if (index == 6) item = new Item6(null, null, world)
    else if (index == 5) item = new Item5(null, null, world)
    else if (index == 4) item = new Item4(null, null, world)
    else if (index == 3) item = new Item3(null, null, world)
    else if (index == 2) item = new Item2(null, null, world)
    else if (index == 1) item = new Item1(null, null, world)
    else println("Illegal Argument Exception")
    item
    //TODO : exception handling cannot be lifted. fix this later.
    // else throw new IllegalArgumentException
  }

  def main(): Unit = {
    var randomWidth = Random.nextInt(world.width)
    var randomHeight = Random.nextInt(world.height)
    while (world.coordinates(randomHeight)(randomWidth).tileType != PrivateProperty || world.coordinates(randomHeight)(randomWidth).hasOwner) {
      randomWidth = Random.nextInt(world.width)
      randomHeight = Random.nextInt(world.height)
    }
    setInitialPosition(world,randomWidth, randomHeight)
    world.addActor(this)
    writer = new PrintWriter(new FileWriter(new File("m/agentFarmer" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    writer.flush()
    while (true) {
      checkIfThereIsOrderFromManufacturer()
      doFarming()
      SpecialInstructions.waitTurns(1)
      sendToManufacturer()
      SpecialInstructions.waitTurns(1)
    }
  }
}