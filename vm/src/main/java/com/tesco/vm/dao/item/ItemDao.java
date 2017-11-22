package com.tesco.vm.dao.item;

import java.util.List;

import com.tesco.vm.model.item.Item;

public interface ItemDao {

	public List<Item> getItems();
	
	public void decrementNumberItemsRemaining(int id);
}
