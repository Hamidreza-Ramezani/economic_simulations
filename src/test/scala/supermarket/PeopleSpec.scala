package supermarket

import meta.example.supermarket.{FIFO, LIFO, Section, SectionTrait, Supermarket, SupermarketTrait}
import meta.example.supermarket.customers.Customer1
import meta.example.supermarket.goods._
import meta.example.supermarket.logistics.{Farmer, Manufacturer, Truck, TruckTrait}
import meta.example.supermarket.people.{Cashier, Employee}
import meta.example.supermarket.worldmap.{World, WorldTrait}
import org.scalatest._

import scala.collection.mutable.ListBuffer

class PeopleSpec extends FlatSpec with Matchers {
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


  val customer1 = new Customer1(supermarkets, worldMap)

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
  var item5_1 = new Item5(supermarket1, sectionVegetable1, worldMap)
  var item6_1 = new Item6(supermarket1, sectionVegetable1, worldMap)
  var item7_1 = new Item7(supermarket1, sectionVegetable1, worldMap)
  var item8_1 = new Item8(supermarket1, sectionVegetable1, worldMap)
  var item9_1 = new Item9(supermarket1, sectionVegetable1, worldMap)
  var item10_1 = new Item10(supermarket1, sectionVegetable1, worldMap)
  var item11_1 = new Item11(supermarket1, sectionVegetable1, worldMap)


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
  supermarketItems1 += item5_1
  supermarketItems1 += item6_1
  supermarketItems1 += item7_1
  supermarketItems1 += item8_1
  supermarketItems1 += item9_1
  supermarketItems1 += item10_1
  supermarketItems1 += item11_1

  supermarket1.initializeShelves(supermarketItems1.toVector)


  supermarket1.warehouse.toList.foreach { section =>
    section.shelves.toList.foreach { shelf =>
      shelf._2.itemsList.toList.foreach { item =>
        item.state.loadInShelves
      }
    }
  }
  // populate with Broccoli, Beef, Rice, and WhiteChocolate. Same as defined in shoppingList
  supermarket1.initializeShelves(Vector(item1_1, item2_1, item3_1, item4_1))

  "Buy listed items" should "populate the fridge" in {
//    println(customer1.mealPlan)
//    println(supermarket1.warehouse)
    customer1.addListedItemsToBasket(customer1.shoppingList.targetItems,supermarket1)
    println(customer1.fridge.storage)
  }
}