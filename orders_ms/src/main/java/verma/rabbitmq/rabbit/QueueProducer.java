package verma.rabbitmq.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import verma.rabbitmq.entity.Orders;

@Component
public class QueueProducer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${toob.rabbitmq.exchange}")
	private String exchange;
	
	public void produce(Orders order){
		amqpTemplate.convertAndSend(exchange, order.getRoutingKey(), order);
		System.out.println("Send msg = " + order);
	}

}
