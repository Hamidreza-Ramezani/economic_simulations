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
  //this class specifies the initial actors of the simulation
  def main(): List[Actor] = {
    var actors = ListBuffer[Actor]()
    val mapWidth = 10
    val mapHeight = 8
    val worldMap: WorldTrait = new World(mapHeight, mapWidth)
    val supermarkets: ListBuffer[SupermarketTrait] = new ListBuffer[SupermarketTrait]
    var trucks = new ListBuffer[TruckTrait]

    val supermarket1 = new Supermarket(new ListBuffer[SectionTrait](), worldMap)
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
    val customer1 = new Customer1(supermarkets, worldMap, MealPlan_Dummy1)
    val customer2 = new Customer2(supermarkets, worldMap, MealPlan_Dummy2)
    val customer3 = new Customer3(supermarkets, worldMap, MealPlan_Dummy3)

    supermarkets.toList.foreach {
      supermarket =>
        supermarket.warehouse += new Section("Vegetable", FIFO, worldMap)
        //        supermarket.warehouse += new Section("Meat", FIFO, worldMap)
        //        supermarket.warehouse += new Section("Dairy", FIFO, worldMap)
        //        supermarket.warehouse += new Section("Snack", FIFO, worldMap)
        //        supermarket.warehouse += new Section("Grain", LIFO, worldMap)

        supermarket.warehouse.toList.foreach {
          section =>
            val employee = new Employee(supermarket, section, manufacturer, worldMap)
            supermarket.employees += employee
            actors += section
            actors += employee
        }

        val cashier = new Cashier(supermarket, worldMap)
        supermarket.cashiers += cashier
        actors += supermarket
        actors += cashier
    }

    supermarkets.toList.foreach {
      supermarket =>
        var supermarketItems = ListBuffer[Item]()
        global.brands.foreach {
          brand =>
            1.to(supermarket.shelfCapacity).foreach {
              _ =>
                supermarketItems += new Item1(supermarket, supermarket.warehouse.filter(_.sectionName == "Vegetable").head, worldMap, brand, global.priceMap(("Item1", brand)))
                supermarketItems += new Item2(supermarket, supermarket.warehouse.filter(_.sectionName == "Vegetable").head, worldMap, brand, global.priceMap(("Item2", brand)))
                supermarketItems += new Item3(supermarket, supermarket.warehouse.filter(_.sectionName == "Vegetable").head, worldMap, brand, global.priceMap(("Item3", brand)))
                supermarketItems += new Item4(supermarket, supermarket.warehouse.filter(_.sectionName == "Vegetable").head, worldMap, brand, global.priceMap(("Item4", brand)))
                supermarketItems += new Item5(supermarket, supermarket.warehouse.filter(_.sectionName == "Vegetable").head, worldMap, brand, global.priceMap(("Item5", brand)))
                supermarketItems += new Item6(supermarket, supermarket.warehouse.filter(_.sectionName == "Vegetable").head, worldMap, brand, global.priceMap(("Item6", brand)))
                supermarketItems += new Item7(supermarket, supermarket.warehouse.filter(_.sectionName == "Vegetable").head, worldMap, brand, global.priceMap(("Item7", brand)))
                supermarketItems += new Item8(supermarket, supermarket.warehouse.filter(_.sectionName == "Vegetable").head, worldMap, brand, global.priceMap(("Item8", brand)))
                supermarketItems += new Item9(supermarket, supermarket.warehouse.filter(_.sectionName == "Vegetable").head, worldMap, brand, global.priceMap(("Item9", brand)))
                supermarketItems += new Item10(supermarket, supermarket.warehouse.filter(_.sectionName == "Vegetable").head, worldMap, brand, global.priceMap(("Item10", brand)))
                supermarketItems += new Item11(supermarket, supermarket.warehouse.filter(_.sectionName == "Vegetable").head, worldMap, brand, global.priceMap(("Item11", brand)))
            }
        }
        actors = actors ++ supermarketItems
        supermarket.initializeShelves(supermarketItems.toVector)
    }
    actors += farmer
    actors += manufacturer

    actors += truck1
    //    actors += truck2
    //    actors += truck3

    actors += customer1
    actors += customer2
    actors += customer3
    actors += worldMap
    actors.toList
  }
}