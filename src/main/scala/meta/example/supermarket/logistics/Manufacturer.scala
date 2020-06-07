package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import meta.example.supermarket.goods.Item
import squid.quasi.lift

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Map}

@lift
class Manufacturer(var truck: Truck) extends Actor {

  val size = 10
  var storage: Map[String, ListBuffer[Item]] = Map(
    "Yogurt" -> ListBuffer[Item],
    "Squash" -> ListBuffer[Item],
    "Bacon" -> ListBuffer[Item],
    "Cheese" -> ListBuffer[Item],
    "Ferraro" -> ListBuffer[Item],
    "Oatmeal" -> ListBuffer[Item],
    "Cabbage" -> ListBuffer[Item],
    "Beef" -> ListBuffer[Item],
    "Broccoli" -> ListBuffer[Item],
    "Noodles" -> ListBuffer[Item],
    "Eggplant" -> ListBuffer[Item],
    "Potato" -> ListBuffer[Item],
    "Celery" -> ListBuffer[Item],
    "Kitkat" -> ListBuffer[Item],
    "Pasta" -> ListBuffer[Item],
    "Cucumber" -> ListBuffer[Item],
    "Tomato" -> ListBuffer[Item],
    "Cereal" -> ListBuffer[Item],
    "Rice" -> ListBuffer[Item],
    "DarkChocolate" -> ListBuffer[Item],
    "Onion" -> ListBuffer[Item],
    "Carrots" -> ListBuffer[Item],
    "Cream" -> ListBuffer[Item],
    "Lamb" -> ListBuffer[Item],
    "WhiteChocolate" -> ListBuffer[Item],
    "Bread" -> ListBuffer[Item],
    "Pork" -> ListBuffer[Item],
    "Mushroom" -> ListBuffer[Item],
    "Spaghetti" -> ListBuffer[Item],
    "Egg" -> ListBuffer[Item],
    "Milk" -> ListBuffer[Item],
    "Chicken" -> ListBuffer[Item]
  )

  def loadTruck():Unit = {

  }

  def main(): Unit = {
    writer = new PrintWriter(new FileWriter(new File("m/agent" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {

      loadTruck();
      SpecialInstructions.waitTurns(1)
    }
  }

}
