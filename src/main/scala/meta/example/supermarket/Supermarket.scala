package meta.example.supermarket

import java.io.{File, PrintWriter}

import meta.example.supermarket.goods.Item
//import meta.example.supermarket.goods_updated.Item
import meta.example.supermarket.people.{CashierTrait, Employee, EmployeeTrait}
import meta.example.supermarket.utils.randElement

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Map, Queue}

class Supermarket extends SummaryTrait {

  val warehouse: mutable.Map[String, Shelf] = mutable.Map[String, Shelf]()
  val isInvalids: mutable.Queue[Long] = new mutable.Queue()
  //  var toBeScannedItems: mutable.Queue[ListBuffer[Item]] = new mutable.Queue[ListBuffer[Item]]()
  val vegetables: Vector[String] = categories.getArticleNames("Vegetable")
  val meats: Vector[String] = categories.getArticleNames("Meat")
  val snacks: Vector[String] = categories.getArticleNames("Snack")
  val grains: Vector[String] = categories.getArticleNames("Grain")
  val dairy: Vector[String] = categories.getArticleNames("Dairy")
  var shelfCapacity: Int = 5
  var employee: EmployeeTrait = null
  var cashier: CashierTrait = null
  val writer = new PrintWriter(new File("m/supermarket"))

  def setShelfCapacity(shelfCapacity: Int): Unit = {
    this.shelfCapacity = shelfCapacity
  }

  def writeWarehouseToFile(): Unit = {
    warehouse.foreach(shelf => writer.write("\n\n" + shelf._1 + "\n\n" + shelf._2.toString))

  }


  def recordWaste(category: String, wastedAmount: Int): Unit = {
    updateWasteSummary(category, wastedAmount)
  }

  def initializeItemDeque(item: Item): Unit = {
    warehouse += (item.name -> new Shelf(item))
  }

  def initializeItemDeque(item: Vector[Item]): Unit = {
    item.groupBy(_.name).foreach(pair =>
      warehouse += (pair._1 -> new Shelf(pair._2))
    )
  }

  def rmDiscarded(items: Shelf): Unit = {
    while (!items.isEmpty && items.peek.state.isDiscarded) {
      items.popLeft
    }
  }

  def sell(item: String, fifo: Boolean = true): Option[Item] = {
    val requested: Shelf = warehouse.getOrElse(item, new Shelf())
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
    val requested: Shelf = warehouse.getOrElse(item, new Shelf())
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
      case "Dairy" => randElement(dairy)
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