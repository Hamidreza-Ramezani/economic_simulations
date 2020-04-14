package meta.example.epidemic

import meta.classLifting.Lifter
import meta.deep.codegen._
import meta.deep.runtime.Actor
import meta.deep.IR.TopLevel._
import meta.deep.IR

object Epidemic_Example extends App {

  val mainClass: ClassWithObject[MainInit] = MainInit.reflect(IR)
  val cls1: ClassWithObject[Person] = Person.reflect(IR)
//  val cls2: ClassWithObject[Helper] = Helper.reflect(IR)
  val startClasses: List[Clasz[_ <: Actor]] = List(cls1)
  val lifter = new Lifter()
  val simulationData = lifter(startClasses, mainClass)
  val pipeline = Pipeline(new CreateActorGraphs(simulationData._1), List(
    new EdgeMerge(),
    new CreateCode(simulationData._2, "generated/main/scala"),
  ))
  pipeline.run()
}
