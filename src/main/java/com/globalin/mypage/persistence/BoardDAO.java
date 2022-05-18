package com.globalin.mypage.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.globalin.mypage.domain.BoardVO;
import com.globalin.mypage.domain.Criteria;

public interface BoardDAO {

	void create(BoardVO board) throws Exception;
	
	BoardVO read(int bno) throws Exception;
	
	int update(BoardVO board) throws Exception;
	
	int delete(int bno) throws Exception;
	
	List<BoardVO> listAll() throws Exception;
	
	List<BoardVO> getListWithPaging(Criteria cri);
	
	void insertSelectKey(BoardVO board);
	
	List<BoardVO> getList(Criteria cri);
	
	int getTotalCount(Criteria cri);

	void updateReplyCnt(@Param("bno") int bno, @Param("amount") int amount);
	
	void updateViewCnt(int bno);
	
}
