package meta.example.supermarket

import meta.example.supermarket.goods._
import meta.example.supermarket.utils.randElement

import scala.collection.mutable
import scala.collection.mutable.{Map, Queue}

class Supermarket extends SummaryTrait {
  val warehouse: Map[String, ItemDeque] = Map[String, ItemDeque]()
  val isInvalids: Queue[Long] = new Queue()
  var toBeScannedItems: mutable.Queue[Item] = new mutable.Queue[Item]()
  val vegetables: Vector[String] = categories.getArticleNames("Vegetable")
  val meats: Vector[String] = categories.getArticleNames("Meat")
  val snacks: Vector[String] = categories.getArticleNames("Snack")
  val grains: Vector[String] = categories.getArticleNames("Grain")
  val dairys: Vector[String] = categories.getArticleNames("Dairy")
  val shelfCapacity: Int = 10

  def recordWaste(category: String, wastedAmount: Int): Unit = {
    updateWasteSummary(category, wastedAmount)
  }

  def initializeItemDeque(item: Item): Unit = {
    warehouse += (item.name -> new ItemDeque(item))
  }

  def initializeItemDeque(item: Vector[Item]): Unit = {
    item.groupBy(_.name).foreach(pair =>
      warehouse += (pair._1 -> new ItemDeque(pair._2))
    )
  }

  def rmDiscarded(items: ItemDeque): Unit = {
    while (!items.isEmpty && items.peek.state.isDiscarded) {
      items.popLeft
    }
  }

  def sell(item: String, fifo: Boolean = true): Option[Item] = {
    val requested: ItemDeque = warehouse.getOrElse(item, new ItemDeque())
    rmDiscarded(requested)
    if (requested.isEmpty) {
      //      sell(getRandFood(item.asInstanceOf[Item].category))
      None
    }

    var requestedItem: Item = null
    if (fifo) {
      requestedItem = requested.popLeft
    } else {
      requestedItem = requested.popRight
    }

    addToScannerQueue(requestedItem)
    while (requestedItem.state.get != "isPurchased") {
      //do nothing
    }
    //    println(s"Item ${requestedItem.name} is scanned! " + requestedItem.id)
    //    requestedItem.purchase
    println(s"Item ${requestedItem.name} is sold! " + requestedItem.id)
    Some(requestedItem)
  }

  def getRequestedItem(item: String, fifo: Boolean = true): Option[Item] = {
    val requested: ItemDeque = warehouse.getOrElse(item, new ItemDeque())
    rmDiscarded(requested)
    if (requested.isEmpty) {
      //      sell(getRandFood(item.asInstanceOf[Item].category))
      None
    }
    var requestedItem: Item = null
    if (fifo) {
      requestedItem = requested.popLeft
    } else {
      requestedItem = requested.popRight
    }
    println(s"Item ${requestedItem.name} is requested! " + requestedItem.id)
    Some(requestedItem)
  }

  def getRandFood(category: String): String = {
    category.capitalize match {
      case "Vegetable" => randElement(vegetables)
      case "Meat" => randElement(meats)
      case "Dairy" => randElement(dairys)
      case "Snack" => randElement(snacks)
      case "Grain" => randElement(grains)
      case _ => {
        println("Unrecognized food category name for generating food! Category is " + category);
        throw new IllegalArgumentException
      }
    }
  }

  def addToScannerQueue(item: Item) = {
    Supermarket.store.toBeScannedItems.enqueue(item)
    item.state.addToBasket
  }


  def fillShelf(item: String): Int = {
    //    println("Fill the shelf for item " + item + " amount: " + (shelfCapacity - Supermarket.store.warehouse(item).size))
    shelfCapacity - Supermarket.store.warehouse(item).size
  }

  def addSupply: Unit = {
    newItemsMap.itemMap.keys.foreach(
      item => 1.to(fillShelf(item)).foreach(_ => {
        val new_item: Item = genNewItem(newItemsMap.itemMap(item))
        //        val new_item: Item = Class.forName("meta.example.supermarket.goods." + newItemsMap.itemMap(item)).newInstance().asInstanceOf[Item]

        //        new_item.timeVar = timer
        Supermarket.store.warehouse(item) += (new_item.asInstanceOf[Item])
        //        actors = actors :+ new_item.asInstanceOf[meta.deep.runtime.Actor]
        println("Add new actor! name: " + item)
      })
    )
  }

  def genNewItem(itemId: String): Item = {
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
      case "Item32" => new Item32()
      case _ => throw new IllegalArgumentException
    }
  }

}

object Supermarket {
  val store: Supermarket = new Supermarket
}