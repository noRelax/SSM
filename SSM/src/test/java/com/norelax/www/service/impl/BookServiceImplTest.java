package com.norelax.www.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.norelax.www.BaseTest;
import com.norelax.www.dao.BookDao;
import com.norelax.www.service.BookService;

public class BookServiceImplTest extends BaseTest {
	@Autowired
	private BookService bookService;
	@Autowired
	private BookDao bookDao;

	@Test
	public void testAppoint() throws Exception {
		Integer bookId = 1001;
		long studentId = 12345678910L;
		System.out.println(bookService.getBookById(bookId));
		System.out.println(bookDao.queryById(bookId));
		Map<Object, Object> map = new HashMap<>();
		map.put("offset", 0);
		map.put("limit", 10);
		System.out.println(sessionTemplate.selectList("com.norelax.www.dao.BookDao.queryAll", map));
	}
}
