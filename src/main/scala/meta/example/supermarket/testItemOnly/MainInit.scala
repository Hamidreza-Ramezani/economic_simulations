package meta.example.supermarket.testItemOnly

import meta.deep.runtime.Actor
import squid.quasi.lift

import scala.collection.mutable.ListBuffer
import meta.example.supermarket.{FIFO, LIFO, Section, SectionTrait, Supermarket}
import meta.example.supermarket.customers._
import meta.example.supermarket.goods._
import meta.example.supermarket.logistics.{Farmer, Manufacturer, Truck}
import meta.example.supermarket.people._

/* Auto generated from genExample*/

@lift
class MainInit {
  //this class specifies the actors of the simulation
  def main(): List[Actor] = {
    val l = ListBuffer[Actor]()
    val l_repeat = ListBuffer[Actor]()


    val sectionVegetable = new Section("Vegetable", FIFO)
    l_repeat.append(sectionVegetable)
    l ++= l_repeat
    l_repeat.clear()

    val sectionMeat = new Section("Meat", FIFO)
    l_repeat.append(sectionMeat)
    l ++= l_repeat
    l_repeat.clear()

    val sectionDairy = new Section("Dairy", FIFO)
    l_repeat.append(sectionDairy)
    l ++= l_repeat
    l_repeat.clear()

    val sectionSnack = new Section("Snack", FIFO)
    l_repeat.append(sectionSnack)
    l ++= l_repeat
    l_repeat.clear()

    val sectionGrain = new Section("Grain", LIFO)
    l_repeat.append(sectionGrain)
    l ++= l_repeat
    l_repeat.clear()

    var sectionLst = new ListBuffer[SectionTrait]()


    sectionLst += sectionVegetable
    sectionLst += sectionMeat
    sectionLst += sectionDairy
    sectionLst += sectionSnack
    sectionLst += sectionGrain


    var supermarket = new Supermarket(sectionLst)
    l_repeat.append(supermarket)
    l ++= l_repeat
    l_repeat.clear()


    val truck = new Truck(supermarket)
    l_repeat.append(truck)
    l ++= l_repeat
    l_repeat.clear()


    val manufacturer = new Manufacturer(truck)
    l_repeat.append(manufacturer)
    l ++= l_repeat
    l_repeat.clear()


    val farmer = new Farmer(manufacturer)
    l_repeat.append(farmer)
    l ++= l_repeat
    l_repeat.clear()


    (1 to 1).foreach(_ => l_repeat.append(new Customer1(supermarket)))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Customer2(supermarket)))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Customer3(supermarket)))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket, sectionVegetable)))
    l ++= l_repeat
    l_repeat.clear()

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

    (1 to 1).foreach(_ => l_repeat.append(new Cashier))
    l ++= l_repeat
    l_repeat.clear()


    (1 to 1).foreach(_ => l_repeat.append(new Item1(supermarket, sectionVegetable)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    (1 to 1).foreach(_ => l_repeat.append(new Item2(supermarket, sectionVegetable)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item3(supermarket, sectionVegetable)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item4(supermarket, sectionVegetable)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item5(supermarket, sectionVegetable)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item6(supermarket, sectionVegetable)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item7(supermarket, sectionVegetable)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item8(supermarket, sectionVegetable)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item9(supermarket, sectionVegetable)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item10(supermarket, sectionVegetable)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item11(supermarket, sectionVegetable)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()






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