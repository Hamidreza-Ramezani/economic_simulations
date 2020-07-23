package meta.example.supermarket.auction

class MyRange(var lowerLimit: Double, var upperLimit: Double) {

  def contain(num: Double): Boolean = {
    if (lowerLimit <= num && num <= upperLimit) {
      return true
    }
    false
  }
}
