package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class GreenCartSteps {
public WebDriver driver;
public String homeProductName,offerProductName;
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
	  //  System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("user search with short productName {string} and actual product is found on home page")
	public void user_search_with_short_product_name_and_actual_product_is_found_on_home_page(String productName) {
	    driver.findElement(By.xpath("//input[type='search']")).sendKeys(productName);
	    homeProductName= driver.findElement(By.cssSelector(".products h4")).getText().split("-")[0].trim();
	    System.out.println(homeProductName);
	}
	@When("user search with short productName {string} and actual product is found on Offer page")
	public void user_search_with_short_product_name_and_actual_product_is_found_on_offer_page(String productName) {
	    driver.findElement(By.linkText("Top Deals")).click();
	    Set<String>windows=driver.getWindowHandles();
	    Iterator<String>it=windows.iterator();
	    //String parent=it.next();
	    String child=it.next();
	    driver.switchTo().window(child);
	    driver.findElement(By.id("search-field")).sendKeys(productName);
	    offerProductName= driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();
	    System.out.println(offerProductName);
	}
	@Then("Verify that productName from offer page is matching with the productName from offer page")
	public void verify_that_product_name_from_offer_page_is_matching_with_the_product_name_from_offer_page() {
	    Assert.assertEquals(offerProductName, homeProductName);
	}
	
}
