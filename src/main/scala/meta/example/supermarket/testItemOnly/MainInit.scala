package meta.example.supermarket.testItemOnly

import meta.deep.runtime.Actor
import meta.example.supermarket.customers._
import meta.example.supermarket.goods._
import meta.example.supermarket.logistics.{Farmer, Manufacturer, Truck, TruckTrait}
import meta.example.supermarket.people._
import meta.example.supermarket.worldmap.{World, WorldTrait}
import meta.example.supermarket._
import squid.quasi.lift
import scala.collection.mutable.ListBuffer

/* Auto generated from genExample*/

@lift
class MainInit {
  //this class specifies the actors of the simulation
  def main(): List[Actor] = {
    var actors = ListBuffer[Actor]()
    val actors_repeat = ListBuffer[Actor]()
    val supermarketItems1 = ListBuffer[Item]()
    val supermarketItems2 = ListBuffer[Item]()
    val supermarketItems3 = ListBuffer[Item]()

    val mapWidth = 10
    val mapHeight = 8
    val worldMap: WorldTrait = new World(mapHeight, mapWidth)

    val sectionVegetable1 = new Section("Vegetable", FIFO, worldMap)
    val sectionMeat1 = new Section("Meat", FIFO, worldMap)
    val sectionDairy1 = new Section("Dairy", FIFO, worldMap)
    val sectionSnack1 = new Section("Snack", FIFO, worldMap)
    val sectionGrain1 = new Section("Grain", LIFO, worldMap)

    //    val sectionVegetable2 = new Section("Vegetable", FIFO, worldMap)
    //    val sectionMeat2 = new Section("Meat", FIFO, worldMap)
    //    val sectionDairy2 = new Section("Dairy", FIFO, worldMap)
    //    val sectionSnack2 = new Section("Snack", FIFO, worldMap)
    //    val sectionGrain2 = new Section("Grain", LIFO, worldMap)
    //
    //    val sectionVegetable3 = new Section("Vegetable", FIFO, worldMap)
    //    val sectionMeat3 = new Section("Meat", FIFO, worldMap)
    //    val sectionDairy3 = new Section("Dairy", FIFO, worldMap)
    //    val sectionSnack3 = new Section("Snack", FIFO, worldMap)
    //    val sectionGrain3 = new Section("Grain", LIFO, worldMap)


    var sectionList1 = new ListBuffer[SectionTrait]()
    sectionList1 += sectionVegetable1
    sectionList1 += sectionMeat1
    sectionList1 += sectionDairy1
    sectionList1 += sectionSnack1
    sectionList1 += sectionGrain1

    //    var sectionList2 = new ListBuffer[SectionTrait]()
    //    sectionList2 += sectionVegetable2
    //    sectionList2 += sectionMeat2
    //    sectionList2 += sectionDairy2
    //    sectionList2 += sectionSnack2
    //    sectionList2 += sectionGrain2
    //
    //    var sectionList3 = new ListBuffer[SectionTrait]()
    //    sectionList3 += sectionVegetable3
    //    sectionList3 += sectionMeat3
    //    sectionList3 += sectionDairy3
    //    sectionList3 += sectionSnack3
    //    sectionList3 += sectionGrain3

    val supermarkets: ListBuffer[SupermarketTrait] = new ListBuffer[SupermarketTrait]
    var trucks = new ListBuffer[TruckTrait]

    val supermarket1 = new Supermarket(sectionList1, worldMap)
    //    val supermarket2 = new Supermarket(sectionList2, worldMap)
    //    val supermarket3 = new Supermarket(sectionList3, worldMap)

    supermarkets += supermarket1
    //    supermarkets += supermarket2
    //    supermarkets += supermarket3

    val truck1 = new Truck(worldMap)
    //    val truck2 = new Truck(worldMap)
    //    val truck3 = new Truck(worldMap)
    trucks += truck1
    //    trucks += truck2
    //    trucks += truck3

    val manufacturer = new Manufacturer(trucks, supermarkets, worldMap)
    val farmer = new Farmer(manufacturer, worldMap)

    val employee1 = new Employee(supermarket1, sectionVegetable1, manufacturer, worldMap)
    val cashier1 = new Cashier(supermarket1, worldMap)

    //    val employee2 = new Employee(supermarket2, sectionVegetable2, manufacturer, worldMap)
    //    val cashier2 = new Cashier(supermarket2, worldMap)
    //
    //    val employee3 = new Employee(supermarket3, sectionVegetable3, manufacturer, worldMap)
    //    val cashier3 = new Cashier(supermarket3, worldMap)


    val customer1 = new Customer1(supermarkets, worldMap, MealPlan_Dummy1)
    val customer2 = new Customer2(supermarkets, worldMap, MealPlan_Dummy2)
    val customer3 = new Customer3(supermarkets, worldMap, MealPlan_Dummy3)


    val item1_1_TerraSuisse = new Item1(supermarket1, sectionVegetable1, worldMap, TerraSuisse, newItemsMap.priceMap(("Item1", TerraSuisse)))
    val item2_1_TerraSuisse = new Item2(supermarket1, sectionVegetable1, worldMap, TerraSuisse, newItemsMap.priceMap(("Item2", TerraSuisse)))
    val item3_1_TerraSuisse = new Item3(supermarket1, sectionVegetable1, worldMap, TerraSuisse, newItemsMap.priceMap(("Item3", TerraSuisse)))
    val item4_1_TerraSuisse = new Item4(supermarket1, sectionVegetable1, worldMap, TerraSuisse, newItemsMap.priceMap(("Item4", TerraSuisse)))
    val item5_1_TerraSuisse = new Item5(supermarket1, sectionVegetable1, worldMap, TerraSuisse, newItemsMap.priceMap(("Item5", TerraSuisse)))
    val item6_1_TerraSuisse = new Item6(supermarket1, sectionVegetable1, worldMap, TerraSuisse, newItemsMap.priceMap(("Item6", TerraSuisse)))
    val item7_1_TerraSuisse = new Item7(supermarket1, sectionVegetable1, worldMap, TerraSuisse, newItemsMap.priceMap(("Item7", TerraSuisse)))
    val item8_1_TerraSuisse = new Item8(supermarket1, sectionVegetable1, worldMap, TerraSuisse, newItemsMap.priceMap(("Item8", TerraSuisse)))
    val item9_1_TerraSuisse = new Item9(supermarket1, sectionVegetable1, worldMap, TerraSuisse, newItemsMap.priceMap(("Item9", TerraSuisse)))
    val item10_1_TerraSuisse = new Item10(supermarket1, sectionVegetable1, worldMap, TerraSuisse, newItemsMap.priceMap(("Item10", TerraSuisse)))
    val item11_1_TerraSuisse = new Item11(supermarket1, sectionVegetable1, worldMap, TerraSuisse, newItemsMap.priceMap(("Item11", TerraSuisse)))

    //    val item1_1_Optigal = new Item1(supermarket1, sectionVegetable1, worldMap, Optigal, newItemsMap.priceMap(("Item1", Optigal)))
    //    val item2_1_Optigal = new Item2(supermarket1, sectionVegetable1, worldMap, Optigal, newItemsMap.priceMap(("Item2", Optigal)))
    //    val item3_1_Optigal = new Item3(supermarket1, sectionVegetable1, worldMap, Optigal, newItemsMap.priceMap(("Item3", Optigal)))
    //    val item4_1_Optigal = new Item4(supermarket1, sectionVegetable1, worldMap, Optigal, newItemsMap.priceMap(("Item4", Optigal)))
    //    val item5_1_Optigal = new Item5(supermarket1, sectionVegetable1, worldMap, Optigal, newItemsMap.priceMap(("Item5", Optigal)))
    //    val item6_1_Optigal = new Item6(supermarket1, sectionVegetable1, worldMap, Optigal, newItemsMap.priceMap(("Item6", Optigal)))
    //    val item7_1_Optigal = new Item7(supermarket1, sectionVegetable1, worldMap, Optigal, newItemsMap.priceMap(("Item7", Optigal)))
    //    val item8_1_Optigal = new Item8(supermarket1, sectionVegetable1, worldMap, Optigal, newItemsMap.priceMap(("Item8", Optigal)))
    //    val item9_1_Optigal = new Item9(supermarket1, sectionVegetable1, worldMap, Optigal, newItemsMap.priceMap(("Item9", Optigal)))
    //    val item10_1_Optigal = new Item10(supermarket1, sectionVegetable1, worldMap, Optigal, newItemsMap.priceMap(("Item10", Optigal)))
    //    val item11_1_Optigal = new Item11(supermarket1, sectionVegetable1, worldMap, Optigal, newItemsMap.priceMap(("Item11", Optigal)))

    //    val item1_1_Aha = new Item1(supermarket1, sectionVegetable1, worldMap, Aha, newItemsMap.priceMap(("Item1", Aha)))
    //    val item2_1_Aha = new Item2(supermarket1, sectionVegetable1, worldMap, Aha, newItemsMap.priceMap(("Item2", Aha)))
    //    val item3_1_Aha = new Item3(supermarket1, sectionVegetable1, worldMap, Aha, newItemsMap.priceMap(("Item3", Aha)))
    //    val item4_1_Aha = new Item4(supermarket1, sectionVegetable1, worldMap, Aha, newItemsMap.priceMap(("Item4", Aha)))
    //    val item5_1_Aha = new Item5(supermarket1, sectionVegetable1, worldMap, Aha, newItemsMap.priceMap(("Item5", Aha)))
    //    val item6_1_Aha = new Item6(supermarket1, sectionVegetable1, worldMap, Aha, newItemsMap.priceMap(("Item6", Aha)))
    //    val item7_1_Aha = new Item7(supermarket1, sectionVegetable1, worldMap, Aha, newItemsMap.priceMap(("Item7", Aha)))
    //    val item8_1_Aha = new Item8(supermarket1, sectionVegetable1, worldMap, Aha, newItemsMap.priceMap(("Item8", Aha)))
    //    val item9_1_Aha = new Item9(supermarket1, sectionVegetable1, worldMap, Aha, newItemsMap.priceMap(("Item9", Aha)))
    //    val item10_1_Aha = new Item10(supermarket1, sectionVegetable1, worldMap, Aha, newItemsMap.priceMap(("Item10", Aha)))
    //    val item11_1_Aha = new Item11(supermarket1, sectionVegetable1, worldMap, Aha, newItemsMap.priceMap(("Item11", Aha)))


    //    val item1_2 = new Item1(supermarket2, sectionVegetable2, worldMap)
    //    val item2_2 = new Item2(supermarket2, sectionVegetable2, worldMap)
    //    val item3_2 = new Item3(supermarket2, sectionVegetable2, worldMap)
    //    val item4_2 = new Item4(supermarket2, sectionVegetable2, worldMap)
    //    val item5_2 = new Item5(supermarket2, sectionVegetable2, worldMap)
    //    val item6_2 = new Item6(supermarket2, sectionVegetable2, worldMap)
    //    val item7_2 = new Item7(supermarket2, sectionVegetable2, worldMap)
    //    val item8_2 = new Item8(supermarket2, sectionVegetable2, worldMap)
    //    val item9_2 = new Item9(supermarket2, sectionVegetable2, worldMap)
    //    val item10_2 = new Item10(supermarket2, sectionVegetable2, worldMap)
    //    val item11_2 = new Item11(supermarket2, sectionVegetable2, worldMap)
    //
    //    val item1_3 = new Item1(supermarket3, sectionVegetable3, worldMap)
    //    val item2_3 = new Item2(supermarket3, sectionVegetable3, worldMap)
    //    val item3_3 = new Item3(supermarket3, sectionVegetable3, worldMap)
    //    val item4_3 = new Item4(supermarket3, sectionVegetable3, worldMap)
    //    val item5_3 = new Item5(supermarket3, sectionVegetable3, worldMap)
    //    val item6_3 = new Item6(supermarket3, sectionVegetable3, worldMap)
    //    val item7_3 = new Item7(supermarket3, sectionVegetable3, worldMap)
    //    val item8_3 = new Item8(supermarket3, sectionVegetable3, worldMap)
    //    val item9_3 = new Item9(supermarket3, sectionVegetable3, worldMap)
    //    val item10_3 = new Item10(supermarket3, sectionVegetable3, worldMap)
    //    val item11_3 = new Item11(supermarket3, sectionVegetable3, worldMap)

    supermarket1.employees += employee1
    //    supermarket2.employees += employee2
    //    supermarket3.employees += employee3

    supermarket1.cashiers += cashier1
    //    supermarket2.cashiers += cashier2
    //    supermarket3.cashiers += cashier3


    actors += farmer
    actors += manufacturer

    actors += truck1
    //    actors += truck2
    //    actors += truck3

    actors += supermarket1
    actors += sectionGrain1
    actors += sectionSnack1
    actors += sectionDairy1
    actors += sectionMeat1
    actors += sectionVegetable1
    actors += employee1
    actors += cashier1

    //    actors += supermarket2
    //    actors += sectionGrain2
    //    actors += sectionSnack2
    //    actors += sectionDairy2
    //    actors += sectionMeat2
    //    actors += sectionVegetable2
    //    actors += employee2
    //    actors += cashier2
    //
    //    actors += supermarket3
    //    actors += sectionGrain3
    //    actors += sectionSnack3
    //    actors += sectionDairy3
    //    actors += sectionMeat3
    //    actors += sectionVegetable3
    //    actors += employee3
    //    actors += cashier3

    actors += customer1
    actors += customer2
    actors += customer3


    supermarketItems1 += item1_1_TerraSuisse
    supermarketItems1 += item2_1_TerraSuisse
    supermarketItems1 += item3_1_TerraSuisse
    supermarketItems1 += item4_1_TerraSuisse
    supermarketItems1 += item5_1_TerraSuisse
    supermarketItems1 += item6_1_TerraSuisse
    supermarketItems1 += item7_1_TerraSuisse
    supermarketItems1 += item8_1_TerraSuisse
    supermarketItems1 += item9_1_TerraSuisse
    supermarketItems1 += item10_1_TerraSuisse
    supermarketItems1 += item11_1_TerraSuisse

    //    supermarketItems1 += item1_1_Optigal
    //    supermarketItems1 += item2_1_Optigal
    //    supermarketItems1 += item3_1_Optigal
    //    supermarketItems1 += item4_1_Optigal
    //    supermarketItems1 += item5_1_Optigal
    //    supermarketItems1 += item6_1_Optigal
    //    supermarketItems1 += item7_1_Optigal
    //    supermarketItems1 += item8_1_Optigal
    //    supermarketItems1 += item9_1_Optigal
    //    supermarketItems1 += item10_1_Optigal
    //    supermarketItems1 += item11_1_Optigal

    //    supermarketItems1 += item1_1_Aha
    //    supermarketItems1 += item2_1_Aha
    //    supermarketItems1 += item3_1_Aha
    //    supermarketItems1 += item4_1_Aha
    //    supermarketItems1 += item5_1_Aha
    //    supermarketItems1 += item6_1_Aha
    //    supermarketItems1 += item7_1_Aha
    //    supermarketItems1 += item8_1_Aha
    //    supermarketItems1 += item9_1_Aha
    //    supermarketItems1 += item10_1_Aha
    //    supermarketItems1 += item11_1_Aha

    //    supermarketItems2 += item1_2
    //    supermarketItems2 += item2_2
    //    supermarketItems2 += item3_2
    //    supermarketItems2 += item4_2
    //    supermarketItems2 += item5_2
    //    supermarketItems2 += item6_2
    //    supermarketItems2 += item7_2
    //    supermarketItems2 += item8_2
    //    supermarketItems2 += item9_2
    //    supermarketItems2 += item10_2
    //    supermarketItems2 += item11_2
    //
    //    supermarketItems3 += item1_3
    //    supermarketItems3 += item2_3
    //    supermarketItems3 += item3_3
    //    supermarketItems3 += item4_3
    //    supermarketItems3 += item5_3
    //    supermarketItems3 += item6_3
    //    supermarketItems3 += item7_3
    //    supermarketItems3 += item8_3
    //    supermarketItems3 += item9_3
    //    supermarketItems3 += item10_3
    //    supermarketItems3 += item11_3

    actors = actors ++ supermarketItems1
    //    actors = actors ++ supermarketItems2
    //    actors = actors ++ supermarketItems3

    actors += worldMap

    supermarket1.initializeShelves(supermarketItems1.toVector)
    //    supermarket2.initializeShelves(supermarketItems2.toVector)
    //    supermarket3.initializeShelves(supermarketItems3.toVector)


    //    supermarket1.warehouse.toList.foreach { section =>
    //      section.shelves.toList.foreach { shelf =>
    //        shelf._2.itemsList.toList.foreach { item =>
    //          item.state = onDisplay
    //        }
    //      }
    //    }

    //    supermarket2.warehouse.toList.foreach { section =>
    //      section.shelves.toList.foreach { shelf =>
    //        shelf._2.itemsList.toList.foreach { item =>
    //          item.state.loadInShelves
    //        }
    //      }
    //    }

    //    supermarket3.warehouse.toList.foreach { section =>
    //      section.shelves.toList.foreach { shelf =>
    //        shelf._2.itemsList.toList.foreach { item =>
    //          item.state.loadInShelves
    //        }
    //      }
    //    }

    actors.toList
  }
}