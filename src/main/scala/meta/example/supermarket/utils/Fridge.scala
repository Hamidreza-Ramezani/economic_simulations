package meta.example.supermarket

import meta.example.supermarket.categories.{articleName, gram}
import meta.example.supermarket.goods.{Item, isExpired, global}
import meta.example.supermarket.utils.utilities

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class Fridge {
  val amountMap: mutable.Map[articleName, gram] = mutable.Map().withDefaultValue(0)
  val storage: mutable.Map[articleName, ListBuffer[Item]] = mutable.Map()
  val opened: mutable.Map[articleName, gram] = mutable.Map().withDefaultValue(0)

  global.itemNameToID_test.foreach {
    item =>
      val newLst = new ListBuffer[Item]()
      storage += (item._1 -> newLst)
  }

  /**
    * thid method is called to add an item to the fridge (usually it is called after shopping)
    *
    * @param item the item needs to be added to the fridge
    */
  def add(item: Item): Unit = {
    getAmount(item.name) match {
      case 0 =>
        val newLst = new ListBuffer[Item]()
        newLst += item
        storage += (item.name -> newLst)
      case _ => storage(item.name) += item
    }
    val newAmount: Int = amountMap(item.name) + item.priceUnit
    amountMap += (item.name -> newAmount)
    if (notOpened(item.name)) {
      opened += (item.name -> item.priceUnit)
    }
  }

  /**
    *
    * @param article like potato
    * @return the amount of the article in the fridge in terms of gram.
    */
  def getAmount(article: articleName): Int = {
    amountMap(article)
  }

  def noStock(article: articleName): Boolean = {
    amountMap(article) == 0
  }

  /**
    *
    * @param article
    * @return true if the item is not half consumed (not openned) and false otherwise
    */
  def notOpened(article: String): Boolean = {
    opened(article) == 0
  }

  /**
    * todo: this function might need to be refactored.
    *
    * @return
    */
  def getAvailFood: Vector[articleName] = {
    opened.filterKeys(opened(_) != 0).keys.toVector
  }

  /**
    * it removes expired items from the fridge
    *
    * @param article
    * @return Return the amount of unexpired food remains in the fridge
    */
  def rmExpired(article: String): Int = {
    var expiredItem: Item = null
    while (storage(article).nonEmpty && storage(article).head.state == isExpired) {
      expiredItem = storage(article).remove(0)
      amountMap += (article -> (amountMap(article) - opened(article)))
      expiredItem.cleanExpired(opened(article))
      opened += (article -> 0)
      if (storage(article).nonEmpty) {
        opened += (article -> expiredItem.priceUnit)
      }
    }
    amountMap(article)
  }

  /**
    * this method updates the amount of food in the fridge
    *
    * @param article
    * @param amount
    * @return the amount of food that is consumed
    */
  def consume(article: articleName, amount: gram): Int = {
    val currentAmount = rmExpired(article)
    if (currentAmount <= amount) {
      consumeAll(article)
      currentAmount
    } else {
      val targetUnit: Int = storage(article).head.priceUnit
      val actorCnt: Int = utilities.toInt(amount > opened(article)) * ((amount - opened(article)) / targetUnit)
      // Consume the opened ones first, if exist
      set2Consume(article, utilities.toInt(!notOpened(article) && (amount >= opened(article))))
      set2Consume(article, utilities.toInt(amount > opened(article)) * (amount - opened(article)) / targetUnit)
      opened += (article -> (opened(article) - amount + utilities.toInt(opened(article) <= amount) * targetUnit * (actorCnt + 1)))

      assert(opened(article) >= 0)
      amountMap += (article -> (amountMap(article) - amount))
      amount
    }
  }


  /**
    * consuming all amount of available of an article
    *
    * @param article
    */
  def consumeAll(article: articleName): Unit = {
    set2Consume(article, storage(article).size)
    amountMap += (article -> 0)
    opened += (article -> 0)
  }

  /**
    * remove count number of instances of given article
    *
    * @param article
    * @param count
    */
  private def set2Consume(article: articleName, count: Int): Unit = {
    (1 to count).foreach(
      _ => storage(article).remove(0).consume
    )
  }

  override def toString: String = {
    var str = ""
    if (amountMap.nonEmpty) {
      str += "\n"
      str += amountMap.map(pair => pair._1 + ": " + pair._2).mkString(" ")
    }
    str += "\nOpened amount map"
    if (opened.nonEmpty) {
      str += "\n"
      str += opened.map(pair => pair._1 + ": " + pair._2).mkString(" ")
    }
    str += "\nStorage size"
    if (storage.nonEmpty) {
      str += "\n"
      str += storage.map(pair => pair._1 + ": " + pair._2.size).mkString(" ")
    }
    str += "\n"
    str
  }
}

