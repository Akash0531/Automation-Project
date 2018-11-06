package com.dikshatech.tst.utilitylibrary;

public class Autoit {

	public  static void File_upload(String filepath) throws Exception
	{
		System.out.println("Browsing the specified file");
		Runtime.getRuntime().exec(filepath);
	    System.out.println("File has been uploaded");
	}
	
}