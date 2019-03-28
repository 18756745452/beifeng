package com.kexun.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.kexun.dao.ProductDao;
import com.kexun.entity.Product;

import net.sf.json.JSONObject;

//�˴����Զ���Ķ�����ipd��Ҳ����ʹ��Ĭ�ϵĶ�����
@Repository("ipd")
public class IProductDao implements ProductDao {

	@Override
	public String selectAll() {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		Product p1 = new Product(1005, "iphoneX", "��������", "8888");
		Product p2 = new Product(1006, "HuweiP30", "������", "8888");
		Product p3 = new Product(1007, "Samsun", "����", "8888");
		list.add(p1);
		list.add(p2);
		list.add(p3);
//		����JSON���߶���
		JSONObject obj = new JSONObject();
//		�Լ�ֵ�Է�ʽ����һ������
		obj.put("list", list);
		String json = obj.toString();
		return json;
	}

}
