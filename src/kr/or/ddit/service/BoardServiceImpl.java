package kr.or.ddit.service;

import java.sql.SQLException;

import kr.or.ddit.dao.BoardDaoImpl;
import kr.or.ddit.dao.IBoardDao;
import kr.or.ddit.vo.BoardVo;

public class BoardServiceImpl implements IBoardService{

	private IBoardDao dao;
	private static IBoardService service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao();
	}
	
	public static IBoardService getServiece() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	@Override
	public int insertBoard(BoardVo bv) {
		int c = 0;
		
		try {
			c = dao.insertBoard(bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public int deleteBoard(int post_no) {
		int c = 0;
		
		try {
			c = dao.deleteBoard(post_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

}
