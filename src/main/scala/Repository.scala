import scala.io.Source

case class Client(name: String, usd: Int, a: Int, b: Int, c: Int, d: Int)
case class Order(clientname: String, operation: String, stock: String, price: Int, num: Int)

class ClientnotFoundException extends Exception

class Repository {

  val clientPattern = "([a-zA-Z0-9]+)\t([0-9]+)\t([0-9]+)\t([0-9]+)\t([0-9]+)\t([0-9]+)".r
  val orderPattern = "([a-zA-Z0-9]+)\t([b,s]+)\t([a-zA-Z]+)\t([0-9]+)\t([0-9]+)".r

  def getClients = {
    Source.fromInputStream(getClass.getResourceAsStream("clients.txt")).getLines.map(
      line=> {
        line match{
          case clientPattern(name,usd,a,b,c,d)=>{
            Client(name,usd.toInt,a.toInt,b.toInt,c.toInt,d.toInt)
          }
        }
      }).toList
  }

  def getOrders = {
    io.Source.fromInputStream(getClass.getResourceAsStream("orders.txt")).getLines.map(
        line=>{
          line match {
            case orderPattern(clientname, op, st, price, num) => {
              Order(clientname, op, st, price.toInt, num.toInt)
            }
          }
        }).toList
  }

}
