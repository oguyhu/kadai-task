package models

import java.time.ZonedDateTime

import scalikejdbc._
import skinny.orm._

case class Task(id: Option[Long],
                title: String,
                content: Option[String],
                status: String,
                createAt: ZonedDateTime,
                updateAt: ZonedDateTime)

object Task extends SkinnyCRUDMapper[Task] {

  override def tableName = "tasks"

  override def defaultAlias: Alias[Task] = createAlias("t")

  override def extract(rs: WrappedResultSet, n: ResultName[Task]): Task =
    autoConstruct(rs, n)

  val statusOptions = Seq("done"->"done","not yet"->"not yet")
}