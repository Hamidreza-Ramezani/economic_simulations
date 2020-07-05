package supermarket

import meta.example.supermarket.customers.{Customer1, Customer2, Customer3}
import meta.example.supermarket.goods._
import meta.example.supermarket.logistics.{Farmer, Manufacturer, Truck, TruckTrait}
import meta.example.supermarket.people.{Cashier, Employee, MealPlan_Dummy1, MealPlan_Dummy2, MealPlan_Dummy3}
import meta.example.supermarket.worldmap.{World, WorldTrait}
import meta.example.supermarket._
import org.scalatest._

import scala.collection.mutable.ListBuffer


class SupermarketSpec extends FlatSpec with Matchers {

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


//  var itemDeque1: Shelf = new Shelf(item1_1.name, Vector(item1_1, item1_2, item1_3, item1_4))
//  var itemDeque2: Shelf = new Shelf(item2_1.name, Vector(item2_1, item2_2, item2_3, item2_4))
//  var itemDeque3: Shelf = new Shelf(item3_1.name, Vector(item3_1, item3_2, item3_3, item3_4))
//  val warehouse: Map[String, Shelf] = Map(item1_1.name -> itemDeque1, item2_1 -> itemDeque2, item3_1 -> itemDeque3)


  var items: Vector[Item] = Vector(item1_1, item1_2, item1_3, item1_4, item2_1, item2_2, item2_3, item2_4, item3_1, item3_2, item3_3, item3_4)

  "New supermarket" should "have an empty warehouse" in {
    supermarket1.warehouse should have size 5
  }

  "initializeItemDeque" should "update the warehouse" in {
    supermarket1.initializeShelves(items)
    sectionVegetable1.shelves should have size 11
  }

  "The overloaded initializeItemDeque" should "update the warehouse" in {
    supermarket1.initializeShelf(item4_1)
    sectionVegetable1.shelves should have size 11
  }

//  "Selling an item" should "update the state of the item in the warehouse" in {
//    supermarket1.sell(item4_1.name)
//    sectionVegetable1.shelves should have size 3
//    item4_1.state.get should be("isPurchased")
//  }

}