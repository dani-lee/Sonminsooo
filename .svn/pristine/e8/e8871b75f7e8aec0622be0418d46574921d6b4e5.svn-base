package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.LocationVo;

public class LocationDaoImpl implements ILocationtDao{

	private static ILocationtDao dao;
	private SqlMapClient smc;
	
	private LocationDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ILocationtDao getInstance() {
		if(dao == null) {
			dao = new LocationDaoImpl();
		}
		return dao;
	}
	
	@Override
	public int insertLocation(String location) {

		int cnt = 0;
		
		try {
			cnt = (int) smc.insert("board.insertLoacion", location);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<LocationVo> getLocationList(String location) {
		List<LocationVo>list = null;
		
		try {
			list = smc.queryForList("board.getLocationList", location);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
