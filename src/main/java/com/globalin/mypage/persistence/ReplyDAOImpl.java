package com.globalin.mypage.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.globalin.mypage.domain.Criteria;
import com.globalin.mypage.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	private static final String NameSpace = "mappers.reply.replyMapper";
	
	private Logger log = LoggerFactory.getLogger(ReplyDAOImpl.class);

	private final SqlSession sqlSession;

	public ReplyDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insert(ReplyVO vo) {

		return sqlSession.insert(NameSpace + ".", vo);
	}

	@Override
	public ReplyVO read(int rno) {
		return sqlSession.selectOne(NameSpace + ".read", rno);
	}

	@Override
	public int delete(int rno) {
		return sqlSession.delete(NameSpace + ".delete", rno);
	}

	@Override
	public int update(ReplyVO vo) {
		return sqlSession.update(NameSpace + ".update", vo);
	}

	@Override
	public List<ReplyVO> getListWithPaging(Criteria cri, int bno) {
		Model model = null;
		model.addAttribute("cri", cri);
		log.info("cri : " + cri);
		model.addAttribute("bno", bno);
		return sqlSession.selectList(NameSpace + ".getListWithPaging", model);
	}

	@Override
	public int getCountByBno(int bno) {
		return sqlSession.selectOne(NameSpace + ".getCountByBno", bno);
	}

}
