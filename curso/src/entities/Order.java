package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date monent;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public Order() {		
	}

	public Order(Date monent, OrderStatus status, Client client) {
		this.monent = monent;
		this.status = status;
		this.client = client;
	}

	public Date getMonent() {
		return monent;
	}

	public void setMonent(Date monent) {
		this.monent = monent;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}	
	
	public void addItem(OrderItem item) {
		orderItem.add(item);
	}
	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}
	public Double total() {		
		double sum = 0.0;
		for(OrderItem o : orderItem) {
			sum += o.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
			sb.append("ORDER SUMMARY:\n");
			sb.append("Order moment: ");
			sb.append(sdf.format(monent)+"\n");
			sb.append("Order status: ");
			sb.append(status+"\n");
			sb.append(client+"\n");
			sb.append("Order items: \n");
			for(OrderItem o : orderItem) {
				sb.append(orderItem+"\n");
			}
			sb.append("Total price: $");
			sb.append(String.format("%.2f",total()));
			return sb.toString();
		
	}

}
