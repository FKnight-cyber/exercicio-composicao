package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.client = client;
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
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
	
	public List<OrderItem> getItems() {
		return items;
	}

	public void addItems(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double sum = 0;
		for(OrderItem i : items) {
			sum += i.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:" + "\n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + OrderStatus.valueOf("PROCESSING") + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order Items:" + "\n");
		for(OrderItem order : items){
			sb.append(order + "\n");
		}
		sb.append("Total price: $" + total());
		return sb.toString();
	}
}
