package meta.example.supermarket.goods

import scala.collection.mutable

object newItemsMap {
  val totalItems: Int = 32
  val totalItems_test = 11

  val priceMap: mutable.Map[(String, Brand), Double] = mutable.Map(
    ("Item1", TerraSuisse) -> 2.0,
    ("Item2", TerraSuisse) -> 0.8,
    ("Item3", TerraSuisse) -> 0.8,
    ("Item4", TerraSuisse) -> 2.0,
    ("Item5", TerraSuisse) -> 1.5,
    ("Item6", TerraSuisse) -> 1.0,
    ("Item7", TerraSuisse) -> 2.0,
    ("Item8", TerraSuisse) -> 1.5,
    ("Item9", TerraSuisse) -> 2.0,
    ("Item10", TerraSuisse) -> 1.0,
    ("Item11", TerraSuisse) -> 1.0,
    ("Item1", Optigal) -> 2.6,
    ("Item2", Optigal) -> 1.3,
    ("Item3", Optigal) -> 1.4,
    ("Item4", Optigal) -> 2.7,
    ("Item5", Optigal) -> 2.1,
    ("Item6", Optigal) -> 1.3,
    ("Item7", Optigal) -> 2.7,
    ("Item8", Optigal) -> 1.8,
    ("Item9", Optigal) -> 2.5,
    ("Item10", Optigal) -> 1.8,
    ("Item11", Optigal) -> 1.6,
    ("Item1", Aha) -> 1.7,
    ("Item2", Aha) -> 0.5,
    ("Item3", Aha) -> 0.6,
    ("Item4", Aha) -> 1.9,
    ("Item5", Aha) -> 1.3,
    ("Item6", Aha) -> 0.8,
    ("Item7", Aha) -> 1.7,
    ("Item8", Aha) -> 1.1,
    ("Item9", Aha) -> 1.6,
    ("Item10", Aha) -> 0.9,
    ("Item11", Aha) -> 0.8
  )


  // goodsName, itemName
//  val itemMap_test: Map[String, String] = Map(
//    "Squash" -> "Item11",
//    "Cabbage" -> "Item10",
//    "Broccoli" -> "Item4",
//    "Eggplant" -> "Item1",
//    "Potato" -> "Item2",
//    "Celery" -> "Item7",
//    "Cucumber" -> "Item5",
//    "Tomato" -> "Item8",
//    "Onion" -> "Item3",
//    "Carrots" -> "Item6",
//    "Mushroom" -> "Item9",
//  )



  val itemMap_test: mutable.Map[String, String] = mutable.Map(
    "Squash" -> "Item11",
    "Cabbage" -> "Item10",
    "Broccoli" -> "Item4",
    "Eggplant" -> "Item1",
    "Potato" -> "Item2",
    "Celery" -> "Item7",
    "Cucumber" -> "Item5",
    "Tomato" -> "Item8",
    "Onion" -> "Item3",
    "Carrots" -> "Item6",
    "Mushroom" -> "Item9",
  )

  // goodsName, itemName
  val itemMap: mutable.Map[String, String] = mutable.Map(
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
  val categoryMap: mutable.Map[String, String] = mutable.Map(
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
