package de.htwg.se.ConnectFour.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * Error tests.
 */
class ErrorSpec extends AnyWordSpec with Matchers:
  "An Error" when {
    "set up" should {
      var error1 = CannotDropPiece()
      var error2 = ColumnFull()
      var error3 = InvalidPiece()
      var error4 = InvalidColumnNumber()
      var error5 = InputExpected()

      "should extend Error" in {
        error1 should be (CannotDropPiece())
        error2 should be (ColumnFull())
        error3 should be (InvalidPiece())
        error4 should be (InvalidColumnNumber())
        error5 should be (InputExpected())
      }
    }
  }