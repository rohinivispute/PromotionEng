package com.promo.demo.com.promo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@PropertySource(value = "classpath:application.properties")
public class TotalPrice implements TotalpriceService {
	int priceOfA=0;
	int priceOfB=0;
	int priceOfC=0;
	int priceOfD=0;
	int priceOfCD=0;
	
	@Value("${promotionAvailable}")
	String ifpromotion;
	
	@Autowired
	SknItem unitPrice;
	
	@Autowired
	PromotionValues pmv;
	
	
		
	@Override
	public String checkpromotion() {
	System.out.println("the pomotion value is set : "+ifpromotion);
	return ifpromotion;
	}
	@Override
	public int  calculatePriceWithPromo(SknCount sk)
	{int total=0;
		if(sk.getItemACount()>=1)
		{
			
			priceOfA=((sk.getItemACount()/pmv.getPromo_unit_A())*pmv.getPromo_price_A())+((sk.getItemACount()-((sk.getItemACount()/pmv.getPromo_unit_A())*pmv.getPromo_unit_A()))*unitPrice.getA());
			System.out.println("prise of A is :"+priceOfA);		
		}
		
		if(sk.getItemBCount()>=1)
		{priceOfB=((sk.getItemBCount()/pmv.getPromo_unit_B())*pmv.getPromo_price_B())+((sk.getItemBCount()-((sk.getItemBCount()/pmv.getPromo_unit_B())*pmv.getPromo_unit_B()))*unitPrice.getB());
		System.out.println("prise of B is :"+priceOfB);
			
		}
		
		if(sk.getItemCCount()>=1 && sk.getItemDCount()>=1)
		{
			if(sk.getItemCCount()<=sk.getItemDCount())
			{priceOfCD=(sk.getItemCCount()*30);
			priceOfD=(sk.getItemDCount()-sk.getItemCCount())*unitPrice.getD();			
			System.out.println("price of CD : "+priceOfCD);
				System.out.println("price of D: "+priceOfD);
			}
			else
			{priceOfCD=(sk.getItemDCount()*30);
			priceOfC=(sk.getItemCCount()-sk.getItemDCount())*unitPrice.getC();	
			System.out.println("price of CD : "+priceOfCD);
			System.out.println("price of C : "+priceOfC);
			}
		}
		else if(sk.getItemCCount()>=1) 
			{
			priceOfC=(sk.getItemCCount()*unitPrice.getC());
			
			System.out.println("price of CD : "+priceOfC);
			System.out.println("price of C :"+priceOfD);
			
			}
		else if(sk.getItemDCount()>=1) 
		{
			priceOfD=(sk.getItemDCount()*unitPrice.getD());
			
			System.out.println("price of CD : "+priceOfD);
			System.out.println("price of C"+priceOfC);
		
		}	
		total=priceOfA+priceOfB+priceOfC+priceOfD+priceOfCD;
		System.out.println("total price of all item : "+total);
		priceOfA=0;
		priceOfB=0;
		priceOfC=0;
		priceOfD=0;
		priceOfCD=0;
		return total;
		
	}
	
}
