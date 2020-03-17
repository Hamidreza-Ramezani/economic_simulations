package supermarket

import meta.deep.runtime.Actor
import meta.example.supermarket.Supermarket
import meta.example.supermarket.goods.{Item, Item1, Item10, Item11, Item12, Item13, Item14, Item15, Item16, Item17, Item18, Item19, Item2, Item20, Item21, Item22, Item23, Item24, Item25, Item26, Item27, Item28, Item29, Item3, Item30, Item31, Item32, Item4, Item5, Item6, Item7, Item8, Item9}
import meta.example.supermarket.people.Employee
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ListBuffer

class EmployeeSpec extends FlatSpec with Matchers {
  var employee: Employee = new Employee
  val l_repeat = ListBuffer[Actor]()

  (1 to 1).foreach(_ => l_repeat.append(new Item1))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item2))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item3))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item4))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item5))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item6))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item7))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item8))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item9))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item10))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item11))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item12))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item13))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item14))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item15))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item16))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item17))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item18))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item19))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item20))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item21))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item22))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item23))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item24))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item25))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item26))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item27))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item28))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item29))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item30))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item31))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()

  (1 to 1).foreach(_ => l_repeat.append(new Item32))
  Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
  l_repeat.clear()



  "fillShelf" should "work" in{
    employee.shelfCapacity = 4
    assert(employee.shelfCapacity == 4)
    assert(employee.getFreeSpace("Pork") == 3)
  }

  "genNewItem" should "work" in{
    assert(employee.genNewItem("Item1").getClass.getName == "meta.example.supermarket.goods.Item1")
  }

  "addSupply" should "work" in{
    employee.shelfCapacity = 10
    assert(Supermarket.store.warehouse.size == 32)
    employee.addSupply
    assert(employee.getFreeSpace("Pork") == 0)
  }

}
