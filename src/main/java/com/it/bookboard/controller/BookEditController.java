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
public class BookEditController {

	@Autowired
	private BookService bookService;
	
	public static final Logger logger
		=LoggerFactory.getLogger(BookEditController.class);
	
	@RequestMapping(value="/bookEdit.do", method = RequestMethod.GET)
	public String bookEdit_get(@RequestParam(defaultValue = "0") int no,
			Model model) {
		//1
		logger.info("책 수정 페이지");
		
		//2
		BookDTO dto=bookService.selectByNo(no);
		logger.info("수정화면 결과 조회 dto={}", dto);
		
		//3
		model.addAttribute("dto", dto);
		
		//4
		return "book/bookEdit";
		
	}
	@RequestMapping(value="/bookEdit.do", method = RequestMethod.POST)
	public String bookEdti_post(@ModelAttribute BookDTO dto,
			Model model) {
		//1
		logger.info("화면 수정처리, 파라미터 dto={}", dto);
		 
		//2
		int cnt=bookService.updateBook(dto);
		
		String msg="수정실패", url="/book/bookDetail.do?no="+dto.getNo();
		if(cnt>0) {
			msg="수정성공";
			url="/book/bookDetail.do?no="+dto.getNo();
		}
		
		//3
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		//4
		return "common/message";
	}
	
	
}














