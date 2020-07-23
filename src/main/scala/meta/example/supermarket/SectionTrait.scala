package meta.example.supermarket

import meta.deep.runtime.Actor
import meta.example.supermarket.goods.{Aha, Brand, Item, Optigal, TerraSuisse, global, isDiscarded}
import meta.example.supermarket.utils.utilities
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

trait SectionTrait extends Actor with SummaryTrait {

  var world: WorldTrait
  var sectionName: String
  val articleNames: Vector[String] = categories.getArticleNames(sectionName)
  val shelves: mutable.Map[(String, Brand), Shelf] = mutable.Map[(String, Brand), Shelf]()
  val isInvalids: mutable.Queue[Long] = new mutable.Queue()
  var shelfCapacity: Int = global.shelfCapacity
  var sectionShufflingPolicy: ShufflingPolicy
  var supermarket: SupermarketTrait = _
  canMove = false

  var brandsList: ListBuffer[Brand] = new ListBuffer[Brand]
  brandsList += TerraSuisse
  brandsList += Optigal
  brandsList += Aha

  articleNames.foreach {
    article =>
      brandsList.foreach {
        brand =>
          shelves += ((article, brand) -> new Shelf(article + brand.toString))
      }
  }

  //  override def setInitialPosition(x: Int, y: Int): Unit = {
  //    world.coordinates_flattened.foreach {
  //      tile =>
  //        tile.actors.foreach {
  //          actor =>
  //            if (actor.getClass.getSimpleName == "Supermarket") {
  //              this.initialXPosition = actor.initialXPosition
  //              this.initialYPosition = actor.initialYPosition
  //            }
  //        }
  //    }
  //    currentXPosition = initialXPosition
  //    currentYPosition = initialYPosition
  //  }

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

  def initializeShelf(item: Item): Unit = {
    if (shelves((item.name, item.brand)).isEmpty) {
      shelves += Tuple2((item.name, item.brand), new Shelf(item))
    }
    else {
      shelves((item.name, item.brand)).+=(item)
    }
  }

  def initializeShelves(itemVec: Vector[Item]): Unit = {
    itemVec.groupBy(_.name).foreach { itemsWithIdenticalName =>
      itemsWithIdenticalName._2.to[ListBuffer].groupBy(_.brand).foreach {
        similarItems =>
          if (shelves((itemsWithIdenticalName._1, similarItems._1)).isEmpty) {
            shelves += Tuple2((itemsWithIdenticalName._1, similarItems._1), new Shelf(null, itemsWithIdenticalName._1 + similarItems._1.toString, similarItems._2))
          }
          else {
            shelves((itemsWithIdenticalName._1, similarItems._1)).+=(itemVec)
          }
      }
    }
  }

  def recordWaste(category: String, wastedAmount: Int): Unit = {
    updateWasteSummary(category, wastedAmount)
  }

  def rmDiscarded(items: Shelf): Unit = {
    while (!items.isEmpty && items.peek.state == isDiscarded) {
      items.popLeft
    }
  }

  def getRequestedItem(item: String, brand: Brand, fifo: Boolean = true): Item = {
    var requestedItem: Item = null
    val requestedShelf: Shelf = shelves.getOrElse((item, brand), new Shelf(null, "", null))
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

  def seeRequestedItem(item: String, brand: Brand, fifo: Boolean = true): Item = {
    var requestedItem: Item = null
    val requestedShelf: Shelf = shelves.getOrElse((item, brand), new Shelf(null, "", null))
    rmDiscarded(requestedShelf)
    if (!requestedShelf.isEmpty) {
      if (fifo) {
        requestedItem = requestedShelf.itemsList.head
      } else {
        requestedItem = requestedShelf.itemsList(requestedShelf.size - 1)
      }
    }
    requestedItem
  }

  def hasItem(itemName: String, brand: Brand): Boolean = {
    var requestedItem: Item = null
    val requestedShelf: Shelf = shelves.getOrElse((itemName, brand), new Shelf(null, "", null))
    rmDiscarded(requestedShelf)
    !requestedShelf.isEmpty
  }

  def getRandFood(): String = {
    utilities.randElementFromVector(articleNames)
  }
}