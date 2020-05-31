package meta.example.supermarket.goods

import scala.collection.mutable.Map

object newItemsMap {
  val totalItems: Int = 32

  // goodsName, itemName
  val itemMap: Map[String, String] = Map(
    "Yogurt" -> "Item29",
    "Squash" -> "Item11",
    "Bacon" -> "Item16",
    "Cheese" -> "Item30",
    "Ferraro" -> "Item18",
    "Oatmeal" -> "Item22",
    "Cabbage" -> "Item10",
    "Beef" -> "Item13",
    "Broccoli" -> "Item4",
    "Noodles" -> "Item24",
    "Eggplant" -> "Item1",
    "Potato" -> "Item2",
    "Celery" -> "Item7",
    "Kitkat" -> "Item17",
    "Pasta" -> "Item26",
    "Cucumber" -> "Item5",
    "Tomato" -> "Item8",
    "Cereal" -> "Item21",
    "Rice" -> "Item23",
    "DarkChocolate" -> "Item19",
    "Onion" -> "Item3",
    "Carrots" -> "Item6",
    "Cream" -> "Item31",
    "Lamb" -> "Item15",
    "WhiteChocolate" -> "Item20",
    "Bread" -> "Item27",
    "Pork" -> "Item14",
    "Mushroom" -> "Item9",
    "Spaghetti" -> "Item25",
    "Egg" -> "Item32",
    "Milk" -> "Item28",
    "Chicken" -> "Item12"
  )
  // goodsName, sectionName
  val categoryMap: Map[String, String] = Map(
    "Yogurt" -> "Dairy",
    "Squash" -> "Vegetable",
    "Bacon" -> "Meat",
    "Cheese" -> "Dairy",
    "Ferraro" -> "Snack",
    "Oatmeal" -> "Grain",
    "Cabbage" -> "Vegetable",
    "Beef" -> "Meat",
    "Broccoli" -> "Vegetable",
    "Noodles" -> "Grain",
    "Eggplant" -> "Vegetable",
    "Potato" -> "Vegetable",
    "Celery" -> "Vegetable",
    "Kitkat" -> "Snack",
    "Pasta" -> "Grain",
    "Cucumber" -> "Vegetable",
    "Tomato" -> "Vegetable",
    "Cereal" -> "Grain",
    "Rice" -> "Grain",
    "DarkChocolate" -> "Snack",
    "Onion" -> "Vegetable",
    "Carrots" -> "Vegetable",
    "Cream" -> "Dairy",
    "Lamb" -> "Meat",
    "WhiteChocolate" -> "Snack",
    "Bread" -> "Grain",
    "Pork" -> "Meat",
    "Mushroom" -> "Vegetable",
    "Spaghetti" -> "Grain",
    "Egg" -> "Dairy",
    "Milk" -> "Dairy",
    "Chicken" -> "Meat"
  )
}
