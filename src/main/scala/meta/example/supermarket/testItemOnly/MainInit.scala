package meta.example.supermarket.testItemOnly

import meta.deep.runtime.Actor
import meta.example.supermarket.customers._
import meta.example.supermarket.goods._
import meta.example.supermarket.logistics.{Farmer, Manufacturer, Truck}
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

    val sectionVegetable = new Section("Vegetable", FIFO, worldMap)
    val sectionMeat = new Section("Meat", FIFO, worldMap)
    val sectionDairy = new Section("Dairy", FIFO, worldMap)
    val sectionSnack = new Section("Snack", FIFO, worldMap)
    val sectionGrain = new Section("Grain", LIFO, worldMap)


    var sectionLst = new ListBuffer[SectionTrait]()
    sectionLst += sectionVegetable
    sectionLst += sectionMeat
    sectionLst += sectionDairy
    sectionLst += sectionSnack
    sectionLst += sectionGrain


    val supermarket1 = new Supermarket(sectionLst, worldMap)
    val supermarkets:ListBuffer[SupermarketTrait] = new ListBuffer[SupermarketTrait]
    supermarkets += supermarket1
    val truck = new Truck(supermarket1, worldMap)
    val manufacturer = new Manufacturer(truck, supermarkets, worldMap)
    val farmer = new Farmer(manufacturer, worldMap)
    val employee1 = new Employee(supermarket1, sectionVegetable, manufacturer, worldMap)
    val cashier1 = new Cashier(supermarket1, worldMap)


    val customer1 = new Customer1(supermarkets, worldMap)
    val customer2 = new Customer2(supermarkets, worldMap)
    val customer3 = new Customer3(supermarkets, worldMap)
//    val customer1 = new Customer1(supermarket1, worldMap)
//    val customer2 = new Customer2(supermarket1, worldMap)
//    val customer3 = new Customer3(supermarket1, worldMap)


    val item1 = new Item1(supermarket1, sectionVegetable, worldMap)
    val item2 = new Item2(supermarket1, sectionVegetable, worldMap)
    val item3 = new Item3(supermarket1, sectionVegetable, worldMap)
    val item4 = new Item4(supermarket1, sectionVegetable, worldMap)
    val item5 = new Item5(supermarket1, sectionVegetable, worldMap)
    val item6 = new Item6(supermarket1, sectionVegetable, worldMap)
    val item7 = new Item7(supermarket1, sectionVegetable, worldMap)
    val item8 = new Item8(supermarket1, sectionVegetable, worldMap)
    val item9 = new Item9(supermarket1, sectionVegetable, worldMap)
    val item10 = new Item10(supermarket1, sectionVegetable, worldMap)
    val item11 = new Item11(supermarket1, sectionVegetable, worldMap)


    //    sectionVegetable.supermarket1 = supermarket1
    //    sectionMeat.supermarket1 = supermarket1
    //    sectionDairy.supermarket1 = supermarket1
    //    sectionSnack.supermarket1 = supermarket1
    //    sectionGrain.supermarket1 = supermarket1


    l_repeat.append(farmer)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(manufacturer)
    l ++= l_repeat
    l_repeat.clear()

    l_repeat.append(truck)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(supermarket1)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(sectionGrain)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(sectionSnack)
    l ++= l_repeat
    l_repeat.clear()

    l_repeat.append(sectionDairy)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(sectionMeat)
    l ++= l_repeat
    l_repeat.clear()

    l_repeat.append(sectionVegetable)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(employee1)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(cashier1)
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


    l_repeat.append(item1)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item2)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item3)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item4)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item5)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item6)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item7)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item8)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item9)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item10)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item11)
    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    //    l.toList.foreach { actor =>
    //      actor.setInitialPosition(Random.nextInt(worldMap.width), Random.nextInt(worldMap.height))
    //      worldMap.addEntity(actor)
    //    }

    l_repeat.append(worldMap)
    l ++= l_repeat
    l_repeat.clear()



    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket1, sectionVegetable,manufacturer)))
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


    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket1, sectionMeat)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket1, sectionDairy)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket1, sectionSnack)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket1, sectionGrain)))
    //    l ++= l_repeat
    //    l_repeat.clear()


    //    (1 to 1).foreach(_ => l_repeat.append(new Item1(supermarket1, sectionVegetable)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item2(supermarket1, sectionVegetable)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item3(supermarket1, sectionVegetable)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item4(supermarket1, sectionVegetable)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item5(supermarket1, sectionVegetable)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item6(supermarket1, sectionVegetable)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item7(supermarket1, sectionVegetable)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item8(supermarket1, sectionVegetable)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item9(supermarket1, sectionVegetable)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item10(supermarket1, sectionVegetable)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item11(supermarket1, sectionVegetable)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()


    //    (1 to 1).foreach(_ => l_repeat.append(new Item12(supermarket1, sectionMeat)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item13(supermarket1, sectionMeat)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item14(supermarket1, sectionMeat)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item15(supermarket1, sectionMeat)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item16(supermarket1, sectionMeat)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item17(supermarket1, sectionSnack)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item18(supermarket1, sectionSnack)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item19(supermarket1, sectionSnack)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item20(supermarket1, sectionSnack)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item21(supermarket1, sectionGrain)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item22(supermarket1, sectionGrain)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item23(supermarket1, sectionGrain)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item24(supermarket1, sectionGrain)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item25(supermarket1, sectionGrain)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item26(supermarket1, sectionGrain)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item27(supermarket1, sectionGrain)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item28(supermarket1, sectionDairy)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item29(supermarket1, sectionDairy)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item30(supermarket1, sectionDairy)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item31(supermarket1, sectionDairy)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item32(supermarket1, sectionDairy)))
    //    supermarket1.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()


    supermarket1.warehouse.toList.foreach { section =>
      section.shelves.toList.foreach { shelf =>
        shelf._2.itemsList.toList.foreach { item =>
          item.state.loadInShelves
        }
      }
    }
    l.toList
  }
}