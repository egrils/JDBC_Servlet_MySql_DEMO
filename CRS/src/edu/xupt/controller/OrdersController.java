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

import edu.xupt.dao.OrdersDao;
import edu.xupt.entity.OrderBean;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	OrdersDao ord = new OrdersDao();

	@RequestMapping("addOrder.do")
	public void addOrder(String user, String product, String number,
			HttpServletResponse response) {

		int r = ord.insert(user, product, number);

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

	@RequestMapping("deleteOrder.do")
	public void deleteOrder(String id, HttpServletResponse response) {

		int r = ord.delete(id);

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

	@RequestMapping("updateOrder.do")
	public void updateOrder(String user, String product, String number,
			String id, HttpServletResponse response) {

		OrderBean o = new OrderBean();

		o.setId(id);
		o.setUser(user);
		o.setProduct(product);
		o.setNumber(number);
		int r = ord.update(o);

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

	@RequestMapping("selectOrder.do")
	public void selectOrder(String name, HttpServletResponse response) {

		List<OrderBean> order = ord.selectAll();
		System.out.println("get user info!");
		response.setCharacterEncoding("utf-8");
		Writer writer;
		try {
			writer = response.getWriter();
			String jsonString = JSON.toJSONString(order);
			System.out.println(jsonString);
			writer.append(JSON.toJSONString(order));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
