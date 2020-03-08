package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.Supermarket
import meta.example.supermarket.goods.{Item, Item1, Item10, Item11, Item12, Item13, Item14, Item15, Item16, Item17, Item18, Item19, Item2, Item20, Item21, Item22, Item23, Item24, Item25, Item26, Item27, Item28, Item29, Item3, Item30, Item31, Item32, Item4, Item5, Item6, Item7, Item8, Item9, newItemsMap}
import squid.quasi.lift


@lift
class Employee extends Actor {
  var shelfCapacity: Int = 20

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
      //      while (i < fillShelf(item)) {
      //        val new_item: Item = genNewItem(newItemsMap.itemMap(item))
      //        Supermarket.store.warehouse(item) += (new_item.asInstanceOf[Item])
      //        println("Add new actor! name: " + item)
      //        i = i + 1
      //      }
    )
  }

  def genNewItem(itemId: String): Item = {
    //    itemId match {
    var lstOfNewItems: List[Item] = List()

    lstOfNewItems = lstOfNewItems.::(new Item32())
    lstOfNewItems = lstOfNewItems.::(new Item31())
    lstOfNewItems = lstOfNewItems.::(new Item30())
    lstOfNewItems = lstOfNewItems.::(new Item29())
    lstOfNewItems = lstOfNewItems.::(new Item28())
    lstOfNewItems = lstOfNewItems.::(new Item27())
    lstOfNewItems = lstOfNewItems.::(new Item26())
    lstOfNewItems = lstOfNewItems.::(new Item25())
    lstOfNewItems = lstOfNewItems.::(new Item24())
    lstOfNewItems = lstOfNewItems.::(new Item23())
    lstOfNewItems = lstOfNewItems.::(new Item22())
    lstOfNewItems = lstOfNewItems.::(new Item21())
    lstOfNewItems = lstOfNewItems.::(new Item20())
    lstOfNewItems = lstOfNewItems.::(new Item19())
    lstOfNewItems = lstOfNewItems.::(new Item18())
    lstOfNewItems = lstOfNewItems.::(new Item17())
    lstOfNewItems = lstOfNewItems.::(new Item16())
    lstOfNewItems = lstOfNewItems.::(new Item15())
    lstOfNewItems = lstOfNewItems.::(new Item14())
    lstOfNewItems = lstOfNewItems.::(new Item13())
    lstOfNewItems = lstOfNewItems.::(new Item12())
    lstOfNewItems = lstOfNewItems.::(new Item11())
    lstOfNewItems = lstOfNewItems.::(new Item10())
    lstOfNewItems = lstOfNewItems.::(new Item9())
    lstOfNewItems = lstOfNewItems.::(new Item8())
    lstOfNewItems = lstOfNewItems.::(new Item7())
    lstOfNewItems = lstOfNewItems.::(new Item6())
    lstOfNewItems = lstOfNewItems.::(new Item5())
    lstOfNewItems = lstOfNewItems.::(new Item4())
    lstOfNewItems = lstOfNewItems.::(new Item3())
    lstOfNewItems = lstOfNewItems.::(new Item2())
    lstOfNewItems = lstOfNewItems.::(new Item1())

    var index: Int = Integer.parseInt(itemId.replaceAll("Item",""))

//    var index: Int = 5


    lstOfNewItems.apply(index-1)

    //      case "Item1" => new Item1()
    //      case "Item2" => new Item2()
    //      case "Item3" => new Item3()
    //      case "Item4" => new Item4()
    //      case "Item5" => new Item5()
    //      case "Item6" => new Item6()
    //      case "Item7" => new Item7()
    //      case "Item8" => new Item8()
    //      case "Item9" => new Item9()
    //      case "Item10" => new Item10()
    //      case "Item11" => new Item11()
    //      case "Item12" => new Item12()
    //      case "Item13" => new Item13()
    //      case "Item14" => new Item14()
    //      case "Item15" => new Item15()
    //      case "Item16" => new Item16()
    //      case "Item17" => new Item17()
    //      case "Item18" => new Item18()
    //      case "Item19" => new Item19()
    //      case "Item20" => new Item20()
    //      case "Item21" => new Item21()
    //      case "Item22" => new Item22()
    //      case "Item23" => new Item23()
    //      case "Item24" => new Item24()
    //      case "Item25" => new Item25()
    //      case "Item26" => new Item26()
    //      case "Item27" => new Item27()
    //      case "Item28" => new Item28()
    //      case "Item29" => new Item29()
    //      case "Item30" => new Item30()
    //      case "Item31" => new Item31()
    //      case "Item32" => new Item32()
    //      case _ => throw new IllegalArgumentException
    //    }
  }

  def main(): Unit = {
    while (true) {
      //      Supermarket.store.addSupply
      addSupply
      waitTurns(1)
    }
  }
}


