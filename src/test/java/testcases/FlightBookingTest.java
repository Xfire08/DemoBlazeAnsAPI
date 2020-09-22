package testcases;

import com.maersk.blaze.base.TestBase;

import com.maersk.blaze.pages.BlazeDemoBookingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlightBookingTest extends TestBase {
	BlazeDemoBookingPage blazeDemoBookingPage = new BlazeDemoBookingPage();
	public FlightBookingTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();

	}

	//Scenario To Test User Is Getting Proper ID After SucessFull Ticket Booking
	@Test
	public void SC1_VerifyUserIsableToBookTicketSucessfully(){
		//Select Values From From and To DropDown and Click on FindFlight
		blazeDemoBookingPage.selectValueFromdepartureDropDown("San Diego");
		blazeDemoBookingPage.selectValueFromToDropDown("Berlin");
		blazeDemoBookingPage.clickOnFindFlight();
		//Choose a Flight
		blazeDemoBookingPage.chooseFirstFlight();

		//Fill the Form
		blazeDemoBookingPage.fillTheFlightDetailsForm("Name","ABC");
		blazeDemoBookingPage.fillTheFlightDetailsForm("Address","Bangalore");
		blazeDemoBookingPage.fillTheFlightDetailsForm("City","Bangalore");
		blazeDemoBookingPage.fillTheFlightDetailsForm("State","Karnataka");
		blazeDemoBookingPage.fillTheFlightDetailsForm("Zip Code","123456");
		blazeDemoBookingPage.fillTheFlightDetailsForm("Credit Card Number","1234567891234567");
		blazeDemoBookingPage.fillTheFlightDetailsForm("Month","12");
		blazeDemoBookingPage.fillTheFlightDetailsForm("Year","2025");
		blazeDemoBookingPage.fillTheFlightDetailsForm("Name on Card","ABC XYZ");
		blazeDemoBookingPage.fillTheFlightDetailsForm("Name","ABC");
		//Click on Purcahse Flight
		blazeDemoBookingPage.clickOnPurchaseFlight();

		//Verify the Details after Booking
		blazeDemoBookingPage.verifyTextAfterBooking("Thank you for your purchase today!");
		blazeDemoBookingPage.sucessIDGeneratedAfterBooking();

	}
	//Scenario To Test User is Not Getting Valid ID Generated for Booking Without Filling form
	@Test
	public void SC2_VerifyUserIsNotableToBookTicketSucessfullyWithoutFillingForm(){
		//Select Values From From and To DropDown and Click on FindFlight
		blazeDemoBookingPage.selectValueFromdepartureDropDown("San Diego");
		blazeDemoBookingPage.selectValueFromToDropDown("Berlin");
		blazeDemoBookingPage.clickOnFindFlight();
		//Choose a Flight
		blazeDemoBookingPage.chooseFirstFlight();


		//Click on Purcahse Flight
		blazeDemoBookingPage.clickOnPurchaseFlight();

		//Verify the Details after Booking
		blazeDemoBookingPage.verifyTextAfterBooking("Thank you for your purchase today!");
		blazeDemoBookingPage.sucessIDGeneratedAfterBooking();
		blazeDemoBookingPage.verifFeildAttributesAfterBooking("Status","PendingCapture");

	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
