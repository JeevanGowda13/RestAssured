package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Get_Property implements Framework_Constants{
	public FileInputStream fis;
	@Test
	public String GetProperty(String key)
	{
		try {
			FileInputStream fis= new FileInputStream(property_path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop= new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String key2 = prop.getProperty(key);
		return key2;
	}

}
