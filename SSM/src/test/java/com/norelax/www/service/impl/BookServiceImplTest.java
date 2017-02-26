package com.norelax.www.service.impl;

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
	}
}
