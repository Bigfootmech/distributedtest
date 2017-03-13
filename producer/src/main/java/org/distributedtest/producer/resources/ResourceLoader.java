package org.distributedtest.producer.resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceLoader {
	
	private static final String RESOURCE_FILE = "application.properties";
	private static final String DESTINATION = "destination_url";

	private static final Properties PROP = new Properties();
	
	private static ResourceLoader instance;
	
	public ResourceLoader() {
		loadAppProperties();
	}
	
	private static void loadAppProperties(){
		try {
			InputStream inStream = ResourceLoader.class.getClassLoader().getResourceAsStream(RESOURCE_FILE);
			
			if(inStream != null){
				PROP.load(inStream);
			} else {
					throw new FileNotFoundException("Property file '" + RESOURCE_FILE + "' not found in classpath.");
			}
		} catch (IOException e) {
			throw new RuntimeException("Could not instantiate properties file", e);
		}
	}
	
	public static ResourceLoader getInstance() {
		if(instance == null){
			instance = new ResourceLoader();
		}
		
		return instance;
	}
	
	public String getPostRequestDestination(){
		return PROP.getProperty(DESTINATION);
	}
}
