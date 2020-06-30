package meta.example.supermarket

import meta.example.supermarket.goods.Item
import scala.collection.mutable.ListBuffer

class Shelf(var item: Item, var itemsList: ListBuffer[Item]) {
  //  var itemsList: ListBuffer[Item] = ListBuffer[Item]()

//    def this(item: Item) {
//      this(item, itemsList = new ListBuffer[Item])
//      itemsList += item
//    }

  //  def this(itemsList: Vector[Item]) {
  //    this(item = null, itemsList.to[ListBuffer])
  //    this.itemsList ++= itemsList
  //  }

    def this() {
      this(item = null, itemsList = new ListBuffer[Item])
    }


  def shuffle(policy: ShufflingPolicy): Unit = {
    if (policy == LIFO) {
      itemsList = itemsList.sortBy(_.age)
    }
    //    policy match {
    //      case FIFO =>
    //      case LIFO => itemsList = itemsList.sortBy(_.age)
    //    }
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
    //    if (size == 0) throw new NoSuchElementException
    itemsList.remove(0)
  }

  def popRight: Item = {
    //    if (size == 0) throw new NoSuchElementException
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