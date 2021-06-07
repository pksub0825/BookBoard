package com.it.bookboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it.bookboard.model.BookDTO;
import com.it.bookboard.model.BookService;

@Controller
@RequestMapping("/book")
public class BookWriteController {

	private static final Logger logger
		=LoggerFactory.getLogger(BookWriteController.class);
	
	@Autowired
	private BookService bookSerivce;
	
	@RequestMapping(value="/bookWrite.do", method=RequestMethod.GET)
	public String wirte_get() {
		logger.info("책등록 화면 보여주기");
		
		return "book/bookWrite";
	}
	
	@RequestMapping(value="/bookWrite.do", method=RequestMethod.POST)
	public String write_post(@ModelAttribute BookDTO bookDto) {
		//1
		logger.info("글쓰기처리, 파라미터 dto={}", bookDto);
		
		//2
		int cnt=bookSerivce.insertBook(bookDto);
		logger.info("글쓰기 처리결과, cnt={}", cnt);
		
		//3
		return "redirect:/book/bookList.do";
		
		
	}
	
}
