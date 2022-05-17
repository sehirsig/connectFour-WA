package de.htwg.se.ConnectFour.databaseComponent.MongoDB

import de.htwg.se.ConnectFour.databaseComponent.DAOInterface

class DAOMangoDBImpl extends DAOInterface {

  val uri: String = "mongodb://mongo:27017/"
  val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("ConnectFour")
  val collection: MongoCollection[Document] = db.getCollection("connectfour")

  /** CREATE */
  override def create =
    None

  /** Load */
  override def load:String =
    ""

  /** SAVE */
  override def save(input:String) =
    None

  /** DELETE */
  override def delete =
    None
}
