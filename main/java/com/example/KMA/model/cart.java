package com.example.KMA.model;

import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.http11.filters.VoidInputFilter;

public class cart {
private  List<cartItem> items;
private double total;
public cart() {
	items=new ArrayList<cartItem>();
	total=0;
}
//ham lay ve item 
public cartItem getItem(Product product) {
	
	for (cartItem item : items) {
		if(item.getProduct().getId()==product.getId()) {
			return item;
		}
	}
	return null;
}
//lay ve danh sach item
public List<cartItem> getItems(){
	return items;
}
// lay ve tong so luong item
public int getItemCount() {
	return items.size();
}
public void add(cartItem item) {
	addItem(item.getProduct(), item.getQuantity());
}
public void addItem(cartItem item) {
	addItem(item.getProduct(), item.getQuantity());
}
public void addItem(Product product,int quantity) {
	cartItem item =getItem(product);
	if(item!=null) {
		item.setQuantity(item.getQuantity()+1);
		
	} 
	else {
		item = new cartItem(product);
		item.setQuantity(quantity);
		items.add(item);
	}
}
public void addItem(Product product) {
	cartItem item = getItem(product);
	
}
public void updateItem(Product product, int quantity) {
	cartItem item = getItem(product);
	if(item!=null) {
		item.setQuantity(quantity);
	}

}
//xoa san pham 
public void removeItem(Product product) {
	cartItem item = getItem(product);
	if (item!=null) {
		items.remove(item);
	}
}
//xoa tat ca san pham 
public void clear () {
	items.clear();
	total=0;
}
//lam trong gio hang
public boolean isEmpty() {
	return items.isEmpty();
}
public double getTotal() {
	total=0;
	for (cartItem item : items) {
		total+=item.getSubTotal();
	}
	return total;
}
public List<cartItem> listCart() {
	
	
	return items;
}
public cartItem findById(Product product){
	
	for (cartItem cartItem : items) {
		if(cartItem.getProduct().getId()==product.getId());
		return cartItem;
	}
	return null;
}
}
