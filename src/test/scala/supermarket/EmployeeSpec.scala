//package supermarket
//
//import java.io.{File, FileWriter, PrintWriter}
//
//import meta.example.supermarket.customers.{Customer1, Customer2, Customer3}
//import meta.example.supermarket.goods._
//import meta.example.supermarket.logistics.{Farmer, Manufacturer, Truck, TruckTrait, loadedTruck, unloadingTruck}
//import meta.example.supermarket.people.{Cashier, Employee, MealPlan_Dummy1, MealPlan_Dummy2, MealPlan_Dummy3}
//import meta.example.supermarket.worldmap.{World, WorldTrait}
//import meta.example.supermarket._
//import org.scalatest.{FlatSpec, Matchers}
//
//import scala.collection.mutable.ListBuffer
//
//class EmployeeSpec extends FlatSpec with Matchers {
//
//  val supermarketItems1: ListBuffer[Item] = ListBuffer[Item]()
//
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
//  val customer1 = new Customer1(supermarkets, worldMap,MealPlan_Dummy1)
//  val customer2 = new Customer2(supermarkets, worldMap,MealPlan_Dummy2)
//  val customer3 = new Customer3(supermarkets, worldMap,MealPlan_Dummy3)
//
//  supermarket1.employees += employee1
//  supermarket1.cashiers += cashier1
//
//
//  //  todo: reflection
//  //  for (i <- 1 to 32) {
//  //    val className: String = "meta.example.supermarket.goods.Item" + i.toString
//  //    val clazz = Class.forName(className)
//  //    val parameterType = new Array[Class[_]](3)
//  //    parameterType(0) = Class.forName("meta.example.supermarket.Supermarket")
//  //    parameterType(1) = Class.forName("meta.example.supermarket.SectionTrait")
//  //    parameterType(2) = Class.forName("meta.example.supermarket.worldmap.WorldTrait")
//  //    for (_ <- 1 to 4) {
//  //      val item: Item = clazz.getDeclaredConstructor(classOf[String]).newInstance(supermarket1, sectionVegetable1, worldMap).asInstanceOf[Item]
//  //      supermarketItems1 += item
//  //    }
//  //  }
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
////  supermarketItems1 += item1_1
//  supermarketItems1 += item1_2
//  supermarketItems1 += item1_3
//  supermarketItems1 += item1_4
//  supermarketItems1 += item1_5
//  supermarketItems1 += item1_6
//  supermarketItems1 += item1_7
////  supermarketItems1 += item2_1
//  supermarketItems1 += item2_2
//  supermarketItems1 += item2_3
//  supermarketItems1 += item2_4
//  supermarketItems1 += item2_5
//  supermarketItems1 += item2_6
//  supermarketItems1 += item2_7
////  supermarketItems1 += item3_1
//  supermarketItems1 += item3_2
//  supermarketItems1 += item3_3
//  supermarketItems1 += item3_4
//  supermarketItems1 += item3_5
//  supermarketItems1 += item3_6
//  supermarketItems1 += item3_7
////  supermarketItems1 += item4_1
//  supermarketItems1 += item4_2
//  supermarketItems1 += item4_3
//  supermarketItems1 += item4_4
//  supermarketItems1 += item4_5
//  supermarketItems1 += item4_6
//  supermarketItems1 += item4_7
//
////  supermarket1.initializeShelves(initialItems.toVector)
//  supermarket1.storage = supermarket1.storage ++ supermarketItems1
//
//  manufacturer.manufacturerState = loadedTruck
//  employee1.truck = truck1
//  truck1.truckState = unloadingTruck
//  employee1.writer = new PrintWriter(new FileWriter(new File("m/agentEmployee")))
//
//  "addSupply" should "work" in {
//    sectionVegetable1.setShelfCapacity(10)
//    supermarket1.shelfCapacity = 10
//    assert(manufacturer.getFreeSpace(supermarket1,"Eggplant") == 10)
//    assert(manufacturer.getFreeSpace(supermarket1,"Potato") == 10)
//    assert(manufacturer.getFreeSpace(supermarket1,"Onion") == 10)
//    assert(manufacturer.getFreeSpace(supermarket1,"Broccoli") == 10)
//
//    employee1.addSupply()
//
//    assert(manufacturer.getFreeSpace(supermarket1,"Eggplant") == 4)
//    assert(manufacturer.getFreeSpace(supermarket1,"Potato") == 4)
//    assert(manufacturer.getFreeSpace(supermarket1,"Onion") == 4)
//    assert(manufacturer.getFreeSpace(supermarket1,"Broccoli") == 4)
//  }
//
//
////  "shuffleShelves" should "work" in {
////    assert(manufacturer.getFreeSpace(supermarket1,"Eggplant") == 9)
////    employee1.shuffleShelves()
////
////  }
//
//  //  "fillShelf" should "work" in {
//  //    supermarket1.shelfCapacity = 4
//  //    assert(supermarket1.shelfCapacity == 4)
//  //    assert(employee1.getFreeSpace("Pork") == 3)
//  //  }
//  //
//  //  "genNewItem" should "work" in {
//  //    assert(employee1.genNewItem("Item1").getClass.getName == "meta.example.supermarket.goods.Item1")
//  //  }
//  //
//  //  "addSupply" should "work for dairy" in {
//  //    employee1.section = sectionDairy1
//  //    supermarket1.shelfCapacity = 10
//  //    assert(supermarket1.warehouse.size == 32)
//  //    employee1.addSupply
//  //    assert(employee1.getFreeSpace("Eggplant") == 9)
//  //    assert(employee1.getFreeSpace("Potato") == 9)
//  //    assert(employee1.getFreeSpace("Onion") == 9)
//  //    assert(employee1.getFreeSpace("Broccoli") == 9)
//  //    assert(employee1.getFreeSpace("Cucumber") == 9)
//  //    assert(employee1.getFreeSpace("Carrots") == 9)
//  //    assert(employee1.getFreeSpace("Celery") == 9)
//  //    assert(employee1.getFreeSpace("Tomato") == 9)
//  //    assert(employee1.getFreeSpace("Mushroom") == 9)
//  //    assert(employee1.getFreeSpace("Cabbage") == 9)
//  //    assert(employee1.getFreeSpace("Squash") == 9)
//  //    assert(employee1.getFreeSpace("Chicken") == 9)
//  //    assert(employee1.getFreeSpace("Beef") == 9)
//  //    assert(employee1.getFreeSpace("Pork") == 9)
//  //    assert(employee1.getFreeSpace("Lamb") == 9)
//  //    assert(employee1.getFreeSpace("Bacon") == 9)
//  //    assert(employee1.getFreeSpace("Kitkat") == 9)
//  //    assert(employee1.getFreeSpace("Ferraro") == 9)
//  //    assert(employee1.getFreeSpace("DarkChocolate") == 9)
//  //    assert(employee1.getFreeSpace("WhiteChocolate") == 9)
//  //    assert(employee1.getFreeSpace("Cereal") == 9)
//  //    assert(employee1.getFreeSpace("Oatmeal") == 9)
//  //    assert(employee1.getFreeSpace("Rice") == 9)
//  //    assert(employee1.getFreeSpace("Noodles") == 9)
//  //    assert(employee1.getFreeSpace("Spaghetti") == 9)
//  //    assert(employee1.getFreeSpace("Pasta") == 9)
//  //    assert(employee1.getFreeSpace("Bread") == 9)
//  //    assert(employee1.getFreeSpace("Milk") == 0)
//  //    assert(employee1.getFreeSpace("Yogurt") == 0)
//  //    assert(employee1.getFreeSpace("Cheese") == 0)
//  //    assert(employee1.getFreeSpace("Cream") == 0)
//  //    assert(employee1.getFreeSpace("Egg") == 0)
//  //  }
//  //
//  //  "addSupply" should "work for Grains" in {
//  //    employee1.section = sectionGrain1
//  //    supermarket1.shelfCapacity = 10
//  //    assert(supermarket1.warehouse.size == 32)
//  //    employee1.addSupply
//  //    assert(employee1.getFreeSpace("Eggplant") == 9)
//  //    assert(employee1.getFreeSpace("Potato") == 9)
//  //    assert(employee1.getFreeSpace("Onion") == 9)
//  //    assert(employee1.getFreeSpace("Broccoli") == 9)
//  //    assert(employee1.getFreeSpace("Cucumber") == 9)
//  //    assert(employee1.getFreeSpace("Carrots") == 9)
//  //    assert(employee1.getFreeSpace("Celery") == 9)
//  //    assert(employee1.getFreeSpace("Tomato") == 9)
//  //    assert(employee1.getFreeSpace("Mushroom") == 9)
//  //    assert(employee1.getFreeSpace("Cabbage") == 9)
//  //    assert(employee1.getFreeSpace("Squash") == 9)
//  //    assert(employee1.getFreeSpace("Chicken") == 9)
//  //    assert(employee1.getFreeSpace("Beef") == 9)
//  //    assert(employee1.getFreeSpace("Pork") == 9)
//  //    assert(employee1.getFreeSpace("Lamb") == 9)
//  //    assert(employee1.getFreeSpace("Bacon") == 9)
//  //    assert(employee1.getFreeSpace("Kitkat") == 9)
//  //    assert(employee1.getFreeSpace("Ferraro") == 9)
//  //    assert(employee1.getFreeSpace("DarkChocolate") == 9)
//  //    assert(employee1.getFreeSpace("WhiteChocolate") == 9)
//  //    assert(employee1.getFreeSpace("Cereal") == 0)
//  //    assert(employee1.getFreeSpace("Oatmeal") == 0)
//  //    assert(employee1.getFreeSpace("Rice") == 0)
//  //    assert(employee1.getFreeSpace("Noodles") == 0)
//  //    assert(employee1.getFreeSpace("Spaghetti") == 0)
//  //    assert(employee1.getFreeSpace("Pasta") == 0)
//  //    assert(employee1.getFreeSpace("Bread") == 0)
//  //    assert(employee1.getFreeSpace("Milk") == 0)
//  //    assert(employee1.getFreeSpace("Yogurt") == 0)
//  //    assert(employee1.getFreeSpace("Cheese") == 0)
//  //    assert(employee1.getFreeSpace("Cream") == 0)
//  //    assert(employee1.getFreeSpace("Egg") == 0)
//  //  }
//  //
//  //  "addSupply" should "work for Snacks" in {
//  //    employee1.section = sectionSnack1
//  //    supermarket1.shelfCapacity = 10
//  //    assert(supermarket1.warehouse.size == 32)
//  //    employee1.addSupply
//  //    assert(employee1.getFreeSpace("Eggplant") == 9)
//  //    assert(employee1.getFreeSpace("Potato") == 9)
//  //    assert(employee1.getFreeSpace("Onion") == 9)
//  //    assert(employee1.getFreeSpace("Broccoli") == 9)
//  //    assert(employee1.getFreeSpace("Cucumber") == 9)
//  //    assert(employee1.getFreeSpace("Carrots") == 9)
//  //    assert(employee1.getFreeSpace("Celery") == 9)
//  //    assert(employee1.getFreeSpace("Tomato") == 9)
//  //    assert(employee1.getFreeSpace("Mushroom") == 9)
//  //    assert(employee1.getFreeSpace("Cabbage") == 9)
//  //    assert(employee1.getFreeSpace("Squash") == 9)
//  //    assert(employee1.getFreeSpace("Chicken") == 9)
//  //    assert(employee1.getFreeSpace("Beef") == 9)
//  //    assert(employee1.getFreeSpace("Pork") == 9)
//  //    assert(employee1.getFreeSpace("Lamb") == 9)
//  //    assert(employee1.getFreeSpace("Bacon") == 9)
//  //    assert(employee1.getFreeSpace("Kitkat") == 0)
//  //    assert(employee1.getFreeSpace("Ferraro") == 0)
//  //    assert(employee1.getFreeSpace("DarkChocolate") == 0)
//  //    assert(employee1.getFreeSpace("WhiteChocolate") == 0)
//  //    assert(employee1.getFreeSpace("Cereal") == 0)
//  //    assert(employee1.getFreeSpace("Oatmeal") == 0)
//  //    assert(employee1.getFreeSpace("Rice") == 0)
//  //    assert(employee1.getFreeSpace("Noodles") == 0)
//  //    assert(employee1.getFreeSpace("Spaghetti") == 0)
//  //    assert(employee1.getFreeSpace("Pasta") == 0)
//  //    assert(employee1.getFreeSpace("Bread") == 0)
//  //    assert(employee1.getFreeSpace("Milk") == 0)
//  //    assert(employee1.getFreeSpace("Yogurt") == 0)
//  //    assert(employee1.getFreeSpace("Cheese") == 0)
//  //    assert(employee1.getFreeSpace("Cream") == 0)
//  //    assert(employee1.getFreeSpace("Egg") == 0)
//  //  }
//  //
//  //  "addSupply" should "work for Meat" in {
//  //    employee1.section = sectionMeat1
//  //    supermarket1.shelfCapacity = 10
//  //    assert(supermarket1.warehouse.size == 32)
//  //    employee1.addSupply
//  //    assert(employee1.getFreeSpace("Eggplant") == 9)
//  //    assert(employee1.getFreeSpace("Potato") == 9)
//  //    assert(employee1.getFreeSpace("Onion") == 9)
//  //    assert(employee1.getFreeSpace("Broccoli") == 9)
//  //    assert(employee1.getFreeSpace("Cucumber") == 9)
//  //    assert(employee1.getFreeSpace("Carrots") == 9)
//  //    assert(employee1.getFreeSpace("Celery") == 9)
//  //    assert(employee1.getFreeSpace("Tomato") == 9)
//  //    assert(employee1.getFreeSpace("Mushroom") == 9)
//  //    assert(employee1.getFreeSpace("Cabbage") == 9)
//  //    assert(employee1.getFreeSpace("Squash") == 9)
//  //    assert(employee1.getFreeSpace("Chicken") == 0)
//  //    assert(employee1.getFreeSpace("Beef") == 0)
//  //    assert(employee1.getFreeSpace("Pork") == 0)
//  //    assert(employee1.getFreeSpace("Lamb") == 0)
//  //    assert(employee1.getFreeSpace("Bacon") == 0)
//  //    assert(employee1.getFreeSpace("Kitkat") == 0)
//  //    assert(employee1.getFreeSpace("Ferraro") == 0)
//  //    assert(employee1.getFreeSpace("DarkChocolate") == 0)
//  //    assert(employee1.getFreeSpace("WhiteChocolate") == 0)
//  //    assert(employee1.getFreeSpace("Cereal") == 0)
//  //    assert(employee1.getFreeSpace("Oatmeal") == 0)
//  //    assert(employee1.getFreeSpace("Rice") == 0)
//  //    assert(employee1.getFreeSpace("Noodles") == 0)
//  //    assert(employee1.getFreeSpace("Spaghetti") == 0)
//  //    assert(employee1.getFreeSpace("Pasta") == 0)
//  //    assert(employee1.getFreeSpace("Bread") == 0)
//  //    assert(employee1.getFreeSpace("Milk") == 0)
//  //    assert(employee1.getFreeSpace("Yogurt") == 0)
//  //    assert(employee1.getFreeSpace("Cheese") == 0)
//  //    assert(employee1.getFreeSpace("Cream") == 0)
//  //    assert(employee1.getFreeSpace("Egg") == 0)
//  //  }
//  //
//  //  "addSupply" should "work for Vegetables" in {
//  //    employee1.section = sectionVegetable1
//  //    supermarket1.shelfCapacity = 10
//  //    assert(supermarket1.warehouse.size == 32)
//  //    employee1.addSupply
//  //    assert(employee1.getFreeSpace("Eggplant") == 0)
//  //    assert(employee1.getFreeSpace("Potato") == 0)
//  //    assert(employee1.getFreeSpace("Onion") == 0)
//  //    assert(employee1.getFreeSpace("Broccoli") == 0)
//  //    assert(employee1.getFreeSpace("Cucumber") == 0)
//  //    assert(employee1.getFreeSpace("Carrots") == 0)
//  //    assert(employee1.getFreeSpace("Celery") == 0)
//  //    assert(employee1.getFreeSpace("Tomato") == 0)
//  //    assert(employee1.getFreeSpace("Mushroom") == 0)
//  //    assert(employee1.getFreeSpace("Cabbage") == 0)
//  //    assert(employee1.getFreeSpace("Squash") == 0)
//  //    assert(employee1.getFreeSpace("Chicken") == 0)
//  //    assert(employee1.getFreeSpace("Beef") == 0)
//  //    assert(employee1.getFreeSpace("Pork") == 0)
//  //    assert(employee1.getFreeSpace("Lamb") == 0)
//  //    assert(employee1.getFreeSpace("Bacon") == 0)
//  //    assert(employee1.getFreeSpace("Kitkat") == 0)
//  //    assert(employee1.getFreeSpace("Ferraro") == 0)
//  //    assert(employee1.getFreeSpace("DarkChocolate") == 0)
//  //    assert(employee1.getFreeSpace("WhiteChocolate") == 0)
//  //    assert(employee1.getFreeSpace("Cereal") == 0)
//  //    assert(employee1.getFreeSpace("Oatmeal") == 0)
//  //    assert(employee1.getFreeSpace("Rice") == 0)
//  //    assert(employee1.getFreeSpace("Noodles") == 0)
//  //    assert(employee1.getFreeSpace("Spaghetti") == 0)
//  //    assert(employee1.getFreeSpace("Pasta") == 0)
//  //    assert(employee1.getFreeSpace("Bread") == 0)
//  //    assert(employee1.getFreeSpace("Milk") == 0)
//  //    assert(employee1.getFreeSpace("Yogurt") == 0)
//  //    assert(employee1.getFreeSpace("Cheese") == 0)
//  //    assert(employee1.getFreeSpace("Cream") == 0)
//  //    assert(employee1.getFreeSpace("Egg") == 0)
//  //  }
//
//}
