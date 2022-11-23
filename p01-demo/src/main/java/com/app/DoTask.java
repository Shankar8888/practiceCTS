package com.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.app.models.Customer;
import com.app.models.Item;
import com.app.models.Order;

public class DoTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Item> itemList = Arrays.asList(new Item(134, "Moto24", 15000.00, "Mobiles"),
				new Item(157, "Spiderman", 50.00, "Books"), new Item(204, "Acer", 70000.00, "Laptops"),
				new Item(210, "iPhone", 45000.00, "Mobiles"), new Item(215, "Shirt", 1500.00, "Shirts"));

		System.out.println("Items Original List: " + itemList);

		List<Order> orderList = Arrays.asList(
				new Order(1, "delivered", "12-Nov-2021", "14-Nov-2021",
						Arrays.asList(new Item(134, "Moto24", 15000.00, "Mobiles"),
								new Item(204, "Acer", 70000.00, "Laptops")),
						new Customer(1, "Tom", "male", "Bangalore")),

				new Order(2, "delivered", "19-May-2022", "24-May-2022",
						Arrays.asList(new Item(204, "Acer", 70000.00, "Laptops")),
						new Customer(4, "Kunal", "male", "Delhi")),

				new Order(3, "delivered", "31-Jul-2021", "04-Aug-2021",
						Arrays.asList(new Item(210, "iPhone", 45000.00, "Mobiles"),
								new Item(215, "Shirt", 1500.00, "Shirts")),
						new Customer(2, "Mike", "male", "Delhi")),

				new Order(4, "pending", "29-Oct-2022", "-",
						Arrays.asList(new Item(134, "Moto24", 15000.00, "Mobiles"),
								new Item(157, "Spiderman", 50.00, "Books"), new Item(204, "Acer", 70000.00, "Laptops"),
								new Item(215, "Shirt", 1500.00, "Shirts")),
						new Customer(3, "Miley", "female", "Pune")),

				new Order(5, "pending", "30-Oct-2021", "-", Arrays.asList(new Item(134, "Moto24", 15000.00, "Mobiles")),
						new Customer(5, "Sakshi", "female", "Delhi")));

		System.out.println("Order original List:: " + orderList);

//		List<Customer> customerList = Arrays.asList(new Customer(1, "Tom", "male", "Bangalore"),
//				new Customer(2, "Mike", "male", "Delhi"), new Customer(3, "Miley", "female", "Pune"),
//				new Customer(4, "Kunal", "male", "Mobiles"), new Customer(5, "Sakshi", "female", "Delhi"));

		
//1: Obtain a list of items belongs to category “Mobiles”
		System.out.println("\n Q1.Obtain a list of items belongs to category “Mobiles”");
		System.out.println("FilterList using Lambda");
		Consumer<List<Item>> consumer = items -> {
			items.forEach(item -> {
				if (item.getCategory().equals("Mobiles"))
					System.out.println(item);
			});
		};

		doTask(consumer, itemList);

		// stream api
		System.out.println("FilterList using Stream");
		itemList.stream().filter(i -> i.getCategory().equals("Mobiles")).forEach(System.out::println);

// 2: Obtain a list of items belongs to category “Mobiles” and price is greater than 20000
		System.out.println("\n Q2.Obtain a list of items belongs to category “Mobiles” and price is greater than 20000");
		System.out.println("FilterList using Lambda");
		Consumer<List<Item>> consumer1 = items -> {
			items.forEach(item -> {
				if (item.getCategory().equals("Mobiles") && item.getPrice() > 20000)
					System.out.println(item);
			});
		};

		doTask(consumer1, itemList);

		// stream api
		System.out.println("FilterList using Stream");
		itemList.stream().filter(i -> i.getCategory().equals("Mobiles")).filter(i -> i.getPrice() > 20000)
				.forEach(System.out::println);

		// 3: Obtain a list of order with items category is not “Mobiles”
		System.out.println("\n Q3.Obtain a list of order with items category is not “Mobiles”");
		System.out.println("FilterList using Lambda");
		
//		Consumer<List<Order>> consumer2 = orders -> {
//			orders.forEach(order -> {
//				boolean flg=false;
//				order.getItems().forEach(item ->{
//					if(!item.getCategory().equalsIgnoreCase("mobiles"))
//						flg=true;
//		System.out.println(order);
//				});
//				if(!flg) 
//				System.out.println(order);
//			});	
//		};

//		doTask1(consumer2, orderList);

		// stream api
		System.out.println("FilterList using Stream");
		orderList.stream().filter(o->o.getItems().stream().
				noneMatch(i->i.getCategory().equalsIgnoreCase("mobiles"))).forEach(System.out::println);
		
		// 4: Obtain a list of items with category “Laptops” and then apply 5% discount
				System.out.println("\n Q4.Obtain a list of items with category “Laptops” and then apply 5% discount");
			
				// stream api
				System.out.println("FilterList using Stream");
				itemList.stream().filter(i->i.getCategory().equals("Laptops")).forEach(System.out::println);
				
				System.out.println("FilterList using Stream 5% discount on price");
				itemList.stream().filter(i->i.getCategory().equals("Laptops")).map((i)->(i.getPrice()-(i.getPrice()* 0.05)))
						.forEach(System.out::println);
				
				System.out.println("FilterList using Lambda");
				Consumer<List<Item>> consumer3 = items -> {
					items.forEach(item -> {
						if (item.getCategory().equals("Laptops")) {
							System.out.println(item);
						item.setPrice(item.getPrice()-(item.getPrice()*0.05));
						System.out.println("With 5% discount:" +item);
						}
					});
				};

				doTask(consumer3, itemList);

//5. Obtain a list of items ordered by customers who are female
	System.out.println("\n Q5.Obtain a list of items ordered by customers who are female");
				
	System.out.println("FilterList using Lambda");
	Consumer<List<Order>> consumer4 = orders -> {
		orders.forEach(cust ->{
			if(cust.getCustomer().getGender().equals("female")){
				System.out.println(cust.getItems());
			};
		});
	};
	
	doTask1(consumer4, orderList);
	

	// stream api
	System.out.println("FilterList using Stream");
	orderList.stream().filter(i -> i.getCustomer().getGender().equals("female")).map(i->i.getItems())
			.forEach(System.out::println);
		
					
//	6: Obtain a list of items ordered by customers between 01-Jan-2022 and 31-Oct-2022
System.out.println("\n Q6.Obtain a list of items ordered by customers between 01-Jan-2022 and 31-Oct-2022");
	
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	System.out.println("FilterList using Lambda");
	Consumer<List<Order>> consumer5 = orders -> {
		orders.forEach(item ->{
			if(LocalDate.parse(item.getOrderDate(),formatter).isAfter(LocalDate.parse("01-Jan-2022", formatter)) 
					&& LocalDate.parse(item.getOrderDate(),formatter).isBefore(LocalDate.parse("31-Oct-2022",formatter))){
				System.out.println(item.getItems());
			};
		});
	};
	
	doTask1(consumer5, orderList);
	
	// stream api
	System.out.println("FilterList using Stream");
	orderList.stream().filter(i -> LocalDate.parse(i.getOrderDate(),formatter).isAfter(LocalDate.parse("01-Jan-2022", formatter)) 
			&& LocalDate.parse(i.getOrderDate(),formatter).isBefore(LocalDate.parse("31-Oct-2022",formatter)))
			.map(i->i.getItems()).forEach(System.out::println);		
	}

	private static void doTask(Consumer<List<Item>> c, List<Item> itemList) {
		c.accept(itemList);
	}

	private static void doTask1(Consumer<List<Order>> c, List<Order> orderList) {
		c.accept(orderList);
	}

}
