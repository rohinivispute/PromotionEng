package com.promo.demo.com.promo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
	
	
	@Autowired
	private TotalpriceService tps;
	@Autowired
	private SknCount sk;
	
	
	@RequestMapping("/")
	public String getHomepage()
	
	{		return "home";
		
	}
    
	@GetMapping("/getprice")
	public String getprice(@RequestParam("itemACount") int itemACount,@RequestParam("itemBCount") int itemBCount,@RequestParam("itemCCount") int itemCCount,@RequestParam("itemDCount") int itemDCount,ModelMap mp )
	{   int totalPrice=0;
		String chekPromoAvalability=tps.checkpromotion();
		
		if(chekPromoAvalability.equalsIgnoreCase("true"))
				{
			sk.setItemACount(itemACount);
			sk.setItemBCount(itemBCount);
			sk.setItemCCount(itemCCount);
			sk.setItemDCount(itemDCount);
			totalPrice=tps.calculatePriceWithPromo(sk);			
			
				}
		mp.put("total", totalPrice);
				
		return "result";}
	
	
	
}
