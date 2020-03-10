package meta.example.supermarket.people

import meta.classLifting.SpecialInstructions
import squid.quasi.lift
import scala.util.Random
import meta.example.supermarket.granularity


/* Auto generated from genCustomers */

@lift
class Customer1 extends People with Weekly with MealPlan1 with ImpulseShopper {

  def isAllItemsScanned(): Boolean = {
    this.basket.foreach(item => {
      if (item.state.get != "isPurchased") {
        return false
      }
    })
    return true
  }

  def main(): Unit = {
    while (true) {
      customerInfo


      //these functions should add the items to toBeScannedItems

      addListedItemsToBasket(shoppingList.targetItems, (Random.nextFloat < priceConscious))
      addRandItemsToBasket(shoppingList.randItems)

      while (!isAllItemsScanned()) {
        SpecialInstructions.waitTurns(1)
      }

      basket.foreach(item => {
        println("Customer bought food " + item.name)
        this.fridge.add(item)
      })
      basket = List()


      // here there should be an if condition that checks whether all items are scanned or not
      // while (! all_Items_Scanned){
      // specialInstructions.waitTurns(1)
      // }


      //buyListedItems(shoppingList.targetItems, (Random.nextFloat < priceConscious))
      //buyRandItems(shoppingList.randItems)
      //those two above functions should only print that customer purchased the foods. without their item id


      List.range(0, frequency).foreach(_ => {
        consumeFood(mealPlan)
        consumeFood
        customerInfo
        SpecialInstructions.waitTurns(24)
      })
    }
  }
}