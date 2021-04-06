package com.how2java.springboot.web;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello(Model m) throws Exception {
		// TODO Auto-generated method stub
		m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
//		return "Hello Spring Boot!";
		if(true) {
			throw new Exception("some exception");
		}
//		这里返回的是jsp文件的前缀，用别的会有Whitelabel Error Page错误
		/**步骤7：修改HelloController，把本来的@RestController 改为@Controller。
		这时返回"hello"就不再是字符串，而是根据application.properties 中的视图重定向，到/WEB-INF/jsp目录下去寻找hello.jsp文件
		*/
		return "hello";
	}
}
