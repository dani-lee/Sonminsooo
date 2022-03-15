package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AtchFileVo;
import kr.or.ddit.vo.FollowVO;
import kr.or.ddit.vo.FriendsVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.OptionVO;

public interface IMemberDao {
	// 팔로워 리스트
	public List<MemberVO> selectAllFollowers(String userId) throws SQLException;
	
	// 팔로우 리스트
	public List<MemberVO> selectAllFollowing(String userId) throws SQLException;
	
	// 친구 리스트
	public List<FriendsVO> selectFriend(String mem_id) throws SQLException;
	
	// 팔로우 취소
	public int friendDelete(FollowVO vo) throws SQLException;
	
	// 친구 삭제
	public int friendUpdate(FollowVO vo) throws SQLException;
	
	// 친구 추가
	public int friendInsert(FollowVO vo) throws SQLException;
	
	//이메일 중복 체크
	public int emailCheck(String memEmail);
	
	//아이디 중복 체크
	public int idCheck(String memId);
	
	// 로그인 검사
	public MemberVO loginCheck(MemberVO vo) throws SQLException;
	
	//회원가입(등록)
	public String insertMember(MemberVO memberVO);
	
	//비밀번호 찾기
	public MemberVO findPassword(String user) throws SQLException;
	
	// 멤버 정보 수정
	public int memberUpdate(MemberVO vo) throws SQLException;
	
	// 비밀번호 변경
	public int passwordUpdate(MemberVO vo) throws SQLException;
	
	// 옵션 리스트
	public OptionVO optionList(String mem_id) throws SQLException;
	
	// 알림옵션 업데이트
	public int notificationUpdate(OptionVO vo) throws SQLException;
	
	// 보안옵션 업데이트
	public int securityUpdate(OptionVO vo) throws SQLException;
	
	// 프로필 사진 업데이트
	public int photoUpdate(MemberVO vo) throws SQLException;
	
	// 프로필 사진 가져오기
	public AtchFileVo photoSelect(long mem_photo) throws SQLException;
	
	// 프로필 알아보기
	public MemberVO otherMemberSelect(String mem_id) throws SQLException;
}
