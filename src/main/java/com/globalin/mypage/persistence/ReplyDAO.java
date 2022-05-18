package com.globalin.mypage.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.globalin.mypage.domain.Criteria;
import com.globalin.mypage.domain.ReplyVO;


public interface ReplyDAO {

	int insert(ReplyVO vo);

	ReplyVO read(int rno);

	int delete(int rno);

	int update(ReplyVO vo);

	List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") int bno);

	int getCountByBno(int bno);
	
}
