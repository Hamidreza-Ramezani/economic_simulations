package meta.example.supermarket

import meta.example.supermarket.goods.Item
import scala.collection.mutable.ListBuffer

class Shelf(var firstItem: Item, var shelfName: String, var itemsList: ListBuffer[Item]) {

  /**
    * overloaded constructor
    *
    * @param firstItem the first item that is added to an empty shelf
    */
  def this(firstItem: Item) {
    this(firstItem, firstItem.name, new ListBuffer[Item])
    itemsList += firstItem
  }

  /**
    * the overloaded constructor
    *
    * @param shelfName the shelf name (usually the concatenation of article name and the brand like milkTerrasuisse)
    */
  def this(shelfName: String) {
    this(null, shelfName, new ListBuffer[Item])
  }

  /**
    * changing the order of the items in the shelf
    *
    * @param policy the policy of shuffling.
    */
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