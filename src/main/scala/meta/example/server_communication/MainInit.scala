package meta.example.server_communication

import meta.deep.runtime.Actor
import squid.quasi.lift

import scala.collection.mutable.ListBuffer

@lift
class MainInit {
  def main(): List[Actor] = {
    val l = ListBuffer[Actor]()

    for(i <- 1 to 1) {
      val backendServer = new BackendServer
      val frontendServer = new FrontendServer
      frontendServer.backendServer = backendServer

      l.append(backendServer)
      l.append(frontendServer)
    }

    l.toList

  }
}
