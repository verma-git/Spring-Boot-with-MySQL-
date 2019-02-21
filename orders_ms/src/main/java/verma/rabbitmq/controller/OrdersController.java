package verma.rabbitmq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import verma.rabbitmq.entity.Orders;
import verma.rabbitmq.service.OrdersService;

@RestController("/orders")
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@PostMapping
	public void createCart(@RequestBody Orders order) {
		ordersService.createCart(order);
	}
	
	@GetMapping
	public List<Orders> getAllOrders() {
		return ordersService.getAllOrders();
	}
	
	
}
