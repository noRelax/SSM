package com.norelax.www.service;

import com.alibaba.fastjson.JSONObject;
import com.norelax.www.entity.Book;

public interface BookService {
	Book getBookById(Integer bookId);

	JSONObject insertAppointment(long bookId, long studentId);

}
