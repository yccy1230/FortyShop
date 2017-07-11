package com.pb.controller.users;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pb.controller.BaseController;
import com.pb.json.BaseJson;
import com.pb.util.JsonUtil;

@Controller
@RequestMapping("/users")
public class Users extends BaseController {

	@RequestMapping(value = "/isVaild", method = { RequestMethod.POST })
	@ResponseBody
	public String isVaild(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<com.pb.entity.Users> list = userRelatedService.isUserValid(
				username, password);
		String session = (String) request.getSession().getAttribute("username");

		if (session == null) {
			if (list.size() > 0) {
				request.getSession().setAttribute("username", username);
				bj.setRetcode("0000");
				bj.setObj(list.get(0));

			} else {
				bj.setRetcode("0001");
				bj.setErrorMsg("用户名或密码错误！");
			}
		} else if (session.equals(username) && list.size() > 0) {
			String usertype = userRelatedService.getUserType(username);
			bj.setRetcode("0002");
			bj.setErrorMsg("您已成功登陆，无需再次登录！");
			bj.setObj(usertype);
		} else {
			bj.setRetcode("0001");
			bj.setErrorMsg("用户名或密码错误！");
		}

		return JsonUtil.getInstance().obj2json(bj);
	}

	@RequestMapping(value = "/registe", method = { RequestMethod.POST })
	@ResponseBody
	public String registe(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String profile = request.getParameter("profile");
		boolean result = userRelatedService.registeUser(username, password,
				gender, profile);
		if (result == true) {
			request.getSession().setAttribute("username", username);
			bj.setRetcode("0000");
			bj.setObj(username);
		} else {
			bj.setRetcode("0001");
			bj.setErrorMsg("用户名已经存在了呢，换一个试试吧。");
		}

		return JsonUtil.getInstance().obj2json(bj);
	}

	@RequestMapping(value = "/deleteUsers", method = { RequestMethod.POST })
	@ResponseBody
	public String deleteUsers(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String username = request.getParameter("username");
		request.getSession().removeAttribute(username);
		System.out.println("remove a session");
		return JsonUtil.getInstance().obj2json(bj);
	}

	@RequestMapping(value = "/getCurrentUser", method = { RequestMethod.POST })
	@ResponseBody
	public String getCurrentUser(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String username = (String) request.getSession()
				.getAttribute("username");
		bj.setObj(username);
		return JsonUtil.getInstance().obj2json(bj);
	}
	
	@RequestMapping(value = "/getCurrentUserType", method = { RequestMethod.POST })
	@ResponseBody
	public String getCurrentUserType(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String usertype = userRelatedService.getUserType((String) request.getSession().getAttribute("username"));
		bj.setObj(usertype);
		return JsonUtil.getInstance().obj2json(bj);
	}
}
