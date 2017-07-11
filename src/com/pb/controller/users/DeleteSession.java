package com.pb.controller.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pb.json.BaseJson;
import com.pb.util.JsonUtil;

@Controller
@RequestMapping("/deleteSession")
public class DeleteSession {

	@RequestMapping(value = "/deleteUsers", method = { RequestMethod.POST })
	@ResponseBody
	public String deleteUsers(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String username = request.getParameter("username");
		request.getSession().removeAttribute("username");
		System.out.println("--------");
		return JsonUtil.getInstance().obj2json(bj);
	}
}
