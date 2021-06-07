package com.it.bookboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.it.bookboard.model.BookDTO;
import com.it.bookboard.model.BookService;

@Controller
@RequestMapping("/book")
public class BookDeleteController {
	private static final Logger logger
		=LoggerFactory.getLogger(BookDeleteController.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/bookDel.do", method = RequestMethod.GET)
	public String del_get(@RequestParam(defaultValue = "0") int no,
			Model model) {
		
		//1
		logger.info("삭제화면, 파라미터 no={}", no);
		
		if(no==0) {
			model.addAttribute("msg", "잘못된 url입니다");
			model.addAttribute("url", "/book/bookList.do");
			return "common/message";
		}
		
		return "book/bookDel";
		
		
	}
	
	@RequestMapping(value="/bookDel.do", method=RequestMethod.POST)
	public String del_post(@ModelAttribute BookDTO dto,
			Model model) {
		logger.info("삭제화면, 파라미터 no={}", dto.getNo());
		
		int cnt=bookService.deleteBook(dto);
		String msg="글 삭제실패", url="/book/bookDetail.do?no="+dto.getNo();
		if(cnt>0) {
			msg="글삭제 되었습니다.";
			url="/book/bookList.do";
		}
		//3
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		//4
		return "common/message";
		
	}
	
}
