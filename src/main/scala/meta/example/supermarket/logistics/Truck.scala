package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.Item
import squid.quasi.lift

import scala.collection.mutable
import scala.collection.mutable.{Map, Queue}

@lift
class Truck(var supermarket: SupermarketTrait) extends Actor {
  var storage: Map[String, Queue[Item]] = Map(
    "Yogurt" -> Queue[Item],
    "Squash" -> Queue[Item],
    "Bacon" -> Queue[Item],
    "Cheese" -> Queue[Item],
    "Ferraro" -> Queue[Item],
    "Oatmeal" -> Queue[Item],
    "Cabbage" -> Queue[Item],
    "Beef" -> Queue[Item],
    "Broccoli" -> Queue[Item],
    "Noodles" -> Queue[Item],
    "Eggplant" -> Queue[Item],
    "Potato" -> Queue[Item],
    "Celery" -> Queue[Item],
    "Kitkat" -> Queue[Item],
    "Pasta" -> Queue[Item],
    "Cucumber" -> Queue[Item],
    "Tomato" -> Queue[Item],
    "Cereal" -> Queue[Item],
    "Rice" -> Queue[Item],
    "DarkChocolate" -> Queue[Item],
    "Onion" -> Queue[Item],
    "Carrots" -> Queue[Item],
    "Cream" -> Queue[Item],
    "Lamb" -> Queue[Item],
    "WhiteChocolate" -> Queue[Item],
    "Bread" -> Queue[Item],
    "Pork" -> Queue[Item],
    "Mushroom" -> Queue[Item],
    "Spaghetti" -> Queue[Item],
    "Egg" -> Queue[Item],
    "Milk" -> Queue[Item],
    "Chicken" -> Queue[Item]
  )


  def doTransport(): Unit = {
    //TODO changing the state of the items: done
    //todo changing the constructor of item class. it probably should not take supermarket and section
    //todo we first should try to initialize supermarket and section of items here is truck class: done
      storage.keys.foreach { itemStr =>
      var queue = storage(itemStr)
      queue.foreach(item => {
        item.supermarket = supermarket
        item.section = supermarket.warehouse.filter(_.sectionName == item.category).head
      })
    }
  }

  def unloadTruck(): Unit = {
    storage.keys.foreach { itemStr =>
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
