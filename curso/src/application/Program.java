package application;

import java.util.Locale;
import java.util.Scanner;

import entities.enums.OrderStatus;
import entities.Product;
import entities.OrderItem;
import entities.Client;
import entities.Order;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date(DD/MM/YYYY): ");
		Date birth = sdf.parse(sc.next());
		Client client = new Client(name,email,birth);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(),orderStatus,client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();		
		for(int i=0;i<n;i++) {
			System.out.println("Enter #"+(i+1)+" item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			Product product = new Product(productName,price);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem orderItem = new OrderItem(quantity,price,product);
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();
	}
}