package meta.example.supermarket.testItemOnly

import meta.deep.runtime.Actor
import squid.quasi.lift

import scala.collection.mutable.ListBuffer
import meta.example.supermarket.{FIFO, LIFO, Section, SectionTrait, Supermarket}
import meta.example.supermarket.customers._
import meta.example.supermarket.goods._
import meta.example.supermarket.logistics.{Farmer, Manufacturer, Truck}
import meta.example.supermarket.people._
import meta.example.supermarket.worldmap.World

import scala.util.Random

/* Auto generated from genExample*/

@lift
class MainInit {
  //this class specifies the actors of the simulation
  def main(): List[Actor] = {
    val l = ListBuffer[Actor]()
    val l_repeat = ListBuffer[Actor]()

    val mapWidth = 10
    val mapHeight = 10
    val worldMap = new World(mapWidth, mapHeight)


    val sectionVegetable = new Section("Vegetable", FIFO)
    val sectionMeat = new Section("Meat", FIFO)
    val sectionDairy = new Section("Dairy", FIFO)
    val sectionSnack = new Section("Snack", FIFO)
    val sectionGrain = new Section("Grain", LIFO)


    var sectionLst = new ListBuffer[SectionTrait]()
    sectionLst += sectionVegetable
    sectionLst += sectionMeat
    sectionLst += sectionDairy
    sectionLst += sectionSnack
    sectionLst += sectionGrain


    val supermarket = new Supermarket(sectionLst)
    val truck = new Truck(supermarket)
    val manufacturer = new Manufacturer(truck, supermarket)
    val farmer = new Farmer(manufacturer)
    val employee1 = new Employee(supermarket, sectionVegetable, manufacturer)
    val cashier1 = new Cashier

    val customer1 = new Customer1(supermarket)
    val customer2 = new Customer2(supermarket)
    val customer3 = new Customer3(supermarket)


    val item1 = new Item1(supermarket, sectionVegetable)
    val item2 = new Item2(supermarket, sectionVegetable)
    val item3 = new Item3(supermarket, sectionVegetable)
    val item4 = new Item4(supermarket, sectionVegetable)
    val item5 = new Item5(supermarket, sectionVegetable)
    val item6 = new Item6(supermarket, sectionVegetable)
    val item7 = new Item7(supermarket, sectionVegetable)
    val item8 = new Item8(supermarket, sectionVegetable)
    val item9 = new Item9(supermarket, sectionVegetable)
    val item10 = new Item10(supermarket, sectionVegetable)
    val item11 = new Item11(supermarket, sectionVegetable)


//    sectionVegetable.supermarket = supermarket
//    sectionMeat.supermarket = supermarket
//    sectionDairy.supermarket = supermarket
//    sectionSnack.supermarket = supermarket
//    sectionGrain.supermarket = supermarket


    l_repeat.append(farmer)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(manufacturer)
    l ++= l_repeat
    l_repeat.clear()

    l_repeat.append(truck)
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(supermarket)
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
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item2)
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item3)
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item4)
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item5)
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item6)
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item7)
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item8)
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item9)
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item10)
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l_repeat.append(item11)
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l.toList.foreach { actor =>
      actor.setInitialPosition(Random.nextInt(mapWidth), Random.nextInt(mapHeight))
      worldMap.addEntity(actor)
    }

    l_repeat.append(worldMap)
    l ++= l_repeat
    l_repeat.clear()



    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket, sectionVegetable,manufacturer)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Cashier))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer1(supermarket)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer2(supermarket)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer3(supermarket)))
    //    l ++= l_repeat
    //    l_repeat.clear()


    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket, sectionMeat)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket, sectionDairy)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket, sectionSnack)))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket, sectionGrain)))
    //    l ++= l_repeat
    //    l_repeat.clear()


    //    (1 to 1).foreach(_ => l_repeat.append(new Item1(supermarket, sectionVegetable)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item2(supermarket, sectionVegetable)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item3(supermarket, sectionVegetable)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item4(supermarket, sectionVegetable)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item5(supermarket, sectionVegetable)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item6(supermarket, sectionVegetable)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item7(supermarket, sectionVegetable)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item8(supermarket, sectionVegetable)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item9(supermarket, sectionVegetable)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item10(supermarket, sectionVegetable)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item11(supermarket, sectionVegetable)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()


    //    (1 to 1).foreach(_ => l_repeat.append(new Item12(supermarket, sectionMeat)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item13(supermarket, sectionMeat)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item14(supermarket, sectionMeat)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item15(supermarket, sectionMeat)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item16(supermarket, sectionMeat)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item17(supermarket, sectionSnack)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item18(supermarket, sectionSnack)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item19(supermarket, sectionSnack)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item20(supermarket, sectionSnack)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item21(supermarket, sectionGrain)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item22(supermarket, sectionGrain)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item23(supermarket, sectionGrain)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item24(supermarket, sectionGrain)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item25(supermarket, sectionGrain)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item26(supermarket, sectionGrain)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item27(supermarket, sectionGrain)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item28(supermarket, sectionDairy)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item29(supermarket, sectionDairy)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item30(supermarket, sectionDairy)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item31(supermarket, sectionDairy)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Item32(supermarket, sectionDairy)))
    //    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    //    l ++= l_repeat
    //    l_repeat.clear()


    supermarket.warehouse.toList.foreach { section =>
      section.shelves.toList.foreach { shelf =>
        shelf._2.itemsList.toList.foreach { item =>
          item.state.loadInShelves
        }
      }
    }
    l.toList
  }
}