package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.Item
import squid.quasi.lift

import scala.collection.mutable

@lift
class Truck(var supermarket: SupermarketTrait) extends TruckTrait {

//  var storage: mutable.Map[String, mutable.Queue[Item]] = mutable.Map(
//    "Yogurt" -> new mutable.Queue[Item],
//    "Squash" -> new mutable.Queue[Item],
//    "Bacon" -> new mutable.Queue[Item],
//    "Cheese" -> new mutable.Queue[Item],
//    "Ferraro" -> new mutable.Queue[Item],
//    "Oatmeal" -> new mutable.Queue[Item],
//    "Cabbage" -> new mutable.Queue[Item],
//    "Beef" -> new mutable.Queue[Item],
//    "Broccoli" -> new mutable.Queue[Item],
//    "Noodles" -> new mutable.Queue[Item],
//    "Eggplant" -> new mutable.Queue[Item],
//    "Potato" -> new mutable.Queue[Item],
//    "Celery" -> new mutable.Queue[Item],
//    "Kitkat" -> new mutable.Queue[Item],
//    "Pasta" -> new mutable.Queue[Item],
//    "Cucumber" -> new mutable.Queue[Item],
//    "Tomato" -> new mutable.Queue[Item],
//    "Cereal" -> new mutable.Queue[Item],
//    "Rice" -> new mutable.Queue[Item],
//    "DarkChocolate" -> new mutable.Queue[Item],
//    "Onion" -> new mutable.Queue[Item],
//    "Carrots" -> new mutable.Queue[Item],
//    "Cream" -> new mutable.Queue[Item],
//    "Lamb" -> new mutable.Queue[Item],
//    "WhiteChocolate" -> new mutable.Queue[Item],
//    "Bread" -> new mutable.Queue[Item],
//    "Pork" -> new mutable.Queue[Item],
//    "Mushroom" -> new mutable.Queue[Item],
//    "Spaghetti" -> new mutable.Queue[Item],
//    "Egg" -> new mutable.Queue[Item],
//    "Milk" -> new mutable.Queue[Item],
//    "Chicken" -> new mutable.Queue[Item]
//  )


  def doTransport(): Unit = {
    //TODO changing the state of the items: done
    //todo changing the constructor of item class. it probably should not take supermarket and section
    //todo we first should try to initialize supermarket and section of items here is truck class: done
    storage.keys.toList.foreach { itemStr =>
      var queue = storage(itemStr)
      queue.toList.foreach(item => {
        item.supermarket = supermarket
        item.section = supermarket.warehouse.filter(_.sectionName == item.category).head
      })
    }
  }


  def unloadTruck(): Unit = {
    storage.keys.toList.foreach { itemStr =>
      var queue = storage(itemStr)
      while (queue.nonEmpty) {
        var item = queue.dequeue()
        supermarket.storage += item
        item.state.loadInStorage

        //ok, lets think how to add items into supermarket
        //we need to add it to a list so that the employee has access to that list
        //then change the employee code base
        // TODO add the item into supermarket: done,
        //  changing the state of the item: done
      }
    }
  }

  def main(): Unit = {
    writer = new PrintWriter(new FileWriter(new File("m/agent" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      doTransport()
      unloadTruck()
      SpecialInstructions.waitTurns(1)
    }
  }
}
