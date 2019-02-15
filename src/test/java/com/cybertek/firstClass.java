package com.cybertek;

import java.util.ArrayList;

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
		driver.get("https://www.dice.com");
		
		ArrayList<String> obj = new ArrayList<String>(); obj.add("Java");
		  obj.add("Selenium"); obj.add("Java Script"); obj.add("Protractor");
		  obj.add("Automation"); obj.add("Vb Script"); obj.add("Python");
		  obj.add("Ruby"); obj.add("UFT"); obj.add("Test Complete");
		  
		  System.out.println(obj);
		  
		  obj.add(1, "Selenium  modified");
		  
		  
		  System.out.println(obj);
	}

}
