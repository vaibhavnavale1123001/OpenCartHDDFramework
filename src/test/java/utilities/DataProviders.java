package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider 1

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String path = ".\\testData\\Opencart_LoginData.xlsx";// taking xl file from testData

		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for XLUtility

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 0);

		String logindata[][] = new String[totalrows][totalcols];// created for two dimension array which can store the
																// data user and password

		System.out.println("totalrows : " + totalrows);
		System.out.println("totalcols : " + totalcols);

		for (int i = 1; i <= totalrows; i++) // 1 //read the data from xl storing in two deminsional array
		{
			for (int j = 0; j < totalcols; j++) // 0 i is rows j is col
			{
				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
			}
		}

		return logindata;// returning two dimension array

//		String path = ".\\testData\\Opencart_LoginData.xlsx";// taking xl file from testData
//
//		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for XLUtility
//
//		int rowCount = xlutil.getRowCount("Sheet1");
//		int colCount = xlutil.getCellCount("Sheet1", 1);
//
//		String logindata[][] = new String[rowCount][colCount];
//
//		for (int i = 1; i <= rowCount; i++) {
//			for (int j = 0; j < colCount; j++) {
//				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
//			}
//		}
//		for (int i = 0; i < logindata.length; i++) // 1 //read the data from xl storing in two deminsional array
//		{
//			for (int j = 0; j < logindata[i].length; j++) // 0 i is rows j is col
//			{
//				System.out.println(logindata[i][j]);
//			}
//
//			System.out.println();
//		}

		// String logindata[][] = { { "TestAuto1002@gmail.com", "Test@123", "Valid" },
		// { "TestAuto1003@gmail.com", "Test@123", "Valid" } };
		// return logindata;
	}

}
