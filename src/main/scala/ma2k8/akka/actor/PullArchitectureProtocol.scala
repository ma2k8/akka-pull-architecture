package ma2k8.akka.actor

object PullArchitectureProtocol {
  // Messages from Workers
  case class WorkerCreated(worker: Worker)
  case class WorkerRequestsWork(worker: Worker)
  case class WorkIsDone(worker: Worker)

  // Messages to Workers
  case class WorkToBeDone(work: Any)
  case object WorkIsReady
  case object NoWorkToBeDone
}
