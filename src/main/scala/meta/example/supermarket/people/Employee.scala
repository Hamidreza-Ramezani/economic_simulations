package meta.example.supermarket.people

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions.waitTurns
import meta.example.supermarket.{Supermarket, granularity}
import meta.example.supermarket.goods.{Item, Item1, Item10, Item11, Item12, Item13, Item14, Item15, Item16, Item17, Item18, Item19, Item2, Item20, Item21, Item22, Item23, Item24, Item25, Item26, Item27, Item28, Item29, Item3, Item30, Item31, Item32, Item4, Item5, Item6, Item7, Item8, Item9, newItemsMap}
import squid.quasi.lift

@lift
class Employee extends EmployeeTrait {

  def addSupply: Unit = {
    newItemsMap.itemMap.keys.toList.foreach(
      item => List.tabulate(getFreeSpace(item))(n => n).foreach(_ => {
        val new_item: Item = genNewItem(newItemsMap.itemMap(item))
        Supermarket.store.warehouse(item) += (new_item.asInstanceOf[Item])
        writer.write("Employee's Actor id " + id + " Add new actor! name: " + item + "\n")
        //        println("Add new actor! name: " + item)
      })
    )
  }

  def genNewItem(itemId: String): Item = {
    //    var lstOfNewItems: List[Item] = List()
    val index: Int = Integer.parseInt(itemId.replaceAll("Item", ""))
    if (index == 32) new Item32("Egg", 3.0, 250, 0.0, 3)
    else if (index == 31) new Item31("Cream", 1.0, 50, 0.0, 3)
    else if (index == 30) new Item30("Cheese", 5.0, 200, 0.0, 3)
    else if (index == 29) new Item29("Yogurt", 1.0, 50, 0.0, 3)
    else if (index == 28) new Item28("Milk", 2.0, 1000, 0.0, 3)
    else if (index == 27) new Item27("Bread", 1.5, 1000, 0.0, 4)
    else if (index == 26) new Item26("Pasta", 1.5, 1000, 0.0, 4)
    else if (index == 25) new Item25("Spaghetti", 1.5, 1000, 0.0, 4)
    else if (index == 24) new Item24("Noodles", 3.0, 1000, 0.0, 4)
    else if (index == 23) new Item23("Rice", 2.0, 1000, 0.0, 4)
    else if (index == 22) new Item22("Oatmeal", 4.0, 1000, 0.0, 4)
    else if (index == 21) new Item21("Cereal", 4.0, 1000, 0.0, 4)
    else if (index == 20) new Item20("WhiteChocolate", 1.8, 100, 0.0, 10)
    else if (index == 19) new Item19("DarkChocolate", 1.8, 100, 0.0, 10)
    else if (index == 18) new Item18("Ferraro", 5.0, 250, 0.0, 10)
    else if (index == 17) new Item17("Kitkat", 3.5, 300, 0.0, 10)
    else if (index == 16) new Item16("Bacon", 25.0, 1000, 0.0, 3)
    else if (index == 15) new Item15("Lamb", 45.0, 1000, 0.0, 3)
    else if (index == 14) new Item14("Pork", 25.0, 1000, 0.0, 3)
    else if (index == 13) new Item13("Beef", 35.0, 1000, 0.0, 3)
    else if (index == 12) new Item12("Chicken", 15.0, 1000, 0.0, 3)
    else if (index == 11) new Item11("Squash", 1.0, 200, 0.0, 5)
    else if (index == 10) new Item10("Cabbage", 1.0, 200, 0.0, 5)
    else if (index == 9) new Item9("Mushroom", 2.0, 200, 0.0, 5)
    else if (index == 8) new Item8("Tomato", 1.5, 200, 0.0, 5)
    else if (index == 7) new Item7("Celery", 2.0, 200, 0.0, 5)
    else if (index == 6) new Item6("Carrots", 1.0, 200, 0.0, 5)
    else if (index == 5) new Item5("Cucumber", 1.5, 200, 0.0, 5)
    else if (index == 4) new Item4("Broccoli", 2.0, 200, 0.0, 5)
    else if (index == 3) new Item3("Onion", 0.8, 200, 0.0, 2)
    else if (index == 2) new Item2("Potato", 0.8, 200, 0.0, 2)
    else if (index == 1) new Item1("Eggplant", 2.0, 200, 0.0, 3)
    else new Item1("Eggplant", 2.0, 200, 0.0, 3)
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
      state.refillShelves
      waitTurns(1)
      addSupply
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