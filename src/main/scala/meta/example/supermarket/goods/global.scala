package meta.example.supermarket.goods

import java.util.Random
import scala.math.BigDecimal

import scala.collection.mutable

/**
  * This singleton object contains global variables
  */
object global {
  val totalItems: Int = 32
  val totalItems_test = 11    //for simplicity, one can consider only vegetables for the test and debug which are 11 items overall
  var shelfCapacity: Int = 5

  def getRandomDouble(rangeMin: Double, rangeMax: Double): Double = {
    val r = new Random()
    val randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble
    BigDecimal(randomValue).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  //  val priceMap: mutable.Map[(String, Brand), Double] = mutable.Map(
  //    ("Item1", TerraSuisse) -> getRandomDouble(0.2, 5),
  //    ("Item2", TerraSuisse) -> getRandomDouble(0.2, 5),
  //    ("Item3", TerraSuisse) -> getRandomDouble(0.2, 5),
  //    ("Item4", TerraSuisse) -> getRandomDouble(0.2, 5),
  //    ("Item5", TerraSuisse) -> getRandomDouble(0.2, 5),
  //    ("Item6", TerraSuisse) -> getRandomDouble(0.2, 5),
  //    ("Item7", TerraSuisse) -> getRandomDouble(0.2, 5),
  //    ("Item8", TerraSuisse) -> getRandomDouble(0.2, 5),
  //    ("Item9", TerraSuisse) -> getRandomDouble(0.2, 5),
  //    ("Item10", TerraSuisse) -> getRandomDouble(0.2, 5),
  //    ("Item11", TerraSuisse) -> getRandomDouble(0.2, 5),
  //    ("Item1", Optigal) -> getRandomDouble(0.2, 5),
  //    ("Item2", Optigal) -> getRandomDouble(0.2, 5),
  //    ("Item3", Optigal) -> getRandomDouble(0.2, 5),
  //    ("Item4", Optigal) -> getRandomDouble(0.2, 5),
  //    ("Item5", Optigal) -> getRandomDouble(0.2, 5),
  //    ("Item6", Optigal) -> getRandomDouble(0.2, 5),
  //    ("Item7", Optigal) -> getRandomDouble(0.2, 5),
  //    ("Item8", Optigal) -> getRandomDouble(0.2, 5),
  //    ("Item9", Optigal) -> getRandomDouble(0.2, 5),
  //    ("Item10", Optigal) -> getRandomDouble(0.2, 5),
  //    ("Item11", Optigal) -> getRandomDouble(0.2, 5),
  //    ("Item1", Aha) -> getRandomDouble(0.2, 5),
  //    ("Item2", Aha) -> getRandomDouble(0.2, 5),
  //    ("Item3", Aha) -> getRandomDouble(0.2, 5),
  //    ("Item4", Aha) -> getRandomDouble(0.2, 5),
  //    ("Item5", Aha) -> getRandomDouble(0.2, 5),
  //    ("Item6", Aha) -> getRandomDouble(0.2, 5),
  //    ("Item7", Aha) -> getRandomDouble(0.2, 5),
  //    ("Item8", Aha) -> getRandomDouble(0.2, 5),
  //    ("Item9", Aha) -> getRandomDouble(0.2, 5),
  //    ("Item10", Aha) -> getRandomDouble(0.2, 5),
  //    ("Item11", Aha) -> getRandomDouble(0.2, 5)
  //  )

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

  //  // Aha < TerraSuisse < Optigal
  //  // (itemNum,itemBrand) -> (verticalDifferentiation, horizontalDifferentiation)
  //  val differentiationMap: mutable.Map[(String, Brand), (Double, Double)] = mutable.Map(
  //    ("Item1", TerraSuisse) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item2", TerraSuisse) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item3", TerraSuisse) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item4", TerraSuisse) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item5", TerraSuisse) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item6", TerraSuisse) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item7", TerraSuisse) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item8", TerraSuisse) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item9", TerraSuisse) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item10", TerraSuisse) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item11", TerraSuisse) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item1", Optigal) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item2", Optigal) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item3", Optigal) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item4", Optigal) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item5", Optigal) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item6", Optigal) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item7", Optigal) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item8", Optigal) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item9", Optigal) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item10", Optigal) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item11", Optigal) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item1", Aha) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item2", Aha) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item3", Aha) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item4", Aha) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item5", Aha) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item6", Aha) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item7", Aha) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item8", Aha) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item9", Aha) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item10", Aha) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2)),
  //    ("Item11", Aha) -> (getRandomDouble(0.2, 8), getRandomDouble(0, 2))
  //  )


  /**
    * map's keys: the first element of the tuple is vertical attribute of the product and the second element
    * is the horizontal attribute of the product.
    */
  val differentiationMap: mutable.Map[(String, Brand), (Double, Double)] = mutable.Map(
    ("Item1", TerraSuisse) -> (4.4, getRandomDouble(0, 2)),
    ("Item2", TerraSuisse) -> (3.7, getRandomDouble(0, 2)),
    ("Item3", TerraSuisse) -> (3.9, getRandomDouble(0, 2)),
    ("Item4", TerraSuisse) -> (4.6, getRandomDouble(0, 2)),
    ("Item5", TerraSuisse) -> (3.4, getRandomDouble(0, 2)),
    ("Item6", TerraSuisse) -> (3.3, getRandomDouble(0, 2)),
    ("Item7", TerraSuisse) -> (4.1, getRandomDouble(0, 2)),
    ("Item8", TerraSuisse) -> (4.4, getRandomDouble(0, 2)),
    ("Item9", TerraSuisse) -> (3.5, getRandomDouble(0, 2)),
    ("Item10", TerraSuisse) -> (3.0, getRandomDouble(0, 2)),
    ("Item11", TerraSuisse) -> (3.7, getRandomDouble(0, 2)),
    ("Item1", Optigal) -> (7.8, getRandomDouble(0, 2)),
    ("Item2", Optigal) -> (5.7, getRandomDouble(0, 2)),
    ("Item3", Optigal) -> (5.2, getRandomDouble(0, 2)),
    ("Item4", Optigal) -> (5.1, getRandomDouble(0, 2)),
    ("Item5", Optigal) -> (6.9, getRandomDouble(0, 2)),
    ("Item6", Optigal) -> (3.9, getRandomDouble(0, 2)),
    ("Item7", Optigal) -> (5.8, getRandomDouble(0, 2)),
    ("Item8", Optigal) -> (6.1, getRandomDouble(0, 2)),
    ("Item9", Optigal) -> (4.3, getRandomDouble(0, 2)),
    ("Item10", Optigal) -> (7.0, getRandomDouble(0, 2)),
    ("Item11", Optigal) -> (6.3, getRandomDouble(0, 2)),
    ("Item1", Aha) -> (2.4, getRandomDouble(0, 2)),
    ("Item2", Aha) -> (3.5, getRandomDouble(0, 2)),
    ("Item3", Aha) -> (3.8, getRandomDouble(0, 2)),
    ("Item4", Aha) -> (4.2, getRandomDouble(0, 2)),
    ("Item5", Aha) -> (3.0, getRandomDouble(0, 2)),
    ("Item6", Aha) -> (2.4, getRandomDouble(0, 2)),
    ("Item7", Aha) -> (3.9, getRandomDouble(0, 2)),
    ("Item8", Aha) -> (2.6, getRandomDouble(0, 2)),
    ("Item9", Aha) -> (2.2, getRandomDouble(0, 2)),
    ("Item10", Aha) -> (2.3, getRandomDouble(0, 2)),
    ("Item11", Aha) -> (3.1, getRandomDouble(0, 2))
  )


  //  val priceMap: mutable.Map[(String, Brand), Double] = mutable.Map(
  //    ("Squash", TerraSuisse) -> 2.0,
  //    ("Cabbage", TerraSuisse) -> 0.8,
  //    ("Broccoli", TerraSuisse) -> 0.8,
  //    ("Eggplant", TerraSuisse) -> 2.0,
  //    ("Potato", TerraSuisse) -> 1.5,
  //    ("Celery", TerraSuisse) -> 1.0,
  //    ("Cucumber", TerraSuisse) -> 2.0,
  //    ("Tomato", TerraSuisse) -> 1.5,
  //    ("Onion", TerraSuisse) -> 2.0,
  //    ("Carrots", TerraSuisse) -> 1.0,
  //    ("Mushroom", TerraSuisse) -> 1.0,
  //    ("Squash", Optigal) -> 2.6,
  //    ("Cabbage", Optigal) -> 1.3,
  //    ("Broccoli", Optigal) -> 1.4,
  //    ("Eggplant", Optigal) -> 2.7,
  //    ("Potato", Optigal) -> 2.1,
  //    ("Celery", Optigal) -> 1.3,
  //    ("Cucumber", Optigal) -> 2.7,
  //    ("Tomato", Optigal) -> 1.8,
  //    ("Onion", Optigal) -> 2.5,
  //    ("Carrots", Optigal) -> 1.8,
  //    ("Mushroom", Optigal) -> 1.6,
  //    ("Squash", Aha) -> 1.7,
  //    ("Cabbage", Aha) -> 0.5,
  //    ("Broccoli", Aha) -> 0.6,
  //    ("Eggplant", Aha) -> 1.9,
  //    ("Potato", Aha) -> 1.3,
  //    ("Celery", Aha) -> 0.8,
  //    ("Cucumber", Aha) -> 1.7,
  //    ("Tomato", Aha) -> 1.1,
  //    ("Onion", Aha) -> 1.6,
  //    ("Carrots", Aha) -> 0.9,
  //    ("Mushroom", Aha) -> 0.8
  //  )


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


  /**
    * the keys are items' names and values are items' ids.
    * This map only has vegetables, which is used for test and debug.
    * Please note this id is totally something different from the actor's id.
    */
  val itemNameToID_test: mutable.Map[String, String] = mutable.Map(
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

  /**
    * the complete map of item names to IDs. Please note this id is totally something different from the actor's id.
    */
  val itemNameToID: mutable.Map[String, String] = mutable.Map(
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

  var brands: List[Brand] = global.priceMap.keys.map(_._2).toSet.toList

}