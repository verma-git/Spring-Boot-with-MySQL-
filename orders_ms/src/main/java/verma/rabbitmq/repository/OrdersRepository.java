package verma.rabbitmq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import verma.rabbitmq.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
