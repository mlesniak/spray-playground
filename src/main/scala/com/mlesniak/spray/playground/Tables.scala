package com.mlesniak.spray.playground

import slick.driver.H2Driver.api._
import slick.lifted.Tag

class KeyValues(tag: Tag) extends Table[(Int, String, String)](tag, "KEY_VALUES") {
  def id = column[Int]("ID", O.AutoInc, O.PrimaryKey)

  def key = column[String]("KEY")

  def value = column[String]("VALUE")

  def * = (id, key, value)
}