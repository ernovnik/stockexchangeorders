import org.scalatest.FunSuite

class ExchangeOrdersTestSuite extends FunSuite{

  test("Order execution test"){
    val clients = List(Client("C1",1000,130,240,760,320),Client("C2",1000,130,240,760,320),Client("C3",1000,130,240,760,320))
    val orders = List(Order("C1","b","A",1500,1),Order("C1","s","A",1500,1),Order("C1","b","C",15,4),Order("C1","s","C",15,4),Order("C3","b","D",3000,1))
    val updatedClients = OrderRequest.executeOrders((clients,orders))
    assert(updatedClients._1==List(Client("C1",1000,130,240,760,320),Client("C2",1000,130,240,760,320),Client("C3",-2000,130,240,760,321)))
  }

}
