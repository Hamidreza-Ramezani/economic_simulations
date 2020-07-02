package supermarket

import meta.example.supermarket.customers.Customer1
import meta.example.supermarket.{FIFO, LIFO, Section, SectionTrait, Supermarket, SupermarketTrait, categoryAmount}
import meta.example.supermarket.goods.{Item, Item1, Item2, Item3, Item4, ItemState, newItemsMap}
import meta.example.supermarket.logistics.{Farmer, Manufacturer, Truck, TruckTrait}
import meta.example.supermarket.people.{Cashier, Employee}
import meta.example.supermarket.worldmap.{World, WorldTrait}
import org.scalatest._

import scala.collection.mutable
import scala.collection.mutable.ListBuffer




class ItemSpec extends FlatSpec with Matchers {
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




  "Age of new item" should "be 0" in {
    item1_1.age should be (0)
  }

  "State of new item" should "be onDisplay" in {
    item1_1.state.get should be ("onDisplay")
  }

  "Fields of Item1" should "match values defined" in {
    item1_1.id should be (14)
    item1_1.category should be ("Vegetable")
    item1_1.name should be ("Eggplant")
    item1_1.discount should be (0.0)
    item1_1.stock should be (3)
    item1_1.priceUnit should be (200)
    item1_1.price should be (2.0)
    item1_1.freshUntil should be (120) //depends on the system granularity
    item1_1.visibility should be (1.0)
  }

  "Transition functions defined in ItemState" should "update the state" in {
    item1_1.state.purchase
    item1_1.state.get should be ("isPurchased")
    item1_1.state.consume
    item1_1.state.get should be ("isConsumed")
    item1_1.state.discard
    item1_1.state.get should be ("isDiscarded")
  }

  "Item update state" should "update the state with new state" in {
    item1_2.id should be (15)
    item1_2.state.get should be ("onDisplay")
    item1_2.updateState("isPurchased", item1_2.state)
    item1_2.state.get should be ("isPurchased")
    item1_2.updateState("isDiscarded", item1_2.state)
    item1_2.state.get should be ("isDiscarded")
    item1_2.updateState("isConsumed", item1_2.state)
    item1_2.state.get should be ("isConsumed")
    a [IllegalArgumentException] should be thrownBy {
      item1_2.updateState("randomState", item1_2.state)
    }
  }

  "Item action" should "update the state with new state" in {
    item1_3.id should be (16)
    item1_3.state.get should be ("onDisplay")
    item1_3.purchase
    item1_3.state.get should be ("isPurchased")
    item1_3.discard
    item1_3.state.get should be ("isDiscarded")
    item1_3.consume
    item1_3.state.get should be ("isConsumed")
  }

  "store" should "have no isInvalids and waste summary is empty" in {
    supermarket1.isInvalids should have size 0
    supermarket1.wasteSummary should be (categoryAmount())
  }

  "Clean expired" should "set the state to discard" in {
    item1_4.id should be (17)
    item1_4.cleanExpired
    item1_4.state.get should be ("isDiscarded")
  }

  it should "record waste in supermarket wasteSummary" in {
    supermarket1.wasteSummary should be (categoryAmount(0,0,0,0,0))
  }

  "Supermarket isInvalids" should "record items been discarded through cleanExpired only" in {
    supermarket1.isInvalids should have size 1
    supermarket1.isInvalids should be (mutable.Queue(17))
  }

  "Invalid item state" should "throw IllegalArgumentException" in {
    val randState = ItemState(inFarm = false)
    a [IllegalArgumentException] should be thrownBy {
      randState.get
    }
  }

  "ItemMap" should "contain mappings" in {
//    newItemsMap.itemMap should have size > 0
    newItemsMap.itemMap.size should be > 0
  }
}
