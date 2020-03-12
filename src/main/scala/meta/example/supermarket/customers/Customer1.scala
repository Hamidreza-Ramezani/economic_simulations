package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions
import squid.quasi.lift
import scala.util.Random
import meta.example.supermarket.{Supermarket, granularity}
import scala.collection.mutable.ListBuffer

/* Auto generated from genCustomers */
@lift
class Customer1 extends People with Weekly with MealPlan1 with ImpulseShopper {
  //  def isAllItemsScanned(): Boolean = {
  //    this.basket.foreach(item => {
  //      if (item.state.get != "isPurchased") {
  //        return false
  //      }
  //    })
  //    true
  //  }
  def main(): Unit = {
    while (true) {
      customerInfo
      //these functions should add the items to toBeScannedItems
      addListedItemsToBasket(shoppingList.targetItems, (Random.nextFloat < priceConscious))
      addRandItemsToBasket(shoppingList.randItems)
      Supermarket.store.toBeScannedItems.enqueue(basket)
      //basket is full, now it should be added to the toBeScannedItem
      while (basket.exists(item => item.state.get != "isPurchased")) {
        SpecialInstructions.waitTurns(1)
      }
      customerInfo
      basket.toList.foreach(item => {
        println("Customer bought food " + item.name + " id: " + item.id)
        fridge.add(item)
      })
      basket = ListBuffer()
      SpecialInstructions.waitTurns(1)
      // while (! all_Items_Scanned){
      // specialInstructions.waitTurns(1)
      // }
      List.range(0, frequency).foreach(_ => {
        consumeFood(mealPlan)
        consumeFood
        customerInfo
        if (basket.size > 0) {
          //now it should be added to the toBeScannedItems
          Supermarket.store.toBeScannedItems.enqueue(basket)
          while (basket.exists(item => item.state.get != "isPurchased")) {
            SpecialInstructions.waitTurns(1)
          }
          customerInfo
          basket.toList.foreach(item => {
            println("Customer bought food " + item.name + " id: " + item.id)
            fridge.add(item)
          })
          basket = ListBuffer()
        }
        SpecialInstructions.waitTurns(12)
      })
    }
  }
}