package com.norelax.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.norelax.www.dao.AppointmentDao;
import com.norelax.www.dao.BookDao;
import com.norelax.www.entity.Book;
import com.norelax.www.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AppointmentDao appointmentDao;

	@Override
	public Book getBookById(Integer bookId) {
		return bookDao.queryById(bookId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public JSONObject insertAppointment(long bookId, long studentId) {
		// 查询bookId对应的书本数目
		long bookCount = bookDao.queryBookCountById(bookId);
		// 如果少于5本就说库存不足
		if (bookCount < 5) {
			throw new RuntimeException("库存不足");
		}
		// book的书本数-1
		bookDao.reduceNumber(bookId);
		// 预约书+1
		int result = appointmentDao.insertAppointment(bookId, studentId);
		JSONObject resObj = new JSONObject();
		if (result > 0) {
			resObj.put("status", 1);
			resObj.put("desc", "图书预约成功！");
		} else {
			resObj.put("status", 0);
			resObj.put("desc", "图书预约失败！");
		}
		return resObj;
	}

}
