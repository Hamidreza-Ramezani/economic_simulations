package meta.example.epidemic

import scala.util.Random
import java.io._
import scala.collection.mutable.ListBuffer



object Utils {
  def double2int(myDouble: Double): Int = {
    myDouble.toInt
  }

  def prob2Bool(probability: Double, precision: Double = 0.001): Boolean = {
    Random.nextInt(double2int(1 / precision)) < double2int(probability / precision);
  }

  def selectRandomly[T](list: List[T]): T = {
    Random.shuffle(list).head
  }

  def myMin(a: Int, b: Int): Int = if (a < b) a
  else b

  def writeToFile(data: String, name: String): Unit = {
    val writer = new PrintWriter(new File("epidemic_generated/" + name))
    writer.write(data)
    writer.close()
  }

  def writeWorkplacesToFile(outputVector: ListBuffer[ListBuffer[Person]], name: String): Unit = {
    var str: String = "";
    outputVector.toList.foreach { colleagues =>
      str += "workplace: \n";
      colleagues.toList.foreach { person =>
        str += "id: " + person.id.toString + "\t";
      }
      str += "\n \n \n";
    }
    val writer = new PrintWriter(new File("epidemic_generated/" + name))
    writer.write(str)
    writer.close()
  }

  def writeSchoolsToFile(outputVector: ListBuffer[ListBuffer[Person]], name: String): Unit = {
    var str: String = "";
    outputVector.toList.foreach { group =>
      str += "school: \n";
      group.toList.foreach { person =>
        str += "id: " + person.id.toString + "\t";
      }
      str += "\n \n \n";
    }
    val writer = new PrintWriter(new File("epidemic_generated/" + name))
    writer.write(str)
    writer.close()
  }

  def writeHouseholdsToFile(outputVector: ListBuffer[ListBuffer[Person]], name: String): Unit = {
    var str: String = "";
    outputVector.toList.foreach { family =>
      str += "family: \n";
      family.toList.foreach { person =>
        str += "id: " + person.id.toString + "\t";
      }
      str += "\n \n \n";
    }
    val writer = new PrintWriter(new File("epidemic_generated/" + name))
    writer.write(str)
    writer.close()
  }

}
