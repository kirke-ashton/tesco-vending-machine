package com.tesco.vm.money;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;

import com.tesco.vm.dao.coin.CoinDao;
import com.tesco.vm.model.coin.Coin;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MoneyTest {
	
	private static final int ONE_PENCE_COIN = 1;
	private static final int TEN_PENCE_COIN = 10;
	
	@InjectMocks
	private Money money;
	
	@Mock
	private CoinDao coinDaoMock;
    
    @Test
    public void CoinNotAcceptedCoinsNull() {
    	
    	when(coinDaoMock.getCoins()).thenReturn(null);
    	
    	money.getAcceptedCoins();
    	
    	assertFalse(money.isCoinAccepted(TEN_PENCE_COIN));
    }
    
    @Test
    public void CoinNotAcceptedCoinsEmpty() {
    	
    	when(coinDaoMock.getCoins()).thenReturn(new ArrayList<Coin>(0));
    	
    	money.getAcceptedCoins();
    	
    	assertFalse(money.isCoinAccepted(TEN_PENCE_COIN));
    }
    
    @Test
    public void CoinAccepted() {
    	
    	when(coinDaoMock.getCoins()).thenReturn(getCoins());
    	
    	money.getAcceptedCoins();
    	
    	assertTrue(money.isCoinAccepted(TEN_PENCE_COIN));
    }
    
    @Test
    public void CoinNotAccepted() {
    	
    	when(coinDaoMock.getCoins()).thenReturn(getCoins());
    	
    	money.getAcceptedCoins();
    	
    	assertFalse(money.isCoinAccepted(ONE_PENCE_COIN));
    }
    
    @Test
    public void UnknownCoinEntered() {
    	
    	when(coinDaoMock.getCoins()).thenReturn(getCoins());
    	
    	money.getAcceptedCoins();
    	
    	assertFalse(money.coinEntered(Money.UNKNOWN_COIN));
    }
    
    @Test
    public void NotAcceptedCoinEntered() {
    	
    	when(coinDaoMock.getCoins()).thenReturn(getCoins());
    	
    	money.getAcceptedCoins();
    	
    	assertFalse(money.coinEntered(ONE_PENCE_COIN));
    }
    
    @Test
    public void AcceptedCoinEntered() {
    	
    	when(coinDaoMock.getCoins()).thenReturn(getCoins());
    	
    	money.getAcceptedCoins();
    	
    	assertTrue(money.coinEntered(TEN_PENCE_COIN));
    }
    
    @Test
    public void setCorrectValueEntered() {
    	
    	when(coinDaoMock.getCoins()).thenReturn(getCoins());
    	
    	money.getAcceptedCoins();
    	
    	assertEquals(10, money.setValueEntered(TEN_PENCE_COIN));
    }
    
    @Test
    public void setIncorrectValueEntered() {
    	
    	when(coinDaoMock.getCoins()).thenReturn(getCoins());
    	
    	money.getAcceptedCoins();
    	
    	assertEquals(0, money.setValueEntered(ONE_PENCE_COIN));
    }
    
    @Test
    public void getTotalValueEntered() {
    	
    	when(coinDaoMock.getCoins()).thenReturn(getCoins());
    	
    	money.getAcceptedCoins();
    	
    	money.setValueEntered(TEN_PENCE_COIN);
    	
    	assertEquals(TEN_PENCE_COIN, money.getTotalValueEntered());
    }
    
    @Test
    public void clearTotalValueEntered() {
    	
    	when(coinDaoMock.getCoins()).thenReturn(getCoins());
    	
    	money.getAcceptedCoins();
    	
    	assertEquals(TEN_PENCE_COIN, money.setValueEntered(TEN_PENCE_COIN));
    	
    	money.clearTotalValueEntered();
    	
    	assertEquals(0, money.getTotalValueEntered());
    	
    }
    
    private List<Coin> getCoins() {
		
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
