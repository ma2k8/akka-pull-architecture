package ma2k8.akka.actor

import akka.actor.ActorRef

case class Worker(
  id: ActorRef,
  master: ActorRef,
  work: Any)
