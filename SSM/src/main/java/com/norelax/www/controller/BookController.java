package com.norelax.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.norelax.www.entity.Book;
import com.norelax.www.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/getBookById")
	@ResponseBody
	public JSONObject getBookById(Integer bookId){
		Book book = bookService.getBookById(bookId);
		JSONObject resObj=new JSONObject();
		resObj.put("book", book);
		return resObj;
		
	}

}
