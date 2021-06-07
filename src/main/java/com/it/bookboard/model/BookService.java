package com.it.bookboard.model;

import java.util.List;

import com.it.bookboard.common.SearchVO;

public interface BookService {
	
	public int insertBook(BookDTO dto);
	public List<BookDTO> selectAll(SearchVO searchVo);
	public int selectTotalRecord(SearchVO searchVo);
	public BookDTO selectByNo(int no);
	public int updateBook(BookDTO dto);  
	public int deleteBook(BookDTO dto);
	public List<BookDTO> selectMainNotice(); 
}
