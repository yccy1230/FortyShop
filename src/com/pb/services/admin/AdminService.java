package com.pb.services.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pb.entity.Item;
import com.pb.services.common.CommService;

@Service("adminService")
public class AdminService extends CommService {

	/**
	 * 获取所有的item
	 * 
	 * @return
	 */
	public List<Item> getAllItem() {
		List<Item> list = baseDAO.findByHQL("from Item item");
		return list;
	}

	/**
	 * 获取一个商品的详细资料
	 * @param itemID
	 * @return 
	 */
	public List<Item> getItem(String itemID) {
		List<Item> list = baseDAO
				.findByHQL("from Item item where item.itemId = ?",
						new Object[] { itemID });
		return list;

	}
	
	/**
	 * 修改一个商品条目
	 * @param itemID
	 * @param coverImage
	 * @param itemName
	 * @param itemDetail
	 * @param size
	 * @param part
	 * @param price
	 * @return
	 */
	public List<Item> modifyItem(String itemID,String coverImage,String itemName,String itemDetail,String size,String part,String price){
		List<Item> result = new ArrayList<Item>();
		List<Item> list = baseDAO
				.findByHQL("from Item item where item.itemId = ?",
						new Object[] { itemID });
		if(list.size()>0){
			Item i = list.get(0);
			i.setClothesdetail(itemDetail);
			i.setClothesName(itemName);
			i.setCoverImage(coverImage);
			i.setPart(part);
			i.setPrice(Double.parseDouble(price));
			i.setSize(size);
			baseDAO.update(i);
			result.add(i);
		}
		return result;
	}

	/**
	 * 增加一个商品条目
	 * @param itemID
	 * @param coverImage
	 * @param itemName
	 * @param itemDetail
	 * @param size
	 * @param part
	 * @param price
	 * @return
	 * 		成功添加返回该条目
	 * 		失败返回null;
	 */
	public List<Item> addItem(String itemID, String coverImage,
			String itemName, String itemDetail, String size, String part,
			String price) {
		// TODO Auto-generated method stub
		List<Item> result = new ArrayList<Item>();
		List<Item> list = baseDAO
				.findByHQL("from Item item where item.itemId = ?",
						new Object[] { itemID });
		if(list.size()>0){
			return result;
		}
		
		Item i = new Item();
		i.setClothesdetail(itemDetail);
		i.setClothesName(itemName);
		i.setCoverImage(coverImage);
		i.setPart(part);
		i.setPrice(Double.parseDouble(price));
		i.setRemainNum("100");
		i.setSize(size);
		i.setItemId(itemID);
		
		baseDAO.save(i);
		result.add(i);
		return result;
	}

	/**
	 * 删除一个条目
	 * @param itemID
	 * @return
	 * 		成功返回该条目
	 * 		失败返回空的list
	 */
	public List<Item> deleteItem(String itemID) {
		// TODO Auto-generated method stub
		List<Item> result = new ArrayList<Item>();
		List<Item> list = baseDAO
				.findByHQL("from Item item where item.itemId = ?",
						new Object[] { itemID });
		if(list.size()==0){
			return result;
		}
		result.add(list.get(0));
		baseDAO.delete(list.get(0));
		return result;
	}
	
}
