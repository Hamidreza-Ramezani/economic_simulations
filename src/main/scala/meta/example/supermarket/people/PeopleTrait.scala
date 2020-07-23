package meta.example.supermarket.people

import meta.deep.runtime.Actor
import meta.example.supermarket._
import meta.example.supermarket.categories.{articleName, gram}
import meta.example.supermarket.goods.global.getRandomDouble
import meta.example.supermarket.goods.{Brand, Item, global, inBasket}
import meta.example.supermarket.utils.utilities
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

trait People extends Actor {

  var supermarkets: ListBuffer[SupermarketTrait]
  val fridge: Fridge = new Fridge
  var world: WorldTrait
  val frequency: Int
  var budget: Double = 2000
  val priceConscious: Double
  var basket: ListBuffer[Item] = ListBuffer[Item]()
  val needBased: Boolean
  var mealPlan: MealPlan
  var qualitySensitivityIndex: Double = getRandomDouble(0, 1)
  var taste: Double = getRandomDouble(0, 2)


  override def getString(): String = {
    "\n \n" + "timer: " + timer + "\n \n" + "position: x = " + currentXPosition + "  y = " + currentYPosition + "\n \n" + toString
  }


  /**
    *
    * @param itemName The item's name like "Egg". It does not provide any info about the brand of the item.
    * @return a list of pairs. The first element of each tuple is brand and the second element is the satisfaction
    *         gained by consuming the item from that brand. This list is sorted by the second element of each pair
    *         in descending order.
    */
  def prioritizeBrands(itemName: String, pickedSupermarket: SupermarketTrait): ListBuffer[(Brand, Double)] = {
    val itemNum: String = global.itemNameToID.getOrElse(itemName, "")
    var brandsToUtilityMap1: Map[Brand, Double] = Map()
    var brandsToUtilityMap2: Map[Brand, Double] = Map()
    global.brands.foreach {
      brand =>
        if (pickedSupermarket.seeRequestedItem(itemName, brand) != null) {
          brandsToUtilityMap1 += (brand -> getUtility(pickedSupermarket.seeRequestedItem(itemName, brand)))
        }
    }
    global.brands.foreach {
      brand =>
        brandsToUtilityMap2 += (brand -> getUtility(itemNum, brand))
    }
    val sortedList1 = brandsToUtilityMap1.toSeq.sortBy(_._2).reverse
    val sortedList2 = brandsToUtilityMap2.toSeq.sortBy(_._2).reverse

    writer.write("Customer's Actor id " + id + " brands' preference for item " + itemName + " is: \n\n")
    sortedList1.foreach {
      pair =>
        writer.write("brand: " + pair._1 + "  utility: " + pair._2 + "\n")
    }
    writer.write("\n\n")

    if (sortedList1.map(_._1) != sortedList2.map(_._1)) {
      writer.write("If there was no auction: Customer's Actor id " + id + " brands' preference for item " + itemName + " is: \n\n")
      sortedList2.foreach {
        pair =>
          writer.write("brand: " + pair._1 + "  utility: " + pair._2 + "\n")
      }
      writer.write("\n\n")
    }
    if (sortedList1.isEmpty) {
      return sortedList2.to[ListBuffer]
    }
    sortedList1.to[ListBuffer]
  }

  /**
    *
    * @param itemNum The item's name like "Egg". It does not provide any info about the brand of the item.
    * @param brand   The brand's name like samsung.
    * @return the satisfaction gained by consuming the item from that particular brand.
    */
  def getUtility(itemNum: String, brand: Brand): Double = {
    val itemVerticalDifferentiation = global.differentiationMap((itemNum, brand))._1
    val itemHorizontalDifferentiation = global.differentiationMap((itemNum, brand))._2
    val itemPrice = global.priceMap((itemNum, brand))
    val verticalUtility = qualitySensitivityIndex * itemVerticalDifferentiation
    val horizontalUtility = (taste - itemHorizontalDifferentiation).abs
    val netUtility = verticalUtility - horizontalUtility - itemPrice
    netUtility
  }


  /**
    * overloaded getUtility
    *
    * @param item
    * @return
    */
  def getUtility(item: Item): Double = {
    val itemNum: String = global.itemNameToID.getOrElse(item.name, "")
    val itemVerticalDifferentiation = global.differentiationMap((itemNum, item.brand))._1
    val itemHorizontalDifferentiation = global.differentiationMap((itemNum, item.brand))._2
    val itemPrice = item.price
    val verticalUtility = qualitySensitivityIndex * itemVerticalDifferentiation
    val horizontalUtility = (taste - itemHorizontalDifferentiation).abs
    val netUtility = verticalUtility - horizontalUtility - itemPrice
    netUtility
  }


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
      val foods = utilities.ccArgToVector(shoppingList)
      foods.foreach(
        categoryAmountPair => {
          1.to(categoryAmountPair._2.asInstanceOf[Int]).foreach { _ =>
            val randFood: String = pickedSupermarket.getRandFood(categoryAmountPair._1.capitalize)
            val brands = prioritizeBrands(randFood, pickedSupermarket)
            val it = brands.iterator
            var brand: Brand = brands.head._1
            breakable {
              while (it.hasNext) {
                brand = it.next()._1
                if (!pickedSupermarket.hasItem(randFood, brand)) {
                  writer.write("Customer's Actor id " + id + " could not find enough " + randFood + " brand: " + brand + "\n")
                }
                else {
                  break()
                }
              }
            }
            val itemWasAvailable: Boolean = addToBasket(randFood, brand, pickedSupermarket)
            if (itemWasAvailable) {
              writer.write("Customer's Actor id " + id + " adds random food " + randFood + " brand: " + brand + "\n")
              println("Customer's Actor id " + id + " adds random food " + randFood + " brand: " + brand)
            }

          }
        }
      )
    }
  }

  def addListedItemsToBasket(meal: Vector[(articleName, Int)], pickedSupermarket: SupermarketTrait, onBudget: Boolean = true): Unit = {
    val shoppingList: Map[String, Int] = utilities.toShoppingList(meal).toMap
    meal.foreach(articlePair => {
      val neededAmountToBuy: Int = frequency * articlePair._2 - fridge.getAmount(articlePair._1)
      var i = 0
      val brands = prioritizeBrands(articlePair._1, pickedSupermarket)
      breakable {
        while (i < neededAmountToBuy) {
          1.to(shoppingList(articlePair._1)).foreach { _ =>
            //            val brands = prioritizeBrands(articlePair._1)
            val it = brands.iterator
            var brand: Brand = brands.head._1
            breakable {
              //define an iterator here
              while (it.hasNext) {
                brand = it.next()._1
                if (!pickedSupermarket.hasItem(articlePair._1, brand)) {
                  writer.write("Customer's Actor id " + id + " could not find enough " + articlePair._1 + " brand: " + brand + "\n")
                }
                else {
                  break()
                }
              }
            }
            val itemWasAvailable: Boolean = addToBasket(articlePair._1, brand, pickedSupermarket)
            if (itemWasAvailable) {
              i += articlePair._2
              if (this.writer != null) {
                writer.write("Customer's Actor id " + id + " adds food from shopping list to the basket! " + articlePair._1 + " brand: " + brand + "\n")
              }
              println("Customer's Actor id " + id + " adds food from shopping list to the basket! " + articlePair._1 + " brand: " + brand)
            }
            else {
              //              if (this.writer != null) {
              //                writer.write("Customer's Actor id " + id + " could not find enough " + articlePair._1 + " brand: " + brand + "\n")
              //              }
              //              println("Customer's Actor id " + id + " could not find enough " + articlePair._1 + " brand: " + brand)
              break()
            }
          }
        }
      }
      writer.write("\n\n")
    })
  }

  //todo: in the usage of addToBasket, brand selection should be more dynamic
  //todo: the customer's budget should be decreased after purchasing item from the cashier, the problem is that in the current design
  // cashier does not know about customers.
  //todo the onbudget from caller methods should be removed
  //todo: customer should own the item when the cashier scanned it
  def addToBasket(itemName: String, itemBrand: Brand, pickedSupermarket: SupermarketTrait): Boolean = {
    //if supermarket's section was busy, the customer has to wait
    val requestedItem: Item = pickedSupermarket.getRequestedItem(itemName, itemBrand)
    if (requestedItem != null) {
      val onBudget: Boolean = requestedItem.price <= budget
      if (!onBudget) {
        writer.write("Customer's Actor id " + id + " does not have enough budget to buy " + requestedItem.name + " brand: " + requestedItem.brand + "\n")
        println("Customer's Actor id " + id + " does not have enough budget to buy " + requestedItem.name + " brand: " + requestedItem.brand)
        return false
      }
      requestedItem.state = inBasket
      requestedItem.owner = this
      basket += requestedItem
      budget -= requestedItem.price
      return true
    }
    false
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
      val someFood: String = utilities.randElementFromVector(fridge.getAvailFood)
      writer.write("Customer's Actor id " + id + " consumed random food " + someFood + " amount " + fridge.consume(someFood, 200) + "\n")
      println("Customer's Actor id " + id + " consumed random food " + someFood + " amount 200")
    }
  }

  // Target consumption behavior
  def consumeFood(mealPlan: Vector[(articleName, gram)]): Unit = {
    mealPlan.foreach(pair => {
      val consumed: Int = fridge.consume(pair._1, pair._2)
      writer.write("Customer's Actor id " + id + " consumed " + pair._1 + " Amount " + consumed + "\n")
      println("Customer's Actor id " + id + " consumed " + pair._1 + " Amount " + consumed)
      //      if (consumed < pair._2) {
      //        println("Not enough food left! Do shopping!")
      //        //addListedItemsToBasket(Vector((pair._1, pair._2)))
      //        var pickedSupermarket = pickSupermarket()
      //        addListedItemsToBasket(Vector((pair._1, pair._2)), pickedSupermarket)
      //      }
    })
  }

  def customerInfo: Unit = {
    println()
    println("Customer's Actor id " + id + " budget: " + budget + " quality sensitivity: " + qualitySensitivityIndex + " taste: " + taste + " frequency " + frequency + "\nfridge " + fridge)
    println()
  }

  override def toString: String = {
    "Customer's Actor id " + id + " budget: " + budget + " quality sensitivity: " + qualitySensitivityIndex + " taste: " + taste + " frequency " + frequency + "\nfridge " + fridge
  }
}