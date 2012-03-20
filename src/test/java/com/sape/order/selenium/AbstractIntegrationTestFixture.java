package com.sape.order.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class AbstractIntegrationTestFixture {

	protected WebDriver webDriver;
	protected String baseUrl;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities ieCapabilities = DesiredCapabilities
				.internetExplorer();
		ieCapabilities.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		webDriver = new InternetExplorerDriver(ieCapabilities);
		baseUrl = "http://localhost:8080/";
	}

	@After
	public void tearDown() throws Exception {
		webDriver.quit();
	}

}
