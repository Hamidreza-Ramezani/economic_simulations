package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.categories.{articleName, gram}
import meta.example.supermarket.goods.Item
import meta.example.supermarket.utils.{randElement, toShoppingList}
import squid.quasi.lift

import scala.util.Random
import meta.example.supermarket.{Supermarket, categoryAmount, granularity, utils}

import scala.collection.mutable.ListBuffer

/* Auto generated from genCustomers */
@lift
class Customer1 extends People with Weekly with MealPlan1 with ImpulseShopper {

  def addRandItemsToBasket1(shoppingList: categoryAmount): Unit = {
    if (!needBased) {
      val foods = utils.ccArgToIntVector(shoppingList)
      foods.toList.foreach(
        categoryAmountPair => {
          List.fill(categoryAmountPair._2)(1).foreach(_ => {
            val randFood: String = supermarket.getRandFood(categoryAmountPair._1)
            println("Customer adds random food to the basket! " + randFood)
            //            addToBasket1(randFood)
          })
        }
      )
    }
  }

  def addListedItemsToBasket1(meal: Vector[(articleName, Int)], onBudget: Boolean = true): Unit = {
    val shoppingList: Map[String, Int] = toShoppingList(meal).toMap
    meal.toList.foreach(articlePair => {
      if (fridge.getAmount(articlePair._1) < (frequency * articlePair._2)) {
        println("Customer adds food from shopping list to the basket! " + articlePair._1)
        //        List.fill(shoppingList(articlePair._1))(1).foreach(_ => addToBasket1(articlePair._1, onBudget))
      }
    })
  }

  def addToBasket1(itemStr: String, onBudget: Boolean = true): Unit = {
    val item: Option[Item] = supermarket.getRequestedItem(itemStr, onBudget)
    if (item.isDefined) {
      val targetItem = item.get
      targetItem.state.addToBasket
      basket += targetItem
    }
  }

  //  def isAllItemsScanned(): Boolean = {
  //      this.basket.foreach(item => {
  //        if (item.state.get != "isPurchased") {
  //          false
  //        }
  //      })
  //      true
  //    }

  def consumeFood1: Unit = {
    if (fridge.getAvailFood.size > 0) {
      var someFood: String = randElement(fridge.getAvailFood)
      println("Customer consumes random food " + someFood)
      println(" amount " + fridge.consume(someFood, 200))
    }
  }

  // Target consumption behavior
  def consumeFood1(mealPlan: Vector[(articleName, gram)]): Unit = {
    mealPlan.toList.foreach(pair => {
      var consumed: Int = fridge.consume(pair._1, pair._2)
      println("Customer consumed " + pair._1 + " Amount " + consumed)
      if (consumed < pair._2) {
        println("Not enough food left! Do shopping!")
        while (Supermarket.store.employee.state.get == "reFillingShelves") {
          println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
          println()
          SpecialInstructions.waitTurns(1)
        }
//        addListedItemsToBasket1(Vector((pair._1, pair._2)))
      }
    })
  }

  def main(): Unit = {
    while (true) {
      customerInfo
      //these functions should add the items to toBeScannedItems
      while (Supermarket.store.employee.state.get == "reFillingShelves") {
        println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
        println()
        SpecialInstructions.waitTurns(1)
      }
      addListedItemsToBasket1(shoppingList.targetItems, (Random.nextFloat < priceConscious))
      addRandItemsToBasket1(shoppingList.randItems)
      println()
      Supermarket.store.toBeScannedItems.enqueue(basket)
      //basket is full, now it should be added to the toBeScannedItem
      while (basket.exists(item => item.state.get != "isPurchased")) {
        println("Customer's Actor id " + id + " is waiting for the cashier to scan items")
        println()
        SpecialInstructions.waitTurns(1)
      }
      customerInfo
      println("shopping basket of Customer's Actor id " + id + " was scanned")
      basket.toList.foreach(item => {
        println("Customer bought food " + item.name + " id: " + item.id)
        fridge.add(item)
      })
      customerInfo
      basket = ListBuffer()
      SpecialInstructions.waitTurns(1)
      //       while (! all_Items_Scanned){
      //       specialInstructions.waitTurns(1)
      //       }
      List.range(0, frequency).foreach(_ => {
        consumeFood1(mealPlan)
        consumeFood1
        //        consumeFood(mealPlan)
        //        consumeFood

        customerInfo
        if (basket.size > 0) {
          //now it should be added to the toBeScannedItems
          Supermarket.store.toBeScannedItems.enqueue(basket)
          while (basket.exists(item => item.state.get != "isPurchased")) {
            println("Customer's Actor id " + id + " is waiting for the cashier to scan items")
            println()
            SpecialInstructions.waitTurns(1)
          }
          customerInfo
          println("shopping basket of Customer's Actor id " + id + " was scanned")
          basket.toList.foreach(item => {
            println("Customer bought food " + item.name + " id: " + item.id)
            fridge.add(item)
          })
          customerInfo
          basket = ListBuffer()
        }
        SpecialInstructions.waitTurns(12)
      })
    }
  }
}