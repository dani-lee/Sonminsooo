package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.ISavePostDao;
import kr.or.ddit.dao.SavePostDaoImpl;
import kr.or.ddit.vo.SavedPostVo;

public class SavePostServiceImpl implements ISavePostService{

	private static ISavePostService service;
	private ISavePostDao dao;
	
	private SavePostServiceImpl() {
		dao = SavePostDaoImpl.getInstance();
	}
	
	public static ISavePostService getInstance() {
		if(service == null) {
			service = new SavePostServiceImpl();
		}
		return service;
	}
	
	@Override	
	public int insertSavePost(SavedPostVo spv) {
		return dao.insertSavePost(spv);
		
	}

	@Override
	public List<SavedPostVo> getSavedPostList(String memId) {

		return dao.getSavedPostList(memId);
	}

}
