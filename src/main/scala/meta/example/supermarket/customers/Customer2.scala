package meta.example.supermarket.people

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
  var employee: Employee = null

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
        while (employee.state.get == "reFillingShelves") {
          println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
          println()
          SpecialInstructions.waitTurns(1)
        }
        addListedItemsToBasket(Vector((pair._1, pair._2)))
      }
    })
  }

  def main(): Unit = {
    while (true) {
      customerInfo
      //these functions should add the items to toBeScannedItems
      while (employee.state.get == "reFillingShelves"){
        println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
        println()
        SpecialInstructions.waitTurns(1)
      }

      addListedItemsToBasket(shoppingList.targetItems, (Random.nextFloat < priceConscious))
      addRandItemsToBasket(shoppingList.randItems)
      println()
      Supermarket.store.toBeScannedItems.enqueue(basket)
      //basket is full, now it should be added to the toBeScannedItem
      while (basket.exists(item => item.state.get != "isPurchased")) {
        println("Customer's Actor id " + id + " is waiting for the cashier to scan items")
        println()
        SpecialInstructions.waitTurns(1)
      }
      customerInfo
      basket.toList.foreach(item => {
        println("Customer bought food " + item.name + " id: " + item.id)
        fridge.add(item)
      })
      customerInfo
      basket = ListBuffer()
      SpecialInstructions.waitTurns(1)
      // while (! all_Items_Scanned){
      // specialInstructions.waitTurns(1)
      // }
      List.range(0, frequency).foreach(_ => {
        consumeFood1(mealPlan)
        consumeFood1
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
