package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dao.HashTagDaoImpl;
import kr.or.ddit.dao.IHashTagDao;
import kr.or.ddit.vo.HashTagVo;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.SimplePhotoVO;

public class HashTagServiceImpl implements IHashTagService{
	
	private static IHashTagService hashTagService;
	private IHashTagDao hashtagDao;
	
	private HashTagServiceImpl() {
		hashtagDao = HashTagDaoImpl.getInstance();
	}
	
	public static IHashTagService getInstance() {
		if(hashTagService == null) {
			hashTagService  =  new HashTagServiceImpl();
		}
		return hashTagService;
	}
	
	@Override
	public int insertHashTag(HashTagVo hashTagVo) {
		return hashtagDao.insertHashTag(hashTagVo);
	}

	@Override
	public List<HashTagVo> getHashtagList(String hash) {
		return hashtagDao.getHashtagList(hash);
	}

	// 해시 검색
	@Override
	public List<HashTagVo> searchHash(String hash) {
		List<HashTagVo> list = null;
		try {
			 list = hashtagDao.searchHash(hash);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 사용자 이름 검색
	@Override
	public List<MemberVO> searchUser(String userName) {
		List<MemberVO> list = null;
		try {
			list = hashtagDao.searchUser(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int searchUserImg(long afId) {
		int cnt = 0;
		try {
			cnt = hashtagDao.searchUserImg(afId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	// 1. 게시물 번호 가져오기
	@Override
	public List<Integer> hashChoice(String hash) {
		List<Integer> post_no = null;
		try {
			post_no = hashtagDao.hashChoice(hash);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post_no;
	}

	// 2. 게시물 사진 가져오기
	@Override
	public List<SimplePhotoVO> hashPhoto(int post_no) {
		List<SimplePhotoVO> list = null;
		try {
			list = hashtagDao.hashPhoto(post_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
