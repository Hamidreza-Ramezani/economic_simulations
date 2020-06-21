package meta.deep.runtime

import java.io.PrintWriter
import java.util.UUID

import meta.deep.runtime.Actor.AgentId
import meta.example.supermarket.worldmap.{Direction, Down, Left, Right, Tile, Up, World, WorldTrait}

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Map}
import scala.util.Random

/**
  * This object handles the unique id generation of an actor
  * as long as all ids are generated on a single instance
  */
object Actor {
  type AgentId = Long
  var lastAgentId: AgentId = 0
  //  val mapWidth = 10
  //  val mapHeight = 10
  //  var world: WorldTrait = _


  /**
    * Generates a new id for an agent and returns it
    *
    * @return id for an agent
    */
  def getNextAgentId: AgentId = {
    lastAgentId = lastAgentId + 1
    lastAgentId
  }

  val newActors: ListBuffer[Actor] = ListBuffer[Actor]()
}

object Monitor {
  val aggregates: Map[String, Int] = Map[String, Int]()
  val timeseries: Map[String, ListBuffer[Int]] = Map[String, ListBuffer[Int]]()

  private var daily_aggregate: mutable.Map[String, Int] = mutable.Map[String, Int]()

  def logAggregate(attr: String, num: Int = 1): Unit = {
    if (aggregates.get(attr).isEmpty) {
      aggregates += (attr -> num)
    } else {
      aggregates += (attr -> (aggregates(attr) + num))
    }
  }

  def logTimeseries(attr: String, num: Int = 1): Unit = {
    if (daily_aggregate.get(attr).isEmpty) {
      daily_aggregate += (attr -> num)
    } else {
      daily_aggregate += (attr -> (daily_aggregate(attr) + num))
    }
  }

  def initTimeseries(attr: String*): Unit = {
    attr.foreach(x =>
      timeseries += (x -> ListBuffer())
    )
  }

  // consider handling aggregates at different granularity
  private def timeElapse(): Unit = {
    timeseries.foreach(x =>
      x._2.append(daily_aggregate.getOrElse(x._1, 0))
    )
    daily_aggregate.clear()
  }

  def eachIteration(action: () => Unit =
                    () => {
                      println("Monitor stats: " + aggregates)
                    }): Unit = {
    action()
    timeElapse()
  }

  def onCompletion(action: () => Unit =
                   () => println("Summary: \n" + aggregates
                     + "\nTimeseries:\n" + timeseries)): Unit = {
    action()
  }
}

/**
  * This class is the supertype of the messages
  */
abstract class Message extends Serializable {

  /**
    * The sender of the message
    */
  val senderId: Actor.AgentId

  /**
    * The receiver of the message
    */
  val receiverId: Actor.AgentId

  /**
    * A unique id for the message-communication (request/response)
    */
  var sessionId: String = UUID.randomUUID().toString

  override def toString: String = {
    "Message: " + senderId + " -> " + receiverId + "(" + sessionId + ")"
  }
}

/**
  * This represents a message, which is used for sending something to another actor
  *
  * @param senderId   the id of the sender
  * @param receiverId the id of the receiver
  * @param methodId   the id of the method which should be called
  * @param argss      the arguments of the method
  */
case class RequestMessage(override val senderId: Actor.AgentId,
                          override val receiverId: Actor.AgentId,
                          methodId: Int,
                          argss: List[List[Any]])
  extends Message {

  var future: Future[Any] = Future[Any]()

  /**
    * this functions simplified the replying to a method
    *
    * @param owner       the sender of the reply message
    * @param returnValue the return value/answer for the request message
    */
  def reply(owner: Actor, returnValue: Any): Unit = {
    val msg = ResponseMessage(receiverId, senderId, returnValue)
    msg.sessionId = this.sessionId
    owner.sendMessage(msg)
  }
}

/**
  * This class is used to answer to a received message.
  *
  * @param senderId   the id of the sender
  * @param receiverId the id of the receiver
  * @param arg        the return value of the method/answer of the request message
  */
case class ResponseMessage(override val senderId: Actor.AgentId,
                           override val receiverId: Actor.AgentId,
                           arg: Any)
  extends Message

case class Future[+T](var isCompleted: Boolean = false,
                      value: Option[T] = None,
                      id: String = UUID.randomUUID().toString) {
  def setValue[U >: T](y: U): Future[U] = {
    Future(isCompleted = true, Some(y), id)
  }
}

/**
  * This class represents the main class of the generated classes
  * It contains the logic for message handling and defines the
  * functions for a step-wise simulation
  */
class Actor {

  var id: AgentId = Actor.getNextAgentId
  var agentName: String = getClass.getSimpleName
  var timer: Int = 0
  var current_pos: Int = 0
  var monitor = Monitor
  //  var writer: PrintWriter = new PrintWriter(new FileWriter(new File("m/agent" + id)))
  var writer: PrintWriter = _
  var initialXPosition: Int = 0
  var initialYPosition: Int = 0
  var currentXPosition: Int = 0
  var currentYPosition: Int = 0
  var oldXPosition: Int = 0
  var oldYPosition: Int = 0
  var canMove: Boolean = true
  var async_messages: Map[String, Future[Any]] = Map[String, Future[Any]]()

  def setInitialPosition(x: Int, y: Int): Unit = {
    this.initialXPosition = x
    this.initialYPosition = y
    currentXPosition = initialXPosition
    currentYPosition = initialYPosition
  }

  def manhattanDistanceFromHome(): Int = {
    val xDifference = (this.currentXPosition - initialXPosition).abs
    val yDifference = (this.currentYPosition - initialYPosition).abs
    val distance: Int = xDifference + yDifference
    distance
  }


  def manhattanDistanceFrom(actor: Actor): Int = {
    val xDifference = (this.currentXPosition - actor.currentXPosition).abs
    val yDifference = (this.currentYPosition - actor.currentYPosition).abs
    val distance: Int = xDifference + yDifference
    distance
  }

  def comeBackToInitialPoint(world: WorldTrait): Unit = {
    move(world, initialXPosition, initialYPosition)
  }

  def move(world: WorldTrait, target: Actor): Unit = {
    move(world, target.currentXPosition, target.currentYPosition)
  }

  def move(world: WorldTrait, targetXPosition: Int, targetYPosition: Int): Unit = {
    if (canMove) {
      while (currentXPosition < targetXPosition) {
        move(world, Down)
      }
      while (currentXPosition > targetXPosition) {
        move(world, Up)
      }
      while (currentYPosition < targetYPosition) {
        move(world, Right)
      }
      while (currentYPosition > targetYPosition) {
        move(world, Left)
      }
    }
  }

  def move(world: WorldTrait, direction: Direction): Unit = {
    if (canMove) {
      val coordinates: Array[Array[Tile]] = world.coordinates
      val worldRows: Int = coordinates(0).length
      val worldCols: Int = coordinates.length
      var directionOptions: ListBuffer[Direction] = new ListBuffer[Direction]
      directionOptions += Up
      directionOptions += Right
      directionOptions += Down
      directionOptions += Left
      /*
       * 1 = move up		3 = move down
       * 2 = move right	4 = move left
       */
      // Entity is in left column
      if (this.currentXPosition == 0) {
        directionOptions -= Up
      }
      // Entity is in right column
      else if (this.currentXPosition == worldCols) {
        directionOptions -= Down
      }
      // Entity is in top row
      if (this.currentYPosition == 0) {
        directionOptions -= Left
      }
      // Entity is in bottom row
      else if (this.currentYPosition == worldRows) {
        directionOptions -= Right
      }
      //      val randomMove = directionOptions(randomInt.nextInt(directionOptions.size))

      if (directionOptions.contains(direction)) {
        this.oldXPosition = this.currentXPosition
        this.oldYPosition = this.currentYPosition
        direction match {
          case Right => this.currentYPosition = this.currentYPosition + 1
          case Down => this.currentXPosition = this.currentXPosition + 1
          case Left => this.currentYPosition = this.currentYPosition - 1
          case Up => this.currentXPosition = this.currentXPosition - 1
        }
        //update map
        world.updateMap(this)
      }
    }
  }


  final def isCompleted(future_obj: Future[Any]): Boolean = {
    async_messages.get(future_obj.id).isDefined
  }

  final def getFutureValue[T](future_obj: Future[T]): T = {
    async_messages.get(future_obj.id).get.value.get.asInstanceOf[T]
  }

  final def clearFutureObj(future_obj: Future[Any]): None.type = {
    async_messages = async_messages.-(future_obj.id)
    None
  }

  /**
    * Contains the received messages from the previous step
    */
  protected var receivedMessages: List[Message] = List()

  /**
    * Contains the messages, which should be sent to other actors in the next step
    */
  protected var sendMessages: List[Message] = List()

  /**
    * A map of listeners, which is required to register a listener for a response of a request message
    */
  protected var responseListeners
  : Map[String, Message => Unit] = Map()

  /**
    * Adds one message to the sendActions list, which will be collected and distributed at the end of the step
    *
    * @param message Action, which should be sent to a different Agent
    */
  final def sendMessage(message: Message): Unit = {
    if (message.receiverId == this.id) {
      addReceiveMessages(List(message))
    } else {
      sendMessages = message :: sendMessages
    }
  }

  /**
    * Adds a list of messages to the agent
    *
    * @param messages Actions with receiver matching the agent from the previous step
    */
  final def addReceiveMessages(messages: List[Message]): Actor = {
    this.receivedMessages = this.receivedMessages ::: messages.filter(
      x =>
        x.isInstanceOf[RequestMessage] || responseListeners
          .get(x.sessionId)
          .isEmpty)
    messages
      .filter(
        x =>
          responseListeners.get(x.sessionId).isDefined && x
            .isInstanceOf[ResponseMessage])
      .foreach(x => {
        val handler = responseListeners(x.sessionId)
        responseListeners.remove(x.sessionId)
        handler(x)
      })
    this
  }

  /**
    * This returns all messages, which are sent via sendMessage
    *
    * @return the actor itself
    */
  final def getSendMessages: List[Message] = {
    sendMessages
  }

  /**
    * This resets sendMessages, so that getSendMessages is empty again
    *
    * @return the actor itself
    */
  final def cleanSendMessage: Actor = {
    sendMessages = List()
    this
  }

  /**
    * Sets a message response handler for a specific session id
    *
    * @param sessionId session of message you want to listen for a response
    * @param handler   function, which handles the message
    */
  final def setMessageResponseHandler(sessionId: String,
                                      handler: Message => Unit): Unit = {
    responseListeners += (sessionId -> handler)
  }

  /**
    * This function removes all receivedMessages of type RequestMessage from the receivedMessages list
    * and returns them to the method caller
    *
    * @return a list of receivedMessages of type RequestMessage
    */
  final def popRequestMessages: List[RequestMessage] = {
    val rM = this.receivedMessages
      .filter(_.isInstanceOf[RequestMessage])
      .map(_.asInstanceOf[RequestMessage])
    this.receivedMessages =
      this.receivedMessages.filterNot(_.isInstanceOf[RequestMessage])
    rM
  }

  /**
    * This function removes all receivedMessages of type ResponseMessage from the receivedMessages list
    * and returns them to the method caller
    *
    * @return a list of receivedMessages of type ResponseMessage
    */
  final def popResponseMessages: List[ResponseMessage] = {
    val rM = this.receivedMessages
      .filter(_.isInstanceOf[ResponseMessage])
      .map(_.asInstanceOf[ResponseMessage])
    this.receivedMessages =
      this.receivedMessages.filterNot(_.isInstanceOf[ResponseMessage])
    rM
  }

  /**
    * This runs the stepFunction until the timer > until
    *
    * @param until how long the code should be executed
    * @return the actor itself
    */
  def run_until(until: Int): Actor = {
    while (timer <= until) {
      println(this.getClass.getSimpleName, timer, until, current_pos)
      val (a, b) = stepFunction
      current_pos = a
      timer = b
    }
    this
  }

  /**
    * Executes one step in the simulation.
    * By default it does not change the pos and increases the timer at 1 (next step)
    *
    * @return a function, which takes the position and timer and
    *         returns the next position and timer which should be passed again
    *         when calling this function the next time.
    */
  def stepFunction: (Int, Int) = (current_pos, timer + 1)
}
