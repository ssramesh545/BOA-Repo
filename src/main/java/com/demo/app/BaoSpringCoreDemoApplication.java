package com.demo.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.boa.model.CustomerModel;
import com.boa.service.Customer;

@SpringBootApplication
@ComponentScan("com")
public class BaoSpringCoreDemoApplication {

	public static void main(String[] args) {
		
		List<CustomerModel> cust = Arrays.asList(new CustomerModel(102,"ABC","LOC2"),new CustomerModel(102, "BCD", "LOC3"));
		ApplicationContext context = SpringApplication.run(BaoSpringCoreDemoApplication.class, args);
		Customer c = (Customer) context.getBean("getCustomerImpl");
		c.fetch(cust);
		//System.out.println("My First Spring Boot APP ->");
		
		
	}
	
	/*
	 package com.boa.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.boa.config.AppConfig;
import com.boa.config.CentralizedConfig;
import com.boa.model.CustomerModel;
import com.boa.service.CustomerService;
import com.boa.service.CustomerServiceImpl;
import com.boa.service.HelloWorld;

@SpringBootApplication
public class BoaSpringCoreDemoApplication {

	public static void main(String[] args) {
		// We need configure the Application Conrtext here for look up the App file 
		 // spring XML and others
		//SpringApplication.run(CoreSpringBoaApplication.class, args);
		//System.out.println("my first Spring 5 App Up with setup");
		
		// look using the Application Context bean look up 
		
		ApplicationContext context=SpringApplication.run(CentralizedConfig.class);
		
        // look up to bean classs 
       
		 HelloWorld lookup=(HelloWorld) context.getBean("helloBean");
		 
		 
      
		 System.out.println(lookup.printDetails("BOA Training"));
		 System.out.println("--------------->");
		 
		 CustomerService customerService = (CustomerService) context.getBean("customerBean");
		 CustomerModel customer1 = new CustomerModel(1, "Rama","Delhi");
			CustomerModel customer2 = new CustomerModel(2, "Radhika","Chennai" );
			
			
	 
			customerService.createCustomer(customer1);
			customerService.createCustomer(customer2);
			System.out.println("AllCustomer :");
			customerService.listAllCustomers();
		 
	}
    
    
}
------------------------------
CentralizedConfig

package com.boa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppConfig.class, CustomerConfig.class})
	

public class CentralizedConfig {
	

}
------------------------
 CustomerConfig   
package com.boa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boa.service.CustomerService;
import com.boa.service.CustomerServiceImpl;


@Configuration
public class CustomerConfig {
	@Bean(name= "customerBean")
public  CustomerService customerServiceImpl() {
		return new CustomerServiceImpl();
	}
	
	
}

    
-----------------------------
CustomerModel

    package com.boa.model;

public class CustomerModel {
	
	private int customerID;
	private String customerName;
	private String customerAddress;
	public CustomerModel(int customerID, String customerName, String customerAddress) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		// TODO Auto-generated constructor stub
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	@Override
	public String toString() {
		return "CustomerModel{" + "CustomerID=" + customerID + ",customerName=" +customerName + '\'' +'}'; 
		
	}
	

}


-------------------------
CustomerService
 
  package com.boa.service;

import java.util.Optional;

import com.boa.model.CustomerModel;

public interface CustomerService {

	void createCustomer(CustomerModel customer);
	Optional<CustomerModel> getCustomerById(int customerId);
	Optional<CustomerModel>getCustomerByName(String customerName);
	Optional<CustomerModel>getCustomerbyAddress(String customerAddress);
	
	void updateCustomer(CustomerModel customer);
	void deleteCustomer(int customerId);
	void listAllCustomers();
	
	
}
  
----------------------------
    
    
 CustomerServiceImpl
package com.boa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.boa.model.CustomerModel;

public class CustomerServiceImpl implements CustomerService{
	private List<CustomerModel> customers = new ArrayList<>();

	@Override
	public void createCustomer(CustomerModel customer) {
	customers.add(customer);
		
	}

	@Override
	public Optional<CustomerModel> getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customers.stream().filter(c->c.getCustomerID()== customerId).findFirst();
	}
	@Override
	public Optional<CustomerModel> getCustomerByName(String customerName) {
		// TODO Auto-generated method stub
		 return customers.stream().filter(c->c.getCustomerName() == customerName).findFirst();
	}

	@Override
	public Optional<CustomerModel> getCustomerbyAddress(String customerAddress) {
		// TODO Auto-generated method stub
		return customers.stream().filter(c->c.getCustomerAddress()== customerAddress).findFirst();
	}

	@Override
	public void updateCustomer(CustomerModel customer) {
		getCustomerById(customer.getCustomerID()).ifPresent(c->{c.setCustomerName(customer.getCustomerName());
		});
	}
    
	
	@Override
	public void deleteCustomer(int customerId) {
		customers.removeIf(c->c.getCustomerID()==customerId);
		
	}
	
	@Override
	public void listAllCustomers()
	{
		customers.forEach(System.out::println);
	}


	

}




	*/

}
