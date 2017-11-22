package com.tesco.vm;

import com.tesco.vm.money.Money;
import com.tesco.vm.product.Product;

import javax.inject.Inject;

/**
 * Encapsulates the state of a vending machine and the operations that can be performed on it
 */
public class VendingMachine {
	
	@Inject
	private Money money;
	
	@Inject
	private Product product;
	
	@Inject
	private Process process;
	
	boolean state = false;
	
	public VendingMachine() {
		super();
	}
	
	public boolean isOn() {
		return state;
	}
	
	public void setOn() {
		money.getAcceptedCoins();
		
		product.getProductItems();
		
		state = true;
	}
	
	public void setOff() {

		state = false;
	}
	
	public void returnMoney() {
		money.clearTotalValueEntered();
	}
	
	/*
	 * A return of false, instructs the Vending machine to reject the coin just entered
	 */
	public boolean coinEntered(int value) {
		
		return money.coinEntered(value);
	}
	
	/*
	 * An integer is return, which instructs the Vending machine, whether to dispense the 
	 * item selected, returns success(value greater or equal to 0) or failure(less than 0)
	 */
	public int itemSelected(char selector) {
		
		return process.itemSelected(selector);
	}
}
