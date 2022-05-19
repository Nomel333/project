package com.globalin.mypage.service;

import java.util.List;

import com.globalin.mypage.domain.Criteria;
import com.globalin.mypage.domain.ReplyPage;
import com.globalin.mypage.domain.ReplyVO;

public interface ReplyService {
	void register(ReplyVO vo);

	List<ReplyVO> get(int bno);

	void modify(ReplyVO vo);

	void remove(int rno);

	List<ReplyVO> getList(Criteria cri, int bno);

	ReplyPage getListPage(Criteria cri, int bno);
}
