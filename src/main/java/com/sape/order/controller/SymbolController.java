package com.sape.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sape.order.vo.JsonResponseWrapper;
import com.sape.order.vo.Symbol;

@Controller
public class SymbolController {
	@RequestMapping(value="/order/symbols",method=RequestMethod.GET)
	public @ResponseBody String retrieveSymbols(HttpServletResponse response, HttpServletRequest request){
		System.out.println("Inside retrievSymbols ");
		Symbol symbol1 = new Symbol();
		symbol1.setName("Google");
		Symbol symbol2 = new Symbol();
		symbol2.setName("Apple");
		List<Symbol> symbols = new ArrayList<Symbol>();
		symbols.add(symbol1);
		symbols.add(symbol2);
		Map<String,Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("symbols", symbols);
		JSONArray jsonArray = JSONArray.fromObject( symbols );
		JsonResponseWrapper wrapper = new JsonResponseWrapper();
		wrapper.setSymbols(symbols);
		System.out.println("JSON Array : " +jsonArray);
		response.setContentType("application/json");
		return jsonArray.toString();
	}
	@RequestMapping(value = "/order/symbol/security", method = RequestMethod.GET)
	public @ResponseBody
	String retrieveSecurityForGivenSymbol(@RequestParam("symbol") String symbol) {
		System.out.println("Inside retrieveSecurityForGivenSymbol " + symbol);
		String[] string = new String[] { "test" };
		JSONArray jsonArray = JSONArray.fromObject(string);
		System.out.println("JSON Array : " + jsonArray);
		return jsonArray.toString();
	}

}
