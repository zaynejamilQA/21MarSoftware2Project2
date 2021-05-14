package com.qa.mma.selenium.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.mma.selenium.homepage.Homepage;

@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Tests {

	@LocalServerPort
	static int randomPort;

	private static final String URL = Homepage.URL + randomPort;

	private static WebDriver driver;

	@Before
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		// option.setHeadless(true);
		driver = new ChromeDriver(option);
		driver.manage().window().setSize(new Dimension(1378, 690));
	}

	@Test
	public void testAdd() {
		driver.get(URL);
		Homepage test = PageFactory.initElements(driver, Homepage.class);
		test.add("Name", 2, 1, 0, 0, 0);
		final String expected = "Name 2 years old, 1-0-0 (0)";
		assertTrue(test.getTopFighter().getText().contains(expected));
	}

	@After
	public void tearDown() {
		driver.close();
	}
}