package selenium.test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class PractoLogin {
	
	private By loginPageButton = By.xpath("//a[@name='Practo login']");
	private By registerLink = By.xpath("//a[@id='registerLink']");
	private By loginLink = By.xpath("//a[@id='loginLink']");
	private By nameField = By.xpath("//input[@id='name']");
	private By usernameField = By.xpath("//input[@id='username']");
	private By mobileField = By.xpath("//input[@id='mobile']");
	private By passwordField = By.xpath("//input[@id='password']");
	private By registerButton = By.xpath("//button[@id='EmailRegister']");
	private By loginButton = By.xpath("//button[@type='submit']");
	
	private By userNameError = By.xpath("//span[@id='usernameErrorBlock']");
	private By passwordError = By.xpath("//span[@id='passwordErrorBlock']");
	
	String EXPECTED_ERROR_UNREGISTERED_USERNAME = "Mobile Number is not registered";
	String EXPECTED_ERROR_NO_PASSWORD = "Password field cannot be empty";

	WebDriver driver;
	WebDriverWait wait;
	
    @BeforeClass
    public void beforeClass() {
	    System.setProperty("webdriver.chrome.driver","/Users/dksan/Downloads/chromedriver_win32n/chromedriver.exe");
	    driver = new ChromeDriver();
	    wait = new WebDriverWait(driver,30);
    }
  
    @BeforeMethod
    public void setUpMethod() {
	    driver.navigate().to("http://practo.com/");
	    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginPageButton)));
	    driver.findElement(loginPageButton).click();
    }
    
	@Test
	public void registerAndValidate() {
	    driver.findElement(registerLink).click();
	    driver.findElement(nameField).sendKeys("Devashish Thakur");
	    driver.findElement(mobileField).sendKeys("8282828282");
	    driver.findElement(passwordField).sendKeys("");
	    driver.findElement(registerButton).click();
	    String errorMessage = driver.findElement(passwordError).getText();
	    Assert.assertEquals(errorMessage, EXPECTED_ERROR_NO_PASSWORD);
	}
	
	@Test
	public void loginAndValidateError() {
	    driver.findElement(loginLink).click();
	    driver.findElement(usernameField).sendKeys("8282828282");
	    driver.findElement(passwordField).sendKeys("Passwoaadd@1");
	    driver.findElement(loginButton).click();
	    String errorMessage = driver.findElement(userNameError).getText();
	    Assert.assertEquals(errorMessage, EXPECTED_ERROR_UNREGISTERED_USERNAME);
	}
}
