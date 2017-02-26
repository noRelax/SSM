package com.norelax.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.norelax.www.dao.BookDao;
import com.norelax.www.entity.Book;
import com.norelax.www.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Override
	public Book getBookById(Integer bookId) {
		return bookDao.queryById(bookId);
	}

}
