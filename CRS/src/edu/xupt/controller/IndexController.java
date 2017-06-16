package edu.xupt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.xupt.dao.StudentDao;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("hello.do")
	public String hello() {
		return "login";
	}

	@RequestMapping("/login.do")
	public String login(String name, String password) {
		StudentDao stu = new StudentDao();
		String pas = stu.selectByUserName(name);

		if (password.equals(pas)) {
			return "home";
		} else {
			return "login";
		}
	}
}
