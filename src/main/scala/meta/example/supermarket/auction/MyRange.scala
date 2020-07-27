package meta.example.supermarket.auction

/**
  * This is a class for range of real numbers.
  * @param lowerLimit The lower bound of the range
  * @param upperLimit The upper bound of the range
  */
class MyRange(var lowerLimit: Double, var upperLimit: Double) {

  /**
    * This method checks if a number is in the range
    * @param num
    * @return true if the num is in the range and false if it is not in the range
    */
  def contain(num: Double): Boolean = {
    if (lowerLimit <= num && num <= upperLimit) {
      return true
    }
    false
  }
}
