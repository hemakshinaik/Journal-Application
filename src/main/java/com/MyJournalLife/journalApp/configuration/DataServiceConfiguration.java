package com.MyJournalLife.journalApp.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//Suppose there are some complex config we have to do configure them for each service class and env
//some of its values are username & password
//journal-config.username
//journal-config.password

//Define property values in application.properties, 
//application-dev.properties and application-prod.properties

//In application.properties, spring-profiles-active = dev/prod 
//will decide which property file to pick

//1. Create a Controller to implement
//2. Create a @ConfigurationProperties(prefix) and declare the config properties here. also make it a component
//3. define the config values in application-dev.properties file (dev specific)


//since its a component (managed by spring), we dont need its constructor. 
//to create its instance, wherever we need it, we will just use @Autowired while creating the instance. 
@ConfigurationProperties(prefix = "journal-config")
@Component
public class DataServiceConfiguration {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
