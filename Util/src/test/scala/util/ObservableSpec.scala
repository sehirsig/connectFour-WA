package de.htwg.se.ConnectFour.util

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * Observable-Pattern tests.
 */
class ObservableSpec extends AnyWordSpec with Matchers:
  "An Observable" should {
    val observable = new Observable
    val observer = new Observer:
      var updated: Boolean = false
      def isUpdated: Boolean = updated
      override def update: Boolean = { updated=true;updated}
      override def toString: String = updated.toString
    "add an Observer" in {
      observable.add(observer)
      observable.subscribers should contain (observer)
    }
    "notify an Observer" in {
      observer.toString should be("false")
      observable.notifyObservers
      observer.toString should be("true")
    }
    "remove an Observer" in {
      observable.remove(observer)
      observable.subscribers should not contain (observer)
    }
  }