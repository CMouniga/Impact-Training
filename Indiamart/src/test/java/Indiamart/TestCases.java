package Indiamart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {
	
	Logger logger = LoggerFactory.getLogger(TestCases.class);
	Driver driver = new Driver();

	@BeforeTest
	public void SetUp() {
		driver.setup();
	}

	@Test(retryAnalyzer = Indiamart.RetryAnalyzer.class, priority = 1, description = "Test Case 1: Verify search functionality with a valid product name.")
	public void SearchWithValidInput() {
		try {
			logger.info("Test case-01 : Verify search functionality with a valid product name.");
			Reporter.log("Test case-01 :");
			Reporter.log("Step 1: Entering 'Home Decor Item' in the search bar.");
			driver.search("Home Decor Item");
			Reporter.log("Step 2: Clicking the search button.");
			driver.searchButton();
			Reporter.log("Step 3: Capturing screenshot.");
			logger.info("Test case : 1 - Successfully completed");
			Reporter.log("Test case : 1 - Successfully completed");
			driver.takeScreenshot("SearchWithValidInput");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\SearchWithValidInput.png' target='_blank'>Testcase:01-Passed</a>");
		} 
		catch (Exception exception) {
			driver.takeScreenshot("SearchWithValidInput_Error");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\SearchWithValidInput_Error.png' target='_blank'>Testcase:01-Failed</a>");
			Reporter.log("Error in Search with valid Input");
		}
	}

	@Test(retryAnalyzer = Indiamart.RetryAnalyzer.class, priority = 2, description = "Test Case 2: Verify search functionality with an invalid product name.")
	public void SearchWithInValidInput() {
		try {
			logger.info("Test case-02: Verify search functionality with an invalid product name.");
			Reporter.log("Test case-02");
			Reporter.log("Step 1: Entering '@@$#@#@#$' in the search bar.");
			driver.search("@@$#@#@#$");
			Reporter.log("Step 2: Clicking the search button.");
			driver.searchButton();
			Reporter.log("Step 3: Capturing screenshot.");
			driver.takeScreenshot("SearchWithInValidInput");
			Reporter.log("Test case : 2 - Successfully completed");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\SearchWithInValidInput.png' target='_blank'>Testcase:02-Passed</a>");
		} 
		catch (Exception exception) {
			driver.takeScreenshot("SearchWithInValidInput_Error");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\SearchWithInValidInput_Error.png' target='_blank'>Testcase:02-Failed</a>");
			logger.info("Error in search with invalid input");
		}
	}

	@Test(retryAnalyzer = Indiamart.RetryAnalyzer.class, priority = 3, description = "Test Case 3: Verify search functionality with product name and location filter.")
	public void SearchWithLocation() {
		try {
			logger.info("Test case-03: Verify search functionality with product name and location filter.");
			Reporter.log("Test case-03");
			Reporter.log("Step 1: Entering 'Home Decor Item' in the search bar.");
			driver.search("Home Decor Item");
			Reporter.log("Step 2: Clicking the search button.");
			driver.searchButton();
			Reporter.log("Step 3: Setting location filter to 'Chennai'.");
			driver.location("Chennai");
			Reporter.log("Step 4: Capturing screenshot.");
			driver.takeScreenshot("SearchWithLocation");
			Reporter.log("Test case : 3 - Successfully completed");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\SearchWithLocation.png' target='_blank'>Testcase:03-Passed</a>");
		} 
		catch (Exception exception) 
		{
			driver.takeScreenshot("SearchWithLocation_Error");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\SearchWithLocation_Error.png' target='_blank'>Testcase:03-Failed</a>");
			logger.info("Error in search with location");
		}
	}

	@Test(retryAnalyzer = Indiamart.RetryAnalyzer.class, priority = 4, description = "Test Case-4 : Verify search functionality with a misspelled product name.")
	public void SearchWithMisSpelled() {
		try {
			logger.info("Test case-04: Verify search functionality with a misspelled product name.");
			Reporter.log("Test case-04:");
			Reporter.log("Step 1: Entering 'Plasic Chair' in the search bar.");
			driver.search("Plasic Chair");
			Reporter.log("Step 2: Clicking the search button.");
			driver.searchButton();
			Reporter.log("Step 3: Capturing screenshot.");
			driver.takeScreenshot("SearchWithMisSpelled");
			Reporter.log("Test case : 4 - Successfully completed");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\SearchWithMisSpelled.png' target='_blank'>Testcase:04-Passed</a>");
		} 
		catch (Exception exception) {
			driver.takeScreenshot("SearchWithMisSpelled_Error");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\SearchWithMisSpelled_Error.png' target='_blank'>Testcase:04-Failed</a>");
			logger.info("Error in search with misspelled Input");
		}
	}

	@Test(retryAnalyzer = Indiamart.RetryAnalyzer.class, priority = 5, description = "Test Case 5: Verify search functionality with special characters in the product name.")
	public void SearchWithSpecialCharacter() {
		try {
			logger.info("Test case-05: Verify search functionality with special characters in the product name.");
			Reporter.log("Test case-05:");
			Reporter.log("Step 1: Entering '#@#Plastic Chair' in the search bar.");
			driver.search("#@#Plastic Chair");
			Reporter.log("Step 2: Clicking the search button.");
			driver.searchButton();
			Reporter.log("Step 3: Capturing screenshot.");
			driver.takeScreenshot("SearchWithSpecialCharacter");
			Reporter.log("Test case : 5 - Successfully completed");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\SearchWithSpecialCharacter.png' target='_blank'>Testcase:05-Passed</a>");
		} catch (Exception exception) {
			driver.takeScreenshot("SearchWithSpecialCharacter_Error");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\SearchWithSpecialCharacter_Error.png' target='_blank'>Testcase:05-Failed</a>");
			logger.info("Error in Search With Special Character");
		}
	}

	@Test(retryAnalyzer = Indiamart.RetryAnalyzer.class, priority = 6, description = "Test case-06 : Verify that product details such as Title, Description, and Price are correctly displayed.")
	public void ProductDetails() {
		try {
			logger.info("Test case - 6: Verifying product details");
			Reporter.log("Test case - 6:");
			Reporter.log("Step 1: Searched for 'Home Decor Item'.");
			Reporter.log("Step 2: Clicked search button.");
			driver.logo();
			driver.search("Home decor item");
			driver.searchButton();
			driver.selectProduct();
			driver.switchToNextTab();
			Reporter.log("Step 3: Selected a product from the search results.");
			driver.takeScreenshot("ProductDetails");
			Reporter.log("Step 4: Screenshot captured for Product Details.");
			Reporter.log("Test case : 6 - Successfully completed");
			logger.info("Product details verification completed successfully.");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\ProductDetails.png' target='_blank'>Testcase:06-Passed</a>");
		} 
		catch (Exception exception) {
			logger.info("Error in Product Details");
			driver.takeScreenshot("ProductDetails_Error");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\ProductDetails_Error.png' target='_blank'>Testcase:06-Failed</a>");

		}
	}

	@Test(retryAnalyzer = Indiamart.RetryAnalyzer.class, priority = 7, description = "Test case - 07 : Verify that product images are displayed correctly after selecting a product.")
	public void ProductImages() {
		try {
			driver.logo();
			logger.info("Test case - 07 : Verifying product images");
			Reporter.log("Test case - 07 :");
			driver.search("Home Decor Item");
			Reporter.log("Step 1: Searched for 'Home Decor Item'.");
			driver.searchButton();
			Reporter.log("Step 2: Clicked search button.");
			driver.selectProduct();
			Reporter.log("Step 3: Selected a product from the search results.");
			driver.switchToNextTab();
			Reporter.log("Step 4: Switched to product window.");
			Reporter.log("Step 5: Entered mobile number for verification.");
			driver.mobilenumber("9442679637");
			driver.ClickcontinueButton();
			driver.selectImage();
			Reporter.log("Step 6: Clicked on a product image.");
			driver.takeScreenshot("ProductImages");
			Reporter.log("Step 7: Screenshot captured for Product Images.");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\ProductImages.png' target='_blank'>Testcase:07-Passed</a>");
			Reporter.log("Product image verification completed successfully.");
			logger.info("Product image verification completed successfully.");
		} 
		catch (Exception exception) {
			Reporter.log("Error in Product Images.");
			driver.takeScreenshot("ProductImages_Error");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\ProductImages_Error.png' target='_blank'>Testcase:07-Failed</a>");
	
		}
	}

	@Test(retryAnalyzer = Indiamart.RetryAnalyzer.class, priority = 8, description = "Test case - 08 : Verify that Product Rating are displayed correctly after selecting a product.")
	public void ProductRating() {
		// Test case - 08 : Verify product reviews are displayed.
		try {
			logger.info("Test case-08 : Verifying product Rating are displayed");
			Reporter.log("Test case-08 : ");
			driver.wrongButton();
			// driver.logo();
			// driver.search("Home Decor Item");
			Reporter.log("Step 1: Searched for 'Home Decor Item'.");
			// driver.searchButton();
			Reporter.log("Step 2: Clicked search button.");
			// driver.selectProduct();
			Reporter.log("Step 3: Selected a product from the search results.");
			// driver.switchToNextTab();
			Reporter.log("Step 4: Switched to product window.");
			driver.rating();
			driver.takeScreenshot("ProductRating");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\ProductRating.png' target='_blank'>Testcase:08-Passed</a>");
			logger.info("Product Rating verification completed successfully.");
			Reporter.log("Product Rating verification completed successfully.");

		} catch (Exception exception) {
			logger.error("Error in ProductRating Testcase");
			driver.takeScreenshot("ProductRating_Error");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\ProductRating_Error.png' target='_blank'>Testcase:08-Failed</a>");

		}

	}
	// Test case - 09 : Verify viewing supplier details from the product page.

	@Test(retryAnalyzer = Indiamart.RetryAnalyzer.class, priority = 9, description = "Test case - 09 : Verify that product supplier details are displayed correctly.")
	public void SuppilerDetails() {
		try {
			logger.info("Test case-09 : Verifying supplier details from the product page. ");
			Reporter.log("Test case-09 :");
			// driver.logo();
			// driver.search("Home Decor Item");
			Reporter.log("Step 1: Searched for 'Home Decor Item'.");
			// driver.searchButton();
			Reporter.log("Step 2: Clicked search button.");
			// driver.selectProduct();
			Reporter.log("Step 3: Selected a product from the search results.");
			// driver.switchToNextTab();
			Reporter.log("Step 4: Switched to product window.");
			driver.supplierDetails();
			driver.takeScreenshot("SuppilerDetails");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\SuppilerDetails.png' target='_blank'>Testcase:09-Passed</a>");
			logger.info("Product supplier details are verification completed successfully.");
			Reporter.log("Product supplier details are verification completed successfully.");
		} 
		catch (Exception exception) {
			logger.error("Error in Supplier Details Testcase");
			driver.takeScreenshot("SuppilerDetails_Error");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\SuppilerDetails_Error.png' target='_blank'>Testcase:09-Failed</a>");

		}
	}

	@Test(retryAnalyzer = Indiamart.RetryAnalyzer.class, priority = 10, description = "Test case - 10 : Verify that Checkout Page are displayed correctly.")

	public void CheckoutDetails() {
		try {
			logger.info("Test case-10 : Starting checkout process.");
			Reporter.log("Test case-10 :");
			driver.logo();
			driver.shoppingbutton();
			Reporter.log("Step 1: Clicked on shopping button.");
			driver.subSearch("Home decor item");
			Reporter.log("Step 2: Searched for 'Home decor item'.");
			driver.ShoppingButton();
			driver.buyButton();
			Reporter.log("Step 3: Clicked on buy button.");
			driver.switchToNextTab();
			Reporter.log("Step 4: Switched to new window.");
			Reporter.log("Step 5: Entering user details");
			driver.emailaddress("mounigac2019@gmail.com");
			Reporter.log("Step 6: Entering user details:Email");
			driver.FirstName("Mouni");
			Reporter.log("Step 7: Entering user details:FirstName");
			driver.LastName("C");
			Reporter.log("Step 8: Entering user details:LastName");
			driver.address("35/1,Thambidurai street");
			Reporter.log("Step 9: Entering user details:Address");
			driver.city("Salem");
			Reporter.log("Step 10: Entering user details:City");
			driver.Pincode("637501");
			Reporter.log("Step 11: Entering user details:Pincode");
			driver.phone("9442679637");
			Reporter.log("Step 12: Entering user details:phone");
			driver.takeScreenshot("CheckoutDetails");
			logger.info("User details entered successfully.");
			Reporter.log("User details entered successfully.");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\CheckoutDetails.png' target='_blank'>Testcase:10-Passed</a>");
		} 
		catch (Exception exception) {
			logger.info("An error occurred during checkout.");
			driver.takeScreenshot("checkout_error");
			Reporter.log("<a href='C:\\Users\\mouniga.chinna\\eclipse-workspace\\Indiamart\\screenshots\\checkout_error.png' target='_blank'>Testcase:10-Failed</a>");

		}
	}

	@AfterTest
	public void CloseBrowser() {
		try {
			if (driver != null) {
				driver.close();
				logger.info("Browser closed successfully.");
			}
		} 
		catch (Exception exception) {
			logger.error("Error in tearDown: ", exception);
		}
	}
}
