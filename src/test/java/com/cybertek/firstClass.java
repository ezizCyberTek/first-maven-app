package com.cybertek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

public class firstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Faker faker = new Faker();
		String creditCard = faker.finance().creditCard();
		System.out.println(creditCard);
		
		System.setProperty("webdriver.chrome.driver", "/Users/ezizkurbanov/Documents/Selenium Dependencies 2019/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cybertekschool.com");
		
	}

}
