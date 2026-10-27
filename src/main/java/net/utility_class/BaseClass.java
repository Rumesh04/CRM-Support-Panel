package net.utility_class;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.pageobject.PomClass;

public class BaseClass {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static JavascriptExecutor js;
	protected static Actions A;
	//PomClass pom = new PomClass();
	
	
	public static void browserLaunch() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		js = (JavascriptExecutor)driver;
		
	}
	
	public static void button(WebElement element) {
		element.click();
	}
	
	public static void setText(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public static void setTextWithEnter(WebElement element, String value) {
		element.sendKeys(value, Keys.ENTER);
	}
	
	public static void waitImpletic() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public static void elementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public static void visibleOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void visibleOfAllElement(List<WebElement> element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public static void select(WebElement element, String value) {
		Select S = new Select(element);
		S.selectByVisibleText(value);
	}
	
	public static void iterateWebElement(List<WebElement> list, int size,String option) {
		for(int i=0;i<size;i++) {
			try {
				Thread.sleep(3000);
			}catch (Exception e) {
				e.printStackTrace();
			}
			String text = list.get(i).getText();
			if(text.equalsIgnoreCase(option)) {
				System.out.println("All the Option: "+option);
			}else {
				System.out.println("Correct option is not displayed");
			}
//			System.out.println(list.get(i).getText() + " | ");
//			System.out.println();
			
		}
	}
	
	public static void iterateWebElementTable(List<WebElement> list, int size,String option) {
		for(int i=0;i<size;i++) {
			try {
				Thread.sleep(3000);
			}catch (Exception e) {
				e.printStackTrace();
			}
			String text = list.get(i).getText();
			if(text.equalsIgnoreCase(option)) {
				System.out.println("Displayed table record: "+option);
			}else {
				System.out.println("Correct record is not displayed");
			}
			
		}
	}
	
	public static void scroll(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void hiddenButton(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void switchToWindow(int i) {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		List<String> list = new ArrayList<>();
		driver.switchTo().window(list.get(i));
	}
	
	public static void scrollToElement(WebElement element) {
		A.moveToElement(element).perform();
	}
	
	public String screenShot(WebDriver driver1, String scenario) {
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		String filePath =  System.getProperty("user.dir") + "/screenShot/" + scenario + " - " + timeStamp + ".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(filePath);
		try {
		    FileUtils.copyFile(src, des);
		}catch (Exception e) {
			throw new RuntimeException("SCreenshot not capture");
		}
		return filePath;
		
	}
	
	public void verifyRows() {
	    List<WebElement> rows = driver.findElements(By.xpath("//table[@class='w-full text-sm text-left']/tbody/tr"));
		System.out.println("Total Rows: "+ rows.size());
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='w-full text-sm text-left']/thead/tr/th"));
		System.out.println("Total clos: "+ cols.size());
		
		if(rows.size() == 1) {
			WebElement noData = driver.findElement(By.xpath("//table/tbody/tr/td"));
			String text = noData.getText();
			System.out.println(text);
		}else {
		
		for(int i=1;i<rows.size();i++) {
			List<WebElement> cells = driver.findElements(By.xpath("//table[@class='w-full text-sm text-left']/tbody/tr['+i+']/td"));
			
			for(WebElement cell : cells) {
				System.out.print(cell.getText()+ " | ");
			}
			System.out.println();
		}
		}
		
	}
	
	public String retrieveText(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	public static void iterateWebElementForm(List<WebElement> list, int size) {
		for(int i=0;i<size;i++) {
			try {
				Thread.sleep(3000);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.print(list.get(i).getText() + " | ");
			System.out.println();
			
		}
	}
	
	public String getSummaryCard(String heading) {
		PomClass pom = new PomClass();
		int size = pom.getSummaryCardHeading().size();
		for(int i=0;i<size;i++) {
			String text = pom.getSummaryCardHeading().get(i).getText();
			if(text.equalsIgnoreCase(heading)) {
				return pom.getSummaryCardCount().get(i).getText().trim();
			}
		}
		throw new RuntimeException("Summary card not found: "+heading);
		
	}
	
	public String assigneeOption(String name) {
		PomClass pom = new PomClass();
		int size = pom.getSummaryCardHeading().size();
		for(int i=0;i<size;i++) {
			String text = pom.getSummaryCardHeading().get(i).getText();
			if(text.equalsIgnoreCase(name)) {
				return pom.getSummaryCardCount().get(i).getText().trim();
			}
		}
		throw new RuntimeException("Options not found: "+name);
		
	}
	
//	public void verifyTableCount() {
//		visibleOfAllElement(pom.getTableRowCount());
//		int tableCount = pom.getTableRowCount().size();
//		
//	}
	
	public void selectPriority(String heading) {
		PomClass pom = new PomClass();
		Select S = new Select(pom.getClickEditFormPriority());
		int size = S.getOptions().size();
		for(int i=0;i<size;i++) {
		        String text = S.getOptions().get(i).getText();
			if(text.equalsIgnoreCase(heading)) {
				S.selectByVisibleText(text);
				return;
			}
		}
		throw new RuntimeException("Priority option is not selected: "+heading);
		
	}
	
	public void printTable() {
		PomClass pom = new PomClass();
		int size = pom.getTableDataAllTicket().size();
		for(int i=0;i<size;i++) {
			//String text = pom.getTableDataAllTicket().get(i).getText();
			System.out.print(pom.getTableDataAllTicket().get(i).getText()+ " | ");
			
		}
		System.out.println();
	}
	
	public void selectStatus(String heading) {
		PomClass pom = new PomClass();
		Select S = new Select(pom.getClickEditFormStatus());
		int size = S.getOptions().size();
		for(int i=0;i<size;i++) {
		        String text = S.getOptions().get(i).getText();
			if(text.equalsIgnoreCase(heading)) {
				S.selectByVisibleText(text);
				return;
			}
		}
		throw new RuntimeException("Status option is not selected: "+heading);
	
	}
	
	public void selectCategory(String heading) {
		PomClass pom = new PomClass();
		Select S = new Select(pom.getClickEditFormCategory());
		int size = S.getOptions().size();
		for(int i=0;i<size;i++) {
		        String text = S.getOptions().get(i).getText();
			if(text.equalsIgnoreCase(heading)) {
				S.selectByVisibleText(text);
				return;
			}
		}
		throw new RuntimeException("Status option is not selected: "+heading);
	
	}
}
