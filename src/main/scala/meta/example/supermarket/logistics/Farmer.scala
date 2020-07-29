package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}
import meta.classLifting.SpecialInstructions
import meta.example.supermarket.goods._
import meta.example.supermarket.worldmap._
import squid.quasi.lift
import scala.collection.mutable
import scala.util.Random

/**
  * note: The logistics' code might not be very efficient. There are some potentials to use design patterns here.
  * here we should use observer pattern and event-based design instead of polling in a busy wait loop.
  *
  * Farmer produces the items, then he/she gives them to manufacturer. Manufacturer does packaging and processing stages
  * and it gives to truck for delivery to supermarket.
  *
  * @param manufacturer the manufacturer whom the farmer interacts with.
  * @param world        the world object which includes farmer.
  */
@lift
class Farmer(var manufacturer: ManufacturerTrait, var world: WorldTrait) extends FarmerTrait {


  /**
    * Manufacturer changes its own state to waitingForFarmer to inform farmer that there is an order.
    */
  def checkIfThereIsOrderFromManufacturer(): Unit = {
    farmerState = doNothing
    while (manufacturer.manufacturerState != waitingForFarmer) {
      SpecialInstructions.waitTurns(1)
    }
    println("---------------------------------------------------------------------------------------------------")
    println("farmer received an order from the manufacturer")
    writer.write("farmer received an order from the manufacturer" + "\n")
  }

  /**
    * farmer gives the items to manufacturer.
    */
  def sendToManufacturer(): Unit = {
    while (crops.nonEmpty) {
      val item = crops.dequeue()
      manufacturer.storage.getOrElse((item.name, item.brand), new mutable.Queue[Item]) += item
      item.owner = manufacturer
      item.state = inManufacturer
    }
    farmerState = sentProductsToManufacturer
    manufacturer.manufacturerState = receivedNoticeFromFarmer
    println("---------------------------------------------------------------------------------------------------")
    println("farmer sent the crops to the manufacturer")
    println("---------------------------------------------------------------------------------------------------")
    writer.write("farmer sent the crops to the manufacturer" + "\n")
  }


  /**
    * farmer produces food in this step.
    */
  def doFarming(): Unit = {
    farmerState = isFarming
    println("Farmer's Actor id " + id + " is farming")
    println("---------------------------------------------------------------------------------------------------")
    println()
    writer.write("\n" + "Farmer's Actor id " + id + " is farming" + "\n")

    global.priceMap.keys.toList.foreach {
      pair =>
        val itemBrand: Brand = pair._2
        val itemNum: String = pair._1
        val itemName: String = global.itemNameToID_test.map(_.swap).getOrElse(pair._1, "")
        List.tabulate(getFreeSpace(itemName, itemBrand))(n => n).foreach { _ => {
          var item: Item = produce(itemNum, itemBrand)
          item.owner = this
          crops += item
          writer.write("Farmer's Actor id " + id + " produced new item! name: " + itemName + " brand: " + itemBrand + " id: " + item.id + "\n")
        }
        }
    }
  }

  /**
    * There is a potential usage of metaprogramming and java reflection here.
    * todo: brand should be assigned by the manufacturer. In current version, there is only one manufacturer and brand
    *  is specified herer.
    *
    * @param itemNum a String like item20
    * @param brand a brand like TerraSuisse
    * @return a new item of that specific brand
    */
  def produce(itemNum: String, brand: Brand): Item = {
    val price: Double = global.priceMap(itemNum, brand)
    val index: Int = Integer.parseInt(itemNum.replaceAll("Item", ""))
    var item: Item = null
    if (index == 32) item = new Item32(null, null, world, brand, price)
    else if (index == 31) item = new Item31(null, null, world, brand, price)
    else if (index == 30) item = new Item30(null, null, world, brand, price)
    else if (index == 29) item = new Item29(null, null, world, brand, price)
    else if (index == 28) item = new Item28(null, null, world, brand, price)
    else if (index == 27) item = new Item27(null, null, world, brand, price)
    else if (index == 26) item = new Item26(null, null, world, brand, price)
    else if (index == 25) item = new Item25(null, null, world, brand, price)
    else if (index == 24) item = new Item24(null, null, world, brand, price)
    else if (index == 23) item = new Item23(null, null, world, brand, price)
    else if (index == 22) item = new Item22(null, null, world, brand, price)
    else if (index == 21) item = new Item21(null, null, world, brand, price)
    else if (index == 20) item = new Item20(null, null, world, brand, price)
    else if (index == 19) item = new Item19(null, null, world, brand, price)
    else if (index == 18) item = new Item18(null, null, world, brand, price)
    else if (index == 17) item = new Item17(null, null, world, brand, price)
    else if (index == 16) item = new Item16(null, null, world, brand, price)
    else if (index == 15) item = new Item15(null, null, world, brand, price)
    else if (index == 14) item = new Item14(null, null, world, brand, price)
    else if (index == 13) item = new Item13(null, null, world, brand, price)
    else if (index == 12) item = new Item12(null, null, world, brand, price)
    else if (index == 11) item = new Item11(null, null, world, brand, price)
    else if (index == 10) item = new Item10(null, null, world, brand, price)
    else if (index == 9) item = new Item9(null, null, world, brand, price)
    else if (index == 8) item = new Item8(null, null, world, brand, price)
    else if (index == 7) item = new Item7(null, null, world, brand, price)
    else if (index == 6) item = new Item6(null, null, world, brand, price)
    else if (index == 5) item = new Item5(null, null, world, brand, price)
    else if (index == 4) item = new Item4(null, null, world, brand, price)
    else if (index == 3) item = new Item3(null, null, world, brand, price)
    else if (index == 2) item = new Item2(null, null, world, brand, price)
    else if (index == 1) item = new Item1(null, null, world, brand, price)
    else println("Illegal Argument Exception")
    item
    //TODO : exception handling cannot be lifted. fix this later.
    // else throw new IllegalArgumentException
  }


  /**
    * The farmer's step function.
    */
  def main(): Unit = {
    var randomWidth = Random.nextInt(world.width)
    var randomHeight = Random.nextInt(world.height)
    while (world.coordinates(randomHeight)(randomWidth).tileType != PrivateProperty || world.coordinates(randomHeight)(randomWidth).hasOwner) {
      randomWidth = Random.nextInt(world.width)
      randomHeight = Random.nextInt(world.height)
    }
    setInitialPosition(world, randomWidth, randomHeight)
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