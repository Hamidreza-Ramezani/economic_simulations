package meta.example.supermarket.people

import meta.deep.runtime.Actor
import meta.example.supermarket._
import meta.example.supermarket.categories.{articleName, getArticleUnit, gram}
import meta.example.supermarket.goods.Item
import meta.example.supermarket.utils.{randElement, toShoppingList}
import meta.example.supermarket.worldmap.WorldTrait
import scala.collection.mutable.ListBuffer

trait People extends Actor {

  var world: WorldTrait
  val frequency: Int
  val priceConscious: Double
  var basket: ListBuffer[Item] = ListBuffer[Item]()
  val needBased: Boolean
  val shoppingList: ShoppingList
  val mealPlan: Vector[(articleName, gram)]
  val preference: String
  val mealCnt: Int
  var supermarkets: ListBuffer[SupermarketTrait]
  //  assert(supermarket.vegetables.size > 1) // store has been properly initialized
  val fridge: Fridge = new Fridge


  //todo refactor it
  def pickSupermarket(): SupermarketTrait = {
    writer.write("The distance of customer " + id + " from close supermarkets are:" + "\n")
    println("The distance of customer " + id + " from close supermarkets are:")
    var selectedSupermarket = supermarkets.head
    var minDistance: Int = world.height * world.width
    supermarkets.foreach {
      supermarket =>
        var distance = actualDistanceFrom(world, supermarket)
        writer.write("supermarket id " + supermarket.id + " Distance: " + distance + "\n")
        println("supermarket id " + supermarket.id + " Distance: " + distance)
        if (distance < minDistance) {
          minDistance = distance
          selectedSupermarket = supermarket
        }
    }
    writer.write("customer " + id + " chose supermarket " + selectedSupermarket.id + "\n")
    println("customer " + id + " chose supermarket " + selectedSupermarket.id)
    selectedSupermarket
  }


  def addRandItemsToBasket(shoppingList: categoryAmount, pickedSupermarket: SupermarketTrait): Unit = {
    if (!needBased) {
      val foods = utils.ccArgToVector(shoppingList)
      foods.foreach(
        categoryAmountPair => {
          1.to(categoryAmountPair._2.asInstanceOf[Int]).foreach(_ => {
            val randFood: String = pickedSupermarket.getRandFood(categoryAmountPair._1.capitalize)
            if (this.writer != null) {
              writer.write("Customer's Actor id " + id + " adds random food to the basket! " + randFood + "\n")
            }
            println("Customer's Actor id " + id + " adds random food to the basket! " + randFood)
            addToBasket(randFood, pickedSupermarket)
          })
        }
      )
    }
  }

  def addListedItemsToBasket(meal: Vector[(articleName, Int)], pickedSupermarket: SupermarketTrait, onBudget: Boolean = true): Unit = {
    val shoppingList: Map[String, Int] = toShoppingList(meal).toMap
    meal.foreach(articlePair => {
      if (fridge.getAmount(articlePair._1) < (frequency * articlePair._2)) {
        if (this.writer != null) {
          writer.write("Customer's Actor id " + id + " adds food from shopping list to the basket! " + articlePair._1 + "\n")
        }
        println("Customer's Actor id " + id + " adds food from shopping list to the basket! " + articlePair._1)
        1.to(shoppingList(articlePair._1)).foreach(_ => addToBasket(articlePair._1, pickedSupermarket, onBudget))
      }
    })
  }

  def addToBasket(item: String, pickedSupermarket: SupermarketTrait, onBudget: Boolean = true): Unit = {
    //if supermarket's section was busy, the customer has to wait
    val requestedItem: Item = pickedSupermarket.getRequestedItem(item, onBudget)
    if (item != null) {
      requestedItem.state.addToBasket
      basket += requestedItem
    }
  }


  //  def addRandItemsToBasket(shoppingList: categoryAmount): Unit = {
  //    if (!needBased) {
  //      val foods = utils.ccArgToIntVector(shoppingList)
  //      foods.toList.foreach(
  //        categoryAmountPair => {
  //          List.fill(categoryAmountPair._2)(1).foreach(_ => {
  //            val randFood: String = supermarket.getRandFood(categoryAmountPair._1)
  //            println("Customer's Actor id " + id + " adds random food to the basket! " + randFood)
  //            addToBasket(randFood, onBudget = true)
  //          })
  //        }
  //      )
  //    }
  //  }
  //
  //  def addListedItemsToBasket(meal: Vector[(articleName, Int)], onBudget: Boolean): Unit = {
  //    val shoppingList: Map[String, Int] = toShoppingList(meal).toMap
  //    meal.toList.foreach(articlePair => {
  //      if (fridge.getAmount(articlePair._1) < (frequency * articlePair._2)) {
  //        println("Customer's Actor id " + id + " adds food from shopping list to the basket! " + articlePair._1)
  //        List.fill(shoppingList(articlePair._1))(1).foreach(_ => addToBasket(articlePair._1, onBudget))
  //      }
  //    })
  //  }
  //
  //  def addToBasket(itemStr: String, onBudget: Boolean): Unit = {
  //    val item: Option[Item] = supermarket.getRequestedItem(itemStr, onBudget)
  //    if (item.isDefined) {
  //      val targetItem = item.get
  //      targetItem.state.addToBasket
  //      basket += targetItem
  //    }
  //  }

  // Random consumption behavior
  def consumeRandomFood(): Unit = {
    if (fridge.getAvailFood.nonEmpty) {
      val someFood: String = randElement(fridge.getAvailFood)
      println("Customer's Actor id " + id + " consumed random food " + someFood)
      println(" amount " + fridge.consume(someFood, 200))
    }
  }

  // Target consumption behavior
  def consumeFood(mealPlan: Vector[(articleName, gram)]): Unit = {
    mealPlan.foreach(pair => {
      val consumed: Int = fridge.consume(pair._1, pair._2)
      println("Customer's Actor id " + id + " consumed " + pair._1 + " Amount " + consumed)
      if (consumed < pair._2) {
        println("Not enough food left! Do shopping!")
        //        addListedItemsToBasket(Vector((pair._1, pair._2)))
        var pickedSupermarket = pickSupermarket()
        addListedItemsToBasket(Vector((pair._1, pair._2)), pickedSupermarket)
      }
    })
  }

  def customerInfo: Unit = {
    println()
    println("Customer's Actor id " + id + " frequency " + frequency + "\nfridge " + fridge)
    println()
  }

  override def toString: String = {
    "Customer's Actor id " + id + " frequency " + frequency + "\nfridge " + fridge
  }

}
