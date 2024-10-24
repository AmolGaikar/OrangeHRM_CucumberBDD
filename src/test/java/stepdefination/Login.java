package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Login {
	
	WebDriver driver;
	
	@Given("Openbrowser and enter url")
	public void openbrowser() {
		driver=new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
   @When("User enter valid username")
   public void validusername() throws InterruptedException {
	   driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	   Thread.sleep(2000);
   }
   @When("User enter valid password")
   public void validpassword() throws InterruptedException {
	   driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");	   
	   Thread.sleep(2000);
   }
   @When("User click on login button")
   public void loginbutton() {
	   driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	   
   }
   @Then("It should navigate to dashboard page")
   public void successfullylogin() {
	  String actualvalue=driver.getTitle();
	  String expectedvalue="OrangeHRM";
	  Assert.assertEquals(actualvalue, expectedvalue);
   }
}
