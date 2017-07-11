package com.pb.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pb.controller.BaseController;
import com.pb.entity.Item;
import com.pb.json.BaseJson;
import com.pb.util.JsonUtil;

@Controller
@RequestMapping("/admin")
public class Admin extends BaseController {

	@RequestMapping(value = "/getAllItem", method = { RequestMethod.POST })
	@ResponseBody
	public String getAllItem(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String usertype = userRelatedService.getUserType((String) request
				.getSession().getAttribute("username"));
		if (!usertype.equals("admin")) {
			bj.setErrorMsg("您不是管理员！");
			bj.setRetcode("0001");
			return JsonUtil.getInstance().obj2json(bj);
		}
		List<Item> list = adminService.getAllItem();
		bj.setObj(list);
		bj.setRetcode("0000");
		return JsonUtil.getInstance().obj2json(bj);
	}
	
	@RequestMapping(value = "/getItem", method = { RequestMethod.POST })
	@ResponseBody
	public String getItem(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String usertype = userRelatedService.getUserType((String) request
				.getSession().getAttribute("username"));
		if (!usertype.equals("admin")) {
			bj.setErrorMsg("您不是管理员！");
			bj.setRetcode("0001");
			return JsonUtil.getInstance().obj2json(bj);
		}
		String itemID = request.getParameter("itemID");
		List<Item> list = adminService.getItem(itemID);
		bj.setObj(list);
		bj.setRetcode("0000");
		return JsonUtil.getInstance().obj2json(bj);
	}
	
	@RequestMapping(value = "/modifyItem", method = { RequestMethod.POST })
	@ResponseBody
	public String modifyItem(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String usertype = userRelatedService.getUserType((String) request
				.getSession().getAttribute("username"));
		if (!usertype.equals("admin")) {
			bj.setErrorMsg("您不是管理员！");
			bj.setRetcode("0001");
			return JsonUtil.getInstance().obj2json(bj);
		}
		String itemID = request.getParameter("itemID");
		String coverImage = request.getParameter("coverImage");
		String itemName = request.getParameter("itemName");
		String itemDetail = request.getParameter("itemDetail");
		String size = request.getParameter("size");
		String part = request.getParameter("part");
		String price = request.getParameter("price");
		
		List<Item> list = adminService.modifyItem(itemID, coverImage, itemName, itemDetail, size, part, price);
		bj.setObj(list);
		bj.setRetcode("0000");
		return JsonUtil.getInstance().obj2json(bj);
	}
	
	@RequestMapping(value = "/addItem", method = { RequestMethod.POST })
	@ResponseBody
	public String addItem(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String usertype = userRelatedService.getUserType((String) request
				.getSession().getAttribute("username"));
		if (!usertype.equals("admin")) {
			bj.setErrorMsg("您不是管理员！");
			bj.setRetcode("0001");
			return JsonUtil.getInstance().obj2json(bj);
		}
		String itemID = request.getParameter("itemID");
		String coverImage = request.getParameter("coverImage");
		String itemName = request.getParameter("itemName");
		String itemDetail = request.getParameter("itemDetail");
		String size = request.getParameter("size");
		String part = request.getParameter("part");
		String price = request.getParameter("price");
		
		List<Item> list = adminService.addItem(itemID, coverImage, itemName, itemDetail, size, part, price);
		if(list.size()==0){
			bj.setErrorMsg("ID重复");
			bj.setRetcode("0001");
			return JsonUtil.getInstance().obj2json(bj);
		}
		bj.setObj(list);
		bj.setRetcode("0000");
		return JsonUtil.getInstance().obj2json(bj);
	}
	
	@RequestMapping(value = "/deleteItem", method = { RequestMethod.POST })
	@ResponseBody
	public String deleteItem(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String usertype = userRelatedService.getUserType((String) request
				.getSession().getAttribute("username"));
		if (!usertype.equals("admin")) {
			bj.setErrorMsg("您不是管理员！");
			bj.setRetcode("0001");
			return JsonUtil.getInstance().obj2json(bj);
		}
		String itemID = request.getParameter("itemID");
		List<Item> list = adminService.deleteItem(itemID);
		if(list.size()==0){
			bj.setErrorMsg("删除失败");
			bj.setRetcode("0001");
			return JsonUtil.getInstance().obj2json(bj);
		}
		bj.setObj(list);
		bj.setRetcode("0000");
		return JsonUtil.getInstance().obj2json(bj);
	}
}
