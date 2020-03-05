package meta.example.traffic_light_example

import meta.deep.runtime.Actor
import squid.quasi.lift

import scala.collection.mutable.ListBuffer

@lift
class MainInit {
  def main(): List[Actor] = {
    val l = ListBuffer[Actor]()
    val trafficLight: TrafficLight = new TrafficLight()
    val passenger: Person = new Person()
    val driver: Driver = new Driver()
    passenger.trafficLight = trafficLight
    driver.trafficLight = trafficLight
    l.append(trafficLight)
    l.append(passenger)
    l.append(driver)
    l.toList
  }
}
