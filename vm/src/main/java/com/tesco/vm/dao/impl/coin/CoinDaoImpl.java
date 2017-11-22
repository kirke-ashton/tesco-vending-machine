package com.tesco.vm.dao.impl.coin;

import java.util.ArrayList;
import java.util.List;

import com.tesco.vm.dao.coin.CoinDao;
import com.tesco.vm.model.coin.Coin;

/*
 * This class will obtain the coins from an EEPROM, but could be obtained from
 * another storage device
 */
public class CoinDaoImpl implements CoinDao {

	public List<Coin> getCoins() {
		
		List<Coin> coins = new ArrayList<>(0);
		
		Coin coin = new Coin(1, false);
		coins.add(coin);
		
		coin = new Coin(5, false);
		coins.add(coin);
		
		coin = new Coin(10, true);
		coins.add(coin);
		
		coin = new Coin(20, true);
		coins.add(coin);
		
		coin = new Coin(50, true);
		coins.add(coin);
		
		coin = new Coin(100, true);
		coins.add(coin);
		
		coin = new Coin(200, false);
		coins.add(coin);
	
		return coins;
	}
}
