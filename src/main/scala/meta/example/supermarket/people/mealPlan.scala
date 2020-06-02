package meta.example.supermarket.people

import meta.example.supermarket.categories.{articleName, gram}
import meta.example.supermarket.{Carnivore, ShoppingList, Vegetarian, categoryAmount}

/* Auto generated from genMealPlans */


trait MealPlan_Dummy1 {
  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(8).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = categoryAmount(1, 0, 0, 0, 0)
  //  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}

trait MealPlan_Dummy2 {
  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(9).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = categoryAmount(1, 0, 0, 0, 0)
  //  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}

trait MealPlan_Dummy3 {
  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(10).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = categoryAmount(1, 0, 0, 0, 0)
  //  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}

trait MealPlan1 {
  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(0).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}

trait MealPlan2 {
  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(1).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}


trait MealPlan3 {
  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(2).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}


trait MealPlan4 {
  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(3).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}


trait MealPlan5 {
  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(4).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}


trait MealPlan6 {
  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(5).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}


trait MealPlan7 {
  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(6).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}


trait MealPlan8 {
  val preference: String = "Vegetarian"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(7).flatMap(num => Vegetarian.mealPlan(num))
  val randShoppingList: categoryAmount = Vegetarian.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}


trait MealPlan9 {
  val preference: String = "Carnivore"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(0).flatMap(num => Carnivore.mealPlan(num))
  val randShoppingList: categoryAmount = Carnivore.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}


trait MealPlan10 {
  val preference: String = "Carnivore"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(1).flatMap(num => Carnivore.mealPlan(num))
  val randShoppingList: categoryAmount = Carnivore.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}


trait MealPlan11 {
  val preference: String = "Carnivore"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(2).flatMap(num => Carnivore.mealPlan(num))
  val randShoppingList: categoryAmount = Carnivore.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}


trait MealPlan12 {
  val preference: String = "Carnivore"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(3).flatMap(num => Carnivore.mealPlan(num))
  val randShoppingList: categoryAmount = Carnivore.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}


trait MealPlan13 {
  val preference: String = "Carnivore"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(4).flatMap(num => Carnivore.mealPlan(num))
  val randShoppingList: categoryAmount = Carnivore.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}


trait MealPlan14 {
  val preference: String = "Carnivore"
  val mealCnt: Int = 1
  val mealPlan: Vector[(articleName, gram)] = Vector(5).flatMap(num => Carnivore.mealPlan(num))
  val randShoppingList: categoryAmount = Carnivore.getRandShoppingList()
  val shoppingList: ShoppingList = new ShoppingList(randShoppingList, mealPlan)
}

object mealPlanSummary {
  val total: Int = 14

  val mealPlanMap: Map[(String, Int), Vector[String]] = Map(
    ("Carnivore", 1) -> Vector("MealPlan9", "MealPlan10", "MealPlan11", "MealPlan12", "MealPlan13", "MealPlan14"),
    ("Vegetarian", 1) -> Vector("MealPlan1", "MealPlan2", "MealPlan3", "MealPlan4", "MealPlan5", "MealPlan6", "MealPlan7", "MealPlan8")
  )
}
