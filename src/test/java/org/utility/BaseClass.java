package org.utility;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		public static  WebDriver driver;
		public static  JavascriptExecutor js;
		public static TakesScreenshot ts;
		public static Actions a;
		
		public static void launchBrowser() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
	public static void maxi() {
		driver.manage().window().maximize();
	}
	public static void launchUrl(String url) {
		driver.get(url);
	}
	public static void passtext(WebElement ele,String name) {
		ele.sendKeys(name);
	}
	public static void btnclick(WebElement ele) {
		ele.click();
	}
	public static void closeTheBrowser() {
		driver.quit();
	}
	public static void getText(WebElement ele) {
		String text = ele.getText();
		System.out.println(text);
	}
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public static void sendKeys(String name,WebElement ele) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttributes('value','name')",ele);
	}

	public static void scroll(boolean b,WebElement ele) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true/false)", ele);
	}

	public static void retrText(WebElement ele) {
		js=(JavascriptExecutor)driver;
		js.executeScript("return arguments[0].getAttribute('value')", ele);
	}

	public static void jsclick(WebElement ele) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",ele);
	}

	public static void screenShot(String path) throws IOException {

		ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File f=new File(path);
		FileUtils.copyFile(source, f);
	}

	public static void Moveele(WebElement ele) {
		a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	public static void dragdrop(WebElement s, WebElement t) {
		a=new Actions(driver);
		a.dragAndDrop(s, t).perform();;
		
	}
	public static void rightClick(WebElement ele) {
		a=new Actions(driver);
		a.contextClick(ele).perform();;
		}

	public static void doubleclk(WebElement ele) {
		a=new Actions(driver);
		a.doubleClick(ele).perform();;
	}

	public static void kUp(WebElement ele, String key) {
		a=new Actions(driver);
		a.keyUp(ele, key).perform();;
	}
	public static void kDown(WebElement ele,String key) {
		a=new Actions(driver);
		a.keyDown(ele, key).perform();
	}
	public static String excelRead(String sheetName, int rowNo, int cellNo) throws IOException {
		
		File f=new File("C:\\Users\\My Note Book\\Desktop\\Selenium\\RedbusSample\\Excel\\RBSignin.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet pSheet= w.getSheet(sheetName);
		
		Row r=pSheet.getRow(rowNo);
		Cell c=r.getCell(cellNo);
		int cellType=c.getCellType();
		
			String value=" ";
			if(cellType==1) {
				value=c.getStringCellValue();
					System.out.println(value);
				}
				else if(DateUtil.isCellDateFormatted(c)) {
					Date dd=c.getDateCellValue();
							
				SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
				value=s.format(dd);
				
				}
				else {
					double n=c.getNumericCellValue();
					long l=(long)n;
					value=String.valueOf(l);
					System.out.println(value);
				}
			return value;
				
			}
	public static void CreateExcelSheet(String sheetName, int rowNo, int cellNo, String newData) throws IOException {
		
		File f=new File("C:\\Users\\My Note Book\\Desktop\\Selenium\\MavenProject1\\Excel\\NewFile.xlsx");
		//Create the Workbook
		Workbook w=new XSSFWorkbook();
		//Create Sheet
		Sheet newSheet = w.createSheet(sheetName);
		//Create Row
		Row newRow=newSheet.createRow(rowNo);
		//Create Cell
		Cell newCell=newRow.createCell(cellNo);
		//Set the data
		newCell.setCellValue(newData);
		//Write the data
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
		//System.out.println("Written");

	}
	public static void CreateRow(String sheetName, int rowNo, int cellNo, String newData) throws IOException {
		
		File f=new File("C:\\Users\\My Note Book\\Desktop\\Selenium\\MavenProject1\\Excel\\NewFile.xlsx");
		FileInputStream fis=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(fis);
		Sheet getSheet=w.getSheet(sheetName);
		Row newRow = getSheet.createRow(rowNo);
		Cell newCell = newRow.createCell(cellNo);
		
		newCell.setCellValue(newData);
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
		//System.out.println("written");
	}
	public static void CreateCell(String sheetName, int rowNo, int cellNo, String newData) throws IOException {
		
		File f=new File("C:\\Users\\My Note Book\\Desktop\\Selenium\\MavenProject1\\Excel\\NewFile.xlsx");
		FileInputStream fis= new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(fis);
		Sheet getSheet = w.getSheet(sheetName);
		Row getRow = getSheet.getRow(rowNo);
		Cell newCell = getRow.createCell(cellNo);
		
		newCell.setCellValue(newData);
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
		//System.out.println("written");
		}

	}









