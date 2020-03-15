package supermarket

import meta.example.supermarket.Supermarket
import meta.example.supermarket.people.Employee
import org.scalatest.{FlatSpec, FunSuite, Matchers}

class EmployeeSpec extends FlatSpec with Matchers {
  var employee: Employee = new Employee

//  "fillShelf" should "work" in{
//    employee.shelfCapacity = 10
//    assert(employee.shelfCapacity == 10)
//    assert(employee.fillShelf("Pork") == 10)
//  }

  "genNewItem" should "work" in{
    assert(employee.genNewItem("Item1").getClass.getName == "meta.example.supermarket.goods.Item1")
  }

//  "addSupply" should "work" in{
//    assert(Supermarket.store.warehouse.size == 0)
//    employee.addSupply
//    assert(Supermarket.store.warehouse.size == 32)
//  }

}
