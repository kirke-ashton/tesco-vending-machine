package com.tesco.vm;

public enum Error {

	INVALID_ITEM(-1),
	ITEM_SOLD_OUT(-2),
	ITEM_INSUFFICIENT_MONEY(-3);
	
    private int statusCode;

    private Error(int statusCode) {
    	this.statusCode = statusCode;
    }
    
    public int getStatusCode() { 
    	return statusCode;
    }
}
