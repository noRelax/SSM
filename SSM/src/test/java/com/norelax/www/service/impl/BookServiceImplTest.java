package com.norelax.www.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.norelax.www.BaseTest;
import com.norelax.www.dao.BookDao;
import com.norelax.www.service.BookService;

/**
 * @ClassName: BookServiceImplTest
 * @Description: TODO(book service测试类)
 * @author no_relax
 * @date 2017年4月7日 上午10:44:49
 * 
 */
public class BookServiceImplTest extends BaseTest {
	@Autowired
	private BookService bookService;
	@Autowired
	private BookDao bookDao;

	@Test
	public void testAppoint() throws Exception {
		Integer bookId = 1001;
		System.out.println(bookService.getBookById(bookId));
		System.out.println(bookDao.queryById(bookId));
		Map<Object, Object> map = new HashMap<>();
		map.put("offset", 0);
		map.put("limit", 10);
		System.out.println(sessionTemplate.selectList("com.norelax.www.dao.BookDao.queryAll", map));
	}

	@Test
	public void operateAppointTest() {
		JSONObject parameter = new JSONObject();
		parameter.put("studentId", 1);
		List<Map<String, Object>> objs = sessionTemplate.selectList("com.norelax.www.dao.AppointmentDao.queryBooksByStudentId", parameter);
		System.out.println(JSONObject.toJSONString(objs, true));
	}

	@Test
	public void insertAppointTest() {
		JSONObject parameter = new JSONObject();
		parameter.put("bookId", 1002);
		parameter.put("studentId", 1);
		int result = sessionTemplate.insert("com.norelax.www.dao.AppointmentDao.insertAppointment", parameter);
		System.out.println(result);
	}

	@Test
	public void batchInsertAppointment() {
		// List<JSONObject> params = new ArrayList<>();
		JSONArray params = new JSONArray();
		for (int i = 0; i < 5; i++) {
			JSONObject param = new JSONObject();
			param.put("name", "图书" + i);
			param.put("number", 10 + i);
			params.add(param);
		}
		int result = sessionTemplate.insert("com.norelax.www.dao.AppointmentDao.batchInsertAppointment", params);
		System.out.println(result);
	}

	@Test
	public void queryAppointmentsByConditions() {
		JSONObject params = new JSONObject();
		params.put("bookId", 1000);
		List<Map<String, Object>> appointments = sessionTemplate.selectList("com.norelax.www.dao.AppointmentDao.queryAppointmentsByConditions", params);
		System.out.println(JSONObject.toJSONString(appointments, true));
	}
}
