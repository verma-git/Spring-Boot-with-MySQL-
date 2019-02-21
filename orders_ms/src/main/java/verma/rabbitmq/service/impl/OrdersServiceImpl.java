package verma.rabbitmq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import verma.rabbitmq.entity.Orders;
import verma.rabbitmq.rabbit.QueueProducer;
import verma.rabbitmq.repository.OrdersRepository;
import verma.rabbitmq.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	OrdersRepository ordersRepo;
	
	@Autowired
	QueueProducer qProducer;
	
	@Override
	public void placeOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long createCart(Orders order) {
		Orders savedOrder = ordersRepo.save(order);
		savedOrder.setRoutingKey("orders.cart");
		qProducer.produce(savedOrder);
		return savedOrder.getOrderId();
	}

	@Override
	public List<Orders> getAllOrders() {
		return ordersRepo.findAll();
	}

	@Override
	public void msgConsumer(Orders order) {
		
		System.out.println("Cart is authorised, Order ID: " + order.getOrderId());
	}

}
