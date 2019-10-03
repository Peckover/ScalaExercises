package Garage

import org.mongodb.scala.bson.collection.immutable.Document
import org.mongodb.scala.bson._

object BsonConverter extends App{
  def bsonTransformer[T](value: T)(implicit transformer: BsonTransformer[T]):BsonValue= {
    transformer(value)
  }

  def objectToDocument(obj:Product) = {
    val values = obj.productIterator
    val bsonSeq = obj.getClass.getDeclaredFields.map(_.getName -> values.next).toMap.toSeq.map{
//    val bsonValue = objMap.toSeq.map {
      case (key, value:String) => (key, bsonTransformer(value))
      case (key, value:Int) => (key, bsonTransformer(value))
      case (key, value:Double) => (key, bsonTransformer(value))
      case (key, value:Boolean) => (key, bsonTransformer(value))
      case (key, value:Seq[Int]) => (key, bsonTransformer(value))
      case (key, value:Seq[String]) => (key, bsonTransformer(value))

      case (key, value:Any) => (key, bsonTransformer(value.toString))

      // need to add a better list handling case
    }
    bsonTransformer(Document.fromSeq(bsonSeq))
    //Document.fromSeq(bsonSeq)
  }

  def printProductIterator(obj:Product)= {
    val values = obj.productIterator
    println(obj.getClass.getDeclaredFields.map( _.getName -> values.next).toMap)
  }

  //parts [LGarage.Part;@548a9f61

  val garage = new Garage

  var testCar = garage.newCar("AB12 CDE", "Fiat", "Punto", "Black", 1)
  var testBike = garage.newBike("AB12 CDE", "Ducatti", "Something", "Red", 1)
  var testEmployee = garage.registerEmployee("Mr", "Pete", "Smith", 1, "Test Street", "Test Town", "Test City", "T3 5TY", "012345678", "test@test.com", "Mechanic" )
  var testCustomer = garage.registerCustomer("Mr", "Simon", "Jones", 2, "Test Street", "Test Town", "Test City", "T3 5TY", "012345678", "test@test.com")

  printProductIterator(testEmployee)

  println(objectToDocument(testCar))
  println(objectToDocument(testBike))
  println(objectToDocument(testEmployee))
  println(objectToDocument(testCustomer))

}
