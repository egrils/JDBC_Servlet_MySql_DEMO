package edu.xupt.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import edu.xupt.dao.StudentDao;
import edu.xupt.entity.UserBean;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/userDelete.do")
	public void userDelete(String id, HttpServletResponse response) {
		StudentDao stu = new StudentDao();
		int r = stu.deleteById(id);

		response.setCharacterEncoding("utf-8");
		Writer writer = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			writer = response.getWriter();
			if (r > 0) {
				System.out.println("delete success!");
				map.put("success", true);
			} else {
				map.put("success", false);
				System.out.println("delete fail!");
			}
			writer.append(JSON.toJSONString(map));
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
					writer = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@RequestMapping("/userUpdate.do")
	public void userUpdate(String id, String name, String password,
			HttpServletResponse response) {
		StudentDao stu = new StudentDao();
		UserBean u = new UserBean();
		u.setId(id);
		u.setName(name);
		u.setPassword(password);
		int r = stu.update(u);

		response.setCharacterEncoding("utf-8");
		Writer writer = null;
		try {
			writer = response.getWriter();
			if (r > 0) {
				writer.append("OK");
			} else {
				writer.append("NO");
			}
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
					writer = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@RequestMapping("/userSelect.do")
	public void userSelect(HttpServletResponse response) {
		StudentDao stu = new StudentDao();
		List<UserBean> users = stu.selectAll();
		System.out.println("get user info!");
		response.setCharacterEncoding("utf-8");
		Writer writer;
		try {
			writer = response.getWriter();
			String jsonString = JSON.toJSONString(users);
			System.out.println(jsonString);
			writer.append(JSON.toJSONString(users));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/register.do")
	public String register() {

		return "register";
	}

	@RequestMapping("/addUser.do")
	public void addUser(String name, String password,
			HttpServletResponse response) {
		StudentDao stu = new StudentDao();
		int r = stu.insert(name, password);

		response.setCharacterEncoding("utf-8");
		Writer writer = null;
		try {
			writer = response.getWriter();
			if (r > 0) {
				writer.append("OK");
			} else {
				writer.append("NO");
			}
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
					writer = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
