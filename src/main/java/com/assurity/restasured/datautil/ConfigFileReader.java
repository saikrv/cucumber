package com.assurity.restasured.datautil;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Data parsing from json files
 * 
 * @author Reddi
 *
 */
public class ConfigFileReader {
	/* Set the Configuration setUp path */
	File src;
	FileInputStream fis;
	Properties prop;

	/**
	 * Method for Loading property file
	 * 
	 * @param configFileName
	 * @throws Exception
	 */
	public void loadPropertyFile(String configFileName) throws Exception {
		src = new File(
				System.getProperty("user.dir") + File.separator + "src" + File.separator + File.separator + "test"
						+ File.separator + "resources" + File.separator + "testData" + File.separator + configFileName);
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
	}

	/**
	 * Method for Get the key value
	 * 
	 * @param propKey
	 * @return
	 */
	public String getProperty(String propKey) {
		return prop.getProperty(propKey);
	}
}
