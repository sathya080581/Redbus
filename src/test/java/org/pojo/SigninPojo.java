package org.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class SigninPojo extends BaseClass{

	public void SigninPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({
		@FindBy(id="select_box_sign"),
		@FindBy(xpath="//div[@class='fr config-div']")
	})
	private WebElement btntxt;
	
	@FindAll({
		@FindBy(id="signInLink"),
		@FindBy(xpath="//li[@class='config-options ']"),
		@FindBy(xpath="//li[text()='Sign In/Sign Up']")
	})
	private WebElement stxt;
	
	@FindAll({
		@FindBy(id="id='mobileNoInp"),	
		@FindBy(xpath="//input[@type='number']"),
		@FindBy(xpath="//input[@class='IP']"),
		@FindBy(xpath="//input[@placeholder='Enter your mobile number']")
		})
	private WebElement signTxt;
	
	public WebElement getSignTxt() {
		return signTxt;
	}

	public WebElement getBtntxt() {
		return btntxt;
	}

	public WebElement getStxt() {
		return stxt;
	}
	
	
}
