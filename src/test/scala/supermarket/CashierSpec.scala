//package supermarket
//
//import meta.example.supermarket.goods._
//import meta.example.supermarket.people.Cashier
//import org.scalatest.{FlatSpec, Matchers}
//
//import scala.collection.mutable
//import scala.collection.mutable.ListBuffer
//
//class CashierSpec extends FlatSpec with Matchers{
//  //test scenario: check the scanItems
//  //case1: the number of customers is less than the numOfBasketsHandledInOneStep
//  //case2: the number of customers is twice as the numOfBasketsHandledInOneStep
//  //case3: the number of customers is way more than the numOfBasketsHandledInOneStep
//
//  var item1_1 = new Item1
//  var item1_2 = new Item1
//  var item1_3 = new Item1
//  var item1_4 = new Item1
//  var item1_5 = new Item1
//  var item1_6 = new Item1
//  var item1_7 = new Item1
//  var item2_1 = new Item2
//  var item2_2 = new Item2
//  var item2_3 = new Item2
//  var item2_4 = new Item2
//  var item2_5 = new Item2
//  var item2_6 = new Item2
//  var item2_7 = new Item2
//  var item3_1 = new Item3
//  var item3_2 = new Item3
//  var item3_3 = new Item3
//  var item3_4 = new Item3
//  var item3_5 = new Item3
//  var item3_6 = new Item3
//  var item3_7 = new Item3
//  var item4_1 = new Item4
//  var item4_2 = new Item4
//  var item4_3 = new Item4
//  var item4_4 = new Item4
//  var item4_5 = new Item4
//  var item4_6 = new Item4
//  var item4_7 = new Item4
//  var basket1: ListBuffer[Item] = ListBuffer(item1_1,item2_1,item3_1,item4_1)
//  var basket2: ListBuffer[Item] = ListBuffer(item1_2,item2_2,item3_2,item4_2)
//  var basket3: ListBuffer[Item] = ListBuffer(item1_3,item2_3,item3_3,item4_3)
//  var basket4: ListBuffer[Item] = ListBuffer(item1_4,item2_4,item3_4,item4_4)
//  var basket5: ListBuffer[Item] = ListBuffer(item1_5,item2_5,item3_5,item4_5)
//  var basket6: ListBuffer[Item] = ListBuffer(item1_6,item2_6,item3_6,item4_6)
//  var basket7: ListBuffer[Item] = ListBuffer(item1_7,item2_7,item3_7,item4_7)
//  var queue: mutable.Queue[ListBuffer[Item]] = mutable.Queue()
//  var cashier: Cashier = new Cashier
//
//
//  //please comment out the waitTurn inside cashier class
//  "isFirstBasket" should "be false if the queue contains only one basket" in {
//    assert(cashier.isFirstBasket == true)
//    queue.enqueue(basket1)
//    queue.enqueue(basket2)
//    cashier.scanItems(queue)
//    assert(cashier.isFirstBasket == false)
//    assert(queue.isEmpty == false)
//    cashier.scanItems(queue)
//    assert(queue.isEmpty == true)
//    assert(cashier.isFirstBasket == true)
//  }
//
//  "numOfBasketsHandledInOneStep" should "be updated" in {
//    assert(cashier.numOfBasketsHandledInOneStep == 1)
//    cashier.numOfBasketsHandledInOneStep = 2
//    assert(cashier.numOfBasketsHandledInOneStep == 2)
//  }
//
//  "scanItems" should "work if the size of queue is less than numOfBasketsHandledInOneStep" in {
//    cashier.numOfBasketsHandledInOneStep = 2
//    assert(cashier.numOfBasketsHandledInOneStep == 2)
//    queue.enqueue(basket3)
//    cashier.scanItems(queue)
//    assert(item1_3.state.get == "isPurchased")
//    assert(item2_3.state.get == "isPurchased")
//    assert(item3_3.state.get == "isPurchased")
//    assert(item4_3.state.get == "isPurchased")
//    assert(queue.isEmpty == true)
//  }
//
//  "scanItems" should "work if the size of queue is way more than the numOfBasketsHandledInOneStep" in {
//    cashier.numOfBasketsHandledInOneStep = 1
//    assert(cashier.numOfBasketsHandledInOneStep == 1)
//    queue.enqueue(basket4)
//    queue.enqueue(basket5)
//    queue.enqueue(basket6)
//    queue.enqueue(basket7)
//    assert(item1_4.state.get == "onDisplay")
//    assert(item1_5.state.get == "onDisplay")
//    assert(item1_6.state.get == "onDisplay")
//    assert(item1_7.state.get == "onDisplay")
//    assert(item2_4.state.get == "onDisplay")
//    assert(item2_5.state.get == "onDisplay")
//    assert(item2_6.state.get == "onDisplay")
//    assert(item2_7.state.get == "onDisplay")
//    assert(item3_4.state.get == "onDisplay")
//    assert(item3_5.state.get == "onDisplay")
//    assert(item3_6.state.get == "onDisplay")
//    assert(item3_7.state.get == "onDisplay")
//    assert(item4_4.state.get == "onDisplay")
//    assert(item4_5.state.get == "onDisplay")
//    assert(item4_6.state.get == "onDisplay")
//    assert(item4_7.state.get == "onDisplay")
//
//    assert(cashier.isFirstBasket == true)
//    cashier.scanItems(queue)
//    assert(cashier.isFirstBasket == false)
//    cashier.scanItems(queue)
//    assert(cashier.isFirstBasket == false)
//    cashier.scanItems(queue)
//    assert(cashier.isFirstBasket == false)
//    cashier.scanItems(queue)
//    assert(cashier.isFirstBasket == true)
//    assert(queue.isEmpty == true)
//
//    assert(item1_4.state.get == "isPurchased")
//    assert(item1_5.state.get == "isPurchased")
//    assert(item1_6.state.get == "isPurchased")
//    assert(item1_7.state.get == "isPurchased")
//    assert(item2_4.state.get == "isPurchased")
//    assert(item2_5.state.get == "isPurchased")
//    assert(item2_6.state.get == "isPurchased")
//    assert(item2_7.state.get == "isPurchased")
//    assert(item3_4.state.get == "isPurchased")
//    assert(item3_5.state.get == "isPurchased")
//    assert(item3_6.state.get == "isPurchased")
//    assert(item3_7.state.get == "isPurchased")
//    assert(item4_4.state.get == "isPurchased")
//    assert(item4_5.state.get == "isPurchased")
//    assert(item4_6.state.get == "isPurchased")
//    assert(item4_7.state.get == "isPurchased")
//
//  }
//
//
//
//}