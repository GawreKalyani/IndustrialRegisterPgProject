package com.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.RegisterPage;

public class RegisterTest extends TestBase {
	RegisterPage rp=null;
	
		@BeforeMethod
		public void openBrowser(){
			try {
				driver=initialization();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			rp=new RegisterPage(driver);
		}
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
		@Test(priority=1)
		public void verifyFirstAndLastNamePlaceholder(){
				ArrayList<String>exp=new ArrayList<String>();
				exp.add("First Name");
				exp.add("Last Name");
		
				Assert.assertEquals(rp.fullNmPlaceholder(), exp);
		}
		@Test(priority=2)
		public void verifyDateOfBirthPlaceholder(){
				String []arr={"Year","Month","Day"};
				List<String>exp=Arrays.asList(arr);
				Assert.assertEquals(rp.dobPlaceholder(), exp);
		}
		@Test(priority=3)
		public void verifyListOfHobbies(){
			Assert.assertTrue(rp.getAllHobbies());
		}
		@Test(priority=4)
		public void verifyFooterText(){
			Assert.assertTrue(rp.getFooterText());
		}
		@Test(priority=5)
		public void verifyHeading(){
			Assert.assertTrue(rp.getHeadingText());
		}
		@Test(priority=6)
		public void verifySubHeading(){
			Assert.assertTrue(rp.getSubHeadingText());
		}
		@Test(priority=7)
		public void verifyTitleOfRegPg(){
			Assert.assertTrue(rp.getTitleOfRegPg());
		}
		@Test(priority=8)
		public void verifyLabelsOfRegPg() throws Exception{
			Assert.assertTrue(rp.getLabels());
		}
		@Test(priority=9)
		public void verifyListOfSkills()throws Exception{
			Assert.assertTrue(rp.getListOfSkills());
		}
		@Test(priority=10)
		public void verifyListOfCountries()throws Exception{
			Assert.assertTrue(rp.getListOfCountries());
		}
		@Test(priority=11)
		public void verifyListOfYear()throws Exception{
			Assert.assertTrue(rp.getListOfYear());
		}
		@Test(priority=12)
		public void verifyListOfMonth()throws Exception{
			Assert.assertTrue(rp.getListOfMonth());
		}
		@Test(priority=13)
		public void verifyListOfDay()throws Exception{
			Assert.assertTrue(rp.getListOfDay());
		}
		@Test(priority=14)
		public void verifyNoOfSelectCountries(){
			Assert.assertTrue(rp.getNoOfSelectCoutry());
		}
		@Test(priority=15)
		public void verifyNoOfCountries(){
			Assert.assertTrue(rp.getNoOfCoutries());
		}
		@Test(priority=16)
		public void verifyNoOfYears(){
			Assert.assertTrue(rp.getNoYears());
		}
		@Test(priority=17)
		public void verifyNoOfMonths(){
			Assert.assertTrue(rp.getNoMonths());
		}
		@Test(priority=18)
		public void verifyNoOfDays(){
			Assert.assertTrue(rp.getNoDays());
		}
		@Test(priority=19)
		public void verifyOneOfSelectCountry()throws Exception{     //say India
			Assert.assertTrue(rp.verifyOneSelectCountry());
		}
		@Test(priority=20)
		public void verifylanguagesSelected() throws Exception{
			Assert.assertTrue(rp.getSelectedLanguages());
		}
}
