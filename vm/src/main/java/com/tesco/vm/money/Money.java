package com.tesco.vm.money;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.tesco.vm.dao.coin.CoinDao;
import com.tesco.vm.model.coin.Coin;

public class Money {
	
	public static final int UNKNOWN_COIN = 0;

	@Inject
	private CoinDao coinDao;
	
	private List<Coin> acceptedCoins = new ArrayList<>(0);
	
	private int totalValue = 0;
	
	public Money() {
	}
	
	public void getAcceptedCoins() {
			
		List<Coin> coins = coinDao.getCoins();
		
		if (coins != null) {
			for (Coin coin : coins) {
			
				if (coin.isAccepted()) {
					acceptedCoins.add(coin);
				}
			}
		}
	}
	
	public boolean isCoinAccepted(int value) {
		
		boolean accepted = false;
		
		if (!acceptedCoins.isEmpty()) {

			for (Coin coin : acceptedCoins) {
			
				if (coin.getValue() == value) {
					accepted = true;
				}
			}
		}
		
		return accepted;
	}
	
	/*
	 * A return of false, indicates that the coin is invalid
	 */
	public boolean coinEntered(int value) {
		
		boolean validCoin = false;
		
		if ((UNKNOWN_COIN != value) && (isCoinAccepted(value))) {
			setValueEntered(value);
			
			validCoin = true;
		}
		
		return validCoin;
	}
	
	public int setValueEntered(int value) {
		
		if (isCoinAccepted(value)) {
			totalValue = totalValue + value;
		}
		
		return totalValue;
	}
	
	public int getTotalValueEntered() {
		return totalValue;
	}
	
	public void clearTotalValueEntered() {
		totalValue = 0;
	}
}
