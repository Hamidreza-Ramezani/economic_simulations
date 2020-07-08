package meta.example.supermarket.people

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.goods.{Item, onDisplay}
import meta.example.supermarket.logistics.{ManufacturerTrait, loadedTruck, unloadingTruck}
import meta.example.supermarket.worldmap.WorldTrait
import meta.example.supermarket.{SectionTrait, SupermarketTrait}
import squid.quasi.lift

import scala.collection.mutable.ListBuffer
import scala.util.Random

@lift
class Employee(var supermarket: SupermarketTrait, var section: SectionTrait, var manufacturer: ManufacturerTrait, var world: WorldTrait) extends EmployeeTrait {


  override def comeBackToInitialPoint(world: WorldTrait): Unit = {
    writer.write("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")

    move(world, initialXPosition, initialYPosition)
    SpecialInstructions.waitTurns(1)

    writer.write("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  }

  override def move(world: WorldTrait, target: Actor): Unit = {
    writer.write("agent id " + id + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")

    move(world, target.currentXPosition, target.currentYPosition)
    SpecialInstructions.waitTurns(1)

    writer.write("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
  }


  def orderItems(): Unit = {
    //calling farmer
    //    println("---------------------------------------------------------------------------------------------------")
    //        println("Employee's Actor id " + id + " ordered some items")
    //    println("Employee's Actor id " + id + " is waiting for the truck")
    //    println("---------------------------------------------------------------------------------------------------")
    //        writer.write("Employee's Actor id " + id + " ordered some items" + "\n")
    //    writer.write("Employee's Actor id " + id + " is waiting for the truck" + "\n")
    state = reFillingShelves
    //    farmer.farmerState = receivedRequestFromSupermarket
    //    manufacturer.manufacturerState = receivedOrderFromSupermarket
    //    SpecialInstructions.waitTurns(1)
    while (manufacturer.manufacturerState != loadedTruck) {
      SpecialInstructions.waitTurns(1)
    }
    //    truck = manufacturer.trucks.filter(truck => truck.supermarket == this.supermarket).head
    while (truck.truckState != unloadingTruck) {
      println("---------------------------------------------------------------------------------------------------")
      println("Employee's Actor id " + id + " is waiting for the truck id " + truck.id)
      println("---------------------------------------------------------------------------------------------------")
      writer.write("Employee's Actor id " + id + " is waiting for the truck id " + truck.id + "\n")
      SpecialInstructions.waitTurns(1)
    }
  }

  def addSupply(): Unit = {
    //check if the number of items in supermarket is full
    if (section.isNotFull()) {
      orderItems()
      state = reFillingShelves
      writer.write("\n")
      println()
      writer.write("Employee's Actor id " + id + " is refilling the shelves")
      println("Employee's Actor id " + id + " is refilling the shelves")
      writer.write("\n")
      println()
      supermarket.storage.toList.foreach { item =>
        section.shelves(item.name) += item
        item.state = onDisplay
        writer.write("Employee's Actor id " + id + " Add new actor! name: " + item.name + "\n")
      }
      supermarket.storage = new ListBuffer[Item]()
    }
    //employee has to make sure that the items are arrived
    //employee should check a variable in while true loop
    //    while (truck.truckState != unloadingTruck) {
    //      println("Employee's Actor id " + id + " is waiting for the truck")
    //      writer.write("Employee's Actor id " + id + " is waiting for the truck" + "\n")
    //      SpecialInstructions.waitTurns(1)
    //    }
    //    while (supermarket.itemsRecentlyOrdered) {
    //      println("Employee's Actor id " + id + " is waiting for the truck")
    //      writer.write("Employee's Actor id " + id + " is waiting for the truck" + "\n")
    //      SpecialInstructions.waitTurns(1)
    //    }

    //    section.articleNames.toList.foreach(
    //      itemStr => List.tabulate(getFreeSpace(itemStr))(n => n).foreach(_ => {
    //            val new_item: Item = genNewItem(newItemsMap.itemMap(itemStr))
    //        section.shelves(itemStr) += new_item.asInstanceOf[Item]
    //        writer.write("Employee's Actor id " + id + " Add new actor! name: " + itemStr + "\n")
    //      })
    //    )
  }

  def shuffleShelves(): Unit = {
    //todo: add delay for the customers
    //Supermarket.store.warehouse.foreach(shelf => shelf._2.itemDeque.)
    state = shufflingShelves
    writer.write("\n")
    println()
    writer.write("Employee's Actor id " + id + " is shuffling the shelves")
    println("Employee's Actor id " + id + " is shuffling the shelves")
    writer.write("\n")
    println()

    section.shelves.toList.foreach(shelf => shelf._2.shuffle(section.sectionShufflingPolicy))
  }

  //  def genNewItem(itemId: String): Item = {
  //    //    var lstOfNewItems: List[Item] = List()
  //    val index: Int = Integer.parseInt(itemId.replaceAll("Item", ""))
  //    var item: Item = null
  //
  //    if (index == 32) item = new Item32(supermarket, section)
  //    else if (index == 31) item = new Item31(supermarket, section)
  //    else if (index == 30) item = new Item30(supermarket, section)
  //    else if (index == 29) item = new Item29(supermarket, section)
  //    else if (index == 28) item = new Item28(supermarket, section)
  //    else if (index == 27) item = new Item27(supermarket, section)
  //    else if (index == 26) item = new Item26(supermarket, section)
  //    else if (index == 25) item = new Item25(supermarket, section)
  //    else if (index == 24) item = new Item24(supermarket, section)
  //    else if (index == 23) item = new Item23(supermarket, section)
  //    else if (index == 22) item = new Item22(supermarket, section)
  //    else if (index == 21) item = new Item21(supermarket, section)
  //    else if (index == 20) item = new Item20(supermarket, section)
  //    else if (index == 19) item = new Item19(supermarket, section)
  //    else if (index == 18) item = new Item18(supermarket, section)
  //    else if (index == 17) item = new Item17(supermarket, section)
  //    else if (index == 16) item = new Item16(supermarket, section)
  //    else if (index == 15) item = new Item15(supermarket, section)
  //    else if (index == 14) item = new Item14(supermarket, section)
  //    else if (index == 13) item = new Item13(supermarket, section)
  //    else if (index == 12) item = new Item12(supermarket, section)
  //    else if (index == 11) item = new Item11(supermarket, section)
  //    else if (index == 10) item = new Item10(supermarket, section)
  //    else if (index == 9) item = new Item9(supermarket, section)
  //    else if (index == 8) item = new Item8(supermarket, section)
  //    else if (index == 7) item = new Item7(supermarket, section)
  //    else if (index == 6) item = new Item6(supermarket, section)
  //    else if (index == 5) item = new Item5(supermarket, section)
  //    else if (index == 4) item = new Item4(supermarket, section)
  //    else if (index == 3) item = new Item3(supermarket, section)
  //    else if (index == 2) item = new Item2(supermarket, section)
  //    else if (index == 1) item = new Item1(supermarket, section)
  //    else println("Illegal Argument Exception")
  //    item
  //
  //    //    if (index == 32) new Dairy("Egg", 3.0, 250, 0.0, 3)
  //    //    else if (index == 31) new Dairy("Cream", 1.0, 50, 0.0, 3)
  //    //    else if (index == 30) new Dairy("Cheese", 5.0, 200, 0.0, 3)
  //    //    else if (index == 29) new Dairy("Yogurt", 1.0, 50, 0.0, 3)
  //    //    else if (index == 28) new Dairy("Milk", 2.0, 1000, 0.0, 3)
  //    //    else if (index == 27) new Grain("Bread", 1.5, 1000, 0.0, 4)
  //    //    else if (index == 26) new Grain("Pasta", 1.5, 1000, 0.0, 4)
  //    //    else if (index == 25) new Grain("Spaghetti", 1.5, 1000, 0.0, 4)
  //    //    else if (index == 24) new Grain("Noodles", 3.0, 1000, 0.0, 4)
  //    //    else if (index == 23) new Grain("Rice", 2.0, 1000, 0.0, 4)
  //    //    else if (index == 22) new Grain("Oatmeal", 4.0, 1000, 0.0, 4)
  //    //    else if (index == 21) new Grain("Cereal", 4.0, 1000, 0.0, 4)
  //    //    else if (index == 20) new Snack("WhiteChocolate", 1.8, 100, 0.0, 10)
  //    //    else if (index == 19) new Snack("DarkChocolate", 1.8, 100, 0.0, 10)
  //    //    else if (index == 18) new Snack("Ferraro", 5.0, 250, 0.0, 10)
  //    //    else if (index == 17) new Snack("Kitkat", 3.5, 300, 0.0, 10)
  //    //    else if (index == 16) new Meat("Bacon", 25.0, 1000, 0.0, 3)
  //    //    else if (index == 15) new Meat("Lamb", 45.0, 1000, 0.0, 3)
  //    //    else if (index == 14) new Meat("Pork", 25.0, 1000, 0.0, 3)
  //    //    else if (index == 13) new Meat("Beef", 35.0, 1000, 0.0, 3)
  //    //    else if (index == 12) new Meat("Chicken", 15.0, 1000, 0.0, 3)
  //    //    else if (index == 11) new Vegetable("Squash", 1.0, 200, 0.0, 5)
  //    //    else if (index == 10) new Vegetable("Cabbage", 1.0, 200, 0.0, 5)
  //    //    else if (index == 9) new Vegetable("Mushroom", 2.0, 200, 0.0, 5)
  //    //    else if (index == 8) new Vegetable("Tomato", 1.5, 200, 0.0, 5)
  //    //    else if (index == 7) new Vegetable("Celery", 2.0, 200, 0.0, 5)
  //    //    else if (index == 6) new Vegetable("Carrots", 1.0, 200, 0.0, 5)
  //    //    else if (index == 5) new Vegetable("Cucumber", 1.5, 200, 0.0, 5)
  //    //    else if (index == 4) new Vegetable("Broccoli", 2.0, 200, 0.0, 5)
  //    //    else if (index == 3) new Vegetable("Onion", 0.8, 200, 0.0, 2)
  //    //    else if (index == 2) new Vegetable("Potato", 0.8, 200, 0.0, 2)
  //    //    else if (index == 1) new Vegetable("Eggplant", 2.0, 200, 0.0, 3)
  //    //    else new Vegetable("Eggplant", 2.0, 200, 0.0, 3)
  //    //TODO : exception handling cannot be lifted. fix this later.
  //    //    else throw new IllegalArgumentException
  //  }

  def main(): Unit = {
    while (!supermarket.isPositionsFixed) {
      state = reFillingShelves
      SpecialInstructions.waitTurns(1)
    }
    setInitialPosition(world, Random.nextInt(world.width), Random.nextInt(world.height))
    world.addActor(this)

    writer = new PrintWriter(new FileWriter(new File("m/agentEmployee" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      //      writer.write("\n")
      //      println()
      //      writer.write("Employee's Actor id " + id + " is refilling the shelves")
      //      println("Employee's Actor id " + id + " is refilling the shelves")
      //      writer.write("\n")
      //      println()

      addSupply()
      waitTurns(1)
      state = walkingAround
      writer.write("\n" + "Employee's Actor id " + id + " refilled the shelves" + "\n")
      println()
      println("Employee's Actor id " + id + " refilled the shelves")
      println()
      waitTurns(23)


      addSupply()
      waitTurns(1)
      state = walkingAround
      writer.write("\n" + "Employee's Actor id " + id + " refilled the shelves" + "\n")
      println()
      println("Employee's Actor id " + id + " refilled the shelves")
      println()
      waitTurns(23)


      shuffleShelves()
      waitTurns(1)
      state = walkingAround
      writer.write("\n" + "Employee's Actor id " + id + " shuffled the shelves" + "\n")
      println()
      println("Employee's Actor id " + id + " shuffled the shelves")
      println()
    }
  }
}