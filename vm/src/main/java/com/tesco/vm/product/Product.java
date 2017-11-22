package com.tesco.vm.product;

import java.util.List;

import javax.inject.Inject;

import com.tesco.vm.dao.item.ItemDao;
import com.tesco.vm.model.item.Item;

public class Product {
	
	@Inject
	private ItemDao itemDao;
	
	private List<Item> items;

	public Product() {
	}
	
	public void getProductItems() {
		
		items = itemDao.getItems();
	}
	
	public int getItemCost(char selector) {

		Item item = getItem(selector);
		
		return ((item != null) ? item.getCost() : 0);
	}
	
	public int getItemCount(char selector) {
		
		Item item = getItem(selector);
		
		return ((item != null) ? item.getNumRemainingItems() : 0);
	}
	
	public void decrementItemCount(char selector) {
		
		Item item = getItem(selector);
		
		if (item != null) {
			item.setNumRemainingItems(item.getNumRemainingItems() - 1);
		}
	}
	
	private Item getItem(char selector) {
		
		Item itemObtained = null;
		
		if (items != null) {
			
			for (Item item : items) {

				if (item.getSelector() == selector) {
					itemObtained = item;
				}
			}
		}
		
		return itemObtained;
	}
}
