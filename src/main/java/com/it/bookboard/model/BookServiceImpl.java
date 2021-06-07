package com.it.bookboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.bookboard.common.SearchVO;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDAO bookDao;
	
	public int insertBook(BookDTO dto) {
		return bookDao.insertBook(dto);
	}
	
	 
	public List<BookDTO> selectAll(SearchVO searchVo) {
		return bookDao.selectAll(searchVo);
	}//

	
	public BookDTO selectByNo(int no)  {
		return bookDao.selectByNo(no);
	}//
	
	public int updateBook(BookDTO dto) {
		return bookDao.updateBook(dto);
	}//

	public int deleteBook(BookDTO dto) {
		return bookDao.deleteBook(dto);
	}

	
	@Override
	public int selectTotalRecord(SearchVO searchVo) {
		return bookDao.selectTotalRecord(searchVo);
	}


	@Override
	public List<BookDTO> selectMainNotice() {
		return bookDao.selectMainNotice();
	}
		
}
