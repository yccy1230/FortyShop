package com.pb.controller.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pb.controller.BaseController;
import com.pb.entity.Item;
import com.pb.entity.Order;
import com.pb.json.BaseJson;
import com.pb.util.JsonUtil;

@Controller
@RequestMapping("/cart")
public class Cart extends BaseController {
	
	@RequestMapping(value = "/getUserCart", method = { RequestMethod.POST })
	@ResponseBody
	public String getUserCart(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String name = request.getParameter("username");
		List<Item> list = cartsService.getUserCart(name);
		bj.setObj(list);
		bj.setRetcode("0000");
		return JsonUtil.getInstance().obj2json(bj);
	}
	
	@RequestMapping(value = "/deleteItem", method = { RequestMethod.POST })
	@ResponseBody
	public String deleteItem(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String itemID = request.getParameter("itemID");
		String username = request.getParameter("username");
		cartsService.deleteCartItem(itemID,username);
		bj.setRetcode("0000");
		return JsonUtil.getInstance().obj2json(bj);
	}
	
	@RequestMapping(value = "/payForCart", method = { RequestMethod.POST })
	@ResponseBody
	public String payForCart(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String username = request.getParameter("username");
		Order order = cartsService.payForCart(username);
		if(order==null){
			bj.setRetcode("0001");
			bj.setErrorMsg("您还没有购买任何东西呢~");
			return JsonUtil.getInstance().obj2json(bj);
		}
		bj.setRetcode("0000");
		bj.setObj(order);
		return JsonUtil.getInstance().obj2json(bj);
	}
}
