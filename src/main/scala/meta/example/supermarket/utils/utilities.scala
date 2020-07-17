package meta.example.supermarket.utils

import meta.example.supermarket.categories.{getArticleCategory, getArticleUnit}
import meta.example.supermarket.goods.Brand

import scala.util.Random

object utilities {
  /**
    * Convert the parameter list of case class to a Vector
    */
  def ccArgToVector(cc: Product): Vector[(String, Any)] = {
    cc.getClass
      .getDeclaredFields
      .map( _.getName )
      .zip( cc.productIterator.to )
      .toVector
  }

  def ccArgToIntVector(cc: Product): Vector[(String, Int)] = {
    cc.getClass
      .getDeclaredFields
      .map( _.getName )
      .zip( cc.productIterator.to )
      .toVector.asInstanceOf[Vector[(String, Int)]]
  }

  def toInt(b: Boolean): Int = {
    if (b) 1 else 0
  }

  def to2Dec(value: Double): Double = {
    (value * 100).round / 100.toDouble
  }

  def divCeil(a: Int, b: Int): Int = {
    a/b+toInt(a%b!=0)
  }


  def double2int(myDouble: Double): Int = {
    myDouble.toInt
  }

  def prob2Bool(probability: Double, precision: Double = 0.01): Boolean = {
    Random.nextInt(double2int(1 / precision)) < double2int(probability / precision);
  }

  def selectRandomly[T](list: List[T]): T = {
    Random.shuffle(list).head
  }

  /**
    * This function takes a Vector[(ArticleName, Gram)] and converts it to
   * Vector[(ArticleName, AgentCount)]
   */
  def toShoppingList(meal: Vector[(String, Int)]): Vector[(String, Int)] = {
    meal.map(
      pair => (pair._1, divCeil(pair._2, getArticleUnit(pair._1)))
    )
  }

  def randElementFromVector(foo: Vector[String]): String = {
    foo(Random.nextInt(foo.size))
  }

  def randElementFromList(foo: List[Brand]): Brand = {
    foo(Random.nextInt(foo.size))
  }
}
