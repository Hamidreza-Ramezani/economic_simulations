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
    val l = ListBuffer[Actor]()
    val l_repeat = ListBuffer[Actor]()

    val mapWidth = 10
    val mapHeight = 8
    val worldMap: WorldTrait = new World(mapHeight, mapWidth)

    val sectionVegetable1 = new Section("Vegetable", FIFO, worldMap)
    val sectionMeat1 = new Section("Meat", FIFO, worldMap)
    val sectionDairy1 = new Section("Dairy", FIFO, worldMap)
    val sectionSnack1 = new Section("Snack", FIFO, worldMap)
    val sectionGrain1 = new Section("Grain", LIFO, worldMap)

    val sectionVegetable2 = new Section("Vegetable", FIFO, worldMap)
    val sectionMeat2 = new Section("Meat", FIFO, worldMap)
    val sectionDairy2 = new Section("Dairy", FIFO, worldMap)
    val sectionSnack2 = new Section("Snack", FIFO, worldMap)
    val sectionGrain2 = new Section("Grain", LIFO, worldMap)

    val sectionVegetable3 = new Section("Vegetable", FIFO, worldMap)
    val sectionMeat3 = new Section("Meat", FIFO, worldMap)
    val sectionDairy3 = new Section("Dairy", FIFO, worldMap)
    val sectionSnack3 = new Section("Snack", FIFO, worldMap)
    val sectionGrain3 = new Section("Grain", LIFO, worldMap)


    var sectionList1 = new ListBuffer[SectionTrait]()
    sectionList1 += sectionVegetable1
    sectionList1 += sectionMeat1
    sectionList1 += sectionDairy1
    sectionList1 += sectionSnack1
    sectionList1 += sectionGrain1

    var sectionList2 = new ListBuffer[SectionTrait]()
    sectionList2 += sectionVegetable2
    sectionList2 += sectionMeat2
    sectionList2 += sectionDairy2
    sectionList2 += sectionSnack2
    sectionList2 += sectionGrain2

    var sectionList3 = new ListBuffer[SectionTrait]()
    sectionList3 += sectionVegetable3
    sectionList3 += sectionMeat3
    sectionList3 += sectionDairy3
    sectionList3 += sectionSnack3
    sectionList3 += sectionGrain3

    val supermarkets: ListBuffer[SupermarketTrait] = new ListBuffer[SupermarketTrait]
    var trucks = new ListBuffer[TruckTrait]

    val supermarket1 = new Supermarket(sectionList1, worldMap)
    val supermarket2 = new Supermarket(sectionList2, worldMap)
    val supermarket3 = new Supermarket(sectionList3, worldMap)

    supermarkets += supermarket1
    supermarkets += supermarket2
    supermarkets += supermarket3

    val truck1 = new Truck(worldMap)
    val truck2 = new Truck(worldMap)
    val truck3 = new Truck(worldMap)
    trucks += truck1
    trucks += truck2
    trucks += truck3

    val manufacturer = new Manufacturer(trucks, supermarkets, worldMap)
    val farmer = new Farmer(manufacturer, worldMap)

    val employee1 = new Employee(supermarket1, sectionVegetable1, manufacturer, worldMap)
    val cashier1 = new Cashier(supermarket1, worldMap)

    val employee2 = new Employee(supermarket2, sectionVegetable2, manufacturer, worldMap)
    val cashier2 = new Cashier(supermarket2, worldMap)

    val employee3 = new Employee(supermarket3, sectionVegetable3, manufacturer, worldMap)
    val cashier3 = new Cashier(supermarket3, worldMap)


    val customer1 = new Customer1(supermarkets, worldMap)
    val customer2 = new Customer2(supermarkets, worldMap)
    val customer3 = new Customer3(supermarkets, worldMap)
    //    val customer1 = new Customer1(supermarket1, worldMap)
    //    val customer2 = new Customer2(supermarket1, worldMap)
    //    val customer3 = new Customer3(supermarket1, worldMap)


    val item1_1 = new Item1(supermarket1, sectionVegetable1, worldMap)
    val item2_1 = new Item2(supermarket1, sectionVegetable1, worldMap)
    val item3_1 = new Item3(supermarket1, sectionVegetable1, worldMap)
    val item4_1 = new Item4(supermarket1, sectionVegetable1, worldMap)
    val item5_1 = new Item5(supermarket1, sectionVegetable1, worldMap)
    val item6_1 = new Item6(supermarket1, sectionVegetable1, worldMap)
    val item7_1 = new Item7(supermarket1, sectionVegetable1, worldMap)
    val item8_1 = new Item8(supermarket1, sectionVegetable1, worldMap)
    val item9_1 = new Item9(supermarket1, sectionVegetable1, worldMap)
    val item10_1 = new Item10(supermarket1, sectionVegetable1, worldMap)
    val item11_1 = new Item11(supermarket1, sectionVegetable1, worldMap)

    val item1_2 = new Item1(supermarket2, sectionVegetable2, worldMap)
    val item2_2 = new Item2(supermarket2, sectionVegetable2, worldMap)
    val item3_2 = new Item3(supermarket2, sectionVegetable2, worldMap)
    val item4_2 = new Item4(supermarket2, sectionVegetable2, worldMap)
    val item5_2 = new Item5(supermarket2, sectionVegetable2, worldMap)
    val item6_2 = new Item6(supermarket2, sectionVegetable2, worldMap)
    val item7_2 = new Item7(supermarket2, sectionVegetable2, worldMap)
    val item8_2 = new Item8(supermarket2, sectionVegetable2, worldMap)
    val item9_2 = new Item9(supermarket2, sectionVegetable2, worldMap)
    val item10_2 = new Item10(supermarket2, sectionVegetable2, worldMap)
    val item11_2 = new Item11(supermarket2, sectionVegetable2, worldMap)

    val item1_3 = new Item1(supermarket3, sectionVegetable3, worldMap)
    val item2_3 = new Item2(supermarket3, sectionVegetable3, worldMap)
    val item3_3 = new Item3(supermarket3, sectionVegetable3, worldMap)
    val item4_3 = new Item4(supermarket3, sectionVegetable3, worldMap)
    val item5_3 = new Item5(supermarket3, sectionVegetable3, worldMap)
    val item6_3 = new Item6(supermarket3, sectionVegetable3, worldMap)
    val item7_3 = new Item7(supermarket3, sectionVegetable3, worldMap)
    val item8_3 = new Item8(supermarket3, sectionVegetable3, worldMap)
    val item9_3 = new Item9(supermarket3, sectionVegetable3, worldMap)
    val item10_3 = new Item10(supermarket3, sectionVegetable3, worldMap)
    val item11_3 = new Item11(supermarket3, sectionVegetable3, worldMap)


    //    sectionVegetable1.supermarket1 = supermarket1
    //    sectionMeat1.supermarket1 = supermarket1
    //    sectionDairy1.supermarket1 = supermarket1
    //    sectionSnack1.supermarket1 = supermarket1
    //    sectionGrain1.supermarket1 = supermarket1


    l_repeat.append(farmer)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(manufacturer)
    l ++= l_repeat
    l_repeat.clear()

    l_repeat.append(truck1)
    l ++= l_repeat
    l_repeat.clear()
    l_repeat.append(truck2)
    l ++= l_repeat
    l_repeat.clear()
    l_repeat.append(truck3)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(supermarket1)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(sectionGrain1)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(sectionSnack1)
    l ++= l_repeat
    l_repeat.clear()

    l_repeat.append(sectionDairy1)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(sectionMeat1)
    l ++= l_repeat
    l_repeat.clear()

    l_repeat.append(sectionVegetable1)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(employee1)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(cashier1)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(supermarket2)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(sectionGrain2)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(sectionSnack2)
    l ++= l_repeat
    l_repeat.clear()

    l_repeat.append(sectionDairy2)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(sectionMeat2)
    l ++= l_repeat
    l_repeat.clear()

    l_repeat.append(sectionVegetable2)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(employee2)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(cashier2)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(supermarket3)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(sectionGrain3)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(sectionSnack3)
    l ++= l_repeat
    l_repeat.clear()

    l_repeat.append(sectionDairy3)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(sectionMeat3)
    l ++= l_repeat
    l_repeat.clear()

    l_repeat.append(sectionVegetable3)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(employee3)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(cashier3)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(customer1)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(customer2)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(customer3)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item1_1)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item2_1)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item3_1)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item4_1)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item5_1)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item6_1)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item7_1)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item8_1)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item9_1)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item10_1)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item11_1)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item1_2)
    supermarket2.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item2_2)
    supermarket2.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item3_2)
    supermarket2.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item4_2)
    supermarket2.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item5_2)
    supermarket2.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item6_2)
    supermarket2.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item7_2)
    supermarket2.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item8_2)
    supermarket2.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item9_2)
    supermarket2.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item10_2)
    supermarket2.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item11_2)
    supermarket2.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item1_3)
    supermarket3.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item2_3)
    supermarket3.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item3_3)
    supermarket3.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item4_3)
    supermarket3.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item5_3)
    supermarket3.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item6_3)
    supermarket3.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item7_3)
    supermarket3.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item8_3)
    supermarket3.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item9_3)
    supermarket3.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item10_3)
    supermarket3.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item11_3)
    supermarket3.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    //    l.toList.foreach { actor =>
    //      actor.setInitialPosition(Random.nextInt(worldMap.width), Random.nextInt(worldMap.height))
    //      worldMap.addEntity(actor)
    //    }

    l_repeat.append(worldMap)
    l ++= l_repeat
    l_repeat.clear()



    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket1, sectionVegetable1,manufacturer)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Cashier))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer1(supermarket1)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer2(supermarket1)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer3(supermarket1)))
    //    l ++= l_repeat
    //    l_repeat.clear()


    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket1, sectionMeat1)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket1, sectionDairy1)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket1, sectionSnack1)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket1, sectionGrain1)))
    //    l ++= l_repeat
    //    l_repeat.clear()


    //    (1 to 1).foreach(_ => l_repeat.append(new Item1(supermarket1, sectionVegetable1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item2(supermarket1, sectionVegetable1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item3(supermarket1, sectionVegetable1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item4(supermarket1, sectionVegetable1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item5(supermarket1, sectionVegetable1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item6(supermarket1, sectionVegetable1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item7(supermarket1, sectionVegetable1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item8(supermarket1, sectionVegetable1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item9(supermarket1, sectionVegetable1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item10(supermarket1, sectionVegetable1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item11(supermarket1, sectionVegetable1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()


    //    (1 to 1).foreach(_ => l_repeat.append(new Item12(supermarket1, sectionMeat1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item13(supermarket1, sectionMeat1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item14(supermarket1, sectionMeat1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item15(supermarket1, sectionMeat1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item16(supermarket1, sectionMeat1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item17(supermarket1, sectionSnack1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item18(supermarket1, sectionSnack1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item19(supermarket1, sectionSnack1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item20(supermarket1, sectionSnack1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item21(supermarket1, sectionGrain1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item22(supermarket1, sectionGrain1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item23(supermarket1, sectionGrain1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item24(supermarket1, sectionGrain1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item25(supermarket1, sectionGrain1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item26(supermarket1, sectionGrain1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item27(supermarket1, sectionGrain1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item28(supermarket1, sectionDairy1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item29(supermarket1, sectionDairy1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item30(supermarket1, sectionDairy1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item31(supermarket1, sectionDairy1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item32(supermarket1, sectionDairy1)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()


    supermarket1.employees += employee1
    supermarket2.employees += employee2
    supermarket3.employees += employee3

    supermarket1.cashiers += cashier1
    supermarket2.cashiers += cashier2
    supermarket3.cashiers += cashier3

    supermarket1.warehouse.toList.foreach { section =>
      section.shelves.toList.foreach { shelf =>
        shelf._2.itemsList.toList.foreach { item =>
          item.state.loadInShelves
        }
      }
    }

    supermarket2.warehouse.toList.foreach { section =>
      section.shelves.toList.foreach { shelf =>
        shelf._2.itemsList.toList.foreach { item =>
          item.state.loadInShelves
        }
      }
    }

    supermarket3.warehouse.toList.foreach { section =>
      section.shelves.toList.foreach { shelf =>
        shelf._2.itemsList.toList.foreach { item =>
          item.state.loadInShelves
        }
      }
    }
    l.toList
  }
}