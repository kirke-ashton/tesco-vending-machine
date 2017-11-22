package com.tesco.vm;

import javax.inject.Inject;

import com.tesco.vm.money.Money;
import com.tesco.vm.product.Product;

public class Process {
	
	@Inject
	private Money money;
	
	@Inject
	private Product product;
	
	MathOperation subtraction = (a, b) -> a - b;

	public Process() {
	}
	
	/*
	 * An integer is return, which indicates the success or failure of selecting the
	 * specified item
	 * 
	 * @return change greater or equal to 0 is success, change value less than 0 is failure
	 */
	public int itemSelected(char selector) {
		
		int change = 0;
		
		int cost = product.getItemCost(selector);
		
		if (cost != 0) {
			
			if (product.getItemCount(selector) > 0) {
				
				int valueEntered = money.getTotalValueEntered();
				
				if (valueEntered >= cost) {
					
					change = operate(valueEntered, cost, subtraction);
		
					money.clearTotalValueEntered();
				} else {
					change = Error.ITEM_INSUFFICIENT_MONEY.getStatusCode();
				}
			} else {
				change = Error.ITEM_SOLD_OUT.getStatusCode();
			}
		} else {
			change = Error.INVALID_ITEM.getStatusCode();
		}
		
		return change;
	}
	
    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
