package com.it.bookboard.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.it.bookboard.common.SearchVO;

@Repository
public class BookDAOMybatis implements BookDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace="config.mybatis.mapper.oracle.book.";
	
	public int insertBook(BookDTO dto) {
		int cnt=sqlSession.insert(namespace+"insertBook", dto);
		return cnt;
	}
	
	public List<BookDTO> selectAll() {
		List<BookDTO> list=sqlSession.selectList(namespace+"selectAll");
		return list;
	}//

	public BookDTO selectByNo(int no) {
		BookDTO dto=sqlSession.selectOne(namespace+"selectByNo", no);
		
		return dto;
		
	}//
	
	public int updateBook(BookDTO dto)  {
		int cnt=sqlSession.update(namespace+"updateBook", dto);
		return cnt;
	}//
	
	public int deleteBook(BookDTO dto) {
		int cnt=sqlSession.delete(namespace+"deleteBook", dto);
		return cnt;
	}

	@Override
	public List<BookDTO> selectAll(SearchVO searchVo) {
		List<BookDTO> list
		=sqlSession.selectList(namespace+"selectAll", searchVo);
	return list;
	}

	@Override
	public int selectTotalRecord(SearchVO searchVo) {
		return sqlSession.selectOne(namespace+"selectTotalRecord", searchVo);
	}

	@Override
	public List<BookDTO> selectMainNotice() {
		return sqlSession.selectList(namespace+"selectMainNotice");
	}

	
}
