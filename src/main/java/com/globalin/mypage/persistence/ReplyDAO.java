package com.globalin.mypage.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.globalin.mypage.domain.Criteria;
import com.globalin.mypage.domain.ReplyVO;


public interface ReplyDAO {

	void insert(ReplyVO vo);

	ReplyVO read(int bno);

	void delete(int rno);

	void update(ReplyVO vo);

	List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") int bno);

	int getCountByBno(int bno);

	
}
