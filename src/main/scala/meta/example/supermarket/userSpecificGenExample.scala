package meta.example.supermarket

import java.io.File

import meta.example.supermarket.goods.global

object userSpecificGenExample {
  val exampleDir: String = "testItemOnly"
  val exampleName: String = exampleDir+"Example"
  val packageName: String = s"meta.example.supermarket.${exampleName}"
  val initName: String = "MainInit"

  // *Ids are 1-indexed.
  val totalItems: Int = global.itemMap.size
  val custIds: List[Int] = Range(1,11).toList
  val itemIds: List[Int] = (1 to totalItems).toList
  val employeeIds: List[Int] = (1 to 1).toList

  val storagePathGegenerated: String = "generated/main/scala"

  var cwd = new File(".").getCanonicalPath()
  cwd = cwd + "/src/main/scala/meta/example/supermarket/"
  val fdir = new File(cwd + s"${exampleDir}")
}
