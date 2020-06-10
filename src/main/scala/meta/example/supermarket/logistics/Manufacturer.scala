package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}
import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import meta.example.supermarket.goods.Item
import squid.quasi.lift
import scala.collection.mutable

@lift
class Manufacturer(var truck: TruckTrait) extends ManufacturerTrait{

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


  def processFood(): Unit = {
    storage.keys.toList.foreach { itemStr =>
      val queue = storage(itemStr)
      queue.toList.foreach(_ => {
      })
    }
  }


  def loadTruck(): Unit = {
    storage.keys.toList.foreach { itemStr =>
      val queue = storage(itemStr)
      while (queue.nonEmpty) {
        var item = queue.dequeue()
        truck.storage.getOrElse(item.name, new mutable.Queue[Item]) += item
        item.state.inTruck
      }
    }
  }

  def main(): Unit = {
    writer = new PrintWriter(new FileWriter(new File("m/agentManufacturer" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      processFood()
      loadTruck()
      SpecialInstructions.waitTurns(1)
    }
  }
}