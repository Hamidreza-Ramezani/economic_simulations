package meta.example.parameter_list_example.toy_factory_example

import meta.classLifting.Lifter
import meta.deep.codegen.{CreateActorGraphs, CreateCode, EdgeMerge, Pipeline}
import meta.deep.runtime.Actor
import meta.deep.IR
import meta.deep.IR.TopLevel._

object toyFactoryExample extends App {
  val cls1: ClassWithObject[toy] = toy.reflect(IR)
  val cls2: ClassWithObject[toyFactory] = toyFactory.reflect(IR)
  val mainClass: ClassWithObject[MainInit] = MainInit.reflect(IR)
  val startClasses: List[Clasz[_ <: Actor]] = List(cls1, cls2)
  val lifter = new Lifter()
  val simulationData = lifter(startClasses, mainClass)

  val pipeline = Pipeline(new CreateActorGraphs(simulationData._1), List(
    new EdgeMerge(),
    new CreateCode(simulationData._2, "generated/main/scala"),
  ))

  pipeline.run()
}