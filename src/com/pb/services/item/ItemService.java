package com.pb.services.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pb.entity.Cart;
import com.pb.entity.CartId;
import com.pb.entity.Item;
import com.pb.entity.Users;
import com.pb.services.common.CommService;

@Service("itemService")
public class ItemService extends CommService {

	/**
	 * 
	 * 向购物车添加物品
	 * 
	 * @param username
	 * @param itemId
	 * @param number
	 * @return
	 */
	public List<Cart> addItem2Cart(String username, String itemId, String number) {
		List<Item> itemList = baseDAO.findByHQL(
				"from Item item where item.itemId = ? ",
				new Object[] { itemId });

		List<Cart> list = baseDAO
				.findByHQL(
						"from Cart cart where cart.id.itemId = ?  and cart.id.userId = ? and cart.id.status = ?",
						new Object[] { itemId, username, "待确认" });

		// 如果购物车中已经存在了相同的商品，则数量在此基础上加一
		if (list.size() > 0) {
			baseDAO.delete(list.get(0));
			Cart cart = new Cart();
			CartId cartID = new CartId();
			cartID.setItemId(list.get(0).getId().getItemId());
			cartID.setSize(list.get(0).getId().getSize());
			cartID.setUserId(list.get(0).getId().getUserId());
			cartID.setStatus(list.get(0).getId().getStatus());
			String num = Integer.parseInt(list.get(0).getId().getNum()) + 1
					+ "";
			String money = Double.parseDouble(list.get(0).getId().getMoney())
					+ itemList.get(0).getPrice() + "";
			cartID.setMoney(money);
			cartID.setNum(num);
			cart.setId(cartID);
			baseDAO.save(cart);
			return new ArrayList<Cart>();
		}
		Cart cart = new Cart();
		CartId cartId = new CartId();
		cartId.setUserId(username);
		cartId.setItemId(itemId);
		cartId.setNum(number);
		cartId.setStatus("待确认");

		// 计算该条记录总值
		Double price = itemList.get(0).getPrice();
		Double money = price * Double.parseDouble(number);
		cartId.setMoney(money + "");

		// 设置购买商品尺寸
		cartId.setSize(itemList.get(0).getSize());

		// 购物车增加条目
		cart.setId(cartId);
		baseDAO.save(cart);

		List<Cart> result = new ArrayList<Cart>();
		result.add(cart);
		return result;

	}

	/**
	 * 根据类别（part）获取商品列表
	 * 
	 * @param part
	 * @return 返回该类别（part）的所有商品
	 */
	public List<Item> getItemByPart(String part) {
		List<Item> result = new ArrayList<Item>();
		List<Item> itemList = baseDAO.findByHQL(
				"from Item item where item.part = ? order by item.itemId asc", new Object[] { part });
		return itemList;
	}

	/**
	 * 辅助函数：提取字符串中的数字
	 */
	public String getNum(String str) {
		str = str.trim();
		String str2 = "";
		if (str != null && !"".equals(str)) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
					str2 += str.charAt(i);
				}
			}

		}
		return str2;
	}
}
