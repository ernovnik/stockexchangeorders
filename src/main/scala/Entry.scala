import OrderRequest.executeOrders

object Entry extends App{
  val repository = new Repository
  val clients = repository.getClients
  val orders = repository.getOrders
  val orderRequest = OrderRequest.executeOrders((clients,orders))
  val updatedClients = executeOrders((clients,orders))._1
  println(clients)
  println(updatedClients)
}
