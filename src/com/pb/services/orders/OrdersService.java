package com.pb.services.orders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pb.entity.Cart;
import com.pb.entity.Item;
import com.pb.entity.Order;
import com.pb.entity.OrderId;
import com.pb.services.common.CommService;


@Service("ordersService")
public class OrdersService extends CommService {
	
	/**
	 * Get all orders
	 * @param username
	 * @return
	 */
	public List<Order> getOrders(String username) {
		List<Order> list = baseDAO.findByHQL(
				"from Order order where order.id.userId = ? order by order.id.orderDate desc",
				new Object[] { username });
		return list;
	}
	
	/**
	 * Delete an order(compliment)
	 * @param username
	 * @param orderID
	 * @return
	 */
	public List<Order> deleteOrder(String username,String orderID){
		List<Order> result = new ArrayList<Order>();
		
		List<Order> list = baseDAO.findByHQL(
				"from Order order where order.id.userId = ? and order.id.orderId = ?",
				new Object[] { username , orderID});
		if(list.size()>0){
			Order order = list.get(0);
			result.add(order);
			baseDAO.delete(order);
		}
		return result;
	}
	
	/**
	 * Set an orderStatus
	 * @param username
	 * @param orderID
	 * @return
	 */
	public List<Order> completeOrder(String username,String orderID,String orderStatus){
		List<Order> result = new ArrayList<Order>();
		List<Order> list = baseDAO.findByHQL(
				"from Order order where order.id.userId = ? and order.id.orderId = ?",
				new Object[] { username , orderID});
		if(list.size()>0){
			baseDAO.delete(list.get(0));
			Order order = new Order();
			OrderId orderId = new OrderId();
			orderId.setCoverImage(list.get(0).getId().getCoverImage());
			orderId.setOrderDate(list.get(0).getId().getOrderDate());
			orderId.setOrderDetail(list.get(0).getId().getOrderDetail());
			orderId.setOrderId(list.get(0).getId().getOrderId());
			orderId.setTotalMoney(list.get(0).getId().getTotalMoney());
			orderId.setUserId(list.get(0).getId().getUserId());
			orderId.setOrderStatus(orderStatus);
			order.setId(orderId);
			result.add(order);
			baseDAO.save(order);
		}
		return result;
	}
	
	/**
	 * Get order detail
	 * @param username
	 * @param orderID
	 * @return
	 */
	public List<Item> getOrderDetail(String username,String orderID){
		List<Item> result = new ArrayList<Item>();
		List<Cart> list = baseDAO.findByHQL(
				"from Cart cart where cart.id.status = ? and cart.id.userId = ?",
				new Object[] {orderID,username});
		
		for(int i=0;i<list.size();i++){
			String itemID = list.get(i).getId().getItemId();
			List<Item> itemList = baseDAO.findByHQL(
					"from Item item where item.itemId = ?",
					new Object[] {itemID});
			if(itemList.size()!=0){
				Item it = itemList.get(0);
				it.setRemainNum(list.get(i).getId().getNum());
				result.add(it);
			}
		}
		return result;
	}
	
}
