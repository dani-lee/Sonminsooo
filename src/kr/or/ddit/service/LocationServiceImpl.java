package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.ILocationtDao;
import kr.or.ddit.dao.LocationDaoImpl;
import kr.or.ddit.vo.LocationVo;

public class LocationServiceImpl implements ILocationService{

	private static ILocationService service;
	private ILocationtDao dao;
	
	private LocationServiceImpl() {
		dao = LocationDaoImpl.getInstance();
	}
	public static ILocationService getInstance() {
		if(service == null) {
			service = new LocationServiceImpl();
		}
		return service;
	}
	
	@Override
	public int insertLocation(String location) {
		return dao.insertLocation(location);
	}

	@Override
	public List<LocationVo> getLocationList(String location) {
		return dao.getLocationList(location);
	}

}
