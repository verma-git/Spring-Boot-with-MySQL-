package verma.rabbitmq.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import verma.rabbitmq.entity.Orders;
import verma.rabbitmq.service.OrdersService;

@Component
public class QueueConsumer {

	@Autowired
	OrdersService ordersService;

	@RabbitListener(queues = "${order.rabbitmq.queue}", containerFactory = "myOrdersListenerContainerFactory")
	public void recievedMessage(Orders order) {
		System.out.println("***********One msg Recieved on Order Queue: " + order.getRoutingKey());
		ordersService.msgConsumer(order);
	}

}
