package com.pb.controller.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pb.controller.BaseController;
import com.pb.entity.Customer;
import com.pb.json.BaseJson;
import com.pb.util.JsonUtil;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
	@RequestMapping(value = "/getCustomers", method = { RequestMethod.GET })
	@ResponseBody
	public String getCustomers(HttpServletRequest request,
			HttpServletResponse response){
		
		BaseJson bj = new BaseJson();
		List<Customer> list = testService.getUsers();
		System.out.println(list);
		bj.setObj(list);
		System.out.println(JsonUtil.getInstance().obj2json(bj));
		return JsonUtil.getInstance().obj2json(bj);
	}
}
