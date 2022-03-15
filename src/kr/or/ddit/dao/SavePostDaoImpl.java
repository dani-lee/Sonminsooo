package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.SavedPostVo;

public class SavePostDaoImpl implements ISavePostDao{

	private static ISavePostDao dao;
	private SqlMapClient smc;
	
	private SavePostDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ISavePostDao getInstance() {
		if(dao == null) {
			dao = new SavePostDaoImpl();
		}
		return dao;
	}
	
	@Override
	public int insertSavePost(SavedPostVo spv) {
		int cnt = 0;
		
		try {
			if(smc.insert("savepost.insertSavePost", spv) == null) {
				cnt = 1;
			}else {
				cnt = 0;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<SavedPostVo> getSavedPostList(String memId) {
		List<SavedPostVo>list = null;
		
		try {
			list = smc.queryForList("savepost.getSavedPostList", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	

}
