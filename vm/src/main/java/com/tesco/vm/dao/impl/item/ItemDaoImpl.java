package com.tesco.vm.dao.impl.item;

import java.util.ArrayList;
import java.util.List;

import com.tesco.vm.dao.item.ItemDao;
import com.tesco.vm.model.item.Item;

/*
 * This class will obtain the items from an EEPROM, but could be obtained from
 * another storage device
 */
public class ItemDaoImpl implements ItemDao {

	public List<Item> getItems() {

		List<Item> items = new ArrayList<>(0);
		
		Item item = new Item('A', 60, 5);
		items.add(item);
		
		item = new Item('B', 100, 8);
		items.add(item);
		
		item = new Item('C', 170, 2);
		items.add(item);
	
		return items;
	}
	
	public void decrementNumberItemsRemaining(int id) {
		// Decrement in the storage device by one the number of items remaining 
	}
}
