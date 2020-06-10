package meta.example.supermarket

import java.io.{File, PrintWriter}

import meta.classLifting.SpecialInstructions
import meta.example.supermarket.logistics.Farmer
import squid.quasi.lift

import scala.collection.mutable.ListBuffer

@lift
class Supermarket(var warehouse: ListBuffer[SectionTrait]) extends SupermarketTrait {
  //  var employees: ListBuffer[EmployeeTrait] = warehouse.map(_.employee)

  def main(): Unit = {
    writer = new PrintWriter(new File("m/supermarket"))
    while (true) {
      writer.write("\n\n" + "Timer " + timer + "\n\n")
      warehouse.toList.foreach(section => section.shelves.toList.foreach(shelf => writer.write("\n\n" + shelf._1 + "\n\n" + shelf._2.toString)))
      SpecialInstructions.waitTurns(1)
    }
  }
}
