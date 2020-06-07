package meta.example.supermarket.logistics

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.Item

import scala.collection.mutable.{ListBuffer, Map}

class Truck(var supermarket: SupermarketTrait) {
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

  def unload(): Unit = {

  }

  def main(): Unit = {
    writer = new PrintWriter(new FileWriter(new File("m/agent" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      unload()
      SpecialInstructions.waitTurns(1)
    }
  }


}
