package com.promo.demo.com.promo.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SknItem {
	@Value("${unit.price.A}")
	 private int A;
	
	@Value("${unit.price.B}")
	private int B;
	@Value("${unit.price.C}")
	private int C;
	@Value("${unit.price.D}")
	private int D;
	
	public int getA() {
		return A;
	}
	public int getB() {
		return B;
	}
	public int getC() {
		return C;
	}
	public int getD() {
		return D;
	}
	

}
