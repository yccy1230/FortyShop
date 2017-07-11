package com.pb.services.testService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pb.entity.Customer;
import com.pb.services.common.CommService;

@Service(value = "testService")
public class TestService extends CommService {
	
	public List<Customer> getUsers(){
		List<Customer> result = baseDAO.findByHQL("from Customer cus");
		return result;
	}
}
