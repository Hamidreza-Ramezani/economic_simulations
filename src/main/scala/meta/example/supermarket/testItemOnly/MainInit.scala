package meta.example.supermarket.testItemOnly

import meta.deep.runtime.Actor
import squid.quasi.lift
import scala.collection.mutable.ListBuffer
import meta.example.supermarket.Supermarket
import meta.example.supermarket.customers._
import meta.example.supermarket.goods._
import meta.example.supermarket.people._

/* Auto generated from genExample*/

@lift
class MainInit {
  //this class specifies the actors of the simulation
  def main(): List[Actor] = {
    val l = ListBuffer[Actor]()
    val l_repeat = ListBuffer[Actor]()

    val supermarket = new Supermarket
    l_repeat.append(supermarket)
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

    (1 to 1).foreach(_ => l_repeat.append(new Employee(supermarket)))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Cashier))
    l ++= l_repeat
    l_repeat.clear()





    (1 to 1).foreach(_ => l_repeat.append(new Item1(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    (1 to 1).foreach(_ => l_repeat.append(new Item2(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item3(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item4(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item5(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item6(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item7(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item8(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item9(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item10(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item11(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item12(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item13(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item14(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item15(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item16(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item17(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item18(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item19(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item20(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item21(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item22(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item23(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item24(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item25(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item26(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item27(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item28(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item29(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item30(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item31(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item32(supermarket)))
    supermarket.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    l.toList
  }
}
