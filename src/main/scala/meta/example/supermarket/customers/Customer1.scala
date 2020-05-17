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

  //  def addRandItemsToBasket2(shoppingList: categoryAmount): Unit = {
  //    if (!needBased) {
  //      val foods = utils.ccArgToIntVector(shoppingList)
  //      foods.toList.foreach(
  //        categoryAmountPair => {
  //          List.fill(categoryAmountPair._2)(1).foreach(_ => {
  //            val randFood: String = supermarket.getRandFood(categoryAmountPair._1)
  //            println("Customer's Actor id " + id + " adds random food to the basket! " + randFood)
  //            addToBasket2(randFood)
  //          })
  //        }
  //      )
  //    }
  //  }
  //
  //  def addListedItemsToBasket2(meal: Vector[(articleName, Int)], onBudget: Boolean = true): Unit = {
  //    val shoppingList: Map[String, Int] = toShoppingList(meal).toMap
  //    meal.toList.foreach(articlePair => {
  //      if (fridge.getAmount(articlePair._1) < (frequency * articlePair._2)) {
  //        println("Customer's Actor id " + id + " adds food from shopping list to the basket! " + articlePair._1)
  //        List.fill(shoppingList(articlePair._1))(1).foreach(_ => addToBasket2(articlePair._1, onBudget))
  //      }
  //    })
  //  }
  //
  //  def addToBasket2(itemStr: String, onBudget: Boolean = true): Unit = {
  //    val item: Option[Item] = supermarket.getRequestedItem(itemStr, onBudget)
  //    if (item.isDefined) {
  //      val targetItem = item.get
  //      targetItem.state.addToBasket
  //      basket += targetItem
  //    }
  //  }

  //    def isAllItemsScanned(): Boolean = {
  //        this.basket.foreach(item => {
  //          if (item.state.get != "isPurchased") {
  //            false
  //          }
  //        })
  //        true
  //      }

  def consumeFood2(): Unit = {
    if (fridge.getAvailFood.nonEmpty) {
      var someFood: String = randElement(fridge.getAvailFood)
      println("Customer's Actor id " + id + " consumes random food " + someFood)
      println(" amount " + fridge.consume(someFood, 200))
    }
  }

  // Target consumption behavior
  def consumeFood2(mealPlan: Vector[(articleName, gram)]): Unit = {
    mealPlan.toList.foreach(pair => {
      var consumed: Int = fridge.consume(pair._1, pair._2)
      println("Customer's Actor id " + id + " consumed " + pair._1 + " Amount " + consumed)
      if (consumed < pair._2) {
        println("Not enough food left! Do shopping!")
        while (Supermarket.store.employee.state.get == "reFillingShelves") {
          println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
          println()
          SpecialInstructions.waitTurns(1)
        }
        //        addListedItemsToBasket2(Vector((pair._1, pair._2)))
        addListedItemsToBasket(Vector((pair._1, pair._2)))
      }
    })
  }

  def main(): Unit = {
    var enteredWhileLoop: Boolean = false
    while (true) {
      println("---------------------------------------------------------------------------------------------------")
      customerInfo
      //these functions should add the items to toBeScannedItems
      while (Supermarket.store.employee.state.get == "reFillingShelves") {
        println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
        println("---------------------------------------------------------------------------------------------------")
        enteredWhileLoop = true
        SpecialInstructions.waitTurns(1)
      }
      if (enteredWhileLoop){
        println("---------------------------------------------------------------------------------------------------")
        enteredWhileLoop = false
      }
      //      addListedItemsToBasket2(shoppingList.targetItems, (Random.nextFloat < priceConscious))
      //      addRandItemsToBasket2(shoppingList.randItems)
      addListedItemsToBasket(shoppingList.targetItems, (Random.nextFloat < priceConscious))
      addRandItemsToBasket(shoppingList.randItems)
      println()
      Supermarket.store.toBeScannedItems.enqueue(basket)
      //basket is full, now it should be added to the toBeScannedItem
      while (basket.exists(item => item.state.get != "isPurchased")) {
        println("Customer's Actor id " + id + " is waiting for the cashier to scan items")
        println("---------------------------------------------------------------------------------------------------")
        println()
        SpecialInstructions.waitTurns(1)
      }
      //      customerInfo
      println("---------------------------------------------------------------------------------------------------")
      println("shopping basket of Customer's Actor id " + id + " was scanned")
      basket.toList.foreach(item => {
        println("Customer's Actor id " + id + " bought food " + item.name + " id: " + item.id)
        fridge.add(item)
      })
      customerInfo
      println("---------------------------------------------------------------------------------------------------")
      basket = ListBuffer()
      SpecialInstructions.waitTurns(1)
      //       while (! all_Items_Scanned){
      //       specialInstructions.waitTurns(1)
      //       }

      List.range(0, frequency).foreach(_ => {
        println("---------------------------------------------------------------------------------------------------")
        consumeFood2(mealPlan)
        consumeFood2()
        //        consumeFood(mealPlan)
        //        consumeFood
        customerInfo
        if (basket.isEmpty){
          println("---------------------------------------------------------------------------------------------------")
        }
        if (basket.nonEmpty) {
          //now it should be added to the toBeScannedItems
          Supermarket.store.toBeScannedItems.enqueue(basket)
          while (basket.exists(item => item.state.get != "isPurchased")) {
            println("Customer's Actor id " + id + " is waiting for the cashier to scan items")
            println("---------------------------------------------------------------------------------------------------")
            println()
            SpecialInstructions.waitTurns(1)
          }
          //      customerInfo
          println("---------------------------------------------------------------------------------------------------")
          println("shopping basket of Customer's Actor id " + id + " was scanned")
          basket.toList.foreach(item => {
            println("Customer's Actor id " + id + " bought food " + item.name + " id: " + item.id)
            fridge.add(item)
          })
          customerInfo
          println("---------------------------------------------------------------------------------------------------")
          basket = ListBuffer()
        }
        SpecialInstructions.waitTurns(12)
      })
    }
  }
}