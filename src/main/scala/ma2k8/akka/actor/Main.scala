package ma2k8.akka.actor

import akka.actor._
import akka.routing.RoundRobinPool
import kamon.Kamon
import com.typesafe.config.ConfigFactory
import scala.collection.JavaConverters._

object Main {
//  val roles = ConfigFactory.load.getConfig("akka.cluster").getStringList("roles").asScala
//  val primaryRole: String = roles.headOption.getOrElse(sys.error("akka.cluster.roles is empty"))

  def main(args: Array[String]): Unit = {
    Kamon.start()
    implicit val system = ActorSystem("cluster")

    val testA = system.actorOf(Props[TestActor].withRouter(new RoundRobinPool(30)))
    println("aaaaaa")

    while (true) {
      testA ! 'hoge
    }

//    primaryRole match {
//      case "seed"    =>
//      case "counter" =>
//      case "frontend" =>
//      case role => sys.error(s"Unexpected role $role")
//    }
  }
}
