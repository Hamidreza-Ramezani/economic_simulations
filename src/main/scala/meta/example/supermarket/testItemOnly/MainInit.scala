package meta.example.supermarket.testItemOnlyExample

import meta.deep.runtime.Actor
import squid.quasi.lift

import scala.collection.mutable.ListBuffer
import meta.example.supermarket.{Supermarket}
import meta.example.supermarket.goods._
import meta.example.supermarket.people._

/* Auto generated from genExample*/

@lift
class MainInit {
  //this class specifies the actors of the simulation
  def main(): List[Actor] = {
    val l = ListBuffer[Actor]()
    val l_repeat = ListBuffer[Actor]()

    (1 to 1).foreach(_ => l_repeat.append(new Customer1))
    l ++= l_repeat
    l_repeat.clear()


    (1 to 1).foreach(_ => l_repeat.append(new Customer2))
    l ++= l_repeat
    l_repeat.clear()


    (1 to 1).foreach(_ => l_repeat.append(new Customer3))
    l ++= l_repeat
    l_repeat.clear()


    (1 to 1).foreach(_ => l_repeat.append(new Employee))
    l ++= l_repeat
    l_repeat.clear()



    //    (1 to 1).foreach(_ => l_repeat.append(new Customer3))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer4))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer5))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer6))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer7))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer8))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer9))
    //    l ++= l_repeat
    //    l_repeat.clear()
    //
    //    (1 to 1).foreach(_ => l_repeat.append(new Customer10))
    //    l ++= l_repeat
    //    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Cashier))
    l ++= l_repeat
    l_repeat.clear()


    (1 to 1).foreach(_ => l_repeat.append(new Item1("Eggplant", 2.0, 200, 0.0, 3)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()


    (1 to 1).foreach(_ => l_repeat.append(new Item2("Potato", 0.8, 200, 0.0, 2)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item3("Onion", 0.8, 200, 0.0, 2)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item4("Broccoli", 2.0, 200, 0.0, 5)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item5("Cucumber", 1.5, 200, 0.0, 5)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item6("Carrots", 1.0, 200, 0.0, 5)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item7("Celery", 2.0, 200, 0.0, 5)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item8("Tomato", 1.5, 200, 0.0, 5)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item9("Mushroom", 2.0, 200, 0.0, 5)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item10("Cabbage", 1.0, 200, 0.0, 5)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item11("Squash", 1.0, 200, 0.0, 5)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item12("Chicken", 15.0, 1000, 0.0, 3)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item13("Beef", 35.0, 1000, 0.0, 3)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item14("Pork", 25.0, 1000, 0.0, 3)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item15("Lamb", 45.0, 1000, 0.0, 3)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item16("Bacon", 25.0, 1000, 0.0, 3)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item17("Kitkat", 3.5, 300, 0.0, 10)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item18("Ferraro", 5.0, 250, 0.0, 10)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item19("DarkChocolate", 1.8, 100, 0.0, 10)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item20("WhiteChocolate", 1.8, 100, 0.0, 10)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item21("Cereal", 4.0, 1000, 0.0, 4)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item22("Oatmeal", 4.0, 1000, 0.0, 4)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item23("Rice", 2.0, 1000, 0.0, 4)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item24("Noodles", 3.0, 1000, 0.0, 4)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item25("Spaghetti", 1.5, 1000, 0.0, 4)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item26("Pasta", 1.5, 1000, 0.0, 4)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item27("Bread", 1.5, 1000, 0.0, 4)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item28("Milk", 2.0, 1000, 0.0, 3)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item29("Yogurt", 1.0, 50, 0.0, 3)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item30("Cheese", 5.0, 200, 0.0, 3)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item31("Cream", 1.0, 50, 0.0, 3)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    (1 to 1).foreach(_ => l_repeat.append(new Item32("Egg", 3.0, 250, 0.0, 3)))
    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
    l ++= l_repeat
    l_repeat.clear()

    l.toList
  }
}
