package com.tesco.vm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.tesco.vm.money.Money;
import com.tesco.vm.product.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProcessTest {
	
	private static final char INVALID_ITEM = 'E';
	
	private static final char ITEM_B = 'B';
	private static final int ITEM_B_COST = 100;
	private static final int ITEM_B_STOCK = 8;
	
	@InjectMocks
	private Process process;
	
	@Mock
	private Money moneyMock;
	
	@Mock
	private Product productMock;
	
	@Test
	public void invalidItemSelected() {
		
		when(productMock.getItemCost(INVALID_ITEM)).thenReturn(0);
		
		assertEquals(Error.INVALID_ITEM.getStatusCode(), process.itemSelected(INVALID_ITEM));
	}
	
	@Test
	public void itemSoldOut() {
		
		mockItem(ITEM_B_COST, 0);
		
		assertEquals(Error.ITEM_SOLD_OUT.getStatusCode(), process.itemSelected(ITEM_B));
	}
	
	@Test
	public void itemInsufficientMoney() {
		
		mockItem(ITEM_B_COST, ITEM_B_STOCK);
		
		when(moneyMock.getTotalValueEntered()).thenReturn(99);
		
		assertEquals(Error.ITEM_INSUFFICIENT_MONEY.getStatusCode(), process.itemSelected(ITEM_B));
	}
	
	@Test
	public void dispenseItem() {
		
		mockItem(ITEM_B_COST, ITEM_B_STOCK);
		
		when(moneyMock.getTotalValueEntered()).thenReturn(110);
		
		assertEquals(10, process.itemSelected(ITEM_B));
		
		verify(moneyMock, times(1)).clearTotalValueEntered();
	}
	
    private void mockItem(int cost, int stock) {
    	
		when(productMock.getItemCost(ITEM_B)).thenReturn(cost);
		
		when(productMock.getItemCount(ITEM_B)).thenReturn(stock);
    }
}
