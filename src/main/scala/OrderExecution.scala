import scala.annotation.tailrec

object OrderRequest{

  @tailrec
  def executeOrders(co: (List[Client],List[Order])) : (List[Client], List[Order]) = {
    co match {
      case (_, Nil) => co
      case (clients, orders) => {
        val order = orders.head
        order match {
          case Order(clientname, operation, stock, price, num) => {
            val client_index = clients.indexWhere(_.name == clientname)
            if (client_index > -1) {
              val client = clients(client_index)
              val amount = (if(operation=="b") 1 else -1) * num
              val amountusd = (if(operation=="b") -1 else 1) * price * num
              val updated_client = stock match {
                case "A"=>client.copy(client.name,client.usd+amountusd,client.a + amount, client.b,client.c,client.d)
                case "B"=>client.copy(client.name,client.usd+amountusd,client.a, client.b + amount,client.c,client.d)
                case "C"=>client.copy(client.name,client.usd+amountusd,client.a, client.b,client.c + amount,client.d)
                case "D"=>client.copy(client.name,client.usd+amountusd,client.a, client.b,client.c,client.d + amount)
              }
              executeOrders(clients.updated(client_index, updated_client), orders.tail)
            }
            else throw new ClientnotFoundException
          }
        }
      }
    }
  }
}
