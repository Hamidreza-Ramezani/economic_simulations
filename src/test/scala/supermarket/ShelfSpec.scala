package supermarket

import meta.example.supermarket.customers.{Customer1, Customer2, Customer3}
import meta.example.supermarket.{FIFO, LIFO, Section, SectionTrait, Shelf, Supermarket, SupermarketTrait}
import meta.example.supermarket.goods.{Item, Item1, Item2, Item3, Item4, onDisplay}
import meta.example.supermarket.logistics.{Farmer, Manufacturer, Truck, TruckTrait}
import meta.example.supermarket.people.{Cashier, Employee, MealPlan_Dummy1, MealPlan_Dummy2, MealPlan_Dummy3}
import meta.example.supermarket.worldmap.{World, WorldTrait}
import org.scalatest._

import scala.collection.mutable.ListBuffer

class ShelfSpec extends FlatSpec with Matchers {

  val supermarketItems1: ListBuffer[Item] = ListBuffer[Item]()

  val mapWidth = 10
  val mapHeight = 8
  val worldMap: WorldTrait = new World(mapHeight, mapWidth)

  val sectionVegetable1 = new Section("Vegetable", LIFO, worldMap)
  val sectionMeat1 = new Section("Meat", FIFO, worldMap)
  val sectionDairy1 = new Section("Dairy", FIFO, worldMap)
  val sectionSnack1 = new Section("Snack", FIFO, worldMap)
  val sectionGrain1 = new Section("Grain", LIFO, worldMap)

  var sectionList1 = new ListBuffer[SectionTrait]()
  sectionList1 += sectionVegetable1
  sectionList1 += sectionMeat1
  sectionList1 += sectionDairy1
  sectionList1 += sectionSnack1
  sectionList1 += sectionGrain1

  val supermarkets: ListBuffer[SupermarketTrait] = new ListBuffer[SupermarketTrait]
  var trucks = new ListBuffer[TruckTrait]

  val supermarket1 = new Supermarket(sectionList1, worldMap)
  val truck1 = new Truck(worldMap)

  supermarkets += supermarket1
  trucks += truck1

  val manufacturer = new Manufacturer(trucks, supermarkets, worldMap)
  val farmer = new Farmer(manufacturer, worldMap)

  val employee1 = new Employee(supermarket1, sectionVegetable1, manufacturer, worldMap)
  val cashier1 = new Cashier(supermarket1, worldMap)


  val customer1 = new Customer1(supermarkets, worldMap,MealPlan_Dummy1)
  val customer2 = new Customer2(supermarkets, worldMap,MealPlan_Dummy2)
  val customer3 = new Customer3(supermarkets, worldMap,MealPlan_Dummy3)

  supermarket1.employees += employee1
  supermarket1.cashiers += cashier1


  var item1_1 = new Item1(supermarket1, sectionVegetable1, worldMap)
  var item1_2 = new Item1(supermarket1, sectionVegetable1, worldMap)
  var item1_3 = new Item1(supermarket1, sectionVegetable1, worldMap)
  var item1_4 = new Item1(supermarket1, sectionVegetable1, worldMap)
  var item1_5 = new Item1(supermarket1, sectionVegetable1, worldMap)
  var item1_6 = new Item1(supermarket1, sectionVegetable1, worldMap)
  var item1_7 = new Item1(supermarket1, sectionVegetable1, worldMap)
  var item2_1 = new Item2(supermarket1, sectionVegetable1, worldMap)
  var item2_2 = new Item2(supermarket1, sectionVegetable1, worldMap)
  var item2_3 = new Item2(supermarket1, sectionVegetable1, worldMap)
  var item2_4 = new Item2(supermarket1, sectionVegetable1, worldMap)
  var item2_5 = new Item2(supermarket1, sectionVegetable1, worldMap)
  var item2_6 = new Item2(supermarket1, sectionVegetable1, worldMap)
  var item2_7 = new Item2(supermarket1, sectionVegetable1, worldMap)
  var item3_1 = new Item3(supermarket1, sectionVegetable1, worldMap)
  var item3_2 = new Item3(supermarket1, sectionVegetable1, worldMap)
  var item3_3 = new Item3(supermarket1, sectionVegetable1, worldMap)
  var item3_4 = new Item3(supermarket1, sectionVegetable1, worldMap)
  var item3_5 = new Item3(supermarket1, sectionVegetable1, worldMap)
  var item3_6 = new Item3(supermarket1, sectionVegetable1, worldMap)
  var item3_7 = new Item3(supermarket1, sectionVegetable1, worldMap)
  var item4_1 = new Item4(supermarket1, sectionVegetable1, worldMap)
  var item4_2 = new Item4(supermarket1, sectionVegetable1, worldMap)
  var item4_3 = new Item4(supermarket1, sectionVegetable1, worldMap)
  var item4_4 = new Item4(supermarket1, sectionVegetable1, worldMap)
  var item4_5 = new Item4(supermarket1, sectionVegetable1, worldMap)
  var item4_6 = new Item4(supermarket1, sectionVegetable1, worldMap)
  var item4_7 = new Item4(supermarket1, sectionVegetable1, worldMap)


  supermarketItems1 += item1_1
  supermarketItems1 += item1_2
  supermarketItems1 += item1_3
  supermarketItems1 += item1_4
  supermarketItems1 += item1_5
  supermarketItems1 += item1_6
  supermarketItems1 += item1_7
  supermarketItems1 += item2_1
  supermarketItems1 += item2_2
  supermarketItems1 += item2_3
  supermarketItems1 += item2_4
  supermarketItems1 += item2_5
  supermarketItems1 += item2_6
  supermarketItems1 += item2_7
  supermarketItems1 += item3_1
  supermarketItems1 += item3_2
  supermarketItems1 += item3_3
  supermarketItems1 += item3_4
  supermarketItems1 += item3_5
  supermarketItems1 += item3_6
  supermarketItems1 += item3_7
  supermarketItems1 += item4_1
  supermarketItems1 += item4_2
  supermarketItems1 += item4_3
  supermarketItems1 += item4_4
  supermarketItems1 += item4_5
  supermarketItems1 += item4_6
  supermarketItems1 += item4_7

  supermarket1.initializeShelves(supermarketItems1.toVector)


  supermarket1.warehouse.toList.foreach { section =>
    section.shelves.toList.foreach { shelf =>
      shelf._2.itemsList.toList.foreach { item =>
        item.state = onDisplay
      }
    }
  }


  "shelf" should "be able to construct from a string" in {
    val newDeque = new Shelf("Potato")
    newDeque should have size 0
  }

  //  "Item deque" should "be able to construct from a list of Item" in {
  //    val newDeque = new Shelf(Vector(item1_1, item2_1, item3_1))
  //    newDeque should have size 3
  //  }

  "Shelf" should "be able to construct from a single Item" in {
    val newDeque = new Shelf(item1_2)
    newDeque should have size 1
  }

  "Item deque +=" should "add an Item to the shelf" in {
    val emptyDeque = new Shelf("Onion")
    emptyDeque += item1_3
    emptyDeque should have size 1
  }

  "Item deque +=" should "add a list of Items to the shelf" in {
    val emptyShelf = new Shelf(item1_4.name)
    emptyShelf += Vector(item1_4, item1_6, item1_7)
    emptyShelf should have size 3
    emptyShelf += Vector(item1_5, item1_2)
    emptyShelf should have size 5
  }

  //  "Item deque popLeft" should "remove the first inserted Item" in {
  //    val newDeque = new Shelf(Vector(item1_6, item2_4, item3_3))
  //    newDeque.popLeft should be (item1_6)
  //    newDeque should have size 2
  //  }

  //  "Item deque popRight" should "remove the last inserted Item" in {
  //    val newDeque = new Shelf(Vector(item1_7, item2_5, item3_4))
  //    newDeque.popRight should be (item3_4)
  //    newDeque should have size 2
  //    newDeque += Vector(item1_7, item2_5)
  //    newDeque should have size 4
  //    newDeque.popRight should be (item2_5)
  //  }

  "Remove from an empty item deque" should "throw NoSuchElementException" in {
    val emptyShelf = new Shelf("Potato")
    a[NoSuchElementException] should be thrownBy {
      emptyShelf.popLeft
    }
    a[NoSuchElementException] should be thrownBy {
      emptyShelf.popRight
    }
  }
}
