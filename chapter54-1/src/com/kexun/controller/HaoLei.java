package com.kexun.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kexun.service.impl.IProductService;

@Controller
public class HaoLei {
	@Resource
	IProductService iPrdouctService;

//	����Ҫ�������Ƿ���һ��json��ʽ���ַ�����xml�ļ���ǰ�˵��á������н���
	@ResponseBody
	@RequestMapping(value = "/go", produces = "text/json;charset=UTF-8", method = RequestMethod.POST)

	public String play() {

//		String json="{\"name\":\"tom\"}";
		String json = iPrdouctService.getJSONString();
		return json;
	}

//	(2)�������ע��@RequestParam,���Դ���HttpServletRequest
	@RequestMapping(value = "/go2", produces = "text/json;charset=UTF-8")
	public void playTwo(@RequestParam String hqy) {
		try {
			String temp = new String(hqy.getBytes(), "gb2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�����" + hqy);

	}

//	(3)·������ע�⣬���ڻ�ȡ�ڶ����󴮽ӵ�һ��ֵ
	@RequestMapping("/go3")
	public void playThree(@PathVariable String req) {
		System.out.println("�����" + req);

	}

//	(4)ʹ���ض���ʵ�ִ��ι��ܣ�Ӧ��Flash����
	@RequestMapping(value="/go4",method=RequestMethod.POST)
	public String playFour(RedirectAttributes rds) {
		rds.addFlashAttribute("msg","Ҳ������");
		return "redirect:/show.jsp";
	}
}
