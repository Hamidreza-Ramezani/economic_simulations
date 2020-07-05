package meta.example.supermarket.people

import squants.mass._
import squants.motion.Distance


sealed trait WeightStatus

case object Underweight extends WeightStatus
case object Normal extends WeightStatus
case object Overweight extends WeightStatus
case object Obese extends WeightStatus
case object DangerouslyLow extends WeightStatus


package object healthCalculations {
  def calcWeightStatus (fromBodyMassIndex: AreaDensity): WeightStatus = {
    fromBodyMassIndex match {
      case bmi if bmi < KilogramsPerSquareMeter(13) => DangerouslyLow
      case bmi if bmi < KilogramsPerSquareMeter(18.5) => Underweight
      case bmi if bmi < KilogramsPerSquareMeter(24.9) => Normal
      case bmi if bmi < KilogramsPerSquareMeter(29.9) => Overweight
      case _ => Obese
    }
  }

  def calcBodyMassIndex(height: Distance, weight: Mass): AreaDensity = weight / (height * height)
}