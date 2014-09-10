package com.instantor.plugin
package utils

import com.instantor.commons._
import java.util.regex.{ Matcher, Pattern }
import org.slf4j.helpers.MarkerIgnoringBase
import org.slf4j.{ Logger => SLF4JLogger }
import sbt.{ Logger => SbtLogger }

object SbtLoggerWrapper {
  private val R = Pattern.quote("{}")
  private def toMessage(message: String, args: List[Any]): String = {
    args match {
      case Nil => message
      case head :: tail =>
          val replacement = Matcher.quoteReplacement(head.toString)
          toMessage(message.replaceFirst(R, replacement), tail)
    }
  }

  private def toMessageWithCause(message: String, cause: Throwable) =
    message + "\n" + cause.stackTrace
}

class SbtLoggerWrapper(protected val log: SbtLogger)
    extends MarkerIgnoringBase
    with SLF4JLogger {
  import SbtLoggerWrapper._

  override def isErrorEnabled = true
  override def isWarnEnabled  = true
  override def isInfoEnabled  = true
  override def isDebugEnabled = true
  override def isTraceEnabled = false

  def error(msg: String, args: Object*) = log error toMessage(msg, args.toList)
  override def error(msg: String)                       = log error msg
  override def error(msg: String, arg1: Any)            = log error toMessage(msg, List(arg1))
  override def error(msg: String, arg1: Any, arg2: Any) = log error toMessage(msg, List(arg1, arg2))
  override def error(msg: String, t: Throwable)         = log error toMessageWithCause(msg, t)

  def warn (msg: String, args: Object*) = log warn toMessage(msg, args.toList)
  override def warn(msg: String)                        = log warn msg
  override def warn(msg: String, arg1: Any)             = log warn toMessage(msg, List(arg1))
  override def warn(msg: String, arg1: Any, arg2: Any)  = log warn toMessage(msg, List(arg1, arg2))
  override def warn(msg: String, t: Throwable)          = log warn toMessageWithCause(msg, t)

  def info (msg: String, args: Object*) = log info toMessage(msg, args.toList)
  override def info(msg: String)                        = log info msg
  override def info(msg: String, arg1: Any)             = log info toMessage(msg, List(arg1))
  override def info(msg: String, arg1: Any, arg2: Any)  = log info toMessage(msg, List(arg1, arg2))
  override def info(msg: String, t: Throwable)          = log info toMessageWithCause(msg, t)

  def debug(msg: String, args: Object*) = log debug toMessage(msg, args.toList)
  override def debug(msg: String)                       = log debug msg
  override def debug(msg: String, arg1: Any)            = log debug toMessage(msg, List(arg1))
  override def debug(msg: String, arg1: Any, arg2: Any) = log debug toMessage(msg, List(arg1, arg2))
  override def debug(msg: String, t: Throwable)         = log debug toMessageWithCause(msg, t)

  def trace(msg: String, args: Object*) = ()
  override def trace(msg: String, t: Throwable)         = ()
  override def trace(msg: String, arg1: Any, arg2: Any) = ()
  override def trace(msg: String, arg1: Any)            = ()
  override def trace(msg: String)                       = ()
}
