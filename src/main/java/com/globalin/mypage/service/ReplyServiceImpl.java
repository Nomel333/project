package com.globalin.mypage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globalin.mypage.domain.Criteria;
import com.globalin.mypage.domain.ReplyPage;
import com.globalin.mypage.domain.ReplyVO;
import com.globalin.mypage.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	private final ReplyDAO replyDao;

	public ReplyServiceImpl(ReplyDAO replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public int register(ReplyVO vo) {
		return replyDao.insert(vo);
	}

	@Override
	public ReplyVO get(int rno) {
		return replyDao.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		return replyDao.update(vo);
	}

	@Override
	public int remove(int rno) {
		return replyDao.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		return replyDao.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPage getListPage(Criteria cri, int bno) {
		ReplyPage page = new ReplyPage();

		page.setReplyCnt(replyDao.getCountByBno(bno));
		page.setList(replyDao.getListWithPaging(cri, bno));

		return page;
	}

}
