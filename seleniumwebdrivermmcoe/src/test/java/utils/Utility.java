package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	public static WebDriver driver;
	public static String getDataFromExcel(String xlfile,String xlsheet,int rownum,int colmun) throws IOException {

		
      fi=new FileInputStream(xlfile);
	  wb= new XSSFWorkbook(fi);
	  ws=wb.getSheet(xlsheet);
	  row=ws.getRow(rownum);
	  cell=row.getCell(colmun);

       String data;
	  
	  try {
		  data=cell.toString();
	  }
	  
	  catch(Exception e) {
		  
		  data="";
	  }


	   wb.close();
	   fi.close();
	   return data;

	}

	/*public static void captureScreenShot(String fileName) {
        TakesScreenshot t = (TakesScreenshot) driver;   
        File src = t.getScreenshotAs(OutputType.FILE);
        File dest = new File("E:\\ScreenShot\\" + fileName + ".png");  
        try {
            FileHandler.copy(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
	
	
	public static void captureScreenShot(String fileName) throws IOException {
		
		TakesScreenshot t = (TakesScreenshot) driver;   
		File src = t.getScreenshotAs(OutputType.FILE);
		//File dest = new File("E:\\ScreenShot\\Test.png");
		File dest = new File("./ScreenShot\\" + fileName + ".png");   
		FileHandler.copy(src, dest);
		
		try {
	        FileHandler.copy(src, dest);
	    } 
		
		catch (IOException e)
		{
	        e.printStackTrace();
	    }
	}
	
}
