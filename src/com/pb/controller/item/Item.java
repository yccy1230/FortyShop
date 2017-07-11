package com.pb.controller.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pb.controller.BaseController;
import com.pb.entity.Cart;
import com.pb.json.BaseJson;
import com.pb.util.JsonUtil;

@Controller
@RequestMapping("/item")
public class Item extends BaseController {

	@RequestMapping(value = "/addItem", method = { RequestMethod.POST })
	@ResponseBody
	public String addItem(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();

		String username = (String) request.getSession()
				.getAttribute("username");
		String itemID = request.getParameter("itemID");
		String number = "1";
		List<Cart> cart = itemService.addItem2Cart(username, itemID, number);
		bj.setObj(cart);
		bj.setRetcode("0000");
		return JsonUtil.getInstance().obj2json(bj);
	}
	
	@RequestMapping(value = "/getItemByPart", method = { RequestMethod.POST })
	@ResponseBody
	public String getItemByPart(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String part = request.getParameter("part");
		List<com.pb.entity.Item> list = itemService.getItemByPart(part);
		bj.setObj(list);
		bj.setRetcode("0000");
		return JsonUtil.getInstance().obj2json(bj);
	}
}
