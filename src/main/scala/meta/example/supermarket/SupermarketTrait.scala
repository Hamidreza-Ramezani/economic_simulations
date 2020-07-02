package meta.example.supermarket

import meta.deep.runtime.Actor
import meta.example.supermarket.goods.{Item, newItemsMap}
import meta.example.supermarket.people.{CashierTrait, EmployeeTrait}
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

trait SupermarketTrait extends Actor with SummaryTrait {


  var world: WorldTrait
  val isInvalids: mutable.Queue[Long] = new mutable.Queue()
  var employees: ListBuffer[EmployeeTrait] = new ListBuffer[EmployeeTrait]()
  var cashiers: ListBuffer[CashierTrait] = new ListBuffer[CashierTrait]()
  var warehouse: ListBuffer[SectionTrait]
  var storage: ListBuffer[Item] = new ListBuffer[Item]()
  var itemsRecentlyOrdered: Boolean = true
  var shelfCapacity: Int = warehouse.head.shelfCapacity
  var toBeScannedItems: mutable.Queue[ListBuffer[Item]] = new mutable.Queue[ListBuffer[Item]]()
  canMove = false


  //  val vegetables: Vector[String] = categories.getArticleNames("Vegetable")
  //  val meats: Vector[String] = categories.getArticleNames("Meat")
  //  val snacks: Vector[String] = categories.getArticleNames("Snack")
  //  val grains: Vector[String] = categories.getArticleNames("Grain")
  //  val dairy: Vector[String] = categories.getArticleNames("Dairy")

  //todo: all functions inside supermarket trait should be a wrapper for the functions inside the section class

  //todo the body of this function needs to be revised
  def getEmployeesState: String = {
    //if at least one of the employees is refilling the shelves the state would be the refilling the shelves
    var result: String = ""
    employees.foreach(employee => if (employee.state.get == "reFillingShelves") {
      result = "reFillingShelves"
    })
    result
  }

  def setShelfCapacity(shelfCapacity: Int): Unit = {
    this.shelfCapacity = shelfCapacity
  }


  def initializeItemDeque(itemVec: Vector[Item]): Unit = {
    itemVec.groupBy(_.name).foreach(pair =>
      pair._2(0).section.initializeItemDeque(pair._2)
    )
  }

  def initializeItemDeque(item: Item): Unit = {
    item.section.initializeItemDeque(item)
  }

  def recordWaste(category: String, wastedAmount: Int): Unit = {
    updateWasteSummary(category, wastedAmount)
  }


  //  def rmDiscarded(items: Shelf): Unit = {
  //    while (!items.isEmpty && items.peek.state.isDiscarded) {
  //      items.popLeft
  //    }
  //  }

  def getRequestedItem(itemStr: String, fifo: Boolean = true): Item = {
    var requestedItem: Item = null
    val categoryName: String = newItemsMap.categoryMap(itemStr)
    if (categoryName == "Vegetable") {
      requestedItem = warehouse.filter(_.sectionName == "Vegetable").head.getRequestedItem(itemStr)
    }
    else if (categoryName == "Meat") {
      requestedItem = warehouse.filter(_.sectionName == "Meat").head.getRequestedItem(itemStr)
    }
    else if (categoryName == "Dairy") {
      requestedItem = warehouse.filter(_.sectionName == "Dairy").head.getRequestedItem(itemStr)
    }
    else if (categoryName == "Snack") {
      requestedItem = warehouse.filter(_.sectionName == "Snack").head.getRequestedItem(itemStr)
    }
    else if (categoryName == "Grain") {
      requestedItem = warehouse.filter(_.sectionName == "Grain").head.getRequestedItem(itemStr)
    }
    requestedItem

    //    var requestedItem: Item = null
    //    val requestedShelf: Shelf = warehouse.getOrElse(item, new Shelf())
    //    rmDiscarded(requestedShelf)
    //    if (!requestedShelf.isEmpty) {
    //      if (fifo) {
    //        requestedItem = requestedShelf.popLeft
    //      } else {
    //        requestedItem = requestedShelf.popRight
    //      }
    //      println(s"Item ${requestedItem.name} is requested! " + requestedItem.id)
    //    }
    //    requestedItem
  }

  def getRandFood(capitalizedCategory: String): String = {
    var randomElement: String = ""
    if (capitalizedCategory == "Vegetable") {
      randomElement = warehouse.filter(_.sectionName == "Vegetable").head.getRandFood()
    }
    else if (capitalizedCategory == "Meat") {
      randomElement = warehouse.filter(_.sectionName == "Meat").head.getRandFood()
    }
    else if (capitalizedCategory == "Dairy") {
      randomElement = warehouse.filter(_.sectionName == "Dairy").head.getRandFood()
    }
    else if (capitalizedCategory == "Snack") {
      randomElement = warehouse.filter(_.sectionName == "Snack").head.getRandFood()
    }
    else if (capitalizedCategory == "Grain") {
      randomElement = warehouse.filter(_.sectionName == "Grain").head.getRandFood()
    }
    //todo: IllegalArgumentException
    //    println("Unrecognized food category name for generating food! Category is " + category);
    randomElement
  }

}
