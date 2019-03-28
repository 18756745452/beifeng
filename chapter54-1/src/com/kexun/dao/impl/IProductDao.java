package com.kexun.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.kexun.dao.ProductDao;
import com.kexun.entity.Product;

import net.sf.json.JSONObject;

//此处有自定义的对象名ipd，也可以使用默认的对象名
@Repository("ipd")
public class IProductDao implements ProductDao {

	@Override
	public String selectAll() {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		Product p1 = new Product(1005, "iphoneX", "土豪标配", "8888");
		Product p2 = new Product(1006, "HuweiP30", "够便宜", "8888");
		Product p3 = new Product(1007, "Samsun", "够大", "8888");
		list.add(p1);
		list.add(p2);
		list.add(p3);
//		生成JSON工具对象
		JSONObject obj = new JSONObject();
//		以键值对方式放入一个对象
		obj.put("list", list);
		String json = obj.toString();
		return json;
	}

}
