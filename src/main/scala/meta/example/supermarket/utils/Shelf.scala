package meta.example.supermarket


import meta.example.supermarket.goods.Item
//import meta.example.supermarket.goods_updated.Item

import scala.collection.mutable.ArrayBuffer

final class Shelf(var item: Item, var itemList: Vector[Item]) {
  val itemDeque: ArrayBuffer[Item] = ArrayBuffer[Item]()

  def this(item: Item){
    this(item, itemList=null)
    itemDeque += item
  }

  override def toString: String = {
    var str: String = ""
    itemDeque.foreach(item => str += item.toString + "\n")
    str
  }

  def this(itemList: Vector[Item]){
    this(item=null, itemList)
    itemDeque ++= itemList
  }

  def this(){
    this(item=null, itemList=null)
  }

  def size: Int = {
    itemDeque.size
  }

  def +=(item: Item): Unit = {
    itemDeque += item
  }

  def +=(itemList: Vector[Item]): Unit = {
    itemDeque ++= itemList
  }

  def popLeft: Item = {
    if (size == 0) throw new NoSuchElementException
    itemDeque.remove(0)
  }

  def popRight: Item = {
    if (size == 0) throw new NoSuchElementException
    itemDeque.remove(size-1)
  }

  def peek: Item = {
    itemDeque(0)
  }

  def isEmpty: Boolean = {
    itemDeque.size == 0
  }
}