package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


public class program {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date moment = new Date();
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("email: ");
		String email = sc.nextLine();
		System.out.print("Birth date: (dd/mm/yyyy)");
		Date birthDate = sdf.parse(sc.next());
		
		Client c1 = new Client(clientName, email, birthDate);
		
		Order order = new Order(moment, OrderStatus.valueOf("PROCESSING"), c1);
		
		System.out.println("How many orders?");
		int n = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter order data:");
		for(int i = 1;i <= n; i++) {
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			Integer quantity = sc.nextInt();
			
			sc.nextLine();
			
			Product p1 = new Product(productName, productPrice);
			OrderItem item = new OrderItem(p1, quantity);
			order.addItems(item);
		}
		
		System.out.println(order);
		
		sc.close();
	}
}