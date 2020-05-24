package meta.example.supermarket.testItemOnly

import meta.classLifting.Lifter
import meta.deep.codegen._
import meta.deep.runtime.Actor
import meta.deep.IR
import meta.deep.IR.TopLevel._
import meta.example.supermarket.customers.{Customer1, Customer2, Customer3}
import meta.example.supermarket.goods.{Dairy, Grain, Meat, Snack, Vegetable, _}
import meta.example.supermarket.people._

object testItemOnlyExample extends App {
  val mainClass: ClassWithObject[MainInit] = MainInit.reflect(IR)
  val cls1: ClassWithObject[Vegetable] = Vegetable.reflect(IR)
  val cls2: ClassWithObject[Meat] = Meat.reflect(IR)
  val cls3: ClassWithObject[Snack] = Snack.reflect(IR)
  val cls4: ClassWithObject[Grain] = Grain.reflect(IR)
  val cls5: ClassWithObject[Dairy] = Dairy.reflect(IR)
  val clsEmp1: ClassWithObject[Employee] = Employee.reflect(IR)
  val clsCust1: ClassWithObject[Customer1] = Customer1.reflect(IR)
  val clsCust2: ClassWithObject[Customer2] = Customer2.reflect(IR)
  val clsCust3: ClassWithObject[Customer3] = Customer3.reflect(IR)
  val clsCashier1: ClassWithObject[Cashier] = Cashier.reflect(IR)

  //  val clsCust4: ClassWithObject[Customer4] = Customer4.reflect(IR)
  //  val clsCust5: ClassWithObject[Customer5] = Customer5.reflect(IR)
  //  val clsCust6: ClassWithObject[Customer6] = Customer6.reflect(IR)
  //  val clsCust7: ClassWithObject[Customer7] = Customer7.reflect(IR)
  //  val clsCust8: ClassWithObject[Customer8] = Customer8.reflect(IR)
  //  val clsCust9: ClassWithObject[Customer9] = Customer9.reflect(IR)
  //  val clsCust10: ClassWithObject[Customer10] = Customer10.reflect(IR)

  //  val startClasses: List[Clasz[_ <: Actor]] = List(cls1, cls2, cls3, cls4, cls5, clsEmp1, clsCust1, clsCust2, clsCust3, clsCust4, clsCust5, clsCust6, clsCust7, clsCust8, clsCust9, clsCust10)
  val startClasses: List[Clasz[_ <: Actor]] = List(cls1, cls2, cls3, cls4, cls5, clsEmp1, clsCust1, clsCust2, clsCust3, clsCashier1)
  val lifter = new Lifter()
  val simulationData = lifter(startClasses, mainClass)

  val pipeline = Pipeline(new CreateActorGraphs(simulationData._1), List(
    new EdgeMerge(),
    new CreateCode(simulationData._2, "generated/main/scala"),
  ))
  pipeline.run()
}
