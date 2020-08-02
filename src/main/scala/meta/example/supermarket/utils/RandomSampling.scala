package meta.example.supermarket.utils

import org.apache.commons.math3.distribution.GammaDistribution
import java.util.concurrent.ThreadLocalRandom
import java.util.Random

class RandomSampling {
  var fRandom = new Random()

  /**
    * get a sample real number from a gamma distribution
    *
    * @param aMean the parameter of gaussian distribution
    * @param sd    the parameter of gaussian distribution
    * @return the sample
    */
  def getGaussianSample(aMean: Double, sd: Double): Double = {
    aMean + fRandom.nextGaussian() * sd
  }

  /**
    * get a sample real number from a gamma distribution
    *
    * @param shape the parameter of gamma distribution
    * @param scale the parameter of gamma distribution
    * @return the sample
    */
  def getGammaSample(shape: Double, scale: Double): Double = {
    val sample: Double = new GammaDistribution(shape, scale).sample()
    sample
  }
}

/**
  * the companion object
  */
object RandomSampling {

  /**
    * get a sample integer from a uniform distribution
    * @param low the lower limit of the range
    * @param high the upper limit of the range
    * @return the sample
    */
  def getUniformSample(low: Int, high: Int): Int = {
    val randomNum: Int = ThreadLocalRandom.current().nextInt(low, high + 1)
    randomNum
  }

  def log(aMsg: Object): Unit = {
    System.out.println(String.valueOf(aMsg))
  }
}