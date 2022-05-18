package com.globalin.mypage.service;

import java.util.List;

import com.globalin.mypage.domain.Criteria;
import com.globalin.mypage.domain.ReplyPage;
import com.globalin.mypage.domain.ReplyVO;

public interface ReplyService {
	int register(ReplyVO vo);

	ReplyVO get(int rno);

	int modify(ReplyVO vo);

	int remove(int rno);

	List<ReplyVO> getList(Criteria cri, int bno);

	ReplyPage getListPage(Criteria cri, int bno);
}
