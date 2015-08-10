package ma2k8.akka.actor

import akka.actor.{ActorLogging, Actor}
import akka.event.slf4j.Logger

class TestActor extends Actor with ActorLogging {

  val interval = 60000 // 1 min
  val maxCount: Int = 500
  val sleepInterval = 1000 // 1 sec

  override def receive: Receive = {
    case 'hoge =>
      log.info("testAAAAAAAAAAAAAA")
      println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
      Thread.sleep(interval)
      self ! 'hoge
  }

}
