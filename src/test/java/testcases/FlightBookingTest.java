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



//		OTher testcases That Can Be Written
//
//		1.verify the different combination of Booking To and Fro Secnario
//		2.Verify the differnt Flight Number For a Pariticular to and From Destiantion
//		3.Verify the Airlines available for to and fro destiantin
//		4.Verify the text messsag are proper in every screen
//		5.Verify the Flight Details in the Third Screen
//		6.Verify the Valid and Invalid CARD Details Scenario
//		7.VErify the Expired Card Scenario
//		8.VErify the functionality of remember me checkbox
//		9.Verify all the details of Confimation page
//		10.Verify the Api reponse from booking
//		11.Verify the different Screen URLs like (https://blazedemo.com/purchase.php and  https://blazedemo.com/confirmation.php ) shouodl not be launched directly
//		12.Verify the Destination of the week Functionality
//		Note - There Can be Many More Test Cases





	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
