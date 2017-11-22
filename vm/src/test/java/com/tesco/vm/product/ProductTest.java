package com.tesco.vm.product;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.tesco.vm.dao.item.ItemDao;
import com.tesco.vm.model.item.Item;

@RunWith(MockitoJUnitRunner.class)
public class ProductTest {
	
	private static final char ITEM_B = 'B';
	private static final int ITEM_B_COST = 100;
	private static final int ITEM_B_STOCK = 8;
	
	private static final char INVALID_ITEM = 'E';

	@InjectMocks
	private Product product;
	
	@Mock
	private ItemDao itemDaoMock;
    
    @Test
    public void ItemNotPresentItemsNull() {
    	
    	mockgetItems(null);
    	
    	assertEquals(0, product.getItemCost(ITEM_B));
    }
    
    @Test
    public void ItemNotPresentItemsEmpty() {
    	
    	mockgetItems(new ArrayList<Item>(0));
    	
    	assertEquals(0, product.getItemCost(ITEM_B));
    }
    
    @Test
    public void getCostValidItem() {
    	
    	mockgetItems(getItems());
    	
    	assertEquals(ITEM_B_COST, product.getItemCost(ITEM_B));
    }
    
    @Test
    public void getCostInvalidItem() {
    	
    	mockgetItems(getItems());
    	
    	assertEquals(0, product.getItemCost(INVALID_ITEM));
    }
    
    @Test
    public void getCountValidItem() {
    	
    	mockgetItems(getItems());
    	
    	assertEquals(8, product.getItemCount(ITEM_B));
    }
    
    @Test
    public void getCountInvalidItem() {
    	
    	mockgetItems(getItems());
    	
    	assertEquals(0, product.getItemCount(INVALID_ITEM));
    }
    
    @Test
    public void decrementCountValidItem() {

    	mockgetItems(getItems());
    	
    	assertEquals(ITEM_B_STOCK, product.getItemCount(ITEM_B));
    	
    	product.decrementItemCount(ITEM_B);
    	
    	assertEquals((ITEM_B_STOCK - 1), product.getItemCount(ITEM_B));
    }
    
    private void mockgetItems(List<Item> items) {
    	
    	when(itemDaoMock.getItems()).thenReturn(items);
    	
    	product.getProductItems();
    }
    
    private List<Item> getItems() {
    	
		List<Item> items = new ArrayList<>(0);
		
		Item item = new Item('A', 60, 5);
		items.add(item);
		
		item = new Item('B', ITEM_B_COST, ITEM_B_STOCK);
		items.add(item);
		
		item = new Item('C', 170, 2);
		items.add(item);
	
		return items;
    }
}
