package generated

object InitData  {
  def initActors: List[meta.deep.runtime.Actor] = {{
  val l_0 = scala.collection.mutable.ListBuffer.apply[meta.deep.runtime.Actor]();
  val trafficLight_1 = new generated.TrafficLight();
  val passenger_2 = new generated.Passenger();
  val driver_3 = new generated.Driver();
  passenger_2.`trafficLight_=`(trafficLight_1);
  driver_3.`trafficLight_=`(trafficLight_1);
  l_0.append(trafficLight_1);
  l_0.append(passenger_2);
  l_0.append(driver_3);
  l_0.toList
}}
}