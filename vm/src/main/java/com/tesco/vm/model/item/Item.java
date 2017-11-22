package com.tesco.vm.model.item;

public class Item {

	private char selector;

	private int cost;
	
	private int numRemainingItems;
	
	public Item(char selector, int cost, int numRemainingItems) {
		this.selector = selector;
		this.cost = cost;
		this.numRemainingItems = numRemainingItems;
	}
	
	public char getSelector() {
		return selector;
	}

	public int getCost() {
		return cost;
	}

	public int getNumRemainingItems() {
		return numRemainingItems;
	}

	public void setNumRemainingItems(int numRemainingItems) {
		this.numRemainingItems = numRemainingItems;
	}
}
