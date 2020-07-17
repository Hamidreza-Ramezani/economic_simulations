package meta.example.supermarket.utils

import org.apache.commons.math3.distribution.GammaDistribution
import java.util.concurrent.ThreadLocalRandom
import java.util.Random

class RandomSampling {
  var fRandom = new Random()

  def getGaussianSample(aMean: Double, sd: Double): Double = {
    aMean + fRandom.nextGaussian() * sd
  }

  def getGammaSample(shape: Double, scale: Double): Double = {
    val sample: Double = new GammaDistribution(shape, scale).sample()
    sample
  }

}

object RandomSampling {

  def getUniformSample(low: Int, high: Int): Int = {
    val randomNum: Int = ThreadLocalRandom.current().nextInt(low, high + 1)
    randomNum
  }


  def log(aMsg: Object): Unit = {
    System.out.println(String.valueOf(aMsg))
  }
}