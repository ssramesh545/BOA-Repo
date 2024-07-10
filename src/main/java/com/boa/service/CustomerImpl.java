package com.boa.service;

import java.util.List;

import com.boa.model.CustomerModel;

public class CustomerImpl implements Customer{

	@Override
	public void fetch(List<CustomerModel> c) {
		
		c.forEach(s-> System.out.println(s));
		
	}

}
