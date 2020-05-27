//package meta.example.supermarket.testItemOnly
//
//import meta.deep.runtime.Actor
//import squid.quasi.lift
//
//import scala.collection.mutable.ListBuffer
//import meta.example.supermarket.Supermarket
//import meta.example.supermarket.customers.{Customer1, Customer2, Customer3}
////import meta.example.supermarket.goods.{Item, _}
//import meta.example.supermarket.goods_updated.{Dairy, Grain, Meat, Vegetable,Item}
//import meta.example.supermarket.people._
//
///* Auto generated from genExample*/
//
//@lift
//class MainInit2 {
//  //this class specifies the actors of the simulation
//  def main(): List[Actor] = {
//    val l = ListBuffer[Actor]()
//    val l_repeat = ListBuffer[Actor]()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Customer1))
//    l ++= l_repeat
//    l_repeat.clear()
//
//
//    (1 to 1).foreach(_ => l_repeat.append(new Customer2))
//    l ++= l_repeat
//    l_repeat.clear()
//
//
//    (1 to 1).foreach(_ => l_repeat.append(new Customer3))
//    l ++= l_repeat
//    l_repeat.clear()
//
//
//    (1 to 1).foreach(_ => l_repeat.append(new Employee))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Cashier))
//    l ++= l_repeat
//    l_repeat.clear()
//
//
//
//
//    //    (1 to 1).foreach(_ => l_repeat.append(new Customer3))
//    //    l ++= l_repeat
//    //    l_repeat.clear()
//    //
//    //    (1 to 1).foreach(_ => l_repeat.append(new Customer4))
//    //    l ++= l_repeat
//    //    l_repeat.clear()
//    //
//    //    (1 to 1).foreach(_ => l_repeat.append(new Customer5))
//    //    l ++= l_repeat
//    //    l_repeat.clear()
//    //
//    //    (1 to 1).foreach(_ => l_repeat.append(new Customer6))
//    //    l ++= l_repeat
//    //    l_repeat.clear()
//    //
//    //    (1 to 1).foreach(_ => l_repeat.append(new Customer7))
//    //    l ++= l_repeat
//    //    l_repeat.clear()
//    //
//    //    (1 to 1).foreach(_ => l_repeat.append(new Customer8))
//    //    l ++= l_repeat
//    //    l_repeat.clear()
//    //
//    //    (1 to 1).foreach(_ => l_repeat.append(new Customer9))
//    //    l ++= l_repeat
//    //    l_repeat.clear()
//    //
//    //    (1 to 1).foreach(_ => l_repeat.append(new Customer10))
//    //    l ++= l_repeat
//    //    l_repeat.clear()
//
//
//
//    (1 to 1).foreach(_ => l_repeat.append(new Vegetable("Eggplant", 2.0, 200, 0.0, 3)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//
//    (1 to 1).foreach(_ => l_repeat.append(new Vegetable("Potato", 0.8, 200, 0.0, 2)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Vegetable("Onion", 0.8, 200, 0.0, 2)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Vegetable("Broccoli", 2.0, 200, 0.0, 5)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Vegetable("Cucumber", 1.5, 200, 0.0, 5)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Vegetable("Carrots", 1.0, 200, 0.0, 5)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Vegetable("Celery", 2.0, 200, 0.0, 5)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Vegetable("Tomato", 1.5, 200, 0.0, 5)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Vegetable("Mushroom", 2.0, 200, 0.0, 5)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Vegetable("Cabbage", 1.0, 200, 0.0, 5)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Vegetable("Squash", 1.0, 200, 0.0, 5)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Meat("Chicken", 15.0, 1000, 0.0, 3)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Meat("Beef", 35.0, 1000, 0.0, 3)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Meat("Pork", 25.0, 1000, 0.0, 3)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Meat("Lamb", 45.0, 1000, 0.0, 3)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Meat("Bacon", 25.0, 1000, 0.0, 3)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Meat("Kitkat", 3.5, 300, 0.0, 10)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Meat("Ferraro", 5.0, 250, 0.0, 10)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Meat("DarkChocolate", 1.8, 100, 0.0, 10)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Meat("WhiteChocolate", 1.8, 100, 0.0, 10)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Grain("Cereal", 4.0, 1000, 0.0, 4)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Grain("Oatmeal", 4.0, 1000, 0.0, 4)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Grain("Rice", 2.0, 1000, 0.0, 4)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Grain("Noodles", 3.0, 1000, 0.0, 4)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Grain("Spaghetti", 1.5, 1000, 0.0, 4)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Grain("Pasta", 1.5, 1000, 0.0, 4)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Grain("Bread", 1.5, 1000, 0.0, 4)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Dairy("Milk", 2.0, 1000, 0.0, 3)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Dairy("Yogurt", 1.0, 50, 0.0, 3)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Dairy("Cheese", 5.0, 200, 0.0, 3)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Dairy("Cream", 1.0, 50, 0.0, 3)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    (1 to 1).foreach(_ => l_repeat.append(new Dairy("Egg", 3.0, 250, 0.0, 3)))
//    Supermarket.store.initializeItemDeque(l_repeat.toVector.map(_.asInstanceOf[Item]))
//    l ++= l_repeat
//    l_repeat.clear()
//
//    l.toList
//  }
//}
