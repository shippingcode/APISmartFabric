package com.agys.utils;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public class CredentialsUtils {

	private static final Logger logger = LoggerFactory.getLogger(CredentialsUtils.class);
	private static final Properties properties = loadProperties();

	public static final String IDENTITY = System.getProperty("baseUrl") + ":" + System.getProperty("identityPort");
	public static final String GUI = System.getProperty("baseUrl") + ":" + System.getProperty("guiPort");
	public static final String DOCUMENTS = System.getProperty("baseUrl") + ":" + System.getProperty("documentsPort");
	public static final String CATALOGS = System.getProperty("baseUrl") + ":" + System.getProperty("catalogsPort");
	public static final String ENGINE = System.getProperty("baseUrl") + ":" + System.getProperty("enginePort");




	private static Properties loadProperties() {
		try {
			Properties prop = new Properties();
			prop.load(CredentialsUtils.class.getClassLoader().getResourceAsStream("credentials.properties"));
			return prop;
		} catch (IOException e) {
			logger.error("Error ocured while loading properties {}", e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public static String getProperty(String property) {
		return properties.getProperty(property);
	}
}

