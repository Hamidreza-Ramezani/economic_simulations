package meta.example.actor_merge_example

import meta.classLifting.Lifter
import meta.deep.codegen.{ActorMerge, CreateActorGraphs, CreateCode, EdgeMerge, Pipeline}
import meta.deep.runtime.Actor
import meta.deep.IR
import meta.deep.IR.TopLevel._

object actorMergeExample extends App{
  val cls1: ClassWithObject[object1] = object1.reflect(IR)
  val cls2: ClassWithObject[object2] = object2.reflect(IR)
  val mainClass: ClassWithObject[MainInit] = MainInit.reflect(IR)
  val startClasses: List[Clasz[_ <: Actor]] = List(cls1, cls2)
  val lifter = new Lifter()
  val simulationData = lifter(startClasses, mainClass)

  val pipeline = Pipeline(new CreateActorGraphs(simulationData._1), List(
    new ActorMerge(List(("object1", "object2"))),
    new EdgeMerge(),
    new CreateCode(simulationData._2, "generated/main/scala"),
  ))

  pipeline.run()
}
