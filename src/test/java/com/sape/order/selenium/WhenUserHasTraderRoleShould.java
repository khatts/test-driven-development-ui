package com.sape.order.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


public class WhenUserHasTraderRoleShould extends AbstractIntegrationTestFixture{
	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		webDriver.get(baseUrl+"tdd/login.jsp");
		
	}
	@Test(expected= NoSuchElementException.class)
	public void notBeAbleToAccessOrders() throws Exception {
		webDriver.findElement(By.linkText("Neil Armstrong")).click();
		webDriver.findElement(By.id("orders"));
	}
	@Test
	public void beAbleToAccessBlotters() throws Exception {
		webDriver.findElement(By.linkText("Neil Armstrong")).click();
		webDriver.findElement(By.id("blotters"));
	}
}

