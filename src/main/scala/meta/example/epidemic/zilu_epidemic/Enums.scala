package meta.example.epidemic.zilu_epidemic

object Enums {

}


object SEIHCRD extends Enumeration {
  type SEIHCRD = String;
  val SUSCEPTIBLE = "SUSCEPTIBLE";
  val EXPOSED = "EXPOSED";
  val INFECTIOUS = "INFECTIOUS";
  val HOSPITALIZED = "HOSPITALIZED"
  val CRITICAL = "CRITICAL"
  val RECOVERED = "RECOVERED";
  val DECEASED = "DECEASED";
}


object AtLocation extends Enumeration {
  type AtLocation = String;
  val HOME = "HOME";
  val SCHOOL = "SCHOOL";
  val WORK = "WORK";
  val RANDOM = "RANDOM"
  val CRITICAL = "CRITICAL"
  val HOSPITAL = "HOSPITAL";
  val CEMENTRY = "CEMENTRY";
}


object RateCategory extends Enumeration {
  type RateCategory = String;
  val HOSPITALIZATION = "HOSPITALIZATION";
  val ICU = "ICU";
  val FATALITY = "FATALITY";
}

