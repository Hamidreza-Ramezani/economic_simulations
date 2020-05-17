package meta.example.supermarket.people

import java.io.{File, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.categories.{articleName, gram}
import meta.example.supermarket.utils.randElement
import squid.quasi.lift

import scala.util.Random
import meta.example.supermarket.{Supermarket, granularity}

import scala.collection.mutable.ListBuffer


/* Auto generated from genCustomers */

@lift
class Customer2 extends People with Weekly with MealPlan2 with ImpulseShopper {
  //  var employee: Employee = null

  def consumeFood1(): Unit = {
    if (fridge.getAvailFood.size > 0) {
      var someFood: String = randElement(fridge.getAvailFood)
      println("Customer's Actor id " + id + " consumes random food " + someFood)
      println(" amount " + fridge.consume(someFood, 200))
    }
  }

  // Target consumption behavior
  def consumeFood1(mealPlan: Vector[(articleName, gram)]): Unit = {
    mealPlan.toList.foreach(pair => {
      var consumed: Int = fridge.consume(pair._1, pair._2)
      println("Customer's Actor id " + id + " consumed " + pair._1 + " Amount " + consumed)
      if (consumed < pair._2) {
        println("Not enough food left! Do shopping!")
        //        while (employee.state.get == "reFillingShelves") {
        //          println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
        //          println()
        //          SpecialInstructions.waitTurns(1)
        //        }
        while (Supermarket.store.employee.state.get == "reFillingShelves") {
          println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
          println()
          SpecialInstructions.waitTurns(1)
        }
        addListedItemsToBasket(Vector((pair._1, pair._2)))
      }
    })
  }

  def main(): Unit = {
    var enteredWhileLoop: Boolean = false
    writer = new PrintWriter(new File("Customer2" ))

    while (true) {
      println("---------------------------------------------------------------------------------------------------")
      customerInfo
      //these functions should add the items to toBeScannedItems
      //      while (employee.state.get == "reFillingShelves"){
      //        println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
      //        println()
      //        SpecialInstructions.waitTurns(1)
      //      }
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
      // while (! all_Items_Scanned){
      // specialInstructions.waitTurns(1)
      // }
      List.range(0, frequency).foreach(_ => {
        println("---------------------------------------------------------------------------------------------------")
        consumeFood1(mealPlan)
        consumeFood1()
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
