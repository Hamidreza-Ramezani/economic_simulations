package meta.example.supermarket

import meta.example.supermarket.goods._
import meta.example.supermarket.people.Employee
import meta.example.supermarket.utils.randElement

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Map, Queue}

class Supermarket extends SummaryTrait {
  val warehouse: Map[String, ItemDeque] = Map[String, ItemDeque]()
  val isInvalids: Queue[Long] = new Queue()
  var toBeScannedItems: mutable.Queue[ListBuffer[Item]] = new mutable.Queue[ListBuffer[Item]]()
  val vegetables: Vector[String] = categories.getArticleNames("Vegetable")
  val meats: Vector[String] = categories.getArticleNames("Meat")
  val snacks: Vector[String] = categories.getArticleNames("Snack")
  val grains: Vector[String] = categories.getArticleNames("Grain")
  val dairys: Vector[String] = categories.getArticleNames("Dairy")
  var shelfCapacity: Int = 10
  //  val employee = null

  var employee: Employee = null

  def setShelfCapacity(shelfCapacity: Int): Unit = {
    this.shelfCapacity = shelfCapacity
  }


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

    //    addToScannerQueue(requestedItem)
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
}

object Supermarket {
  val store: Supermarket = new Supermarket
}