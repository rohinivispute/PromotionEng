package com.promo.demo.com.promo.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PromotionValues {

	@Value("${promo.price.A}")
	  private int promo_price_A;	 
	@Value("${promo.unit.A}")
	  private int promo_unit_A;
	  @Value("${promo.price.B}")
	  private int promo_price_B;
	  @Value("${promo.unit.B}")
	  private int promo_unit_B;
	  @Value("${promo.price.CD}")
	  private int promo_price_CD;
	  
	  public int getPromo_price_A() {
			return promo_price_A;
		}
		public int getPromo_unit_A() {
			return promo_unit_A;
		}
		public int getPromo_price_B() {
			return promo_price_B;
		}
		public int getPromo_unit_B() {
			return promo_unit_B;
		}
		public int getPromo_price_CD() {
			return promo_price_CD;
		}
	
}
