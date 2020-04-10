package meta.example.epidemic

object State extends Enumeration {
  type State = String;
  val Susceptible = "Susceptible";
  val Exposed = "Exposed";
  val Infectious = "Infectious";
  val Recovered = "Recovered";
}
