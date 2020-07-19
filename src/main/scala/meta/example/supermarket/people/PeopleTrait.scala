package meta.example.supermarket.people

import meta.deep.runtime.Actor
import meta.example.supermarket._
import meta.example.supermarket.categories.{articleName, gram}
import meta.example.supermarket.goods.{Brand, Item, inBasket, newItemsMap}
import meta.example.supermarket.utils.utilities
import meta.example.supermarket.worldmap.WorldTrait

import scala.collection.mutable
import scala.collection.mutable.Stack
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
  var qualitySensitivityIndex: Double = Math.random()
  var taste: Double = Math.random() * 2
  var brands: List[Brand] = newItemsMap.priceMap.keys.map(_._2).toSet.toList


  //todo change to orderBrands
  def orderBrands(itemName: String): mutable.Queue[(Brand, Double)] = {
    val itemNum: String = newItemsMap.itemMap_test.getOrElse(itemName, "")
    //    var maximumUtility: Double = getUtility(itemNum, brands.head)
    var brandsPriority: Map[Brand, Double] = Map()
    brands.foreach {
      brand =>
        brandsPriority += (brand -> getUtility(itemNum, brand))
      //        if (getUtility(itemNum, brand) > maximumUtility) {
      //          maximumUtility = getUtility(itemNum, brand)
      //          brandsPriority = brand
      //        }
    }
    var result = mutable.ListMap(brandsPriority.toSeq.sortWith(_._2 > _._2): _*)
    writer.write("Customer's Actor id " + id + " brands' preference for item " + itemName + " is: \n")
    result.foreach {
      pair =>
        writer.write("brand: " + pair._1 + "  utility: " + pair._2 + "\n")
    }
    result.to[mutable.Queue]
  }

  def getUtility(itemNum: String, brand: Brand): Double = {
    val itemVerticalDifferentiation = newItemsMap.differentiationMap((itemNum, brand))._1
    val itemHorizontalDifferentiation = newItemsMap.differentiationMap((itemNum, brand))._2
    val itemPrice = newItemsMap.priceMap((itemNum, brand))
    val verticalUtility = qualitySensitivityIndex * itemVerticalDifferentiation
    val horizontalUtility = (taste - itemHorizontalDifferentiation).abs
    val netUtility = verticalUtility + horizontalUtility - itemPrice
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
            val preference = orderBrands(randFood)
            addToBasket(randFood, preference.dequeue()._1, pickedSupermarket)
            if (this.writer != null) {
              writer.write("Customer's Actor id " + id + " adds random food to the basket! " + randFood + " brand: " + preference + "\n")
            }
            println("Customer's Actor id " + id + " adds random food to the basket! " + randFood + " brand: " + preference)
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
      breakable {
        while (i < neededAmountToBuy) {
          1.to(shoppingList(articlePair._1)).foreach { _ =>
            val brands = orderBrands(articlePair._1)
            var brand: Brand = brands.head._1
            breakable {
              while (brands.nonEmpty) {
                brand = brands.dequeue()._1
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
    })
  }

  //todo: in the usage of addToBasket, brand selection should be more dynamic
  //todo: the customer's budget should be decreased after purchasing item from the cashier, the problem is that in the current design
  // cashier does not know about customers.
  //todo the onbudget from caller methods should be removed
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
      println("Customer's Actor id " + id + " consumed random food " + someFood)
      println(" amount " + fridge.consume(someFood, 200))
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