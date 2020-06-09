package meta.example.supermarket.logistics

import meta.deep.runtime.Actor
import meta.example.supermarket.goods.Item

import scala.collection.mutable

trait ManufacturerTrait extends Actor{

  var storage: mutable.Map[String, mutable.Queue[Item]] = mutable.Map(
    "Yogurt" -> new mutable.Queue[Item],
    "Squash" -> new mutable.Queue[Item],
    "Bacon" -> new mutable.Queue[Item],
    "Cheese" -> new mutable.Queue[Item],
    "Ferraro" -> new mutable.Queue[Item],
    "Oatmeal" -> new mutable.Queue[Item],
    "Cabbage" -> new mutable.Queue[Item],
    "Beef" -> new mutable.Queue[Item],
    "Broccoli" -> new mutable.Queue[Item],
    "Noodles" -> new mutable.Queue[Item],
    "Eggplant" -> new mutable.Queue[Item],
    "Potato" -> new mutable.Queue[Item],
    "Celery" -> new mutable.Queue[Item],
    "Kitkat" -> new mutable.Queue[Item],
    "Pasta" -> new mutable.Queue[Item],
    "Cucumber" -> new mutable.Queue[Item],
    "Tomato" -> new mutable.Queue[Item],
    "Cereal" -> new mutable.Queue[Item],
    "Rice" -> new mutable.Queue[Item],
    "DarkChocolate" -> new mutable.Queue[Item],
    "Onion" -> new mutable.Queue[Item],
    "Carrots" -> new mutable.Queue[Item],
    "Cream" -> new mutable.Queue[Item],
    "Lamb" -> new mutable.Queue[Item],
    "WhiteChocolate" -> new mutable.Queue[Item],
    "Bread" -> new mutable.Queue[Item],
    "Pork" -> new mutable.Queue[Item],
    "Mushroom" -> new mutable.Queue[Item],
    "Spaghetti" -> new mutable.Queue[Item],
    "Egg" -> new mutable.Queue[Item],
    "Milk" -> new mutable.Queue[Item],
    "Chicken" -> new mutable.Queue[Item]
  )


}
