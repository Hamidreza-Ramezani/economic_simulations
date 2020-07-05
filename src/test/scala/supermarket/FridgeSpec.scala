import meta.example.supermarket.customers.{Customer1, Customer2, Customer3}
import meta.example.supermarket.{FIFO, Fridge, LIFO, Section, SectionTrait, Supermarket, SupermarketTrait}
import meta.example.supermarket.goods.{Broccoli, _}
import meta.example.supermarket.logistics.{Farmer, Manufacturer, Truck, TruckTrait}
import meta.example.supermarket.people.{Cashier, Employee, MealPlan_Dummy1, MealPlan_Dummy2, MealPlan_Dummy3}
import meta.example.supermarket.worldmap.{World, WorldTrait}
import org.scalatest._

import scala.collection.mutable.ListBuffer

//@Ignore
class FridgeSpec extends FlatSpec with Matchers {

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
        item.state.loadInShelves
      }
    }
  }


  val fridge: Fridge = new Fridge()


  "New fridge" should "have be empty" in {
    fridge.getAmount("Carrots") should be(0)
    fridge.isEmpty should be(true)
  }

  "Add an item to the fridge" should "update the amount and storage" in {
    fridge.add(item1_1)
    //    fridge.amountMap should be (Map(item1.name -> item1.priceUnit))
    fridge.getAmount(item1_1.name) should be(item1_1.priceUnit)
  }

  "Add multiple items" should "work" in {
    fridge.add(item2_1)
    fridge.getAmount(item2_1.name) should be(item2_1.priceUnit)
    fridge.add(item1_2)
    fridge.getAmount(item1_1.name) should be(2 * item1_1.priceUnit)
    //    println(fridge.storage)
  }

  "Query non-existing article" should "return 0" in {
    fridge.getAmount("Kitkat") should be(0)
  }

  "Consume an unexpired article" should "set the article state to consumed" in {
    val prior = fridge.storage
    fridge.consume(item2_1.name, item2_1.priceUnit)
    fridge.storage.get(item2_1.name).get should have size 0
    fridge.getAmount(item2_1.name) should be(0)
    item2_1.state.get should be("isConsumed")
    fridge.opened(item2_1.name) should be(0)
  }

  "Partially consume an item" should "change the amountMap and opened, but not storage" in {
    fridge.consume(item1_1.name, 50)
    fridge.storage.get(item1_1.name).get should have size 2
    fridge.opened(item1_1.name) should be(item1_1.priceUnit - 50)
    fridge.getAmount(item1_1.name) should be(2 * item1_1.priceUnit - 50)

    fridge.consume(item1_1.name, 50)
    fridge.storage.get(item1_1.name).get should have size 2
    fridge.opened(item1_1.name) should be(item1_1.priceUnit - 100)
    fridge.getAmount(item1_1.name) should be(2 * item1_1.priceUnit - 100)

    fridge.consume(item1_1.name, 100)
    fridge.storage.get(item1_1.name).get should have size 1
    fridge.opened(item1_1.name) should be(200)
    fridge.getAmount(item1_1.name) should be(item1_1.priceUnit)
    item1_1.state.get should be("isConsumed")
    item1_2.state.get should be("onDisplay") // initial state hasn't been updated
  }

  "Consume multiple items" should "work properly" in {
    fridge.add(item1_3)
    fridge.add(item1_4)
    fridge.getAmount(item1_1.name) should be(3 * item1_1.priceUnit)
    fridge.consume(item1_2.name, 500) should be(500)
    item1_2.state.get should be("isConsumed")
    item1_3.state.get should be("isConsumed")
    item1_4.state.get should be("onDisplay")
    fridge.opened.get(item1_1.name).get should be(100)
    fridge.getAmount(item1_1.name) should be(3 * item1_1.priceUnit - 500)
  }

  "Consume more items than there are" should "return the amount of items consumed" in {
    fridge.storage.get(item1_1.name)
    fridge.consume(item1_1.name, 200) should be(100)
  }

  "Get available food" should "return a vector of available food" in {
    fridge.getAvailFood should be(Vector())
    fridge.add(item1_5)
    fridge.add(item2_2)
    fridge.getAvailFood.toSet should be(Vector(item1_1.name, item2_1.name).toSet)
    fridge.consume(item1_1.name, 100)
    fridge.consume(item1_1.name, 100)
    fridge.getAvailFood.toSet should be(Vector(item2_1.name).toSet)
  }

  "Remove expired food" should "update the wastage summary" in {
    val aboutToExpireItem: Item = item3_1
    aboutToExpireItem.state.purchase
    aboutToExpireItem.state.get should be("isPurchased")
    fridge.add(aboutToExpireItem)
    fridge.consume(aboutToExpireItem.name, 50)
    fridge.getAmount(aboutToExpireItem.name) should be(aboutToExpireItem.priceUnit - 50)
    fridge.opened(aboutToExpireItem.name) should be(aboutToExpireItem.priceUnit - 50)

    aboutToExpireItem.cleanExpired()
    aboutToExpireItem.state.get should be("isExpired")

    fridge.rmExpired(aboutToExpireItem.name)
    fridge.getAmount(aboutToExpireItem.name) should be(0)
    fridge.opened(aboutToExpireItem.name) should be(0)
    aboutToExpireItem.state.get should be("isDiscarded")
  }

  "When an item expires" should "not be consumed" in {
    val expireFoo: Item = item3_2
    val expireBar: Item = item3_3
    Vector(expireBar, expireFoo).foreach(
      item => {
        fridge.add(item); item.state.purchase
      })
    expireFoo.cleanExpired()
    expireBar.cleanExpired()
    expireFoo.state.get should be("isExpired")
    expireBar.state.get should be("isExpired")
    fridge.storage(expireFoo.name) should have size (2)
    fridge.opened(expireFoo.name) should be(expireFoo.priceUnit)
    fridge.consume(expireFoo.name, 100) should be(0)
    fridge.storage(expireFoo.name) should have size (0)
    fridge.opened(expireFoo.name) should be(0)
    fridge.amountMap(expireBar.name) should be(0)
    expireFoo.state.get should be("isDiscarded")
    expireBar.state.get should be("isDiscarded")
  }

  "Add new items of the same name" should "not change the opened amount" in {
    val Broccoli1: Item = item4_1
    val Broccoli2: Item = item4_2
    fridge.add(Broccoli1)
    Broccoli1.state.purchase
    fridge.opened(Broccoli1.name) should be(Broccoli1.priceUnit)
    fridge.consume(Broccoli1.name, 50)
    fridge.opened(Broccoli1.name) should be(Broccoli1.priceUnit - 50)
    fridge.add(Broccoli2)
    Broccoli2.state.purchase
    fridge.opened(Broccoli1.name) should be(Broccoli1.priceUnit - 50)
    fridge.amountMap(Broccoli1.name) should be(2 * Broccoli1.priceUnit - 50)
  }
}
