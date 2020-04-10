package meta.example.epidemic
import scala.util.Random

object Utils {


  def double2int(myDouble: Double): Int = {
      myDouble.toInt
  }

  def prob2Bool(probability: Double, precision: Double = 0.001): Boolean = {
    Random.nextInt(double2int(1 / precision)) < double2int(probability / precision);
  }
  


}
