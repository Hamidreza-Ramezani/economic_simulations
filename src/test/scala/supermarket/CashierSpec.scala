package supermarket

import java.io.{File, FileWriter, PrintWriter}

import meta.example.supermarket.customers.{Customer1, Customer2, Customer3}
import meta.example.supermarket.{FIFO, LIFO, Section, SectionTrait, Supermarket, SupermarketTrait}
import meta.example.supermarket.goods._
import meta.example.supermarket.logistics.{Farmer, Manufacturer, Truck, TruckTrait}
import meta.example.supermarket.people.{Cashier, Employee, MealPlan_Dummy1, MealPlan_Dummy2, MealPlan_Dummy3}
import meta.example.supermarket.worldmap.{World, WorldTrait}
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class CashierSpec extends FlatSpec with Matchers {
  //test scenario: check the scanItems
  //case1: the number of customers is less than the numOfBasketsHandledInOneStep
  //case2: the number of customers is twice as the numOfBasketsHandledInOneStep
  //case3: the number of customers is way more than the numOfBasketsHandledInOneStep

  val supermarketItems1: ListBuffer[Item] = ListBuffer[Item]()

  val mapWidth = 10
  val mapHeight = 8
  val worldMap: WorldTrait = new World(mapHeight, mapWidth)

  val sectionVegetable1 = new Section("Vegetable", FIFO, worldMap)
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


  val customer1 = new Customer1(supermarkets, worldMap, MealPlan_Dummy1)
  val customer2 = new Customer2(supermarkets, worldMap, MealPlan_Dummy2)
  val customer3 = new Customer3(supermarkets, worldMap, MealPlan_Dummy3)

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


  var basket1: ListBuffer[Item] = ListBuffer(item1_1, item2_1, item3_1, item4_1)
  var basket2: ListBuffer[Item] = ListBuffer(item1_2, item2_2, item3_2, item4_2)
  var basket3: ListBuffer[Item] = ListBuffer(item1_3, item2_3, item3_3, item4_3)
  var basket4: ListBuffer[Item] = ListBuffer(item1_4, item2_4, item3_4, item4_4)
  var basket5: ListBuffer[Item] = ListBuffer(item1_5, item2_5, item3_5, item4_5)
  var basket6: ListBuffer[Item] = ListBuffer(item1_6, item2_6, item3_6, item4_6)
  var basket7: ListBuffer[Item] = ListBuffer(item1_7, item2_7, item3_7, item4_7)


  var queue: mutable.Queue[ListBuffer[Item]] = mutable.Queue()
  var cashier: Cashier = new Cashier(supermarket1, worldMap)
  cashier.writer = new PrintWriter(new FileWriter(new File("m/agentCashier")))


  //please comment out the waitTurn inside cashier class
  "isFirstBasket" should "be false if the queue contains only one basket" in {
    assert(cashier.isFirstBasket)
    queue.enqueue(basket1)
    queue.enqueue(basket2)
    cashier.scanItems(queue)
    assert(!cashier.isFirstBasket)
    assert(queue.nonEmpty)
    cashier.scanItems(queue)
    assert(queue.isEmpty)
    assert(cashier.isFirstBasket)
  }

  "numOfBasketsHandledInOneStep" should "be updated" in {
    assert(cashier.numOfBasketsHandledInOneStep == 1)
    cashier.numOfBasketsHandledInOneStep = 2
    assert(cashier.numOfBasketsHandledInOneStep == 2)
  }

  "scanItems" should "work if the size of queue is less than numOfBasketsHandledInOneStep" in {
    cashier.numOfBasketsHandledInOneStep = 2
    assert(cashier.numOfBasketsHandledInOneStep == 2)
    queue.enqueue(basket3)
    cashier.scanItems(queue)
    assert(item1_3.state == isPurchased)
      assert (item2_3.state == isPurchased)
      assert (item3_3.state == isPurchased)
      assert (item4_3.state == isPurchased)
      assert (queue.isEmpty)
      }

      "scanItems" should "work if the size of queue is way more than the numOfBasketsHandledInOneStep" in {
      cashier.numOfBasketsHandledInOneStep = 1
      assert (cashier.numOfBasketsHandledInOneStep == 1)
      queue.enqueue (basket4)
      queue.enqueue (basket5)
      queue.enqueue (basket6)
      queue.enqueue (basket7)
      assert (item1_4.state == onDisplay)
      assert (item1_5.state == onDisplay)
      assert (item1_6.state == onDisplay)
      assert (item1_7.state == onDisplay)
      assert (item2_4.state == onDisplay)
      assert (item2_5.state == onDisplay)
      assert (item2_6.state == onDisplay)
      assert (item2_7.state == onDisplay)
      assert (item3_4.state == onDisplay)
      assert (item3_5.state == onDisplay)
      assert (item3_6.state == onDisplay)
      assert (item3_7.state == onDisplay)
      assert (item4_4.state == onDisplay)
      assert (item4_5.state == onDisplay)
      assert (item4_6.state == onDisplay)
      assert (item4_7.state == onDisplay)

      assert (cashier.isFirstBasket)
      cashier.scanItems (queue)
      assert (! cashier.isFirstBasket)
      cashier.scanItems (queue)
      assert (! cashier.isFirstBasket)
      cashier.scanItems (queue)
      assert (! cashier.isFirstBasket)
      cashier.scanItems (queue)
      assert (cashier.isFirstBasket)
      assert (queue.isEmpty)

      assert (item1_4.state == isPurchased)
      assert (item1_5.state == isPurchased)
      assert (item1_6.state == isPurchased)
      assert (item1_7.state == isPurchased)
      assert (item2_4.state == isPurchased)
      assert (item2_5.state == isPurchased)
      assert (item2_6.state == isPurchased)
      assert (item2_7.state == isPurchased)
      assert (item3_4.state == isPurchased)
      assert (item3_5.state == isPurchased)
      assert (item3_6.state == isPurchased)
      assert (item3_7.state == isPurchased)
      assert (item4_4.state == isPurchased)
      assert (item4_5.state == isPurchased)
      assert (item4_6.state == isPurchased)
      assert (item4_7.state == isPurchased)
      }
      }