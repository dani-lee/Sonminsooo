package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.vo.AtchFileVo;
import kr.or.ddit.vo.FollowVO;
import kr.or.ddit.vo.FriendsVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.OptionVO;

public class MemberServiceImpl implements IMemberService{
	private IMemberDao dao;
	private static IMemberService service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getDao();
	}
	
	public static IMemberService getService() {
		if(service == null)
			service = new MemberServiceImpl();
		return service;
	}
	@Override
	public List<MemberVO> selectAllFollowers(String userId) {
		List<MemberVO> list = null;
		try {
			list = dao.selectAllFollowers(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberVO> selectAllFollowing(String userId) throws SQLException {
		List<MemberVO> list = null;
		try {
			list = dao.selectAllFollowing(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		MemberVO lu = new MemberVO();
		try {
			lu = dao.loginCheck(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lu;
	}

	@Override
	public int emailCheck(String memEmail) {
		return dao.emailCheck(memEmail);
	}

	@Override
	public int idCheck(String memId) {
		return dao.idCheck(memId);
	}

	@Override
	public String insertMember(MemberVO memberVO) {
		return dao.insertMember(memberVO);
	}

	@Override
	public MemberVO findPassword(String user) {
		MemberVO vo = new MemberVO();
		try {
			vo = dao.findPassword(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		int count = 0;
		try {
			count = dao.memberUpdate(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int passwordUpdate(MemberVO vo) {
		int count = 0;
		try {
			count = dao.passwordUpdate(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public OptionVO optionList(String mem_id) {
		OptionVO vo = new OptionVO();
		try {
			vo = dao.optionList(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int notificationUpdate(OptionVO vo) {
		int count = 0;
		try {
			count = dao.notificationUpdate(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int securityUpdate(OptionVO vo) {
		int count = 0;
		try {
			count = dao.securityUpdate(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int photoUpdate(MemberVO vo) {
		int count = 0;
		try {
			count = dao.photoUpdate(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public AtchFileVo photoSelect(long mem_photo) {
		AtchFileVo vo = new AtchFileVo();
		try {
			vo = dao.photoSelect(mem_photo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<FriendsVO> selectFriend(String mem_id) {
		List<FriendsVO> list = null;
		try {
			list = dao.selectFriend(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int friendDelete(FollowVO vo) {
		int count = 0;
		try {
			count = dao.friendDelete(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int friendInsert(FollowVO vo) {
		int count = 0;
		try {
			count = dao.friendInsert(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int friendUpdate(FollowVO vo) {
		int count = 0;
		try {
			count = dao.friendUpdate(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public MemberVO otherMemberSelect(String mem_id) {
		MemberVO vo = new MemberVO();
		try {
			vo = dao.otherMemberSelect(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
