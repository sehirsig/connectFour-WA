package de.htwg.se.ConnectFour.model.gridComponent

/**
 * Cell case class
 */
case class Cell(piece: Option[Piece]):
  def isSet: Boolean = piece.isDefined

  def toPlainString: String =
    piece match
      case None => "_ "
      case Some(value) => value.toPlainString

  override def toString: String =
    piece match
      case None => Console.BLUE + "_ "
      case Some(value) => value.toString