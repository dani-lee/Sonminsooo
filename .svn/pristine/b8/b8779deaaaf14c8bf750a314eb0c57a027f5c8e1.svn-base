package kr.or.ddit.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.BoardVo;

public class BoardDaoImpl implements IBoardDao{

	private static IBoardDao dao;
	   
	private SqlMapClient smc;
	
	private BoardDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	   
	public static IBoardDao getDao() {
		if(dao == null) {
			dao = new BoardDaoImpl();
		}
		return dao;
	}
	@Override
	public int insertBoard(BoardVo bv) throws SQLException {
		int c = 0;
		
		c = (int) smc.insert("board.insertBoard", bv);
		
		
		return c;
	}

	@Override
	public int deleteBoard(int post_no) throws SQLException {
		int c = 0;
		
		c = smc.delete("board.deleteBoard", post_no);
		
		return c;
	}

}
