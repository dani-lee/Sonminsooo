package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.vo.HashTagVo;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.SimplePhotoVO;

public interface IHashTagDao {

	public int insertHashTag(HashTagVo hashTagVo);
	
	public List<HashTagVo> getHashtagList(String hash);
	
	// 검색창 검색
	// 1. 사용자 이름 검색
	public List<MemberVO> searchUser(String userName) throws SQLException;
	// 1-1 사용자 프로필 사진 가져오기
		public int searchUserImg(long afId) throws SQLException;
	// 2. 해시태그 검색
	public List<HashTagVo> searchHash(String hash) throws SQLException;
	
	// 검색창에서 해시 선택했을때
	// 1. 게시물 번호 가져오기
	public List<Integer> hashChoice(String hash) throws SQLException;
	// 2. 게시물 사진 가져오기
	public List<SimplePhotoVO> hashPhoto(int post_no) throws SQLException;
	
}
