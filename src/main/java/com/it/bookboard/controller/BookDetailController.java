package com.it.bookboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.it.bookboard.model.BookDTO;
import com.it.bookboard.model.BookService;

@Controller
@RequestMapping("/book")
public class BookDetailController {

	private static final Logger logger
		=LoggerFactory.getLogger(BookDetailController.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/bookDetail.do")
	public String detail(@RequestParam(defaultValue = "0") int no,
			Model model) {
		
		logger.info("상세보기 파라미터 no={}", no);
		
		BookDTO dto=bookService.selectByNo(no);
		logger.info("상세보기 결과, dto={}", dto);
		
		model.addAttribute("dto", dto);
		
		return "book/bookDetail";
		
	}
	
}
