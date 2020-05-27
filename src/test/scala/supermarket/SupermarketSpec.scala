import meta.example.supermarket.Supermarket
import meta.example.supermarket.goods._
import org.scalatest._


class SupermarketSpec extends FlatSpec with Matchers {

  val item1_1 = new Item1
  val item1_2 = new Item1
  val item1_3 = new Item1
  val item1_4 = new Item1
  val item2_1 = new Item2
  val item2_2 = new Item2
  val item2_3 = new Item2
  val item2_4 = new Item2
  val item3_1 = new Item3
  val item3_2 = new Item3
  val item3_3 = new Item3
  val item3_4 = new Item3
  val item4_1 = new Item4



//  var itemDeque1: ItemDeque =  new ItemDeque(item1_1.name,Vector(item1_1,item1_2,item1_3,item1_4))
//  var itemDeque2: ItemDeque =  new ItemDeque(item2_1.name,Vector(item2_1,item2_2,item2_3,item2_4))
//  var itemDeque3: ItemDeque =  new ItemDeque(item3_1.name,Vector(item3_1,item3_2,item3_3,item3_4))
//val warehouse: Map[String, ItemDeque] = Map(item1_1.name -> itemDeque1, item2_1 -> itemDeque2, item3_1 -> itemDeque3)



  var items: Vector[Item] =  Vector(item1_1,item1_2,item1_3,item1_4,item2_1,item2_2,item2_3,item2_4,item3_1,item3_2,item3_3,item3_4)
  var supermarket1 = new Supermarket

  "New supermarket" should "have an empty warehouse" in {
    supermarket1.warehouse should have size 0
  }

  "initializeItemDeque" should "update the warehouse" in {
    supermarket1.initializeItemDeque(items)
    supermarket1.warehouse should have size 3
  }

  "The overloaded initializeItemDeque" should "update the warehouse" in {
    supermarket1.initializeItemDeque(item4_1)
    supermarket1.warehouse should have size 4
  }

  "Selling an item" should "update the state of the item and warehouse" in {
    supermarket1.sell(item4_1.name)
    supermarket1.warehouse should have size 3
    item4_1.state.get should be ("isPurchased")

  }

























}