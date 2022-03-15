package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.HashTagVo;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.SimplePhotoVO;

public class HashTagDaoImpl implements IHashTagDao{
	
	private static IHashTagDao dao;
	private SqlMapClient smc;
	
	private HashTagDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IHashTagDao getInstance() {
		if(dao == null){
			dao = new HashTagDaoImpl();
		}
		return dao;
	}
	@Override
	public int insertHashTag(HashTagVo hashTagVo) {
		int cnt = 0;
		
		try {
			cnt = (Integer)smc.insert("board.insertHashTag", hashTagVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<HashTagVo> getHashtagList(String hash) {
		List<HashTagVo> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("board.getHashtagList", hash);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	// 해시 검색
	@Override
	public List<HashTagVo> searchHash(String hash) throws SQLException {
		return smc.queryForList("search.searchHash",hash);
	}

	// 사용자 이름 검색
	@Override
	public List<MemberVO> searchUser(String userName) throws SQLException {
		return smc.queryForList("search.searchUser",userName);
	}
	// 사용자 프로필 사진 가져오기
	@Override
	public int searchUserImg(long afId) throws SQLException {
		return (int) smc.queryForObject("search.searchUserImg",afId);
	}
	
	// 1. 게시물 번호 가져오기
	@Override
	public List<Integer> hashChoice(String hash) throws SQLException {
		return (List<Integer>) smc.queryForList("search.hashChoice",hash);
	}

	// 2. 게시물 사진 가져오기
	@Override
	public List<SimplePhotoVO> hashPhoto(int post_no) throws SQLException{
		return (List<SimplePhotoVO>) smc.queryForList("search.hashPhoto",post_no);
	}
	

}






























