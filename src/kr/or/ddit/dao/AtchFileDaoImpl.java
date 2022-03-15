package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.AtchFileVo;

public class AtchFileDaoImpl implements IAtchFileDao{

	private static IAtchFileDao dao;
	private SqlMapClient smc;
	
	private AtchFileDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IAtchFileDao getInstance() {
		if(dao == null) {
			dao = new AtchFileDaoImpl();
		}
		return dao;
	}
	@Override
	public int insertAtchFile(AtchFileVo atchFileVo) {
		int cnt = 0; //쿼리 작성 고려!
		
		try {
			Object obj = smc.insert("atch_file.insertAtchFile",atchFileVo);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int inserAtchFileDetail(AtchFileVo atchFileVo) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("atch_file.insertAtchFileDetail", atchFileVo);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<AtchFileVo> getAtchFileList(AtchFileVo atchFileVo) {
		List<AtchFileVo> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("atch_file.getAtchFileList", atchFileVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public AtchFileVo getAtchFileDetail(AtchFileVo atchFileVo) {
		AtchFileVo fileVo = null;
		
		try {
			fileVo = (AtchFileVo) smc.queryForObject("atch_file.getAtchFileDetail", atchFileVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileVo;
	}

}
