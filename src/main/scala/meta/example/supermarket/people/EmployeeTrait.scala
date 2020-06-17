package meta.example.supermarket.people

import meta.deep.runtime.Actor
import meta.example.supermarket.logistics.{Farmer, FarmerTrait, ManufacturerTrait, TruckTrait}
import meta.example.supermarket.{Section, SectionTrait, Supermarket, SupermarketTrait}

trait EmployeeTrait extends Actor {
  var state: EmployeeState = EmployeeState()
  var section: SectionTrait
  var hasItemsOnTheWay: Boolean = true
  var manufacturer: ManufacturerTrait
  var truck: TruckTrait = manufacturer.truck
  var supermarket: SupermarketTrait

  override def setInitialPosition(x: Int, y: Int): Unit = {
    this.xPosition = supermarket.xPosition
    this.yPosition = supermarket.yPosition
  }


  //  def getFreeSpace(item: String): Int = {
  //    Supermarket.store.shelfCapacity - Supermarket.store.warehouse(item).size
  //  }

  //  def addSupply: Unit = {
  //    var section: List[String] = null
  //    //    if (this.section == "Dairy") {
  //    //      section = categories.dairyss.toList.map(n => n._1)
  //    //    } else if (this.section == "Grain") {
  //    //      section = categories.grainss.toList.map(n => n._1)
  //    //    } else if (this.section == "Meat") {
  //    //      section = categories.meatss.toList.map(n => n._1)
  //    //    } else if (this.section == "Snack") {
  //    //      section = categories.snackss.toList.map(n => n._1)
  //    //    } else if (this.section == "Vegetable") {
  //    //      section = categories.vegiess.toList.map(n => n._1)
  //    //    }
  //    //    section.foreach(t => println(t))
  //    //    newItemsMap.itemMap.keys.toList.filter(t => section.contains(t)).foreach(
  //    //      item => List.tabulate(getFreeSpace(item))(n => n).foreach(_ => {
  //    //        val new_item: Item = genNewItem(newItemsMap.itemMap(item))
  //    //        Supermarket.store.warehouse(item) += (new_item.asInstanceOf[Item])
  //    //                println("Add new actor! name: " + item)
  //    //      })
  //    //    )
  //    newItemsMap.itemMap.keys.toList.foreach(
  //      item => List.tabulate(getFreeSpace(item))(n => n).foreach(_ => {
  //        val new_item: Item = genNewItem(newItemsMap.itemMap(item))
  //        Supermarket.store.warehouse(item) += (new_item.asInstanceOf[Item])
  //        //        println("Add new actor! name: " + item)
  //      })
  //    )
  //  }
}
