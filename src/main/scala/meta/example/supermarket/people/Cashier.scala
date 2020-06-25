package meta.example.supermarket.people

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.Item
import meta.example.supermarket.worldmap.WorldTrait
import squid.quasi.lift

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Queue}
import scala.util.Random

@lift
class Cashier(var supermarket:SupermarketTrait, var world: WorldTrait) extends CashierTrait {
  var isFirstBasket: Boolean = true


  override def comeBackToInitialPoint(world: WorldTrait): Unit = {
    writer.write("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")

    move(world, initialXPosition, initialYPosition)
    SpecialInstructions.waitTurns(1)

    writer.write("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  }

  override def move(world: WorldTrait, target: Actor): Unit = {
    writer.write("agent id " + id + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")

    move(world, target.currentXPosition, target.currentYPosition)
    SpecialInstructions.waitTurns(1)

    writer.write("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
  }


  def scanItems(queue: mutable.Queue[ListBuffer[Item]]): Unit = {
    var customerBasket: ListBuffer[Item] = ListBuffer[Item]()
    var j: Int = 0
    while (queue.nonEmpty && j < numOfBasketsHandledInOneStep) {
      customerBasket = queue.dequeue()
      var i: Int = 0
      while (i < customerBasket.size) {
        if (isFirstBasket) {
          isFirstBasket = false
          //TODO double check to see if this wait statement is essential
          //          waitTurns(1)
        }
        var item = customerBasket(i)
        //      customerBasket -= item
        item.state.purchase
        i = i + 1
      }
      writer.write("Cashier's Actor id " + id + " scanned the customer's basket with size " + customerBasket.size + "\n")
      j = j + 1
      isFirstBasket = true
    }

    // println("Customer's Actor id " + id + " is waiting")

    //    if (queue.isEmpty) {
    //      isFirstBasket = true
    //    } else {
    //      isFirstBasket = false
    //    }
  }

  def main(): Unit = {
    setInitialPosition(Random.nextInt(world.width), Random.nextInt(world.height))
    world.addActor(this)

    writer = new PrintWriter(new FileWriter(new File("m/agentCashier" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      scanItems(supermarket.toBeScannedItems)
      waitTurns(1)
    }
  }
}