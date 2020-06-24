package services

import forms.TaskForm
import models.Task
import scalikejdbc.{AutoSession, DBSession}

trait TaskService {

  def create(model: TaskForm)(implicit session: DBSession = AutoSession): Long

  def findAll(implicit session: DBSession = AutoSession): List[Task]

  def findById(id: Long)(implicit session: DBSession = AutoSession): Option[Task]

  def update(id: Long, model: TaskForm)(implicit session: DBSession = AutoSession): Int

  def deleteById(id: Long)(implicit session: DBSession = AutoSession): Int

}
