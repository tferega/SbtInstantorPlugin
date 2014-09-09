package com.instantor.plugin

import scala.collection.mutable.Map

object Memoize1 {
  def apply[A, R](f: A => R) = new Memoize1(f)
}

class Memoize1[-A, +R](f: A => R) extends (A => R) {
  private case object Lock
  private[this] val cache = Map.empty[A, R]

  def apply(a: A): R = Lock.synchronized {
    if (cache.contains(a)) {
      cache(a)
    }
    else {
      val r = f(a)
      cache += ((a, r))
      r
    }
  }
}
