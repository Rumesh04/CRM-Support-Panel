package net.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.pageobject.PomClass;
import net.utility_class.BaseClass;

public class LogOut extends BaseClass {
	
	PomClass pom = new PomClass();
	
	@Given("the User is logged in to Support Dashboard")
	public void the_user_is_logged_in_to_support_dashboard() {
		driver.get("https://d38c4xafcjpo0f.cloudfront.net/");
		waitImpletic();
		setText(pom.getEnterEmail(), "gokulraj.kiaq@gmail.com");
		setText(pom.getEnterPassword(), "Gokul@1234");
		button(pom.getClickLogin());
		visibleOfElement(pom.getDashbroadPage());
		Assert.assertTrue("Support Dashbroad is not displayed", pom.getDashbroadPage().isDisplayed());
	}
	@Given("the user clicks the support profile")
	public void the_user_clicks_the_support_profile() {
	    button(pom.getClickSupport());
	}
	@Given("the logout confirmation popup is displayed")
	public void the_logout_confirmation_popup_is_displayed() {
	    Assert.assertTrue("Log Out pop up page is not displayed", pom.getLogoutPopup().isDisplayed());
	}
	@When("the user clicks the Log Out button")
	public void the_user_clicks_the_log_out_button() {
	    button(pom.getClickLogoutBtn());
	}
	@Then("the user should be logged out successfully")
	public void the_user_should_be_logged_out_successfully() {
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertFalse("User is not log out from dashbroad page", "https://d38c4xafcjpo0f.cloudfront.net/dashboard".equals(currentUrl));
	}
	@Then("the user should be redirected to the login page")
	public void the_user_should_be_redirected_to_the_login_page() {
	    Assert.assertTrue("User is not redirected to log in page", pom.getLoginPage().isDisplayed());
	    System.out.println("pass");
	}

}
