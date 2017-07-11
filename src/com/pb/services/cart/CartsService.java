package com.pb.services.cart;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pb.entity.Cart;
import com.pb.entity.CartId;
import com.pb.entity.Item;
import com.pb.entity.Order;
import com.pb.entity.OrderId;
import com.pb.services.common.CommService;

@Service("cartsService")
public class CartsService extends CommService {

	/**
	 * 获取用户购物车中的条目
	 * 
	 * @param name
	 * @return 该用户名下购物车的所有item
	 */
	public List<Item> getUserCart(String name) {
		List<Item> result = new ArrayList<Item>();
		List<Cart> list = baseDAO.findByHQL(
				"from Cart cart where cart.id.userId = ? and cart.id.status=?",
				new Object[] { name ,"待确认"});
		for (int i = 0; i < list.size(); i++) {
			String itemID = list.get(i).getId().getItemId();
			String num = list.get(i).getId().getNum();
			List<Item> itemList = baseDAO.findByHQL(
					"from Item item where item.itemId = ? ",
					new Object[] { itemID });
			if (itemList.size() != 0) {
				Item item = itemList.get(0);
				item.setRemainNum(num);
				result.add(item);
			}
		}
		return result;
	}

	/**
	 * 删除用户名下购物车商品ID为itemID的条目
	 * 
	 * @param itemID
	 *            username
	 */
	public void deleteCartItem(String itemID, String username) {
		boolean result = false;
		List<Cart> list = baseDAO
				.findByHQL(
						"from Cart cart where cart.id.itemId = ?  and cart.id.userId = ? and cart.id.status= ?",
						new Object[] { itemID, username ,"待确认"});
		baseDAO.delete(list.get(0));
	}

	/**
	 * 将username的购物车商品整合成订单
	 * 
	 * @param username
	 */
	public Order payForCart(String username) {
		List<Cart> list = baseDAO.findByHQL(
				"from Cart cart where cart.id.userId = ? and cart.id.status = ?",
				new Object[] { username,"待确认" });

		if(list.size()==0){
			return null;
		}
		// 利用时间生成订单号：
		Calendar c = Calendar.getInstance();
		String s = "TB" + c.get(Calendar.MONTH) + c.get(Calendar.DATE)
				+ c.get(Calendar.HOUR) + c.get(Calendar.MINUTE)
				+ c.get(Calendar.SECOND);
		Order order = new Order();
		OrderId orderId = new OrderId();

		orderId.setUserId(username);// 设置订单用户名
		orderId.setOrderStatus("待发货");// 设置订单初始状态
		orderId.setOrderId(s);// 设置订单号

		Timestamp orderDate = new Timestamp(System.currentTimeMillis());
		orderId.setOrderDate(orderDate);// 设置订单时间

		// 设置封面图片
		List<Item> itemList = getUserCart(username);
		orderId.setCoverImage(itemList.get(0).getCoverImage());

		//获取总商品件数、订单总金额
		int totalNum=0;
		double totalMoney = 0.0;
		for(int i=0;i<list.size();i++){
			totalNum += Integer.parseInt(list.get(i).getId().getNum());
			totalMoney += Double.parseDouble(list.get(i).getId().getMoney())
					* Double.parseDouble(list.get(i).getId().getNum());
		}
		orderId.setTotalMoney(totalMoney + "");

		// 设置订单明细
		String orderDetail = "";
		int count=0;
		for(int i=0;i<list.size();i++){
			if(count<2){
				String name = itemList.get(i).getClothesName();
				if(!orderDetail.contains(name)){
					orderDetail +=name+"<br/>";
					count++;
				}
			}
		}
		orderDetail+="等共"+totalNum+"件商品";
		orderId.setOrderDetail(orderDetail);

		order.setId(orderId);

		// 更新购物车中条目的status，赋值订单ID（便于查询明细）
		for (int i = 0; i < list.size(); i++) {
			baseDAO.delete(list.get(i));
			Cart tmpCart = new Cart();
			CartId tmpCartID = new CartId();
			tmpCartID.setItemId(list.get(i).getId().getItemId());
			tmpCartID.setMoney(list.get(i).getId().getMoney());
			tmpCartID.setNum(list.get(i).getId().getNum());
			tmpCartID.setSize(list.get(i).getId().getSize());
			tmpCartID.setUserId(list.get(i).getId().getUserId());
			tmpCartID.setStatus(s);
			tmpCart.setId(tmpCartID);
			baseDAO.save(tmpCart);
		}

		
		// 保存订单到数据库
		baseDAO.save(order);

		return order;
	}
}
