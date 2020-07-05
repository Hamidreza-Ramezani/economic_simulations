//package supermarket.logistics
//
//import java.io.{File, FileWriter, PrintWriter}
//
//import meta.example.supermarket.{FIFO, LIFO, Section, SectionTrait, Supermarket, SupermarketTrait}
//import meta.example.supermarket.customers.Customer1
//import meta.example.supermarket.goods.{Item, Item1, Item2, Item3, Item4}
//import meta.example.supermarket.logistics.{Farmer, Manufacturer, Truck, TruckTrait, loadedTruck, relaxed, unloadingTruck}
//import meta.example.supermarket.people.{Cashier, Employee}
//import meta.example.supermarket.worldmap.{World, WorldTrait}
//import org.scalatest.{FlatSpec, Matchers}
//
//import scala.collection.mutable.ListBuffer
//
//class TruckSpec extends FlatSpec with Matchers{
//
//  val items: ListBuffer[Item] = ListBuffer[Item]()
//  val mapWidth = 10
//  val mapHeight = 8
//  val worldMap: WorldTrait = new World(mapHeight, mapWidth)
//
//  val sectionVegetable1 = new Section("Vegetable", LIFO, worldMap)
//  val sectionMeat1 = new Section("Meat", FIFO, worldMap)
//  val sectionDairy1 = new Section("Dairy", FIFO, worldMap)
//  val sectionSnack1 = new Section("Snack", FIFO, worldMap)
//  val sectionGrain1 = new Section("Grain", LIFO, worldMap)
//
//  var sectionList1 = new ListBuffer[SectionTrait]()
//  sectionList1 += sectionVegetable1
//  sectionList1 += sectionMeat1
//  sectionList1 += sectionDairy1
//  sectionList1 += sectionSnack1
//  sectionList1 += sectionGrain1
//
//  val supermarkets: ListBuffer[SupermarketTrait] = new ListBuffer[SupermarketTrait]
//  var trucks = new ListBuffer[TruckTrait]
//
//  val supermarket1 = new Supermarket(sectionList1, worldMap)
//  val truck1 = new Truck(worldMap)
//
//  supermarkets += supermarket1
//  trucks += truck1
//
//  val manufacturer = new Manufacturer(trucks, supermarkets, worldMap)
//  val farmer = new Farmer(manufacturer, worldMap)
//
//  val employee1 = new Employee(supermarket1, sectionVegetable1, manufacturer, worldMap)
//  val cashier1 = new Cashier(supermarket1, worldMap)
//
//
//  val customer1 = new Customer1(supermarkets, worldMap)
//
//  supermarket1.employees += employee1
//  supermarket1.cashiers += cashier1
//
//
//  var item1_1 = new Item1(supermarket1, sectionVegetable1, worldMap)
//  var item1_2 = new Item1(supermarket1, sectionVegetable1, worldMap)
//  var item1_3 = new Item1(supermarket1, sectionVegetable1, worldMap)
//  var item1_4 = new Item1(supermarket1, sectionVegetable1, worldMap)
//  var item1_5 = new Item1(supermarket1, sectionVegetable1, worldMap)
//  var item1_6 = new Item1(supermarket1, sectionVegetable1, worldMap)
//  var item1_7 = new Item1(supermarket1, sectionVegetable1, worldMap)
//  var item2_1 = new Item2(supermarket1, sectionVegetable1, worldMap)
//  var item2_2 = new Item2(supermarket1, sectionVegetable1, worldMap)
//  var item2_3 = new Item2(supermarket1, sectionVegetable1, worldMap)
//  var item2_4 = new Item2(supermarket1, sectionVegetable1, worldMap)
//  var item2_5 = new Item2(supermarket1, sectionVegetable1, worldMap)
//  var item2_6 = new Item2(supermarket1, sectionVegetable1, worldMap)
//  var item2_7 = new Item2(supermarket1, sectionVegetable1, worldMap)
//  var item3_1 = new Item3(supermarket1, sectionVegetable1, worldMap)
//  var item3_2 = new Item3(supermarket1, sectionVegetable1, worldMap)
//  var item3_3 = new Item3(supermarket1, sectionVegetable1, worldMap)
//  var item3_4 = new Item3(supermarket1, sectionVegetable1, worldMap)
//  var item3_5 = new Item3(supermarket1, sectionVegetable1, worldMap)
//  var item3_6 = new Item3(supermarket1, sectionVegetable1, worldMap)
//  var item3_7 = new Item3(supermarket1, sectionVegetable1, worldMap)
//  var item4_1 = new Item4(supermarket1, sectionVegetable1, worldMap)
//  var item4_2 = new Item4(supermarket1, sectionVegetable1, worldMap)
//  var item4_3 = new Item4(supermarket1, sectionVegetable1, worldMap)
//  var item4_4 = new Item4(supermarket1, sectionVegetable1, worldMap)
//  var item4_5 = new Item4(supermarket1, sectionVegetable1, worldMap)
//  var item4_6 = new Item4(supermarket1, sectionVegetable1, worldMap)
//  var item4_7 = new Item4(supermarket1, sectionVegetable1, worldMap)
//
//
//  var initialItems = new ListBuffer[Item]
//  initialItems += item1_1
//  initialItems += item2_1
//  initialItems += item3_1
//  initialItems += item4_1
//
//  //  supermarketItems1 += item1_1
//  items += item1_2
//  items += item1_3
//  items += item1_4
//  items += item1_5
//  items += item1_6
//  items += item1_7
//  //  supermarketItems1 += item2_1
//  items += item2_2
//  items += item2_3
//  items += item2_4
//  items += item2_5
//  items += item2_6
//  items += item2_7
//  //  supermarketItems1 += item3_1
//  items += item3_2
//  items += item3_3
//  items += item3_4
//  items += item3_5
//  items += item3_6
//  items += item3_7
//  //  supermarketItems1 += item4_1
//  items += item4_2
//  items += item4_3
//  items += item4_4
//  items += item4_5
//  items += item4_6
//  items += item4_7
//
//  supermarket1.initializeShelves(initialItems.toVector)
////  supermarket1.storage = supermarket1.storage ++ supermarketItems1
//
//  items.foreach {
//    item =>
//      truck1.storage(item.name).enqueue(item)
//  }
//
//  manufacturer.manufacturerState = loadedTruck
//  //  employee1.truck = truck1
//  truck1.truckState = unloadingTruck
//  truck1.supermarket = supermarket1
//  truck1.writer = new PrintWriter(new FileWriter(new File("m/agentTruck")))
//
//  "unloadTruck" should "work" in {
////    sectionVegetable1.setShelfCapacity(10)
////    supermarket1.shelfCapacity = 10
////    truck1.truckState = relaxed
//
//    truck1.unloadTruck()
//
//    items.foreach{
//      item =>
//        assert(supermarket1.storage.contains(item))
//        assert(item.state.get == "inStorage")
//    }
//  }
//}