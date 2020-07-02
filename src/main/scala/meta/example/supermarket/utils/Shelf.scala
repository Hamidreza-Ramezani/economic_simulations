package meta.example.supermarket

import meta.example.supermarket.goods.Item
import scala.collection.mutable.ListBuffer

class Shelf(var firstItem: Item, var shelfName: String, var itemsList: ListBuffer[Item]) {

  //  var itemsList: ListBuffer[Item] = new ListBuffer[Item]

  def this(firstItem: Item) {
    this(firstItem, firstItem.name, new ListBuffer[Item])
    itemsList += firstItem
  }

  def this(shelfName: String) {
    this(null, shelfName, new ListBuffer[Item])
  }

  def shuffle(policy: ShufflingPolicy): Unit = {
    if (policy == LIFO) {
      itemsList = itemsList.sortBy(_.age)
    }
  }

  override def toString: String = {
    var str: String = ""
    itemsList.foreach(item => str = str + item.toString + "\n")
    str
  }

  def size: Int = {
    itemsList.size
  }

  def +=(item: Item): Unit = {
    itemsList += item
  }

  def +=(itemList: Vector[Item]): Unit = {
    itemsList ++= itemList
  }

  def popLeft: Item = {
    if (size == 0) throw new NoSuchElementException
    itemsList.remove(0)
  }

  def popRight: Item = {
    if (size == 0) throw new NoSuchElementException
    itemsList.remove(size - 1)
  }

  def pickItem(index: Int): Item = {
    //    if (size == 0) throw new NoSuchElementException
    itemsList.remove(index)
  }

  def peek: Item = {
    itemsList.head
  }

  def isEmpty: Boolean = {
    itemsList.isEmpty
  }
}