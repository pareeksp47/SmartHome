/**
 * 
 */
package com.exchange.isep.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author SAURABH
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
//@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.exchange.isep.controller", "com.exchange.isep.repository"})
public class Application  extends SpringBootServletInitializer{
	
	
	  @Override 
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) { return
	  application.sources(Application.class); }
	 

	    public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    } 

}
