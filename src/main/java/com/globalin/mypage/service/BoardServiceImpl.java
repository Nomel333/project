package com.globalin.mypage.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalin.mypage.domain.BoardVO;
import com.globalin.mypage.domain.Criteria;
import com.globalin.mypage.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDAO boardDao;

	public BoardServiceImpl(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public void create(BoardVO board) throws Exception {
		boardDao.create(board);
	}
	
	@Transactional
	@Override
	public BoardVO read(int bno) throws Exception {
		boardDao.updateViewCnt(bno);
		return boardDao.read(bno);
	}

	@Override
	public boolean update(BoardVO board) throws Exception {
		return boardDao.update(board);
	}

	@Override
	public boolean delete(int bno) throws Exception {
		return boardDao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardDao.listAll();
	}

	@Override
	public void insertSelectKey(BoardVO board) {
		boardDao.insertSelectKey(board);
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return boardDao.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.getTotalCount(cri);
	}

	@Override
	public void updateReplyCnt(int bno, int amount) {
		boardDao.updateReplyCnt(bno, amount);
	}

	@Override
	public void updateViewCnt(int bno) {
		boardDao.updateViewCnt(bno);
	}

}
