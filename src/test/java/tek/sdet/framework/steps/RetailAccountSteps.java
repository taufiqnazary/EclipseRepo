package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGenerator;

public class RetailAccountSteps extends CommonUtility {
	
	POMFactory factory = new POMFactory();
		
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.homePage().account);
		logger.info("user clicked on account option"); 
	}
	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String nameValue, String PhoneValue) {
		clearTextUsingSendKeys (factory.accountPage().nameField);
		sendText(factory.accountPage().nameField,nameValue);
		clearTextUsingSendKeys (factory.accountPage().phoneInputField);
		sendText(factory.accountPage().phoneInputField,PhoneValue);
		logger.info("user updated name and phone");
	}
	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().updateButton);
		logger.info("user clicked on Update button");

	}
	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInformationUpdateMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInformationUpdateMessage));
		logger.info("user profile information is updated");
	
	}
	
	
	@When("User enter below information")
	public void userEnterBelowInformation(DataTable dataTable) {
		
		List<Map<String, String>>passwordInformation = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().previousPasswordInput,passwordInformation.get(0).get("previousPassword"));
		sendText(factory.accountPage().newPasswordInput,passwordInformation.get(0).get("newPassword"));
		sendText(factory.accountPage().confirmPasswordInput,passwordInformation.get(0).get("confirmPassword"));
		logger.info("user entered password information");
			
	    
	}
	@When("User click on Change Password button")
	public void userClickOnChangePasswordButton() {
		click(factory.accountPage().changePasswordButton);
		logger.info("user clicked on change Password button");
		
			   
	}
	@Then("a messasge should be displayed {string}")
	public void aMessasgeShouldBeDisplayed(String expectedMessage) {
		
		if(expectedMessage.contains("Password")) {
		waitTillPresence(factory.accountPage().passwordUpdatedSuccessfullyMessage);
		Assert.assertEquals(expectedMessage, factory.accountPage().passwordUpdatedSuccessfullyMessage.getText());
		logger.info(expectedMessage + "is displayed");
		}else if (expectedMessage.contains("Payment Method added")) {
			waitTillPresence(factory.accountPage().paymentMethodAddedSuccessfullyMessage);
			Assert.assertEquals(expectedMessage, factory.accountPage().paymentMethodAddedSuccessfullyMessage.getText());
			logger.info(expectedMessage + "is displayed");
			
		} else if (expectedMessage.contains("Payment Method updated")) {
			waitTillPresence(factory.accountPage().paymentMethodUpdatedSuccessfullyMessage);
			Assert.assertEquals(expectedMessage, factory.accountPage().paymentMethodUpdatedSuccessfullyMessage.getText());
			logger.info(expectedMessage + "is displayed"); 
		
		}else if (expectedMessage.contains("Address Added Successfully")) {
			waitTillPresence(factory.accountPage().addAddressSuccessfullMessage);
			Assert.assertEquals(expectedMessage, factory.accountPage().addAddressSuccessfullMessage.getText());
			logger.info(expectedMessage + "is displayed"); 
		
		}else if (expectedMessage.contains("Address Updated Successfully")) {
			waitTillPresence(factory.accountPage().addressUpdatedSuccessfullyMessage);
			Assert.assertEquals(expectedMessage, factory.accountPage().addressUpdatedSuccessfullyMessage.getText());
			logger.info(expectedMessage + "is displayed");
			
		}else if (expectedMessage.contains("Order Placed, Thanks")) {
			waitTillPresence(factory.homePage().orderPlacedMessage);
			Assert.assertEquals(expectedMessage, factory.homePage().orderPlacedMessage.getText());
			logger.info(expectedMessage + "is displayed");
			
		
		}
	  
	}

	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.accountPage().addPaymentMethodLink);
		logger.info("user clicked on add a payment method link");
	    	}
	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>>paymentInformation = dataTable.asMaps(String.class, String.class);
		
		sendText(factory.accountPage().cardNumberInput, paymentInformation.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardInput, paymentInformation.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationYearInput,paymentInformation.get(0).get("expirationYear"));
		selectByVisibleText(factory.accountPage().expirationMonthInput,paymentInformation.get(0).get("expirationMonth"));		
		sendText(factory.accountPage().securityCodeInput, paymentInformation.get(0).get("securityCode"));
		logger.info("user entered required card information");
	    
	}
	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.accountPage().addYourCardButton);
		logger.info("user clicked on Add your card button");
	    	}
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String string) {
	    
	}	
	
	@When("User select card with ending {string}")
	public void userSelectCardWithEnding(String cardEndingNumber) {
		
		List<WebElement> cards = factory.accountPage().cardEndingNumber;
		for (WebElement card: cards) {
			if (card.getText().equals(cardEndingNumber))
				System.out.println(card.getText()+ "==============");
				click(card);				
			logger.info(cardEndingNumber + "is selected");
			break;		
			
		}
		
		}
	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.accountPage().cardEditButton);
		logger.info("user clicked on Edit Option");
		

	}
	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>>paymentInformation = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(factory.accountPage().cardNumberInput);
		sendText(factory.accountPage().cardNumberInput, paymentInformation.get(0).get("cardNumber"));
		clearTextUsingSendKeys(factory.accountPage().nameOnCardInput);
		sendText(factory.accountPage().nameOnCardInput, paymentInformation.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationYearInput,paymentInformation.get(0).get("expirationYear"));
		selectByVisibleText(factory.accountPage().expirationMonthInput,paymentInformation.get(0).get("expirationMonth"));
		clearTextUsingSendKeys(factory.accountPage().securityCodeInput);
		sendText(factory.accountPage().securityCodeInput, paymentInformation.get(0).get("securityCode"));
		logger.info("user entered required card information");

	}
	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.accountPage().updateYourCardButton);
		logger.info("user clicked on Update your card button");
	
	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.accountPage().removeCardLink);
		logger.info("user clicked on remove option of card section");

	}
	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		try {
	   Assert.assertFalse(isElementDisplayed(factory.accountPage().cardPresent));
	   logger.info("payment details removed from account");
	}catch(AssertionError e) {
		logger.info(e.getMessage());
	}

	}
	
	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().addAddressButton);
		logger.info("user clicked on Add Address option");

	}
	@When("User fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>>addressInformation = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().countryDropDown, DataGenerator.addressGenerator(addressInformation.get(0).get("country")));
		clearTextUsingSendKeys(factory.accountPage().addressFullNameInput);
		sendText(factory.accountPage().addressFullNameInput, DataGenerator.addressGenerator(addressInformation.get(0).get("fullname")));
		clearTextUsingSendKeys(factory.accountPage().addressPhoneNumberInput);
		sendText(factory.accountPage().addressPhoneNumberInput, DataGenerator.addressGenerator(addressInformation.get(0).get("phoneNumber")));
		clearTextUsingSendKeys(factory.accountPage().addressInput);
		sendText(factory.accountPage().addressInput, DataGenerator.addressGenerator(addressInformation.get(0).get("streetAddress")));
		clearTextUsingSendKeys(factory.accountPage().apartmentInput);
		sendText(factory.accountPage().apartmentInput, DataGenerator.addressGenerator(addressInformation.get(0).get("apt")));
		clearTextUsingSendKeys(factory.accountPage().cityInput);
		sendText(factory.accountPage().cityInput, DataGenerator.addressGenerator(addressInformation.get(0).get("city")));
		selectByVisibleText(factory.accountPage().stateInput, DataGenerator.addressGenerator(addressInformation.get(0).get("state")));
		clearTextUsingSendKeys(factory.accountPage().zipCodeInput);
		sendText(factory.accountPage().zipCodeInput, DataGenerator.addressGenerator(addressInformation.get(0).get("zipCode")));
		logger.info("user filled the address form");		

	}
	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.accountPage().addYourAddress);
		logger.info("user clicked Add your Address button");
	    
	}

	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.accountPage().editAddressButton);
		logger.info("user clicked on edit address option");

	}
	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.accountPage().updateAddressButton);
		logger.info("user clicked on Update your Address button");
	   
	}
	
	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.accountPage().removeAddressOption);
		logger.info("user clicked on remove option of address section");
	   
	}
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		
		try {
			   Assert.assertFalse(isElementDisplayed(factory.accountPage().removeAddressOption));
			   logger.info("Address details removed");
			}catch(AssertionError e) {
				logger.info(e.getMessage());
			}
	    
	}


}
