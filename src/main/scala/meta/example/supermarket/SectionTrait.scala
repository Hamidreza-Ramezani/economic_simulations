package meta.example.supermarket

import meta.deep.runtime.Actor
import meta.example.supermarket.goods.Item
import meta.example.supermarket.utils.randElement
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

trait SectionTrait extends Actor with SummaryTrait {

  var world: WorldTrait
  var sectionName: String
  val articleNames: Vector[String] = categories.getArticleNames(sectionName)
  val shelves: mutable.Map[String, Shelf] = mutable.Map[String, Shelf]()
  val isInvalids: mutable.Queue[Long] = new mutable.Queue()
  var shelfCapacity: Int = 5
  var sectionShufflingPolicy: ShufflingPolicy
  canMove = false

  articleNames.foreach {
    article =>
      shelves += (article -> new Shelf(article))
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
    if (shelves(item.name).isEmpty) {
      shelves += Tuple2(item.name, new Shelf(item))
    }
    else {
      shelves(item.name).+=(item)
    }
  }

  def initializeShelves(itemVec: Vector[Item]): Unit = {
    itemVec.groupBy(_.name).foreach(pair =>
      if (shelves(pair._1).isEmpty) {
        shelves += Tuple2(pair._1, new Shelf(null, pair._1, pair._2.to[ListBuffer]))
      }
      else {
        shelves(pair._1).+=(itemVec)
      }
    )
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
    val requestedShelf: Shelf = shelves.getOrElse(item, new Shelf(null, "", null))
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