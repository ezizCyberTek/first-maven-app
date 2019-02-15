package com.dice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.io.*; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jobSearch {

	public static void main(String[] args) throws IOException {
		// Set up chrome driver path
		WebDriverManager.chromedriver().setup();
		// invoke selenium webdriver
		WebDriver driver = new ChromeDriver();
		// fullcreen
		driver.manage().window().fullscreen();
		// set universal wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * Step 1. Launch browser and navigate to https://dice.com Expected: dice home
		 * page should be displayed
		 */
		String url = "https://dice.com";
		driver.get(url);

		String actualTitle = driver.getTitle();
		String expectedTitle = "Find Jobs in Tech | Dice.com";

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Step PASS. Dice homepage successfully loaded");
		} else {
			System.out.println("Step FAIL. Dice homepage did not load successfully");
			throw new RuntimeException("Step FAIL. Dice homepage did not load successfully");
		}
		
		File file = new File("/Users/ezizkurbanov/Documents/workspace2019/firstMavenProject/first-maven-app/src/test/resources/jobs.txt"); 
		  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		
		ArrayList<String> obj = new ArrayList<String>(); obj.add("Java");
		 
		String st;
		while((st = br.readLine()) != null){
			System.out.println("Adding"+st);
			obj.add(st);
		}
		System.out.println("===================================================");
		for(String item : obj) {
			System.out.println(item);
		}
		
		System.out.println("===================================================");
		
		String keyword=null;
		int countResult=0;
		int size = obj.size();
		
		for(int i=0; i<size; i++) {
			
			keyword = obj.get(i);
					
			driver.findElement(By.name("q")).clear();
			driver.findElement(By.name("q")).sendKeys(keyword);
	
			String location = "77064";
			driver.findElement(By.name("l")).clear();
			driver.findElement(By.name("l")).sendKeys(location);
	
			if (i==0) {
				driver.findElement(By.id("findTechJobs")).click();
			} else {
				driver.findElement(By.xpath("//input[@class='btn btn-lg btn-primary btn-block dice-btn mB5']")).click();
			}
	
			String count = driver.findElement(By.id("posiCountId")).getText();
			// ensure count is more than 0
			countResult = Integer.parseInt(count.replace(",", ""));
	
			if (countResult > 0) {
				System.out.println(
						"Step PASS: Keyword : " + keyword + " search returned " + countResult + " results in " + location);
			} else {
				System.out.println(
						"Step FAIL: Keyword : " + keyword + " search returned " + countResult + " results in " + location);
			}
			
			if (i>0) {
				obj.remove(i);
				obj.add(i, keyword+"-"+countResult);
			}
		
		}
		
		System.out.println("===================================================");
		
		for(String item : obj) {
			System.out.println(item);
		}

		driver.close();
		System.out.println("TEST COMPLETED - " + LocalDateTime.now());

	}

}
