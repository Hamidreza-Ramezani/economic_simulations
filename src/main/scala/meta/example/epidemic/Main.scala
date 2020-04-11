package meta.example.epidemic

object Main {

  def main(args: Array[String]): Unit = {
    var person = new Person(23, 10.1f, State.Susceptible, Location.atHome, Status.employee);
    person.updateCurrentLocation(168);
  }

}
