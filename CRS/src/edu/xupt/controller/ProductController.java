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

import edu.xupt.dao.ProductDao;
import edu.xupt.entity.ProductBean;

@Controller
@RequestMapping("/products")
public class ProductController {
	ProductDao pro = new ProductDao();

	@RequestMapping("/addProduct.do")
	public void addProduct(String name, String type, String description,
			HttpServletResponse response) {

		int r = pro.insert(name, type, description);

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

	@RequestMapping("/deleteProduct.do")
	public void deleteProduct(String id, HttpServletResponse response) {
		ProductBean p = new ProductBean();

		int r = pro.delete(id);

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

	@RequestMapping("/updateProduct.do")
	public void updateProduct(String name, String type, String description,
			String id, HttpServletResponse response) {

		ProductBean p = new ProductBean();
		p.setId(id);
		p.setName(name);
		p.setType(type);
		p.setDescription(description);
		int r = pro.update(p);

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

	@RequestMapping("/selectProduct.do")
	public void selectProduct(HttpServletResponse response) {

		List<ProductBean> prod = pro.selectAll();
		System.out.println("get user info!");
		response.setCharacterEncoding("utf-8");
		Writer writer;
		try {
			writer = response.getWriter();
			String jsonString = JSON.toJSONString(prod);
			System.out.println(jsonString);
			writer.append(JSON.toJSONString(prod));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
