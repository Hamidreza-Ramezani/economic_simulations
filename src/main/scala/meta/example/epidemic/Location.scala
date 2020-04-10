package meta.example.epidemic

object Location extends Enumeration {
  type Location = String;
  val atHome = "atHome"
  val atSchool = "atSchool"
  val atWork = "atWork"
  val inCommunity = "inCommunity"
  val atHospital = "atHospital"
}
