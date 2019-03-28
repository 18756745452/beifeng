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

//	他主要的作用是返回一个json格式的字符串或xml文件给前端调用。并进行解析
	@ResponseBody
	@RequestMapping(value = "/go", produces = "text/json;charset=UTF-8", method = RequestMethod.POST)

	public String play() {

//		String json="{\"name\":\"tom\"}";
		String json = iPrdouctService.getJSONString();
		return json;
	}

//	(2)请求参数注解@RequestParam,可以代替HttpServletRequest
	@RequestMapping(value = "/go2", produces = "text/json;charset=UTF-8")
	public void playTwo(@RequestParam String hqy) {
		try {
			String temp = new String(hqy.getBytes(), "gb2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("这就是" + hqy);

	}

//	(3)路径变量注解，用于获取在动作后串接的一个值
	@RequestMapping("/go3")
	public void playThree(@PathVariable String req) {
		System.out.println("这就是" + req);

	}

//	(4)使用重定向实现传参功能，应用Flash技术
	@RequestMapping(value="/go4",method=RequestMethod.POST)
	public String playFour(RedirectAttributes rds) {
		rds.addFlashAttribute("msg","也就这样");
		return "redirect:/show.jsp";
	}
}
