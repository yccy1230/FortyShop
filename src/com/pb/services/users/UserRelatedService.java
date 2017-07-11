package com.pb.services.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pb.entity.User;
import com.pb.entity.Users;
import com.pb.services.common.CommService;

@Service("userRelatedService")
public class UserRelatedService extends CommService{

	/**
	 * 验证是否存在该用户
	 * @param name 
	 * @param pwd 
	 * @return 返回包含该用户名的List<Users>
	 */
	public List<Users> isUserValid(String name,String pwd){
		List<Users> list = baseDAO.findByHQL("from Users users where users.username = ? ",new Object[]{name});
		ArrayList<Users> result = new ArrayList<Users>();
		for(int i=0;i<list.size();i++){
			Users user = list.get(i);
			if(user.getPassword().equals(pwd)){
				Users u = new Users();
				u.setId(user.getId());
				u.setUsername(user.getUsername());
				u.setGender(user.getGender());
				u.setPassword(user.getPassword());
				u.setProfile(user.getProfile());
				u.setUsertype(user.getUsertype());
				result.add(u);
			}
		}
		return result;
	}
	
	/**
	 * 注册逻辑
	 * @param name
	 * @param pwd
	 * @param gender
	 */
	public boolean registeUser(String name,String pwd,String gender,String profile){
		List<Users> list = baseDAO.findByHQL("from Users users where users.username = ? ",new Object[]{name});
		ArrayList<Users> result = new ArrayList<Users>();
		if(list.size()>0)return false;
		Users u = new Users(name, pwd, gender,profile,"customer");
		baseDAO.save(u);
		return true;
	}
	
	/**
	 * 获取用户类型
	 * precondition： 用户已经确认为合法用户
	 * @param username
	 * @return
	 */
	public String getUserType(String username){
		List<Users> list = baseDAO.findByHQL("from Users users where users.username = ? ",new Object[]{username});
		if(list.size()==0) return null;
		else return list.get(0).getUsertype();
	}
}
