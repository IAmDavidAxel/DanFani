package server;

import utility.datamanager.ApplicationConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyConfiguration {

	private String fileName;
	private Properties properties = null;
	private InputStream inputStream;

	public PropertyConfiguration(String propertiesFileName){
		fileName = propertiesFileName;
		inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
	}

	public void initialize(){
		properties = new Properties();
	}

	public void apply(){
		if ((properties != null)){
			try{
				properties.load(inputStream);
			}catch (IOException e){
				Logger.getGlobal().log(Level.SEVERE,"Can't load properties file");
			}
		}

		ApplicationConfiguration.mode = properties.getProperty("app.mode");
		ApplicationConfiguration.serverPort = Integer.parseInt(properties
		.getProperty("app.server.port"));

		ApplicationConfiguration.tokenExpirationPolicyFromProperties = properties.getProperty("app.system.token.expiration.policy");

		ApplicationConfiguration.tokenLength = Integer.parseInt(properties.getProperty("user.token.length"));

		ApplicationConfiguration.passwordPolicyMode = properties.getProperty("app.system.token.password.policy");


	}
}
