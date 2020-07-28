package meta.example.supermarket

import java.io.{BufferedWriter, File, FileWriter}
import scala.collection.mutable.{ListBuffer, Map}
import meta.example.supermarket.people.{frequencySummary,shopperTypeSummary, mealPlanSummary}

object genCustomers extends App {

  val generatingFileName: String = "genCustomers"
  var counter: Int = 1
  var cwd = new File(".").getCanonicalPath()
  val storagePath = cwd + "/src/main/scala/meta/example/supermarket/customers"

  // (frequency, mealplan, habbit)->CustId
  val custMap: Map[(String, String, String), String] = Map()

  private def customerString(className: String): String =
    s"""package meta.example.supermarket.customers
      |
      |import java.io.{File, FileWriter, PrintWriter}
      |import meta.classLifting.SpecialInstructions
      |import meta.deep.runtime.Actor
      |import meta.example.supermarket.SupermarketTrait
      |import meta.example.supermarket.categories.{articleName, gram}
      |import meta.example.supermarket.goods.isPurchased
      |import meta.example.supermarket.people.{ImpulseShopper, MealPlan, People, Weekly}
      |import meta.example.supermarket.worldmap.{Down, PrivateProperty, Tile, Up, Utils, WorldTrait, Right, Left}
      |import squid.quasi.lift
      |import scala.collection.mutable.ListBuffer
      |import scala.util.Random
      |
      |
      |/* Auto generated from ${generatingFileName} */
      |
      |@lift
      |${className}
      |{
      |
      |  /**
      |    * The customer goes back into its initial position from their current position. This method is usually caled when
      |    * the customer does his/her shopping and wants to back home from supermarket.
      |    *
      |    * @param world the world map, which the customer is in
      |    */
      |  override def comeBackInitialPoint(world: WorldTrait): Unit = {
      |
      |    writer.write("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\\n\\n\\n")
      |    println("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\\n\\n\\n")
      |
      |    moveOneStep(world, initialXPosition, initialYPosition)
      |    //    SpecialInstructions.waitTurns(1)
      |
      |    writer.write("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\\n\\n\\n")
      |    println("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\\n\\n\\n")
      |  }
      |
      |  /**
      |    * The customer goes from the source (the current position) toward the destination.
      |    *
      |    * @param world  the world map, which the customer is in
      |    * @param target the destination
      |    */
      |  override def move(world: WorldTrait, target: Actor): Unit = {
      |    writer.write("agent id " + id + "  goes toward the agent id " + target.id + " target x: " + target.currentXPosition + " target y: " + target.currentYPosition + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\\n\\n\\n")
      |    println("agent id " + id + "  goes toward the agent id " + target.id + " target x:  " + target.currentXPosition + " target y: " + target.currentYPosition + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\\n\\n")
      |
      |    moveOneStep(world, target.currentXPosition, target.currentYPosition)
      |    //    SpecialInstructions.waitTurns(1)
      |
      |    writer.write("agent id " + id + "  gets into the agent id " + target.id + " target x: " + target.currentXPosition + " target y: " + target.currentYPosition + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\\n\\n\\n")
      |    println("agent id " + id + "  gets into the agent id " + target.id + " target x: " + target.currentXPosition + " target y: " + target.currentYPosition + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\\n\\n")
      |  }
      |
      |  /**
      |    * This is a helper method for the move and comeBackToInitialPoint
      |    *
      |    * @param world           the world map, which the customer is in
      |    * @param targetXPosition the x coordinate of the destination
      |    * @param targetYPosition the y coordinate of the destination
      |    */
      |  def moveOneStep(world: WorldTrait, targetXPosition: Int, targetYPosition: Int): Unit = {
      |    if (canMove) {
      |      var path: ListBuffer[Tile] = Utils.getPath(world, world.coordinates(currentYPosition)(currentXPosition), world.coordinates(targetYPosition)(targetXPosition))
      |      path.toList.foreach {
      |        tile =>
      |          if (currentXPosition < tile.getX()) {
      |            SpecialInstructions.waitTurns(1)
      |            move(world, Right)
      |          }
      |          if (currentXPosition > tile.getX()) {
      |            SpecialInstructions.waitTurns(1)
      |            move(world, Left)
      |          }
      |          if (currentYPosition < tile.getY()) {
      |            SpecialInstructions.waitTurns(1)
      |            move(world, Down)
      |          }
      |          if (currentYPosition > tile.getY()) {
      |            SpecialInstructions.waitTurns(1)
      |            move(world, Up)
      |          }
      |      }
      |    }
      |  }
      |
      |  /**
      |    * This method is called when the customer consumes according to a meal plan
      |    * @param mealPlan list of tuples whose first element is the item name and the second is the amount of
      |    *                 consumption in gram.
      |    */
      |  override def consumeMealPlan(mealPlan: Vector[(articleName, gram)]): Unit = {
      |    mealPlan.toList.foreach(pair => {
      |      var consumed: Int = fridge.consume(pair._1, pair._2)
      |      writer.write("Customer's Actor id " + id + " consumed " + pair._1 + " Amount " + consumed + "\\n")
      |      println("Customer's Actor id " + id + " consumed " + pair._1 + " Amount " + consumed)
      |      //      if (consumed < pair._2) {
      |      //        writer.write("Not enough food left! Do shopping!" + "\\n")
      |      //        println("Not enough food left! Do shopping!")
      |      //        var pickedSupermarket = pickSupermarket()
      |      //        //        move(world, pickedSupermarket)
      |      //        //        val sectionName = newItemsMap.categoryMap(pair._1)
      |      //        //        val employee = supermarket.employees.filter(_.section.sectionName == sectionName).head
      |      //        if (pickedSupermarket.getEmployeesState == "reFillingShelves") {
      |      //          writer.write("Customer's Actor id " + id + " is waiting for the employee " + "to refill the shelves" + "\\n")
      |      //          println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
      |      //          println()
      |      //          SpecialInstructions.waitTurns(3)
      |      //        }
      |      //        //        addListedItems(Vector((pair._1, pair._2)), onBudget = true)
      |      //        //        addListedItemsToBasket(Vector((pair._1, pair._2)))
      |      //        addListedItemsToBasket(Vector((pair._1, pair._2)), pickedSupermarket)
      |      //      }
      |    })
      |  }
      |
      |
      |  /**
      |    * The customer's step function
      |    */
      |  def main(): Unit = {
      |    var randomWidth = Random.nextInt(world.width)
      |    var randomHeight = Random.nextInt(world.height)
      |    while (world.coordinates(randomHeight)(randomWidth).tileType != PrivateProperty || world.coordinates(randomHeight)(randomWidth).hasOwner) {
      |      randomWidth = Random.nextInt(world.width)
      |      randomHeight = Random.nextInt(world.height)
      |    }
      |    setInitialPosition(world, randomWidth, randomHeight)
      |    world.addActor(this)
      |    var enteredWhileLoop: Boolean = false
      |    writer = new PrintWriter(new FileWriter(new File("m/agentCustomer" + id)))
      |    writer.write("timer: " + timer + "\\n\\n\\n")
      |    writer.write("agent id " + id + " preference is " + mealPlan.preference + "\\n\\n\\n")
      |    while (true) {
      |      println("---------------------------------------------------------------------------------------------------")
      |      customerInfo
      |      writer.write(toString + "\\n")
      |      val pickedSupermarket: SupermarketTrait = pickSupermarket()
      |      move(world, pickedSupermarket)
      |      //these functions should add the items to toBeScannedItems
      |      if (pickedSupermarket.getEmployeesState == "reFillingShelves") {
      |        writer.write("Customer's Actor id " + id + " is waiting for the employee to refill the shelves" + "\\n")
      |        println("Customer's Actor id " + id + " is waiting for the employee to refill the shelves")
      |        println("---------------------------------------------------------------------------------------------------")
      |        enteredWhileLoop = true
      |        SpecialInstructions.waitTurns(3)
      |      }
      |      if (enteredWhileLoop) {
      |        println("---------------------------------------------------------------------------------------------------")
      |        enteredWhileLoop = false
      |      }
      |      addListedItemsToBasket(mealPlan.shoppingList.targetItems, pickedSupermarket, Random.nextFloat < priceConscious)
      |      addRandItemsToBasket(mealPlan.shoppingList.randItems, pickedSupermarket)
      |      println()
      |      pickedSupermarket.toBeScannedItems.enqueue(basket)
      |      //basket is full, now it should be added to the toBeScannedItem
      |      while (basket.exists(item => item.state != isPurchased)) {
      |        writer.write("Customer's Actor id " + id + " is waiting for the cashier to scan items" + "\\n")
      |        println("Customer's Actor id " + id + " is waiting for the cashier to scan items")
      |        println("---------------------------------------------------------------------------------------------------")
      |        println()
      |        SpecialInstructions.waitTurns(1)
      |      }
      |      //      customerInfo
      |      writer.write("shopping basket of Customer's Actor id " + id + " was scanned" + "\\n")
      |      println("---------------------------------------------------------------------------------------------------")
      |      println("shopping basket of Customer's Actor id " + id + " was scanned")
      |      comeBackInitialPoint(world)
      |      basket.toList.foreach(item => {
      |        writer.write("Customer's Actor id " + id + " bought food " + item.name + " id: " + item.id + "\\n")
      |        println("Customer's Actor id " + id + " bought food " + item.name + " id: " + item.id)
      |        fridge.add(item)
      |      })
      |      writer.write(toString + "\\n")
      |      customerInfo
      |      println("---------------------------------------------------------------------------------------------------")
      |      basket = ListBuffer()
      |      SpecialInstructions.waitTurns(1)
      |      //       while (! all_Items_Scanned){
      |      //       specialInstructions.waitTurns(1)
      |      //       }
      |      List.range(0, frequency).foreach(_ => {
      |        println("---------------------------------------------------------------------------------------------------")
      |
      |        consumeMealPlan(mealPlan.meal)
      |        consumeRandomFood()
      |
      |        writer.write(toString + "\\n")
      |        customerInfo
      |        println("---------------------------------------------------------------------------------------------------")
      |
      |        //        if (basket.isEmpty) {
      |        //          println("---------------------------------------------------------------------------------------------------")
      |        //        }
      |        //        if (basket.nonEmpty) {
      |        //          //now it should be added to the toBeScannedItems
      |        //          pickedSupermarket.toBeScannedItems.enqueue(basket)
      |        //          while (basket.exists(item => item.state != isPurchased)) {
      |        //            writer.write("Customer's Actor id " + id + " is waiting for the cashier to scan items" + "\\n")
      |        //            println("Customer's Actor id " + id + " is waiting for the cashier to scan items")
      |        //            println("---------------------------------------------------------------------------------------------------")
      |        //            println()
      |        //            SpecialInstructions.waitTurns(1)
      |        //          }
      |        //          //      customerInfo
      |        //          println("---------------------------------------------------------------------------------------------------")
      |        //          writer.write("shopping basket of Customer's Actor id " + id + " was scanned" + "\\n")
      |        //          println("shopping basket of Customer's Actor id " + id + " was scanned")
      |        //          //          comeBackToInitialPoint(world)
      |        //
      |        //          basket.toList.foreach(item => {
      |        //            writer.write("Customer's Actor id " + id + " bought food " + item.name + " id: " + item.id + "\\n")
      |        //            println("Customer's Actor id " + id + " bought food " + item.name + " id: " + item.id)
      |        //            fridge.add(item)
      |        //          })
      |        //          writer.write(toString + "\\n")
      |        //          customerInfo
      |        //          println("---------------------------------------------------------------------------------------------------")
      |        //          basket = ListBuffer()
      |        //        }
      |        SpecialInstructions.waitTurns(12)
      |      })
      |    }
      |  }
      |}
      |
      |
      |
      |
      |
      |
      |""".stripMargin

  private def newCustomer(frequency: String, mealPlan: String, habbit: String): Unit ={
    val file = new File(storagePath + s"/Customer${counter}.scala")
    val bw = new BufferedWriter(new FileWriter(file))

    val className: String = s"""class Customer${counter} (var supermarkets: ListBuffer[SupermarketTrait], var world: WorldTrait, var mealPlan: MealPlan) extends People with ${frequency} with ${habbit} """
    custMap+=((s""""${frequency}"""", s""""${mealPlan}"""", s""""${habbit}"""")->s""""Customer${counter}"""")

    bw.write(customerString(className))
    bw.close()
  }

  def main(): Unit = {
    val fdir = new File(storagePath)
    if (!fdir.exists()){
      fdir.mkdirs()
    }

    frequencySummary.names.foreach(frequency => {
      shopperTypeSummary.names.foreach(habbit => {
        (1 to mealPlanSummary.total).foreach {mealPlanId =>
          newCustomer(frequency, "MealPlan"+mealPlanId, habbit)
          counter = counter + 1
        }
      })
    })

    val mapFile = new File(storagePath + s"/newCustomersMap.scala")
    val mapBW = new BufferedWriter(new FileWriter(mapFile))

    mapBW.write(
      s"""package meta.example.supermarket.goods
         |
         |import scala.collection.mutable.Map
         |
         |/* Auto generated from ${generatingFileName} */
         |
         |object newCustomersMap {
         |  val totalItems: Int = ${counter-1}
         |
         |  // goodsName, itemName
         |  val itemMap: Map[(String, String, String), String] = Map(
         |    ${custMap.mkString(",\\n    ")}
         |  )
         |}
         |""".stripMargin
    )
    mapBW.close()
  }

  main()
}


