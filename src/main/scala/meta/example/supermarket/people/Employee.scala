package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.new_instance_example.object1
import meta.example.supermarket
import meta.example.supermarket.Supermarket
import meta.example.supermarket.goods._
import squid.quasi.lift

import scala.collection.mutable.ListBuffer

@lift
class Labor extends Actor {

  val object_queue = ListBuffer[object1]()
  val shelfCapacity: Int = 20

  def fillShelf(item: String): Int = {
    //    println("Fill the shelf for item " + item + " amount: " + (shelfCapacity - Supermarket.store.warehouse(item).size))
    shelfCapacity - Supermarket.store.warehouse(item).size
  }

  def addSupply: Unit = {
    newItemsMap.itemMap.keys.foreach(
      item => 1.to(fillShelf(item)).foreach(_ => {
        val new_item: Item = genNewItem(newItemsMap.itemMap(item)
//        new_item.timeVar = timer
//        Supermarket.store.warehouse(item) += (new_item.asInstanceOf[Item])
          Supermarket.store.warehouse(item) += (new_item)
//        actors = actors :+ new_item.asInstanceOf[meta.deep.runtime.Actor]
        println("Add new actor! name: " + item)
      })
    )
  }


  private def genNewItem(itemId: String): newItem = {
    itemId match {
      case "Item1" => new Item1()
      case "Item2" => new Item2()
      case "Item3" => new Item3()
      case "Item4" => new Item4()
      case "Item5" => new Item5()
      case "Item6" => new Item6()
      case "Item7" => new Item7()
      case "Item8" => new Item8()
      case "Item9" => new Item9()
      case "Item10" => new Item10()
      case "Item11" => new Item11()
      case "Item12" => new Item12()
      case "Item13" => new Item13()
      case "Item14" => new Item14()
      case "Item15" => new Item15()
      case "Item16" => new Item16()
      case "Item17" => new Item17()
      case "Item18" => new Item18()
      case "Item19" => new Item19()
      case "Item20" => new Item20()
      case "Item21" => new Item21()
      case "Item22" => new Item22()
      case "Item23" => new Item23()
      case "Item24" => new Item24()
      case "Item25" => new Item25()
      case "Item26" => new Item26()
      case "Item27" => new Item27()
      case "Item28" => new Item28()
      case "Item29" => new Item29()
      case "Item30" => new Item30()
      case "Item31" => new Item31()
      case _ => throw new IllegalArgumentException
    }
  }

  def addObject1(): Unit = {
    object_queue.append(new object1)
  }

  def main(): Unit = {
    while (true) {
//      addObject1()
      addSupply
      waitTurns(1)
    }
  }
}


