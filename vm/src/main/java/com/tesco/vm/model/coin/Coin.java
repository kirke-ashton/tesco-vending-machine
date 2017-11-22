package com.tesco.vm.model.coin;

public class Coin {

	private int value;
	
	private boolean accepted;
	
	public Coin(int value, boolean accepted) {
		this.value = value;
		this.accepted = accepted;
	}

	public int getValue() {
		return value;
	}

	public boolean isAccepted() {
		return accepted;
	}
}
