package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import meta.example.supermarket.goods.Item
import squid.quasi.lift

import scala.collection.mutable
import scala.collection.mutable.{Queue, Map}

@lift
class Manufacturer(var truck: Truck) extends Actor {


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

  def processFood(): Unit = {
    storage.keys.foreach { itemStr =>
      var queue = storage(itemStr)
      queue.foreach(item => {
      })
    }
  }

  def loadTruck(): Unit = {
    storage.keys.foreach { itemStr =>
      var queue = storage(itemStr)
      while (queue.nonEmpty) {
        var item = queue.dequeue()
        truck.storage.getOrElse(item.name, new mutable.Queue[Item]) += item
        item.state.inTruck
      }
    }
  }

  def main(): Unit = {
    writer = new PrintWriter(new FileWriter(new File("m/agent" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      processFood()
      loadTruck()
      SpecialInstructions.waitTurns(1)
    }
  }

}
