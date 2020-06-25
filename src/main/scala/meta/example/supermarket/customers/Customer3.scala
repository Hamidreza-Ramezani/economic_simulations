package meta.example.supermarket.customers

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.deep.runtime.Actor
import meta.example.supermarket.categories.{articleName, gram}
import meta.example.supermarket.people.{ImpulseShopper, MealPlan3, MealPlan_Dummy3, People, Weekly}
import meta.example.supermarket.utils.randElement
import meta.example.supermarket.worldmap.{Down, Left, PrivateProperty, Right, Up, WorldTrait}
import squid.quasi.lift

import scala.util.Random
import meta.example.supermarket.{Supermarket, SupermarketTrait, granularity}

import scala.collection.mutable.ListBuffer


/* Auto generated from genCustomers */

@lift
class Customer3(var supermarkets: ListBuffer[SupermarketTrait], var world: WorldTrait) extends People with Weekly with MealPlan_Dummy3 with ImpulseShopper {

  override def comeBackToInitialPoint(world: WorldTrait): Unit = {
    writer.write("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")

    move2(world, initialXPosition, initialYPosition)
    //    SpecialInstructions.waitTurns(1)

    writer.write("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  }

  override def move(world: WorldTrait, target: Actor): Unit = {
    writer.write("agent id " + id + "  goes toward the agent id " + target.id + " target x: " + target.currentXPosition + " target y: " + target.currentYPosition + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  goes toward the agent id " + target.id + " target x:  " + target.currentXPosition + " target y: " + target.currentYPosition + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")

    move2(world, target.currentXPosition, target.currentYPosition)
    //    SpecialInstructions.waitTurns(1)

    writer.write("agent id " + id + "  gets into the agent id " + target.id + " target x: " + target.currentXPosition + " target y: " + target.currentYPosition + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets into the agent id " + target.id + " target x: " + target.currentXPosition + " target y: " + target.currentYPosition + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
  }

  def move2(world: WorldTrait, targetXPosition: Int, targetYPosition: Int): Unit = {
    if (canMove) {

      while (currentXPosition < targetXPosition) {
        writer.write("agent id " + id + " name: " + agentName + "  goes Right" + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
        println("agent id " + id + " name: " + agentName + "  goes Right" + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
        SpecialInstructions.waitTurns(1)
        move(world, Right)
      }
      while (currentXPosition > targetXPosition) {
        writer.write("agent id " + id + " name: " + agentName + "  goes Left" + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
        println("agent id " + id + " name: " + agentName + "  goes Left" + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
        SpecialInstructions.waitTurns(1)
        move(world, Left)
      }
      while (currentYPosition < targetYPosition) {
        writer.write("agent id " + id + " name: " + agentName + "  goes Down" + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
        println("agent id " + id + " name: " + agentName + "  goes Down" + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
        SpecialInstructions.waitTurns(1)
        move(world, Down)
      }
      while (currentYPosition > targetYPosition) {
        writer.write("agent id " + id + " name: " + agentName + "  goes Up" + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
        println("agent id " + id + " name: " + agentName + "  goes Up" + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
        SpecialInstructions.waitTurns(1)
        move(world, Up)
      }
    }
  }


  //  def addRandItems(shoppingList: categoryAmount): Unit = {
  //    if (!needBased) {
  //      val foods = utils.ccArgToIntVector(shoppingList)
  //      foods.toList.foreach(
  //        categoryAmountPair => {
  //          List.fill(categoryAmountPair._2)(1).foreach(_ => {
  //            val randFood: String = supermarket.getRandFood(categoryAmountPair._1)
  //            println("Customer's Actor id " + id + " adds random food to the basket! " + randFood)
  //            add2Basket(randFood, onBudget = true)
  //          })
  //        }
  //      )
  //    }
  //  }

  //  def addListedItems(meal: Vector[(articleName, Int)], onBudget: Boolean): Unit = {
  //    val shoppingList: Map[String, Int] = toShoppingList(meal).toMap
  //    meal.toList.foreach(articlePair => {
  //      if (fridge.getAmount(articlePair._1) < (frequency * articlePair._2)) {
  //        println("Customer's Actor id " + id + " adds food from shopping list to the basket! " + articlePair._1)
  //        List.fill(shoppingList(articlePair._1))(1).foreach(_ => add2Basket(articlePair._1, onBudget))
  //      }
  //    })
  //  }

  //  def add2Basket(itemStr: String, onBudget: Boolean): Unit = {
  //    //    val item: Option[Item] = supermarket.getRequestedItem(itemStr, onBudget)
  //    //    if (item.isDefined) {
  //    //      val targetItem = item.get
  //    //      targetItem.state.addToBasket
  //    //      basket += targetItem
  //    //    }
  //  }


  //    def isAllItemsScanned: Boolean = {
  //      var flag: Boolean = true
  //      this.basket.toList.foreach(item => {
  //        if (item.state.get != "isPurchased") {
  //          flag = false
  //        }
  //      })
  //      flag
  //    }


  //  def consumeFood2(): Unit = {
  //    if (fridge.getAvailFood.nonEmpty) {
  //      var someFood: String = randElement(fridge.getAvailFood)
  //      var consumedFoodAmount = fridge.consume(someFood, 200)
  //      writer.write("Customer's Actor id " + id + " consumed random food " + someFood + "\n")
  //      writer.write(" amount " + consumedFoodAmount + "\n")
  //      println("Customer's Actor id " + id + " consumed random food " + someFood)
  //      println(" amount " + consumedFoodAmount)
  //    }
  //  }

  //   Target consumption behavior
  def consumeFood2(mealPlan: Vector[(articleName, gram)]): Unit = {
    mealPlan.toList.foreach(pair => {
      var consumed: Int = fridge.consume(pair._1, pair._2)
      writer.write("Customer's Actor id " + id + " consumed " + pair._1 + " Amount " + consumed + "\n")
      println("Customer's Actor id " + id + " consumed " + pair._1 + " Amount " + consumed)
      if (consumed < pair._2) {
        writer.write("Not enough food left! Do shopping!" + "\n")
        println("Not enough food left! Do shopping!")
        var pickedSupermarket = pickSupermarket()
        move(world, pickedSupermarket)
        //        val sectionName = newItemsMap.categoryMap(pair._1)
        //        val employee = supermarket.employees.filter(_.section.sectionName == sectionName).head
        while (pickedSupermarket.getEmployeesState == "reFillingShelves") {
          writer.write("Customer's Actor id " + id + " is waiting for the employee " + "to refill the shelves" + "\n")
          println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
          println()
          SpecialInstructions.waitTurns(1)
        }
        //        addListedItems(Vector((pair._1, pair._2)), onBudget = true)
        //        addListedItemsToBasket(Vector((pair._1, pair._2)))
        addListedItemsToBasket(Vector((pair._1, pair._2)), pickedSupermarket)
      }
    })
  }

  def main(): Unit = {

    var randomWidth = Random.nextInt(world.width)
    var randomHeight = Random.nextInt(world.height)
    while (world.coordinates(randomHeight)(randomWidth).tileType != PrivateProperty) {
      randomWidth = Random.nextInt(world.width)
      randomHeight = Random.nextInt(world.height)
    }
    setInitialPosition(randomWidth, randomHeight)
    //    setInitialPosition(Random.nextInt(world.width), Random.nextInt(world.height))
    world.addActor(this)
    var enteredWhileLoop: Boolean = false
    writer = new PrintWriter(new FileWriter(new File("m/agentCustomer" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      println("---------------------------------------------------------------------------------------------------")
      customerInfo
      writer.write(toString + "\n")
      var pickedSupermarket: SupermarketTrait = pickSupermarket()
      move(world, pickedSupermarket)
      //these functions should add the items to toBeScannedItems
      while (pickedSupermarket.getEmployeesState == "reFillingShelves") {
        writer.write("Customer's Actor id " + id + " is waiting for the employee to refill the shelves" + "\n")
        println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
        println("---------------------------------------------------------------------------------------------------")
        enteredWhileLoop = true
        SpecialInstructions.waitTurns(1)
      }
      if (enteredWhileLoop) {
        println("---------------------------------------------------------------------------------------------------")
        enteredWhileLoop = false
      }
      //      addListedItems(shoppingList.targetItems, (Random.nextFloat < priceConscious))
      //      addRandItems(shoppingList.randItems)
      addListedItemsToBasket(shoppingList.targetItems, pickedSupermarket, Random.nextFloat < priceConscious)
      addRandItemsToBasket(shoppingList.randItems, pickedSupermarket)
      println()
      pickedSupermarket.toBeScannedItems.enqueue(basket)
      //basket is full, now it should be added to the toBeScannedItem
      while (basket.exists(item => item.state.get != "isPurchased")) {
        writer.write("Customer's Actor id " + id + " is waiting for the cashier to scan items" + "\n")
        println("Customer's Actor id " + id + " is waiting for the cashier to scan items")
        println("---------------------------------------------------------------------------------------------------")
        println()
        SpecialInstructions.waitTurns(1)
      }
      //      customerInfo
      writer.write("shopping basket of Customer's Actor id " + id + " was scanned" + "\n")
      println("---------------------------------------------------------------------------------------------------")
      println("shopping basket of Customer's Actor id " + id + " was scanned")
      comeBackToInitialPoint(world)
      basket.toList.foreach(item => {
        writer.write("Customer's Actor id " + id + " bought food " + item.name + " id: " + item.id + "\n")
        println("Customer's Actor id " + id + " bought food " + item.name + " id: " + item.id)
        fridge.add(item)
      })
      writer.write(toString + "\n")
      customerInfo
      println("---------------------------------------------------------------------------------------------------")
      basket = ListBuffer()
      SpecialInstructions.waitTurns(1)
      //       while (! all_Items_Scanned){
      //       specialInstructions.waitTurns(1)
      //       }
      List.range(0, frequency).foreach(_ => {
        println("---------------------------------------------------------------------------------------------------")
        pickedSupermarket = pickSupermarket()
        consumeFood2(mealPlan)
        //        consumeFood2()
        consumeRandomFood()
        //        consumeFood(mealPlan)
        //        consumeFood
        writer.write(toString + "\n")
        customerInfo
        if (basket.isEmpty) {
          println("---------------------------------------------------------------------------------------------------")
        }
        if (basket.nonEmpty) {
          //now it should be added to the toBeScannedItems
          pickedSupermarket.toBeScannedItems.enqueue(basket)
          while (basket.exists(item => item.state.get != "isPurchased")) {
            writer.write("Customer's Actor id " + id + " is waiting for the cashier to scan items" + "\n")
            println("Customer's Actor id " + id + " is waiting for the cashier to scan items")
            println("---------------------------------------------------------------------------------------------------")
            println()
            SpecialInstructions.waitTurns(1)
          }
          //      customerInfo
          println("---------------------------------------------------------------------------------------------------")
          writer.write("shopping basket of Customer's Actor id " + id + " was scanned" + "\n")
          println("shopping basket of Customer's Actor id " + id + " was scanned")
          comeBackToInitialPoint(world)

          basket.toList.foreach(item => {
            writer.write("Customer's Actor id " + id + " bought food " + item.name + " id: " + item.id + "\n")
            println("Customer's Actor id " + id + " bought food " + item.name + " id: " + item.id)
            fridge.add(item)
          })
          writer.write(toString + "\n")
          customerInfo
          println("---------------------------------------------------------------------------------------------------")
          basket = ListBuffer()
        }
        SpecialInstructions.waitTurns(12)
      })

    }
  }
}