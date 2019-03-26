package com.lax.codeexercise.ice.eod;

public class PricePoint {
	private String cusip;
	private String price;
		
	public PricePoint(String cusip, String price) {
		this.cusip = cusip;
		this.price = price;
	}

	public String toString() {
		return cusip+","+price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
