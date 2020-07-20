package meta.example.supermarket

import meta.deep.runtime.Actor
import meta.example.supermarket.goods.{Brand, Item, global, onDisplay}
import meta.example.supermarket.people.{CashierTrait, EmployeeTrait, reFillingShelves}
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
  var numberOfDifferentBrands = 3
//  var shelfCapacity: Int = warehouse.head.shelfCapacity * numberOfDifferentBrands
  var shelfCapacity: Int = warehouse.head.shelfCapacity
  var toBeScannedItems: mutable.Queue[ListBuffer[Item]] = new mutable.Queue[ListBuffer[Item]]()
  var isPositionsFixed: Boolean = false
  canMove = false


  //  val vegetables: Vector[String] = categories.getArticleNames("Vegetable")
  //  val meats: Vector[String] = categories.getArticleNames("Meat")
  //  val snacks: Vector[String] = categories.getArticleNames("Snack")
  //  val grains: Vector[String] = categories.getArticleNames("Grain")
  //  val dairy: Vector[String] = categories.getArticleNames("Dairy")


  override def setInitialPosition(world: WorldTrait, x: Int, y: Int): Unit = {
    if (!isPositionsFixed) {
      this.initialXPosition = x
      this.initialYPosition = y
      currentXPosition = initialXPosition
      currentYPosition = initialYPosition
      oldXPosition = initialXPosition
      oldYPosition = initialYPosition
      world.coordinates(y)(x).hasOwner = true
      isPositionsFixed = true
    }
  }


  //todo the body of this function needs to be revised
  def getEmployeesState: String = {
    //if at least one of the employees is refilling the shelves the state would be the refilling the shelves
    var result: String = ""
    employees.foreach(employee => if (employee.state == reFillingShelves) {
      result = "reFillingShelves"
    })
    result
  }

  def setShelfCapacity(shelfCapacity: Int): Unit = {
    this.shelfCapacity = shelfCapacity
  }


  def initializeShelves(itemVec: Vector[Item]): Unit = {
    itemVec.groupBy(_.name).foreach(pair =>
      pair._2(0).section.initializeShelves(pair._2)
    )
    itemVec.foreach { item =>
      item.state = onDisplay
    }
  }

  def initializeShelf(item: Item): Unit = {
    item.section.initializeShelf(item)
  }

  def recordWaste(category: String, wastedAmount: Int): Unit = {
    updateWasteSummary(category, wastedAmount)
  }


  //  def rmDiscarded(items: Shelf): Unit = {
  //    while (!items.isEmpty && items.peek.state.isDiscarded) {
  //      items.popLeft
  //    }
  //  }

  def getRequestedItem(itemName: String, itemBrand: Brand, fifo: Boolean = true): Item = {
    var requestedItem: Item = null
    val categoryName: String = global.categoryMap(itemName)
    if (categoryName == "Vegetable") {
      requestedItem = warehouse.filter(_.sectionName == "Vegetable").head.getRequestedItem(itemName,itemBrand)
    }
    else if (categoryName == "Meat") {
      requestedItem = warehouse.filter(_.sectionName == "Meat").head.getRequestedItem(itemName,itemBrand)
    }
    else if (categoryName == "Dairy") {
      requestedItem = warehouse.filter(_.sectionName == "Dairy").head.getRequestedItem(itemName,itemBrand)
    }
    else if (categoryName == "Snack") {
      requestedItem = warehouse.filter(_.sectionName == "Snack").head.getRequestedItem(itemName,itemBrand)
    }
    else if (categoryName == "Grain") {
      requestedItem = warehouse.filter(_.sectionName == "Grain").head.getRequestedItem(itemName,itemBrand)
    }
    requestedItem
  }

  def hasItem(itemName: String, itemBrand: Brand): Boolean = {
    var isItemAvailable: Boolean = false
    val categoryName: String = global.categoryMap(itemName)
    if (categoryName == "Vegetable") {
      isItemAvailable = warehouse.filter(_.sectionName == "Vegetable").head.hasItem(itemName,itemBrand)
    }
    else if (categoryName == "Meat") {
      isItemAvailable = warehouse.filter(_.sectionName == "Meat").head.hasItem(itemName,itemBrand)
    }
    else if (categoryName == "Dairy") {
      isItemAvailable = warehouse.filter(_.sectionName == "Dairy").head.hasItem(itemName,itemBrand)
    }
    else if (categoryName == "Snack") {
      isItemAvailable = warehouse.filter(_.sectionName == "Snack").head.hasItem(itemName,itemBrand)
    }
    else if (categoryName == "Grain") {
      isItemAvailable = warehouse.filter(_.sectionName == "Grain").head.hasItem(itemName,itemBrand)
    }
    isItemAvailable
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