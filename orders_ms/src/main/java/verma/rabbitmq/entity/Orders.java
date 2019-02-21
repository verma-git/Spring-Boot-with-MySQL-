package verma.rabbitmq.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private long orderId;
	
	@Column(name= "product_id")
	private long productId;
	
	@Temporal(TemporalType.DATE)
	@Column(name= "order_place_date")
	private Date orderPlaceDate;
	
	@Transient
	private String routingKey;
	
	@Column(name= "order_status")
	private int orderStatus;
	
	
	
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getRoutingKey() {
		return routingKey;
	}
	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public Date getOrderPlaceDate() {
		return orderPlaceDate;
	}
	public void setOrderPlaceDate(Date orderPlaceDate) {
		this.orderPlaceDate = orderPlaceDate;
	}
	
	
}
