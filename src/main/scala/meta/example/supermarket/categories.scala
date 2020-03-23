package meta.example.supermarket

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object categories {
  type categoryName = String
  type articleName = String
  type price = Double
  type priceUnit = Int
  type gram = Int
  type discount = Double
  type stock = Int
  type namePriceUnit = Vector[(articleName, price, priceUnit, discount, stock)]

  final case class Attr(name: String, attrVal: Any)
  final case class Article(name: articleName, fields: Vector[Attr])
  final case class Category(name: categoryName, fields: Vector[Attr], children: Vector[Article])
  // Parameters of CategoryFields and ArticleFields should be DISJOINT
  final case class ArticleFields(price: price, priceUnit: priceUnit, discount: discount, stock: stock)
  final case class CategoryFields(freshUntil: Int, visibility: Double)

  val kg: Int = 1000
  val bar: Int = 100
  val box: Int = 250
  val bag: Int = 300
  val cup: Int = 50 // a cup of yogurt
  val carton: Int = 250
  val piece: Int = 200 // a piece of cheese/cucumber

  var totalCategories: Int = 0;
  val summary: ListBuffer[(categoryName, CategoryFields, namePriceUnit)] = ListBuffer()

  val Vegie: CategoryFields = CategoryFields(5, 1.0)
  // Unify the unit to simplify random selection of the article
  val vegieStock: stock = 5 // Leave stock as an attribute of item rather than category for more flexibility
  val vegiess: namePriceUnit = Vector(
    ("Eggplant", 2, piece, 0, 3),
    ("Potato", 0.8, piece, 0, 2),
    ("Onion", 0.8, piece, 0, 2),
    ("Broccoli", 2, piece, 0, vegieStock),
    ("Cucumber", 1.5, piece, 0, vegieStock),
    ("Carrots", 1, piece, 0, vegieStock),
    ("Celery", 2, piece, 0, vegieStock),
    ("Tomato", 1.5, piece, 0, vegieStock),
    ("Mushroom", 2, piece, 0, vegieStock),
    ("Cabbage", 1, piece, 0, vegieStock),
    ("Squash", 1, piece, 0, vegieStock)
  )

  val Meat: CategoryFields = CategoryFields(15, 0.8)
  val meatStock: stock = 3
  val meatss: namePriceUnit = Vector(
    ("Chicken", 15, kg, 0, meatStock),
    ("Beef", 35, kg, 0, meatStock),
    ("Pork", 25, kg, 0, meatStock),
    ("Lamb", 45, kg, 0, meatStock),
    ("Bacon", 25, kg, 0, meatStock)
  )

  val Snack: CategoryFields = CategoryFields(100, 1.0)
  val snackStock: stock = 10
  val snackss: namePriceUnit = Vector(
    ("Kitkat", 3.5, bag, 0, snackStock),
    ("Ferraro", 5, box, 0, snackStock),
    ("DarkChocolate", 1.8, bar, 0, snackStock),
    ("WhiteChocolate", 1.8, bar, 0, snackStock))

  val Grain: CategoryFields = CategoryFields(50, 0.6)
  val grainStock: stock = 4
  val grainss: namePriceUnit = Vector(
    ("Cereal", 4, kg, 0, grainStock),
    ("Oatmeal", 4, kg, 0, grainStock),
    ("Rice", 2, kg, 0, grainStock),
    ("Noodles", 3, kg, 0, grainStock),
    ("Spaghetti", 1.5, kg, 0, grainStock),
    ("Pasta", 1.5, kg, 0, grainStock),
    ("Bread", 1.5, kg, 0, grainStock))

  // Treat egg as vegetable as it has expiration date is later
  val Dairy: CategoryFields = CategoryFields(7, 0.8)
  val dairyStock: stock = 3
  val dairyss: namePriceUnit = Vector(
    ("Milk", 2, kg, 0, dairyStock),
    ("Yogurt", 1, cup, 0, dairyStock),
    ("Cheese", 5, piece, 0, dairyStock),
    ("Cream", 1, cup, 0, dairyStock),
    ("Egg", 3, carton, 0, dairyStock))

  private def addToSummary(name: categoryName, newCategory: CategoryFields, newCategoryNamePrice: namePriceUnit): Unit = {
    summary.append((name, newCategory, newCategoryNamePrice))
    totalCategories += 1
  }

  // Capitalize the Name
  def addAll: Unit = {
    addToSummary("Vegetable", Vegie, vegiess)
    addToSummary("Meat", Meat, meatss)
    addToSummary("Snack", Snack, snackss)
    addToSummary("Grain", Grain, grainss)
    addToSummary("Dairy", Dairy, dairyss)
  }

  addAll

  def getCnt: Int = { totalCategories }

  def getSummary: Vector[(categoryName, CategoryFields, namePriceUnit)] = { summary.toVector }

  def getCategoryNames: Vector[categoryName] = { summary.toVector.map(item => item._1.capitalize) }

  def getArticleNames(categoryName: categoryName): Vector[articleName] = {
    summary.find(x => x._1==categoryName.capitalize).get
      ._3
      .map(article => article._1.capitalize)
  }

  def getArticleNames: Vector[articleName] = {
    getCategoryNames.flatMap(
      categoryName => getArticleNames(categoryName)
    )
  }

  def getArticlePrices(categoryName: categoryName): Vector[price] = {
    summary.find(x => x._1==categoryName.capitalize).get
      ._3
      .map(article => article._2)
  }

  def getArticlePrices: Vector[price] = {
    getCategoryNames.flatMap(
      categoryName => getArticlePrices(categoryName)
    )
  }

  def getArticleStocks(categoryName: categoryName): Vector[stock] = {
    summary.find(x => x._1==categoryName.capitalize).get
      ._3
      .map(article => article._5)
  }

  def getArticleStocks: Vector[stock] = {
    getCategoryNames.flatMap(
      categoryName => getArticleStocks(categoryName)
    )
  }

  val articleUnitMap: Map[articleName, priceUnit] = (getArticleNames zip getArticleUnits).toMap
  var articleCategoryMap: mutable.Map[articleName, categoryName] = mutable.Map()

  getCategoryNames.foreach(
    category => getArticleNames(category).foreach(article => articleCategoryMap+=(article -> category))
  )

  def getArticleUnits(categoryName: categoryName): Vector[priceUnit] = {
    summary.find(x => x._1==categoryName.capitalize).get
      ._3
      .map(article => article._3)
  }

  def getArticleUnits: Vector[priceUnit] = {
    getCategoryNames.flatMap(
      categoryName => getArticleUnits(categoryName)
    )
  }

  def getArticleUnit(article: articleName): priceUnit = {
//    println("article unit map is " + articleUnitMap)
    assert(articleUnitMap contains article)
    articleUnitMap.get(article).get
  }

  def getArticleCategory(article: articleName): categoryName = {
//    println("article category map is " + articleCategoryMap)
    assert(articleCategoryMap contains article)
    articleCategoryMap.get(article).get
  }
}
