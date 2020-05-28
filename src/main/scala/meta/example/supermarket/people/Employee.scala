package meta.example.supermarket.people

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions.waitTurns
import meta.example.supermarket.Supermarket
import meta.example.supermarket.goods._
//import meta.example.supermarket.goods_updated.{Dairy, Grain, Meat, Snack, Vegetable, newItemsMap}
import squid.quasi.lift

@lift
class Employee(var supermarket: Supermarket) extends EmployeeTrait {

  def getFreeSpace(item: String): Int = {
    supermarket.shelfCapacity - supermarket.warehouse(item).size
  }


  def addSupply(): Unit = {
    newItemsMap.itemMap.keys.toList.foreach(
      itemStr => List.tabulate(getFreeSpace(itemStr))(n => n).foreach(_ => {
        val new_item: Item = genNewItem(newItemsMap.itemMap(itemStr))
        supermarket.warehouse(itemStr) += new_item.asInstanceOf[Item]
        writer.write("Employee's Actor id " + id + " Add new actor! name: " + itemStr + "\n")
      })
    )
  }

  def shuffleShelves(): Unit = {
    //todo: add delay for the customers
    //    Supermarket.store.warehouse.foreach(shelf => shelf._2.itemDeque.)
  }

  def genNewItem(itemId: String): Item = {
    //    var lstOfNewItems: List[Item] = List()
    val index: Int = Integer.parseInt(itemId.replaceAll("Item", ""))

    if (index == 32) new Item32(supermarket)
    else if (index == 31) new Item31(supermarket)
    else if (index == 30) new Item30(supermarket)
    else if (index == 29) new Item29(supermarket)
    else if (index == 28) new Item28(supermarket)
    else if (index == 27) new Item27(supermarket)
    else if (index == 26) new Item26(supermarket)
    else if (index == 25) new Item25(supermarket)
    else if (index == 24) new Item24(supermarket)
    else if (index == 23) new Item23(supermarket)
    else if (index == 22) new Item22(supermarket)
    else if (index == 21) new Item21(supermarket)
    else if (index == 20) new Item20(supermarket)
    else if (index == 19) new Item19(supermarket)
    else if (index == 18) new Item18(supermarket)
    else if (index == 17) new Item17(supermarket)
    else if (index == 16) new Item16(supermarket)
    else if (index == 15) new Item15(supermarket)
    else if (index == 14) new Item14(supermarket)
    else if (index == 13) new Item13(supermarket)
    else if (index == 12) new Item12(supermarket)
    else if (index == 11) new Item11(supermarket)
    else if (index == 10) new Item10(supermarket)
    else if (index == 9) new Item9(supermarket)
    else if (index == 8) new Item8(supermarket)
    else if (index == 7) new Item7(supermarket)
    else if (index == 6) new Item6(supermarket)
    else if (index == 5) new Item5(supermarket)
    else if (index == 4) new Item4(supermarket)
    else if (index == 3) new Item3(supermarket)
    else if (index == 2) new Item2(supermarket)
    else if (index == 1) new Item1(supermarket)
    else new Item1(supermarket)

    //    if (index == 32) new Dairy("Egg", 3.0, 250, 0.0, 3)
    //    else if (index == 31) new Dairy("Cream", 1.0, 50, 0.0, 3)
    //    else if (index == 30) new Dairy("Cheese", 5.0, 200, 0.0, 3)
    //    else if (index == 29) new Dairy("Yogurt", 1.0, 50, 0.0, 3)
    //    else if (index == 28) new Dairy("Milk", 2.0, 1000, 0.0, 3)
    //    else if (index == 27) new Grain("Bread", 1.5, 1000, 0.0, 4)
    //    else if (index == 26) new Grain("Pasta", 1.5, 1000, 0.0, 4)
    //    else if (index == 25) new Grain("Spaghetti", 1.5, 1000, 0.0, 4)
    //    else if (index == 24) new Grain("Noodles", 3.0, 1000, 0.0, 4)
    //    else if (index == 23) new Grain("Rice", 2.0, 1000, 0.0, 4)
    //    else if (index == 22) new Grain("Oatmeal", 4.0, 1000, 0.0, 4)
    //    else if (index == 21) new Grain("Cereal", 4.0, 1000, 0.0, 4)
    //    else if (index == 20) new Snack("WhiteChocolate", 1.8, 100, 0.0, 10)
    //    else if (index == 19) new Snack("DarkChocolate", 1.8, 100, 0.0, 10)
    //    else if (index == 18) new Snack("Ferraro", 5.0, 250, 0.0, 10)
    //    else if (index == 17) new Snack("Kitkat", 3.5, 300, 0.0, 10)
    //    else if (index == 16) new Meat("Bacon", 25.0, 1000, 0.0, 3)
    //    else if (index == 15) new Meat("Lamb", 45.0, 1000, 0.0, 3)
    //    else if (index == 14) new Meat("Pork", 25.0, 1000, 0.0, 3)
    //    else if (index == 13) new Meat("Beef", 35.0, 1000, 0.0, 3)
    //    else if (index == 12) new Meat("Chicken", 15.0, 1000, 0.0, 3)
    //    else if (index == 11) new Vegetable("Squash", 1.0, 200, 0.0, 5)
    //    else if (index == 10) new Vegetable("Cabbage", 1.0, 200, 0.0, 5)
    //    else if (index == 9) new Vegetable("Mushroom", 2.0, 200, 0.0, 5)
    //    else if (index == 8) new Vegetable("Tomato", 1.5, 200, 0.0, 5)
    //    else if (index == 7) new Vegetable("Celery", 2.0, 200, 0.0, 5)
    //    else if (index == 6) new Vegetable("Carrots", 1.0, 200, 0.0, 5)
    //    else if (index == 5) new Vegetable("Cucumber", 1.5, 200, 0.0, 5)
    //    else if (index == 4) new Vegetable("Broccoli", 2.0, 200, 0.0, 5)
    //    else if (index == 3) new Vegetable("Onion", 0.8, 200, 0.0, 2)
    //    else if (index == 2) new Vegetable("Potato", 0.8, 200, 0.0, 2)
    //    else if (index == 1) new Vegetable("Eggplant", 2.0, 200, 0.0, 3)
    //    else new Vegetable("Eggplant", 2.0, 200, 0.0, 3)
    //TODO : exception handling cannot be lifted. fix this later.
    //    else throw new IllegalArgumentException
  }

  def main(): Unit = {
    writer = new PrintWriter(new FileWriter(new File("m/agent" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      writer.write("\n")
      println()
      writer.write("Employee's Actor id " + id + " is refilling the shelves")
      println("Employee's Actor id " + id + " is refilling the shelves")
      writer.write("\n")
      println()
      addSupply()
      state.refillShelves
      waitTurns(1)
      state.walkAround
      writer.write("\n")
      println()
      writer.write("Employee's Actor id " + id + " refilled the shelves")
      println("Employee's Actor id " + id + " refilled the shelves")
      writer.write("\n")
      println()
      //      waitTurns((1 * granularity.hour))
      waitTurns(12)
    }
  }
}