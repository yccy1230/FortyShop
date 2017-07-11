package com.pb.controller.order;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.binding.corba.wsdl.Array;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pb.controller.BaseController;
import com.pb.entity.Item;
import com.pb.json.BaseJson;
import com.pb.util.JsonUtil;

@Controller
@RequestMapping("/order")
public class Order extends BaseController {
	
	@RequestMapping(value = "/getOrders", method = { RequestMethod.POST })
	@ResponseBody
	public String getOrders(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String username = (String) request.getSession().getAttribute("username");
		if(username==null){
			bj.setErrorMsg("获取用户名失败");
			bj.setRetcode("0001");
			return JsonUtil.getInstance().obj2json(bj);
		}
		List<com.pb.entity.Order> list = ordersService.getOrders(username);
		bj.setObj(list);
		bj.setRetcode("0000");

		for(int i=0;i<list.size();i++){
			Timestamp data = list.get(i).getId().getOrderDate();
			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			list.get(i).getId().setUserId(sdf.format(data));//将类型转换后的时间存储在userid字段
		}
		
		return JsonUtil.getInstance().obj2json(bj);
	}
	
	@RequestMapping(value = "/deleteOrder", method = { RequestMethod.POST })
	@ResponseBody
	public String deleteOrder(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String username = (String) request.getSession().getAttribute("username");
		if(username==null){
			bj.setErrorMsg("获取用户名失败");
			bj.setRetcode("0001");
			return JsonUtil.getInstance().obj2json(bj);
		}
		String orderID = request.getParameter("orderID");
		List<com.pb.entity.Order> list = ordersService.deleteOrder(username, orderID);
		bj.setObj(list);
		bj.setRetcode("0000");
		return JsonUtil.getInstance().obj2json(bj);
	}
	
	@RequestMapping(value = "/completeOrder", method = { RequestMethod.POST })
	@ResponseBody
	public String completeOrder(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String username = (String) request.getSession().getAttribute("username");
		if(username==null){
			bj.setErrorMsg("获取用户名失败");
			bj.setRetcode("0001");
			return JsonUtil.getInstance().obj2json(bj);
		}
		String orderID = request.getParameter("orderID");
		String orderStatus = request.getParameter("orderStatus");
		List<com.pb.entity.Order> list = ordersService.completeOrder(username, orderID,orderStatus);
		bj.setObj(list);
		bj.setRetcode("0000");
		return JsonUtil.getInstance().obj2json(bj);
	}
	
	@RequestMapping(value = "/getOrderDetail", method = { RequestMethod.POST })
	@ResponseBody
	public String getOrderDetail(HttpServletRequest request,
			HttpServletResponse response) {
		BaseJson bj = new BaseJson();
		String username = (String) request.getSession().getAttribute("username");
		if(username==null){
			bj.setErrorMsg("获取用户名失败");
			bj.setRetcode("0001");
			return JsonUtil.getInstance().obj2json(bj);
		}
		String orderID = request.getParameter("orderID");
		List<Item> list = ordersService.getOrderDetail(username, orderID);
		bj.setObj(list);
		bj.setRetcode("0000");
		return JsonUtil.getInstance().obj2json(bj);
	}
}
