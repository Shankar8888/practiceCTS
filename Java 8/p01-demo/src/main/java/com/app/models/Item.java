package com.app.models;


public class Item {

	private int id;
	private String item;
	private Double price;
	private String category;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int id, String item, Double price, String category) {
		super();
		this.id = id;
		this.item = item;
		this.price = price;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", item=" + item + ", price=" + price + ", category=" + category + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
