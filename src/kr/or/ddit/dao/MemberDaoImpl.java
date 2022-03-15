package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.AtchFileVo;
import kr.or.ddit.vo.FollowVO;
import kr.or.ddit.vo.FriendsVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.OptionVO;

public class MemberDaoImpl implements IMemberDao{
	private static IMemberDao dao;
	private SqlMapClient client;
	
	private MemberDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static IMemberDao getDao() {
		if(dao==null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<MemberVO> selectAllFollowers(String userId) throws SQLException {
		List<MemberVO> list = null;

		list = client.queryForList("friends.selectAllFollowers", userId);
		return list;
	}

	@Override
	public List<MemberVO> selectAllFollowing(String userId) throws SQLException {
		List<MemberVO> list = null;

		list = client.queryForList("friends.selectAllFollowing", userId);
		return list;
	}

	@Override
	public int emailCheck(String memEmail){
		int cnt = 0;
		
		try {
			cnt = (int) client.queryForObject("member.emailCheck", memEmail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	@Override
	public int idCheck(String memid) {
		
		int cnt = 0;
		
		try {
			cnt = (int) client.queryForObject("member.idCheck", memid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) throws SQLException {
		MemberVO lu = null;
		lu = (MemberVO) client.queryForObject("member.loginCheck",vo);
		return lu;
	}

	@Override
	public String insertMember(MemberVO memberVO) {
		
		String memid = null;
		
		try {
			memid = (String) client.insert("member.insertMember", memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memid;
	}

	@Override
	public MemberVO findPassword(String user) throws SQLException {
		MemberVO vo = null;
		vo = (MemberVO) client.queryForObject("member.findPassword",user);
		return vo;
	}

	@Override
	public int memberUpdate(MemberVO vo) throws SQLException {
		return (int) client.update("member.memberUpdate", vo);
	}

	@Override
	public int passwordUpdate(MemberVO vo) throws SQLException {
		return (int) client.update("member.passwordUpdate", vo);
	}

	@Override
	public OptionVO optionList(String mem_id) throws SQLException {
		OptionVO vo = null;
		vo =  (OptionVO) client.queryForObject("member.optionList",mem_id);
		return vo;
	}

	@Override
	public int notificationUpdate(OptionVO vo) throws SQLException {
		return (int) client.update("member.notificationUpdate", vo);
	}

	@Override
	public int securityUpdate(OptionVO vo) throws SQLException {
		return (int) client.update("member.securityUpdate", vo);
	}

	@Override
	public int photoUpdate(MemberVO vo) throws SQLException {
		return (int) client.update("member.photoUpdate", vo);
	}

	@Override
	public AtchFileVo photoSelect(long mem_photo) throws SQLException {
		AtchFileVo vo = null;
		vo =  (AtchFileVo) client.queryForObject("member.photoSelect",mem_photo);
		return vo;
	}

	@Override
	public List<FriendsVO> selectFriend(String mem_id) throws SQLException {
		List<FriendsVO> list = null;

		list = client.queryForList("friends.friendSelect", mem_id);
		return list;
	}

	@Override
	public int friendDelete(FollowVO vo) throws SQLException {
		return (int) client.update("friends.friendDelete", vo);
	}

	@Override
	public int friendInsert(FollowVO vo) throws SQLException {
		return (int) client.delete("friends.friendInsert", vo);
	}

	@Override
	public int friendUpdate(FollowVO vo) throws SQLException {
		return (int) client.update("friends.friendUpdate", vo);
	}

	@Override
	public MemberVO otherMemberSelect(String mem_id) throws SQLException {
		MemberVO list = null;

		list = (MemberVO) client.queryForObject("member.otherMemberSelect", mem_id);
		return list;
	}




}
