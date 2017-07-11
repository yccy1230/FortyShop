package com.pb.mapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pb.entity.Item;
import com.pb.entity.Users;
import com.pb.services.common.CommService;

@Service("cartService")
public class CartService extends CommService {
	public List<Item> getCartItem(String name){
		List<Item> result = new ArrayList<Item>();
		List<Item> list = baseDAO.findByHQL("from Cart cart where cart.username = ? ", new Object[]{name});
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getClothesName());
		}
		
		return result;
	}
	
}
