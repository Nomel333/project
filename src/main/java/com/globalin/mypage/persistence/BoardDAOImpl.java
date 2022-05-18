package com.globalin.mypage.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.globalin.mypage.domain.BoardVO;
import com.globalin.mypage.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final String NameSpace = "mappers.board.boardMapper";

	private final SqlSession sqlSession;

	@Inject
	public BoardDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void create(BoardVO board) throws Exception {
		sqlSession.insert(NameSpace + ".create", board);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return sqlSession.selectOne(NameSpace + ".read", bno);
	}

	@Override
	public int update(BoardVO board) throws Exception {
		return sqlSession.update(NameSpace + ".update", board);
	}

	@Override
	public int delete(int bno) throws Exception {
		return sqlSession.delete(NameSpace + ".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return sqlSession.selectList(NameSpace + ".listAll");
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		return sqlSession.selectList(NameSpace + ".getListWithPaging", cri);
	}

	@Override
	public void insertSelectKey(BoardVO board) {
		sqlSession.insert(NameSpace + ".insertSelectKey", board);
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return sqlSession.selectList(NameSpace + ".getList", cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return sqlSession.selectOne(NameSpace + ".getTotalCount", cri);
	}

	@Override
	public void updateReplyCnt(int bno, int amount) {
		Model model = null;
		model.addAttribute("bno", bno);
		model.addAttribute("amount", amount);
		sqlSession.update(NameSpace + ".updateReplyCnt", model);
	}

	@Override
	public void updateViewCnt(int bno) {
		sqlSession.update(NameSpace + ".updateViewCnt", bno);
	}

}
