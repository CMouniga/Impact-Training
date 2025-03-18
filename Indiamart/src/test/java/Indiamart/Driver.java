package Indiamart;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

public class Driver {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit Wait (10s)

	@FindBy(xpath="//input[contains(@id,'search_string')]")
	WebElement searchbar;
	@FindBy(xpath="//input[contains(@id,'btnSearch')]")
	WebElement searchbutton;
	@FindBy(xpath="//input[contains(@id,'city_suggest')]")
	WebElement Location;
	@FindBy(xpath="//span[contains(@class,'nearMeText')]")
	WebElement Locationbutton;
	@FindBy(xpath="//a[contains(@class,'cardlinks')]")
	WebElement selectproduct;
	@FindBy(xpath="//input[contains(@id,'mbl_idn')]")
	WebElement Mobilenumber;
	@FindBy(xpath="//input[contains(@id,'logintoidentify')]")
	WebElement continueButton;
	@FindBy(xpath="//div[contains(@class,'tn9_card pcp')]")
	WebElement selectimage;
	@FindBy(xpath="//span[contains(@class,'bo fs30')]")
	WebElement getRating;
	@FindBy(xpath="//h2[contains(@class,'fs15')]")
	WebElement supplierdetails;
	@FindBy(xpath="//a[contains(@class,'Hd_fl')]")
	WebElement Logo;
	@FindBy(xpath="//a[contains(@class,'h_ic42')]")
	WebElement shopping;
	@FindBy(xpath="//input[contains(@id,'search_string1')]")
	WebElement Shoppingsearch;
	@FindBy(xpath="//button[contains(@id,'btnSearch')]")
	WebElement ShoppingSearchbutton;
	@FindBy(xpath="//span[contains(@id,'bn_cta_0')]")
	WebElement buy;
	@FindBy(xpath="//input[contains(@id,'email')]")
	WebElement Email;
	@FindBy(xpath="//input[contains(@name,'firstName')]")
	WebElement firstname;
	@FindBy(xpath="//input[contains(@name,'lastName')]")
	WebElement lastname;
	@FindBy(xpath="//input[contains(@name,'address1')]")
	WebElement addresss;
	@FindBy(xpath="//input[contains(@name,'city')]")
	WebElement cityname;
	@FindBy(xpath="//input[contains(@name,'postalCode')]")
	WebElement postalcode;
	@FindBy(xpath="//input[contains(@name,'phone')]")
	WebElement Phonenumber;
	@FindBy(xpath="//div[contains(@class,'ber-cls-rec closeScrl cp')]")
	WebElement Wrong;

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
		driver.navigate().to("https://www.indiamart.com");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this); // Initialize WebElements
	}

	public void search(String input) {
		WebElement searchBar =  wait.until(ExpectedConditions.visibilityOf(searchbar));
		Assert.assertNotNull(searchBar, "Search bar is not found.");
		searchBar.clear();
		searchBar.sendKeys(input);
		Assert.assertEquals(searchBar.getAttribute("value"), input, "Search input does not match the expected value.");
	}

	public void searchButton() {
		WebElement searchButton =  wait.until(ExpectedConditions.visibilityOf(searchbutton));
		Assert.assertNotNull(searchButton, "Search button is not found.");
		searchButton.click();
	}

	public void location(String input) {
		WebElement location = wait.until(ExpectedConditions.visibilityOf(Location));
		Assert.assertNotNull(location, "Location input field is not found.");
		location.sendKeys(input);
		WebElement locationSearch = wait.until(ExpectedConditions.visibilityOf(Locationbutton));
		Assert.assertNotNull(locationSearch, "Location search button is not found.");
		locationSearch.click();
	}

	public void selectProduct() {
		WebElement product = wait.until(ExpectedConditions.visibilityOf(selectproduct));
		product.click();
	}

	public void switchToNextTab() {
		Iterator<String> iterator = driver.getWindowHandles().iterator();
		String currentWindow = driver.getWindowHandle();
		while (iterator.hasNext()) {
			String nextWindow = iterator.next();
			if (nextWindow.equals(currentWindow) && iterator.hasNext()) {
				driver.switchTo().window(iterator.next());
				break;
			}
		}
	}

	public void mobilenumber(String input) {
		WebElement number = wait.until(ExpectedConditions.elementToBeClickable(Mobilenumber));
		number.sendKeys(input);
	}

	public void ClickcontinueButton() {
		WebElement continuebutton =  wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continuebutton.click();
	}

	public void selectImage() {
		WebElement image = wait.until(ExpectedConditions.elementToBeClickable(selectimage));
		image.click();
	}

	public void rating() {
		Actions actions = new Actions(driver);
		WebElement review = wait.until(ExpectedConditions.visibilityOf(getRating));
		actions.moveToElement(review).perform();
		System.out.println("Product Rating : "+review.getText());

	}
	public void supplierDetails() {
		WebElement supplier = wait.until(ExpectedConditions.visibilityOf(supplierdetails));
		System.out.println("Supplier details : "+supplier.getText());
	}
	public void logo() {
		WebElement mainLogo =  wait.until(ExpectedConditions.elementToBeClickable(Logo));
		mainLogo.click();    	
	}
	public void shoppingbutton() {
		WebElement shoppingButton = wait.until(ExpectedConditions.elementToBeClickable(shopping));
		shoppingButton.click();
	}
	
	public void subSearch(String input) {
		WebElement ShoppingSearch = wait.until(ExpectedConditions.elementToBeClickable(Shoppingsearch));
		ShoppingSearch.sendKeys(input);
	}
	
	public void ShoppingButton() {
		WebElement ShoppingSearchButton = wait.until(ExpectedConditions.elementToBeClickable(ShoppingSearchbutton));
		ShoppingSearchButton.click();
	}
	
	public void buyButton() {
		WebElement Buy = wait.until(ExpectedConditions.elementToBeClickable(buy));
		Buy.click();
	}
	
	public void emailaddress(String input) {
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(Email));
		email.sendKeys(input);
	}
	
	public void FirstName(String input) {
		WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(firstname));
		firstName.sendKeys(input);
	}
	
	public void LastName(String input) {
		WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(lastname));
		lastName.sendKeys(input);
	}
	
	public void address(String input) {
		WebElement Address = wait.until(ExpectedConditions.elementToBeClickable(addresss));
		Address.sendKeys(input);
	}
	
	public void city(String input) {
		WebElement City = wait.until(ExpectedConditions.elementToBeClickable(cityname));
		City.sendKeys(input);
	}
	public void Pincode(String input) {
		WebElement pincode = wait.until(ExpectedConditions.elementToBeClickable(postalcode));
		pincode.sendKeys(input);
	}
	public void phone(String input) {
		WebElement Phone = wait.until(ExpectedConditions.elementToBeClickable(Phonenumber));
		Phone.sendKeys(input);
	}
	public void wrongButton() {
		WebElement wrong = wait.until(ExpectedConditions.elementToBeClickable(Wrong));
		wrong.click();
	}
	public void close() {
		driver.quit();
	}

	public void takeScreenshot(String screenshotName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String targetPath = "screenshots/" + screenshotName + ".png";

		try {

			File target = new File(targetPath);
			target.getParentFile().mkdirs();
			FileHandler.copy(source, target);
			System.out.println("Screenshot saved at: " + targetPath);
		}
		catch (IOException e) {
			System.out.println("Error while saving screenshot: " + e.getMessage());
		}
	}
}



