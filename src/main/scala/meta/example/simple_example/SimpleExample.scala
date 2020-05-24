package meta.example.simple_example


import meta.classLifting.{Lifter, SpecialInstructions}
import meta.deep.IR
import meta.deep.codegen.{CreateActorGraphs, CreateCode, EdgeMerge, Pipeline}
import meta.deep.runtime.Actor
import squid.quasi.lift
import meta.deep.IR.TopLevel._


@lift
class MainClass1 {
  def main(): List[Actor] = {
    val a = new Example()
    List(a)
  }
}

@lift
class Example extends Actor {
  def main():Unit = {
    var a = 5
    println(a)
    println(a + 5)
    SpecialInstructions.waitTurns(2)
    println("now im here")
  }
}

object SimpleExample extends App {
  val cls1: ClassWithObject[Example] = Example.reflect(IR)
  val cls2: ClassWithObject[MainClass1] = MainClass1.reflect(IR)
  val startClasses: List[Clasz[_ <: Actor]] = List(cls1)
  val mainClass = cls2
  val lifter = new Lifter()
  val simulationData = lifter(startClasses, mainClass)

  val pipeline = Pipeline(
    new CreateActorGraphs(simulationData._1),
    List(new EdgeMerge(), new CreateCode(simulationData._2,"generated/main/scala"))
  )

  pipeline.run()
}