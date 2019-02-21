package verma.rabbitmq.service;

import java.util.List;

import verma.rabbitmq.entity.Orders;

public interface OrdersService {
	
	public void placeOrder();
	public long createCart(Orders order);
	public List<Orders> getAllOrders();
	public void msgConsumer(Orders order);

}
