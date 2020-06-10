package meta.example.supermarket

import meta.deep.runtime.Actor
import meta.example.supermarket.goods.Item
import meta.example.supermarket.utils.randElement

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

trait SectionTrait extends Actor with SummaryTrait {

  var sectionName: String
  val articleNames: Vector[String] = categories.getArticleNames(sectionName)
  val shelves: mutable.Map[String, Shelf] = mutable.Map[String, Shelf]()
  val isInvalids: mutable.Queue[Long] = new mutable.Queue()
  var shelfCapacity: Int = 5
  //  var employee: EmployeeTrait = null
  //  var cashier: CashierTrait = null
  var sectionShufflingPolicy: ShufflingPolicy


  def isNotFull(): Boolean = {
    shelves.foreach(shelf =>
      if (shelf._2.itemsList.size < shelfCapacity) {
        return true
      }
    )
    false
  }

  def setShelfCapacity(shelfCapacity: Int): Unit = {
    this.shelfCapacity = shelfCapacity
  }

  def initializeItemDeque(itemVec: Vector[Item]): Unit = {
    itemVec.groupBy(_.name).foreach(pair =>
      shelves += Tuple2(pair._1, new Shelf(null, pair._2.to[ListBuffer]))
    )
  }

  //  def writeWarehouseToFile(): Unit = {
  //    shelves.toList.foreach(shelf => writer.write("\n\n" + shelf._1 + "\n\n" + shelf._2.toString))
  //  }

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
    val requestedShelf: Shelf = shelves.getOrElse(item, new Shelf(null, null))
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

  def getRandFood(): String = {
    randElement(articleNames)
  }

}
