package com.sape.order.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sape.order.vo.EquityOrder;

@Controller
@RequestMapping("/blotter")
public class BlotterController {
	@RequestMapping(method=RequestMethod.GET)
	public String retrieveBlotters(Map<String,Object> model){
		EquityOrder order = new EquityOrder();
		order.setOrderId(10000000L);
		order.setStatus("New");
		List<EquityOrder> orders = new ArrayList<EquityOrder>();
		orders.add(order);
		model.put("orders",orders);
		System.out.println("Inside retrieveBlotters");
		return "blotter";
	}

}
