package com.fooddelivery.model;

import java.util.HashMap;

public class Cart {
	
	HashMap<Integer, CartItem> items;
	
	public Cart() {
		this.items = new HashMap<Integer, CartItem>();
	}
	
	
	public void addItem(CartItem newItem) {
		
		if (items.containsKey(newItem.getItemId())) {
            // Item already exists in the cart
            CartItem existingItem = items.get(newItem.getItemId());
            int newQuantity = existingItem.getQuantity() + newItem.getQuantity();
            existingItem.setQuantity(newQuantity);
        } else {
            // Item does not exist in the cart, add it
            items.put(newItem.getItemId(), newItem);
        }
		
	}
	
	public void updateItem(int itemId, int quantity) {
		
		if (items.containsKey(itemId)) {
            // Item exists in the cart
            CartItem existingItem = items.get(itemId);
            if (quantity > 0) {
                // Update the quantity
                existingItem.setQuantity(quantity);
            } else {
                // Remove the item if the new quantity is zero or less
                items.remove(itemId);
           }
		}
	}
	
	
	public void removeItem(int itemId) {
		items.remove(itemId);
	}
	
	
	public HashMap<Integer, CartItem> getItems(){
		
		return items;
	}
	
	
	public void clear() {
		
		items.clear();
	}

}

































