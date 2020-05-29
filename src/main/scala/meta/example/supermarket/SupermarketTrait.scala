package meta.example.supermarket

import meta.deep.runtime.Actor
import meta.example.supermarket.goods.Item
import meta.example.supermarket.people.{CashierTrait, EmployeeTrait}
import meta.example.supermarket.utils.randElement

import scala.collection.mutable

trait SupermarketTrait extends Actor with SummaryTrait {

  val warehouse: mutable.Map[String, Shelf] = mutable.Map[String, Shelf]()
  val vegetables: Vector[String] = categories.getArticleNames("Vegetable")
  val meats: Vector[String] = categories.getArticleNames("Meat")
  val snacks: Vector[String] = categories.getArticleNames("Snack")
  val grains: Vector[String] = categories.getArticleNames("Grain")
  val dairy: Vector[String] = categories.getArticleNames("Dairy")
  val isInvalids: mutable.Queue[Long] = new mutable.Queue()
  var shelfCapacity: Int = 5
  //todo : having a list of employees
  var employee: EmployeeTrait = null
  var cashier: CashierTrait = null

  //todo: having a list of sections
  //todo: all functions inside supermarket trait should be a wrapper for the functions inside the section class
  //todo complete the body of this function
  def getEmployeesState(): String = {
    //if at least one of the employees is refilling the shelves the state would be the refilling the shelves
    ""
  }


  def setShelfCapacity(shelfCapacity: Int): Unit = {
    this.shelfCapacity = shelfCapacity
  }


  def initializeItemDeque(itemVec: Vector[Item]): Unit = {
    itemVec.groupBy(_.name).foreach(pair =>
      warehouse += Tuple2(pair._1, new Shelf(pair._2))
    )
  }


  def writeWarehouseToFile(): Unit = {
    warehouse.toList.foreach(shelf => writer.write("\n\n" + shelf._1 + "\n\n" + shelf._2.toString))
  }


  def recordWaste(category: String, wastedAmount: Int): Unit = {
    updateWasteSummary(category, wastedAmount)
  }


  def rmDiscarded(items: Shelf): Unit = {
    while (!items.isEmpty && items.peek.state.isDiscarded) {
      items.popLeft
    }
  }


  def getRequestedItem(item: String, fifo: Boolean = true): Item = {
    var requestedItem: Item = null
    val requestedShelf: Shelf = warehouse.getOrElse(item, new Shelf())
    rmDiscarded(requestedShelf)
    if (!requestedShelf.isEmpty) {
      if (fifo) {
        requestedItem = requestedShelf.popLeft
      } else {
        requestedItem = requestedShelf.popRight
      }
      println(s"Item ${requestedItem.name} is requested! " + requestedItem.id)
    }
    requestedItem
  }

  def getRandFood(capitalizedCategory: String): String = {
    var randomElement: String = ""
    if (capitalizedCategory == "Vegetable") {
      randomElement = randElement(vegetables)
    }
    else if (capitalizedCategory == "Meat") {
      randomElement = randElement(meats)
    }
    else if (capitalizedCategory == "Dairy") {
      randomElement = randElement(dairy)
    }
    else if (capitalizedCategory == "Snack") {
      randomElement = randElement(snacks)
    }
    else if (capitalizedCategory == "Grain") {
      randomElement = randElement(grains)
    }
    //todo: IllegalArgumentException
    //    println("Unrecognized food category name for generating food! Category is " + category);
    randomElement
  }

}
