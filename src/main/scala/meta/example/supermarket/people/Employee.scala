package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.{Supermarket, granularity}
import meta.example.supermarket.goods.{Item, Item1, Item10, Item11, Item12, Item13, Item14, Item15, Item16, Item17, Item18, Item19, Item2, Item20, Item21, Item22, Item23, Item24, Item25, Item26, Item27, Item28, Item29, Item3, Item30, Item31, Item32, Item4, Item5, Item6, Item7, Item8, Item9, newItemsMap}
import squid.quasi.lift


@lift
class Employee extends Actor {
  var shelfCapacity: Int = 4

  def fillShelf(item: String): Int = {
    shelfCapacity - Supermarket.store.warehouse(item).size
  }

  def addSupply: Unit = {
    var i = 0
    newItemsMap.itemMap.keys.toList.foreach(
      item => List.tabulate(fillShelf(item))(n => n).foreach(_ => {
        val new_item: Item = genNewItem(newItemsMap.itemMap(item))
        Supermarket.store.warehouse(item) += (new_item.asInstanceOf[Item])
        println("Add new actor! name: " + item)
      })
    )
  }

  def genNewItem(itemId: String): Item = {
    var lstOfNewItems: List[Item] = List()
    var index: Int = Integer.parseInt(itemId.replaceAll("Item", ""))
    if (index == 32) new Item32()
    else if (index == 31) new Item31()
    else if (index == 30) new Item30()
    else if (index == 29) new Item29()
    else if (index == 28) new Item28()
    else if (index == 27) new Item27()
    else if (index == 26) new Item26()
    else if (index == 25) new Item25()
    else if (index == 24) new Item24()
    else if (index == 23) new Item23()
    else if (index == 22) new Item22()
    else if (index == 21) new Item21()
    else if (index == 20) new Item20()
    else if (index == 19) new Item19()
    else if (index == 18) new Item18()
    else if (index == 17) new Item17()
    else if (index == 16) new Item16()
    else if (index == 15) new Item15()
    else if (index == 14) new Item14()
    else if (index == 13) new Item13()
    else if (index == 12) new Item12()
    else if (index == 11) new Item11()
    else if (index == 10) new Item10()
    else if (index == 9) new Item9()
    else if (index == 8) new Item8()
    else if (index == 7) new Item7()
    else if (index == 6) new Item6()
    else if (index == 5) new Item5()
    else if (index == 4) new Item4()
    else if (index == 3) new Item3()
    else if (index == 2) new Item2()
    else if (index == 1) new Item1()
    else new Item1
    //TODO : exception handling cannot be lifted. fix this later.
    //    else throw new IllegalArgumentException
  }

  def main(): Unit = {
    while (true) {
      addSupply
//      waitTurns((1 * granularity.hour))
      waitTurns(12)
    }
  }
}