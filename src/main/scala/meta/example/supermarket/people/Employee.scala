package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.Supermarket
import meta.example.supermarket.goods.{Item, Item1, newItemsMap}
import squid.quasi.lift


@lift
class Employee extends Actor {
  val shelfCapacity: Int = 10

  def fillShelf(item: String): Int = {
    //    println("Fill the shelf for item " + item + " amount: " + (shelfCapacity - Supermarket.store.warehouse(item).size))
    shelfCapacity - Supermarket.store.warehouse(item).size
  }

  def addSupply: Unit = {
    newItemsMap.itemMap.keys.foreach(
      item => 1.to(fillShelf(item)).foreach(_ => {
//        val new_item: Item = Class.forName("meta.example.supermarket.goods." + newItemsMap.itemMap(item)).newInstance().asInstanceOf[Item]
//        val new_item: Item = genNewItem(newItemsMap.itemMap(item))
        val new_item: Item1 = new Item1

        Supermarket.store.warehouse(item) += (new_item.asInstanceOf[Item])
        println("Add new actor! name: " + item)
      })
    )
  }

  def main(): Unit = {
    while (true)  {
//      Supermarket.store.addSupply
            addSupply
      waitTurns(1)
    }
  }
}


