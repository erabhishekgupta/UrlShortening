package com.assignment.newsbyte;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class UrlShorteningApplication {
	  @Autowired
	  private Environment env;
	public static void main(String[] args) {
		
		 
		SpringApplication.run(UrlShorteningApplication.class, args);
	}
	 //to get the active log profile
	 @EventListener(ApplicationReadyEvent.class)
	    public void logActiveProfiles() {
	        String[] activeProfiles = env.getActiveProfiles();
	        System.out.println("Active Profiles: " + String.join(", ", activeProfiles));
	    }

}
