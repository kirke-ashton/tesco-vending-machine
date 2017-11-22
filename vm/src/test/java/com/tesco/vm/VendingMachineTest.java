package com.tesco.vm;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.tesco.vm.money.Money;
import com.tesco.vm.product.Product;

/**
 * Unit tests for {@link VendingMachine}
 */
@RunWith(MockitoJUnitRunner.class)
public class VendingMachineTest {
	
	private static final char ITEM_B = 'B';
	
	@InjectMocks
	private VendingMachine machine;
	
	@Mock
	private Money moneyMock;
	
	@Mock
	private Product productMock;
	
	@Mock
	private Process processMock;

	@Test
	public void defaultStateIsOff() {
		
		assertFalse(machine.isOn());
	}
	
	@Test
	public void turnOn() {
		machine.setOn();
		
		assertTrue(machine.isOn());
		
        verify(moneyMock, times(1)).getAcceptedCoins();
        verify(productMock, times(1)).getProductItems();
	}
	
	@Test
	public void turnOff() {
		machine.setOff();
		
		assertFalse(machine.isOn());		
	}
	
	@Test
	public void returnMoney() {
		
		machine.returnMoney();

		verify(moneyMock, times(1)).clearTotalValueEntered();
	}
	
	@Test
	public void coinEntered() {
		
		machine.coinEntered(10);

		verify(moneyMock, times(1)).coinEntered(anyInt());
	}
	
	@Test
	public void itemSelected() {
		
		machine.itemSelected(ITEM_B);

		verify(processMock, times(1)).itemSelected(ITEM_B);
	}
}
