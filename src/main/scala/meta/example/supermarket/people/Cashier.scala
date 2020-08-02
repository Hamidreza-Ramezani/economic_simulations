package meta.example.supermarket.people

import java.io.{File, FileWriter, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.classLifting.SpecialInstructions.waitTurns
import meta.deep.runtime.Actor
import meta.example.supermarket.SupermarketTrait
import meta.example.supermarket.goods.{Item, isPurchased}
import meta.example.supermarket.worldmap.{Down, Left, Right, Tile, Up, Utils, WorldTrait}
import squid.quasi.lift

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

@lift
class Cashier(var supermarket: SupermarketTrait, var world: WorldTrait) extends CashierTrait {
  var isFirstBasket: Boolean = true



  override def comeBackInitialPoint(world: WorldTrait): Unit = {
    writer.write("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  goes toward its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")

    moveOneStep(world, initialXPosition, initialYPosition)

    writer.write("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets its initial position. currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
  }

  override def move(world: WorldTrait, target: Actor): Unit = {
    writer.write("agent id " + id + " name: " + agentName + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + " name: " + agentName + "  goes toward the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")

    moveOneStep(world, target.currentXPosition, target.currentYPosition)

    writer.write("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n\n")
    println("agent id " + id + "  gets into the agent id " + target.id + " currentX: " + currentXPosition + " currentY: " + currentYPosition + "\n\n")
  }

  def moveOneStep(world: WorldTrait, targetXPosition: Int, targetYPosition: Int): Unit = {
    if (canMove) {
      var path: ListBuffer[Tile] = Utils.getPath(world, world.coordinates(currentYPosition)(currentXPosition), world.coordinates(targetYPosition)(targetXPosition))
      path.toList.foreach {
        tile =>
          if (currentXPosition < tile.getX()) {
            SpecialInstructions.waitTurns(1)
            move(world, Right)
          }
          if (currentXPosition > tile.getX()) {
            SpecialInstructions.waitTurns(1)
            move(world, Left)
          }
          if (currentYPosition < tile.getY()) {
            SpecialInstructions.waitTurns(1)
            move(world, Down)
          }
          if (currentYPosition > tile.getY()) {
            SpecialInstructions.waitTurns(1)
            move(world, Up)
          }
      }
    }
  }

  /**
    *
    * @param queue the queue cashier takes items from and scans them. Usually the toBeScannedItems (an attribute of
    *              supermarket) is passed here. This queue is basically the batch of all items which are added to
    *              cutomers' shopping baskets.
    */
  def scanItems(queue: mutable.Queue[ListBuffer[Item]]): Unit = {
    var customerBasket: ListBuffer[Item] = ListBuffer[Item]()
    var j: Int = 0
    while (queue.nonEmpty && j < numOfBasketsHandledInOneStep) {
      customerBasket = queue.dequeue()
      var i: Int = 0
      while (i < customerBasket.size) {
        var item = customerBasket(i)
        item.state = isPurchased
        i = i + 1
      }
      writer.write("Cashier's Actor id " + id + " scanned the customer's basket with size " + customerBasket.size + "\n")
      j = j + 1
    }
  }


  /**
    * cashier's step function
    */
  def main(): Unit = {
    while (!supermarket.isPositionsFixed){
      SpecialInstructions.waitTurns(1)
    }
    setInitialPosition(world, Random.nextInt(world.width), Random.nextInt(world.height))
    world.addActor(this)
    writer = new PrintWriter(new FileWriter(new File("m/agentCashier" + id)))
    writer.write("timer: " + timer + "\n\n\n")
    while (true) {
      scanItems(supermarket.toBeScannedItems)
      waitTurns(1)
    }
  }
}