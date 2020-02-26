package meta.example.supermarket

import meta.example.supermarket.categories.{articleName, gram}

import scala.util.Random

object Vegetarian {
  // 1: 1 unit of food (1 agent)
  val randShoppingList: Vector[categoryAmount] = Vector(
    categoryAmount(1, 0, 0, 0, 1),
    categoryAmount(1, 0, 0, 1, 1),
    categoryAmount(3, 0, 2, 2, 0),
    categoryAmount(3, 0, 0, 3, 0),
    categoryAmount(3, 0, 0, 1, 0)
  )

  val mealPlan: Vector[Vector[(articleName, gram)]] = Vector(
    Vector(
      ("Milk", 200),
      ("Cereal", 200),
      ("Egg", 50),
      ("WhiteChocolate", 50)
    ),
    Vector(
      ("Milk", 200),
      ("Oatmeal", 200),
      ("Cheese", 50),
      ("Ferraro", 50)
    ),
    Vector(
      ("Egg", 200),
      ("Cheese", 50),
      ("Bread", 100),
      ("Yogurt", 100),
      ("Ferraro", 50)
    ),
    Vector(
      ("Carrots", 100),
      ("Tomato", 100),
      ("Cheese", 50),
      ("Spaghetti", 100),
      ("Kitkat", 50),
      ("Potato", 100),
      ("Rice", 50)
    ),
    Vector(
      ("Rice", 100),
      ("Eggplant", 200),
      ("Tomato", 100),
      ("Onion", 50),
      ("WhiteChocolate", 50)
    ),
    Vector(
      ("Cream", 100),
      ("Broccoli", 100),
      ("Cucumber", 100),
      ("Celery", 100),
      ("Potato", 100),
      ("DarkChocolate", 50)
    ),
    Vector(
      ("Yogurt", 100),
      ("Mushroom", 100),
      ("Squash", 100),
      ("Cabbage", 100),
      ("Noodles", 100),
      ("Onion", 50),
      ("WhiteChocolate", 100)
    ),
    Vector(
      ("Spaghetti", 200),
      ("Tomato", 100),
      ("Cheese", 100),
      ("Onion", 50),
      ("DarkChocolate", 50)
    )
  )

  def getRandShoppingList(listNum: Int = 1): categoryAmount = {
    randShoppingList(Random.nextInt(randShoppingList.size))
  }
}
