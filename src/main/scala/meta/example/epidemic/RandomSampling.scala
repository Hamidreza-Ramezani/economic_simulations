package meta.example.epidemic

import org.apache.commons.math3.distribution.GammaDistribution
import java.util.concurrent.ThreadLocalRandom;


import java.util.Random

class RandomSampling {
  var fRandom = new Random()

  def getGaussianSample(aMean: Double, sd: Double): Double = {
    aMean + fRandom.nextGaussian() * sd;
  }

  def getGammaSample(shape:Double, scale: Double): Double ={
     val sample: Double = new GammaDistribution(shape, scale).sample();
    sample
  }

  def getUniformSample(low:Int, high:Int): Int ={
     val randomNum: Int = ThreadLocalRandom.current().nextInt(low, high + 1);
    randomNum
  }
}

object RandomSampling {
  def log(aMsg: Object): Unit = {
    System.out.println(String.valueOf(aMsg));
  }
}
