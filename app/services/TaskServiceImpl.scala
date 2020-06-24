package services

import java.time.ZonedDateTime

import forms.TaskForm
import javax.inject.Singleton
import models.Task
import scalikejdbc._

import scala.collection.immutable.Range

@Singleton
class TaskServiceImpl extends TaskService {

  override def create(model: TaskForm)(implicit session: DBSession): Long = {
    val now = ZonedDateTime.now
    Task.createWithAttributes(
      'title -> model.title,
      'content -> model.content,
      'status -> model.status,
      'createAt -> now,
      'updateAt -> now
    )
  }

  override def findAll(implicit session: DBSession): List[Task] = Task.findAll()

  override def findById(id: Long)(implicit session: DBSession): Option[Task] = Task.findById(id)

  override def update(id: Long, model: TaskForm)(implicit session: DBSession): Int = {
    Task.updateById(id).withAttributes(
      'title -> model.title,
      'content -> model.content,
      'status -> model.status,
      'updateAt -> ZonedDateTime.now
    )
  }

  override def deleteById(id: Long)(implicit session: DBSession): Int = Task.deleteById(id)

}
