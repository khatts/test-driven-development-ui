package com.sape.order.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class WhenUserHasPortfolioManagerAccessRoleShould extends AbstractIntegrationTestFixture{
	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		webDriver.get(baseUrl+"tdd/login.jsp");
		
	}
	@Test
	public void beAbleToAccessOrders() throws Exception {
		webDriver.findElement(By.linkText("Steve Jobs")).click();
		webDriver.findElement(By.id("orders"));
	}
	@Test
	public void beAbleToAccessBlotters() throws Exception {
		webDriver.findElement(By.linkText("Steve Jobs")).click();
		webDriver.findElement(By.id("blotters"));
	}
}

