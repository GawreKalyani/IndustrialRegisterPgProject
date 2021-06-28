package com.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class RegisterPage extends PageBase {
	
	public RegisterPage(WebDriver driver)       //constructor
	{	super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(tagName="h2")
	private WebElement register; 
	@FindBy(tagName="h1")
	private WebElement heading;
	@FindBy(xpath="//input[@ng-model='FirstName']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@ng-model='LastName']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[contains(@placeholder,'Name')]")
	private List<WebElement>firstLastNmPlaceholders;
	
	@FindBy(xpath="//textarea[@ng-model='Adress']")
	private WebElement address;
	
	@FindBy(xpath="//input[@ng-model='EmailAdress']")
	private WebElement email;
	
	@FindBy(xpath="//input[@ng-model='Phone']")
	private WebElement phone;
	
	@FindBy(xpath="//input[@ng-model='radiovalue']")
	private List<WebElement>genders;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private List<WebElement>hobbiesCheckboxes;
	
	@FindBy(xpath="//select[@ng-model='country']")
	private WebElement country;
	
	@FindBy(xpath="//div[@id='msdd']")
	private WebElement languages;            //not having select class"DropDown" (multiple selection)
	
	@FindBy(xpath = "//ul//li//a[contains(text(),'Hindi')]")
	public WebElement langHindi;
	
	@FindBy(xpath = "//ul//li//a[contains(text(),'English')]")
	public WebElement langEnglish;
	
	@FindBy(xpath = "//div[@class='ui-autocomplete-multiselect-item']")  //complete list
	public List<WebElement> languageSelected;
	
	@FindBy(xpath="//select[@id='country']")
	private WebElement selCountry;   
	
	@FindBy(xpath="//span[@title='India']")
	private WebElement indiaSelCoun;
	
	@FindBy(xpath="//select[@ng-model='Skill']")
	private WebElement skills;
	
	
	@FindBy(xpath="//select[@ng-model='yearbox']")
	private WebElement year;
	@FindBy(xpath="//select[@placeholder='Month']")
	private WebElement month;
	@FindBy(xpath="//select[@placeholder='Day']")
	private WebElement day;
	
	@FindBy(xpath="//select[contains(@ng-model,'box')]")
	private List<WebElement>yearMonthDayPlaceholders;
	
	@FindBy(xpath="//input[@ng-model='Password']")
	private WebElement password;
	@FindBy(xpath="//input[@ng-model='CPassword']")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//button[text()=' Submit ']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//button[text()='Refresh']")
	private WebElement refreshBtn;
	@FindBy(xpath="//button[text()=' Submit ']//preceding::label")
	private List<WebElement>labels;
	@FindBy(tagName="footer")
	private WebElement footer;
	
	public void enterEmail(String text){
		sendkeys(email, text);
	}
	public void enterPassword(String text){
		sendkeys(password, text);
	}
	public void enterConfirmPassword(String text){
		sendkeys(confirmPassword, text);
	}
	public void enterFirstName(String text){
		sendkeys(firstName, text);
	}
	public void enterlastName(String text){
		sendkeys(lastName, text);
	}
	public void enterPhone(String text){
		sendkeys(phone, text);
	}
	public void enterAddress(String text){
		sendkeys(address, text);
	}
	public void checkGender(String text){
		radioButton(text, genders);
	}
	public void checkHobbiesCheckboxes(List<String>strings){
		checkbox(strings, hobbiesCheckboxes);
	}
	public void skillDropDown(String text){
		dropDown(text, skills);
	}
	public void yearDropDown(String text){
		dropDown(text, year);
	}
	public void monthDropDown(String text){
		dropDown(text, month);
	}
	public void dayDropDown(String text){
		dropDown(text, day);
	}
	public void countryDropDown(String text){
		dropDown(text, country);
	}
	public void language(){}
	public void selectCountry(){}
	
	public ArrayList<String> fullNmPlaceholder(){
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:firstLastNmPlaceholders)
		{
			String text=element.getAttribute("placeholder");
			actData.add(text);
		}
		return actData;
	}
	public ArrayList<String> dobPlaceholder(){
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:yearMonthDayPlaceholders)
		{
			String text=element.getAttribute("placeholder");
			actData.add(text);
		}
		return actData;
	}
	public boolean getAllHobbies(){
		ArrayList<String>actData=new ArrayList<String>();
		String []arr={"Cricket","Movies","Hockey"};
		List<String>expData=Arrays.asList(arr);

		for(WebElement e:hobbiesCheckboxes)
		{
			String text=e.getAttribute("value");
			actData.add(text);
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
		
	}
	
	public boolean getFooterText(){
		String exp="\"@ 2016\"Automation Testing\"All Rights Reserved.\"";
		String act=getText(footer);
		if(act.equals(exp))
			return true;
		else
			return false;
	}
	public boolean getHeadingText(){
		String exp="Automation Demo Site";
		String act=getText(heading);
	
		if(act.equals(exp))
			return true;
		else
			return false;
	}
	public boolean getSubHeadingText() {
		String exp="Register";
		String act=getText(register);
		if(act.equals(exp))
			return true;
		else
		return false;
	}
	public boolean getTitleOfRegPg() {
		String exp="Register";
		String act=getTitle(driver);
		if(act.equals(exp))
			return true;
		else
			return false;
	}
	public boolean getLabels() throws Exception {
		ArrayList<String>expData=getColumnData("Test.xlsx", "labels", 0);
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement label:labels){
			actData.add(label.getText());
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}
	public boolean getListOfSkills()throws Exception {
		ArrayList<String>expData=getColumnData("Test.xlsx", "skills", 0);
		ArrayList<String>actData=getOptionsOfDropDown(skills);
		if(actData.equals(expData))
			return true;
		else
			return false;
	}
	public boolean getListOfCountries()throws Exception {
		ArrayList<String>expData=getColumnData("Test.xlsx", "country", 0);
		ArrayList<String>actData=getOptionsOfDropDown(country);
		if(actData.equals(expData))
			return true;
		else
			return false;
	}
	public boolean getListOfYear() throws Exception {
		ArrayList<String>expData=getColumnData("Test.xlsx", "year", 0);
		ArrayList<String>actData=getOptionsOfDropDown(year);
		if(actData.equals(expData))
			return true;
		else
		return false;
	}
	public boolean getListOfMonth() throws Exception {
		ArrayList<String>expData=getColumnData("Test.xlsx", "month", 0);
		ArrayList<String>actData=getOptionsOfDropDown(month);
		if(actData.equals(expData))
			return true;
		else
		return false;
	}
	public boolean getListOfDay() throws Exception {
		ArrayList<String>expData=getColumnData("Test.xlsx", "day", 0);
		ArrayList<String>actData=getOptionsOfDropDown(day);
		if(actData.equals(expData))
			return true;
		else
		return false;
	}
	public boolean getNoOfSelectCoutry(){
		
		int act=getSizeOfDropDownList(selCountry);
		int exp=11;
		if(act==exp)
			return true;
		else
		return false;	
	}
	public boolean getNoOfCoutries() {
		int act=getSizeOfDropDownList(country);
		int exp=251;
		if(act==exp)
			return true;
		else
		return false;
	}
	public boolean getNoYears() {
		int act=getSizeOfDropDownList(year);
		
		int exp=101;
		if(act==exp)
			return true;
		else
		return false;
	}
	public boolean getNoMonths() {
		int act=getSizeOfDropDownList(month);
		int exp=13;
		if(act==exp)
			return true;
		else
		return false;
	}
	public boolean getNoDays() {
		int act=getSizeOfDropDownList(day);
		int exp=32;
		if(act==exp)
			return true;
		else
		return false;
	}
	public boolean verifyOneSelectCountry() throws Exception
	{	dropDown("India", selCountry);
		
		Thread.sleep(3000);
		
		String actualSelectedCountry = indiaSelCoun.getText();
		//System.out.println(actualSelectedCountry);
		TestBase.log.info(actualSelectedCountry);
		
		String expSelectedCountry = "India" ;
		TestBase.log.info(expSelectedCountry);
		
		if(actualSelectedCountry.equals(expSelectedCountry))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean getSelectedLanguages() throws Exception
	{
		click(languages);  //textbox
		Thread.sleep(5000);
		click(langHindi);
		Thread.sleep(5000);
		click(langEnglish);
		Thread.sleep(5000);
		
		ArrayList<String> actlangSelected = new ArrayList <String> ();
		for(WebElement element : languageSelected)
		{
			actlangSelected.add(element.getText());
		}
		TestBase.log.info(actlangSelected);
		
		ArrayList<String> explangSelected = new ArrayList <String> ();
		explangSelected.add("Hindi");
		explangSelected.add("English");
		TestBase.log.info(explangSelected);

		if(actlangSelected.equals(explangSelected))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
