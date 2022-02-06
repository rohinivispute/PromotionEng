package com.promo.demo;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import com.promo.demo.com.promo.demo.PromotionValues;
import com.promo.demo.com.promo.demo.SknCount;
import com.promo.demo.com.promo.demo.SknItem;
import com.promo.demo.com.promo.demo.TotalPrice;


public class TotalPriceTest {	
	
	
	TotalPrice tp = new TotalPrice();
	
	
	@Autowired
	SknItem unitPrice= new SknItem();
	@Autowired
	PromotionValues pmv= new PromotionValues();
	
	
	
	@Before
	public void setUp() {
		
		
		ReflectionTestUtils.setField(unitPrice, "A", 50);
		ReflectionTestUtils.setField(unitPrice, "B", 30);
		ReflectionTestUtils.setField(unitPrice, "C", 20);
		ReflectionTestUtils.setField(unitPrice, "D", 15);
		
		  ReflectionTestUtils.setField(pmv, "promo_unit_A", 3);
		  ReflectionTestUtils.setField(pmv, "promo_price_A", 130);
		  ReflectionTestUtils.setField(pmv, "promo_price_B", 45);
          ReflectionTestUtils.setField(pmv, "promo_unit_B", 2);
		  ReflectionTestUtils.setField(pmv, "promo_price_CD", 30);
		  
		  ReflectionTestUtils.setField(tp, "unitPrice", unitPrice);
		  ReflectionTestUtils.setField(tp, "pmv", pmv);
		 
	}
     
	@Test
	public void testcalculatePriceWithPromo()
	{
	
		
		SknCount sk1=new SknCount();
		sk1.setItemACount(5);
		sk1.setItemBCount(5);
		sk1.setItemCCount(1);
		sk1.setItemDCount(0);
		
		
		int i1=tp.calculatePriceWithPromo(sk1);
		assertEquals(370, i1);
		
			
		SknCount sk2=new SknCount();
		sk2.setItemACount(1);
		sk2.setItemBCount(1);
		sk2.setItemCCount(1);
		sk2.setItemDCount(0);
		
		int i2=tp.calculatePriceWithPromo(sk2);
		assertEquals(100, i2);
		
		SknCount sk3=new SknCount();
		sk3.setItemACount(3);
		sk3.setItemBCount(5);
		sk3.setItemCCount(1);
		sk3.setItemDCount(1);
		
		int i3=tp.calculatePriceWithPromo(sk3);
		assertEquals(280, i3);
		
		
		
	}
}
