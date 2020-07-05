package meta.example.supermarket.people

import meta.example.supermarket.categories.{articleName, gram}
import meta.example.supermarket.{Carnivore, ShoppingList, Vegetarian, categoryAmount}

/* Auto generated from genMealPlans */

sealed trait MealPlan{
  val preference: String = this.getClass.getSimpleName
  val mealCnt: Int
  val meal: Vector[(articleName, gram)]
  val randShoppingList: categoryAmount
  val shoppingList: ShoppingList
}


case object MealPlan_Dummy1 extends MealPlan{
//  val preference: String = this.getClass.getSimpleName
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(8).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = categoryAmount(1, 0, 0, 0, 0)
  //  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}

case object MealPlan_Dummy2 extends MealPlan{
//  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(9).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = categoryAmount(1, 0, 0, 0, 0)
  //  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}

case object MealPlan_Dummy3 extends MealPlan{
//  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(10).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = categoryAmount(1, 0, 0, 0, 0)
  //  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}

case object MealPlan1 extends MealPlan{
//  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(0).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}

case object MealPlan2 extends MealPlan{
//  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(1).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}


case object MealPlan3 extends MealPlan{
//  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(2).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}


case object MealPlan4 extends MealPlan{
//  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(3).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}


case object MealPlan5 extends MealPlan{
//  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(4).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}


case object MealPlan6 extends MealPlan{
//  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(5).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}


case object MealPlan7 extends MealPlan{
//  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(6).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}


case object MealPlan8 extends MealPlan{
//  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(7).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}


case object MealPlan9 extends MealPlan{
//  val preference: String = "Carnivore"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(0).flatMap(num => Carnivore.mealPlan(num))
  val randShoppingList: categoryAmount = Carnivore.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}


case object MealPlan10 extends MealPlan{
//  val preference: String = "Carnivore"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(1).flatMap(num => Carnivore.mealPlan(num))
  val randShoppingList: categoryAmount = Carnivore.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}


case object MealPlan11 extends MealPlan{
//  val preference: String = "Carnivore"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(2).flatMap(num => Carnivore.mealPlan(num))
  val randShoppingList: categoryAmount = Carnivore.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}


case object MealPlan12 extends MealPlan{
//  val preference: String = "Carnivore"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(3).flatMap(num => Carnivore.mealPlan(num))
  val randShoppingList: categoryAmount = Carnivore.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}


case object MealPlan13 extends MealPlan{
//  val preference: String = "Carnivore"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(4).flatMap(num => Carnivore.mealPlan(num))
  val randShoppingList: categoryAmount = Carnivore.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}


case object MealPlan14 extends MealPlan{
//  val preference: String = "Carnivore"
  val mealCnt: Int = 1
  val meal: Vector[(articleName, gram)] = Vector(5).flatMap(num => Carnivore.mealPlan(num))
  val randShoppingList: categoryAmount = Carnivore.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, meal)
}

object mealPlanSummary {
  val total: Int = 14

  val mealPlanMap: Map[(String, Int), Vector[String]] = Map(
    ("Carnivore", 1) -> Vector("MealPlan9", "MealPlan10", "MealPlan11", "MealPlan12", "MealPlan13", "MealPlan14"),
    ("Vegetarian", 1) -> Vector("MealPlan1", "MealPlan2", "MealPlan3", "MealPlan4", "MealPlan5", "MealPlan6", "MealPlan7", "MealPlan8")
  )
}
