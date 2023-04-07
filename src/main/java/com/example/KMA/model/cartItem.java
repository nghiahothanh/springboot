package com.example.KMA.model;

public class cartItem {
	private  Product product;
	private int quantity;
	private double subTotal;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubTotal() {
		subTotal=product.getPrice()*quantity;
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public cartItem(Product product) {
		this.product=product;
		this.quantity=1;
		this.subTotal=product.getPrice();
	}
	public cartItem(Product product, int quantity, double subTotal) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	
}
