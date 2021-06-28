package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class PageBase {
	public  WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver=driver;
	}

	public void checkbox(List<String> strings, List<WebElement> elements) {
		for (String string : strings) {
			for (WebElement element : elements) {
				if (element.getAttribute("value").equals(string)) {
					element.click();
					break;
				}
			}
		}
	}

	public void radioButton(String text, List<WebElement> elements) {

		for (WebElement ele : elements) {
			if (ele.getAttribute("value").equals(text)) {
				ele.click();
				break;
			}
		}
	}

	public void dropDown(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void mutiselectDropDown(List<String> options, WebElement ele) {
		Select s = new Select(ele);
		if (s.isMultiple()) {
			for (String option : options)
				s.selectByVisibleText(option);
		}
	}

	public void sendkeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public void robotActions(int key) throws AWTException{
		Robot robot=new Robot();
		robot.keyPress(key);
	}

	public void click(WebElement element) {
		element.click();
	}
	public String getText(WebElement element){
		return element.getText();
	}
	public String getTitle(WebDriver driver){
		return driver.getTitle();
	}
	public ArrayList<String> getOptionsOfDropDown(WebElement element){
		ArrayList<String>actData=new ArrayList<String>();
		Select select=new Select(element);
		List<WebElement>options=select.getOptions();
		for(WebElement option:options){
			String text=option.getText();
			actData.add(text);
		}
		return actData;
	}
	public int getSizeOfDropDownList(WebElement element){
		Select select=new Select(element);
		List<WebElement>options=select.getOptions();
		return options.size();
	}
	public  ArrayList<String> getColumnData(String fileNm,String sheetNm,int colNo)throws Exception{
		ArrayList<String> expData=new ArrayList<String>();
		String value=null;
		String path=System.getProperty("user.dir")+"/src/test/resources/"+fileNm;
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetNm);
		int row=sh.getPhysicalNumberOfRows();
		for (int i = 0; i < row; i++) 
		{
			Cell cell=sh.getRow(i).getCell(colNo);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				expData.add(value);
				//System.out.println(value);
		}
		return expData;
	}
}
