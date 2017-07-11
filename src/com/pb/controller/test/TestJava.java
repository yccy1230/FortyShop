package com.pb.controller.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TestJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String tsStr = "";
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			//方法一
			tsStr = sdf.format(ts);
			System.out.println(tsStr);
			//方法二
			tsStr = ts.toString();
			System.out.println(tsStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
