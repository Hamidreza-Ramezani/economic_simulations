package meta.example.supermarket.people

import java.io._

import meta.deep.runtime.Actor
import meta.example.supermarket._
import meta.example.supermarket.categories.{articleName, getArticleUnit, gram}
import meta.example.supermarket.goods.Item
import meta.example.supermarket.utils.{randElement, toShoppingList}

import scala.collection.mutable.ListBuffer

trait People extends Actor {
  //  val age: Int
  val frequency: Int
  val priceConscious: Double
  var basket: ListBuffer[Item] = ListBuffer[Item]()
  val needBased: Boolean
  val shoppingList: ShoppingList
  val mealPlan: Vector[(articleName, gram)]
  val preference: String
  val mealCnt: Int
  var supermarket: Supermarket = Supermarket.store
  assert(supermarket.vegetables.size > 1) // store has been properly initialized
  val fridge: Fridge = new Fridge
  var writer: PrintWriter = null

  def addRandItemsToBasket(shoppingList: categoryAmount): Unit = {
    if (!needBased) {
      val foods = utils.ccArgToVector(shoppingList)
      foods.foreach(
        categoryAmountPair => {
          1.to(categoryAmountPair._2.asInstanceOf[Int]).foreach(_ => {
            val randFood: String = supermarket.getRandFood(categoryAmountPair._1)
            writer.write("Customer's Actor id " + id + " adds random food to the basket! " + randFood)
            println("Customer's Actor id " + id + " adds random food to the basket! " + randFood)
            addToBasket(randFood)
          })
        }
      )
    }
  }

  def addListedItemsToBasket(meal: Vector[(articleName, Int)], onBudget: Boolean = true): Unit = {
    val shoppingList: Map[String, Int] = toShoppingList(meal).toMap
    meal.foreach(articlePair => {
      if (fridge.getAmount(articlePair._1) < (frequency * articlePair._2)) {
        writer.write("Customer's Actor id " + id + " adds food from shopping list to the basket! " + articlePair._1)
        println("Customer's Actor id " + id + " adds food from shopping list to the basket! " + articlePair._1)
        1.to(shoppingList(articlePair._1)).foreach(_ => addToBasket(articlePair._1, onBudget))
      }
    })
  }

  def addToBasket(item: String, onBudget: Boolean = true): Unit = {
    supermarket.getRequestedItem(item, onBudget) match {
      case Some(item1) =>
        item1.state.addToBasket
        basket += item1
      //        Supermarket.store.toBeScannedItems.enqueue(item1)
      //        fridge.add(item1)

      case None =>
    }
    //    supermarket.sell(item, onBudget) match {
    //      case Some(item) => fridge.add(item)
    //      case None =>
    //    }
  }

  // Random consumption behavior
  def consumeFood: Unit = {
    if (fridge.getAvailFood.size > 0) {
      val someFood: String = randElement(fridge.getAvailFood)
      println("Customer's Actor id " + id + " consumes random food " + someFood)
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
        addListedItemsToBasket(Vector((pair._1, pair._2)))
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
