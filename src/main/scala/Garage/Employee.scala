package Garage

class Employee (
  val id: Int,
  val title: String, //could use enums in future
  val forename: String,
  val surname: String,
  val address: Address,
  var telephoneHome: String,
  var telephoneMobile: String,
  var email: String,
  var jobRole: String //enum in future
    ) extends Person {

  def this(
           title: String,
           forename:String,
           surname:String,
           address: Address,
           telephoneHome: String,
           telephoneMobile:String,
           email:String,
           jobRole: String) = this (
    Employee.generateId(), //create auto id
    title,
    forename,
    surname,
    address: Address,
    telephoneHome,
    telephoneMobile,
    email,
    jobRole
  )

  override def toString: String =
    s"""$id
       |$title $forename $surname,
       |$address,
       |$telephoneHome,
       |$telephoneMobile,
       |$jobRole
       |$email""".stripMargin

}

object Employee extends GenerateId {
  var idCount = 0
  generateId()
}