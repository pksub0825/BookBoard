package com.it.bookboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.it.bookboard.common.PaginationInfo;
import com.it.bookboard.common.SearchVO;
import com.it.bookboard.common.Utility;
import com.it.bookboard.model.BookDTO;
import com.it.bookboard.model.BookService;


@Controller
@RequestMapping("/book")
public class BookListController {
	private static final Logger logger
		=LoggerFactory.getLogger(BookListController.class);
	
	@Autowired
	public BookService bookService;

	@RequestMapping("/bookList.do")
	public String list(@ModelAttribute SearchVO searchVo, Model model) {
		//1
		logger.info("글목록 페이지, 파라미터  searchVo={}", searchVo);
		
		//2
		//페이징 처리 관련 셋팅
		//[1] PaginationInfo 생성
		PaginationInfo pagingInfo=new PaginationInfo();
		pagingInfo.setBlockSize(Utility.BLOCK_SIZE);
		pagingInfo.setRecordCountPerPage(Utility.RECORD_COUNT);
		pagingInfo.setCurrentPage(searchVo.getCurrentPage());
		
		//[2] SearchVo 셋팅
		searchVo.setRecordCountPerPage(Utility.RECORD_COUNT);
		searchVo.setFirstRecordIndex(pagingInfo.getFirstRecordIndex());
		
		List<BookDTO> list=bookService.selectAll(searchVo);
		logger.info("글목록 결과, list.size={}", list.size());
		
		int totalRecord=bookService.selectTotalRecord(searchVo);
		logger.info("글객수 결과, totalRecord={}", totalRecord);
		
		pagingInfo.setTotalRecord(totalRecord);
		
		//3. 모델에 결과 저장
		model.addAttribute("list", list);
		model.addAttribute("pagingInfo", pagingInfo);
		
		//4. 뷰페이지 리턴
		return "book/bookList";
		
		}

}











