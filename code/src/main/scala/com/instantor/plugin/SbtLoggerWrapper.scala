package com.instantor.plugin

import org.slf4j.{ Logger => SLF4JLogger }
import org.slf4j.helpers.MarkerIgnoringBase
import sbt.{ Logger => SbtLogger }
import java.io.StringWriter
import java.io.PrintWriter

object SbtLoggerWrapper {
  private val R = """\{\}"""
  private def toMessage(message: String, args: List[Any]): String = {
    args match {
      case Nil => message
      case head :: tail =>
          toMessage(message.replaceFirst(R, head.toString), tail)
    }
  }

  private def toMessageWithCause(message: String, cause: Throwable) =
    message + "\n" + getStackTrace(cause)

  private def getStackTrace(e: Throwable): String = {
    val sw = new StringWriter
    val pw = new PrintWriter(sw)
    e.printStackTrace(pw)
    val s = sw.toString
    pw.close
    sw.close
    s
  }
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
