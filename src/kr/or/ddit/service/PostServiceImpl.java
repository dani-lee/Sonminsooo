package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.dao.IPostDao;
import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.dao.PostDaoImpl;
import kr.or.ddit.vo.LocationVo;
import kr.or.ddit.vo.PostLikeVO;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.ReplyLikeVO;
import kr.or.ddit.vo.ReplyVO;
import kr.or.ddit.vo.SimplePhotoVO;

public class PostServiceImpl implements IPostService{

	private IPostDao dao;
	private static IPostService service;
	
	private PostServiceImpl() {
		dao = PostDaoImpl.getDao();
	}
	
	public static IPostService getService() {
		if(service == null)
			service = new PostServiceImpl();
		return service;
	}

	@Override
	public List<PostVO> selectMyFollwingNewPost(String mem_id) {
		List<PostVO> pl = null;
		try {
			pl = dao.selectMyFollwingNewPost(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pl;
	}

	@Override
	public List<PostLikeVO> selectPostLike(String mem_id) {
		List<PostLikeVO> list = null;
		try {
			list = dao.selectPostLike(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<PostVO> selectPost(String mem_id) {
		return dao.selectPost(mem_id);
	}

	@Override
	public SimplePhotoVO selectPostImg(int post_no) {
		SimplePhotoVO sn = new SimplePhotoVO();
		try {
			sn = dao.selectPostImg(post_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sn;
	}

	@Override
	public PostLikeVO cntPostLike(int post_no) {
		return dao.cntPostLike(post_no);
	}
	
	@Override
	public List<PostVO> mypostSelect(String mem_id) {
		List<PostVO> list = null;
		try {
			list = dao.mypostSelect(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public List<ReplyVO> replySelect(String post_no) {
		List<ReplyVO> list = null;
		try {
			list = dao.replySelect(post_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ReplyVO postGetReply(int post_no) {
		return dao.postGetReply(post_no);
	}

	@Override
	public LocationVo postGetLocation(int post_no) {
		return dao.postGetLocation(post_no);
	}

	@Override
	public List<PostVO> postGetlikelist(int post_no) {
		return dao.postGetlikelist(post_no);
	}

	@Override
	public List<ReplyLikeVO> replylikeSelect(String child_id) {
		List<ReplyLikeVO> list = null;
		try {
			list = dao.replylikeSelect(child_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<PostLikeVO> postlikeSelect(String post_no) {
		List<PostLikeVO> list = null;
		try {
			list = dao.postlikeSelect(post_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int replyInsert(ReplyVO vo) {
		int cnt=0;
		try {
			cnt= dao.replyInsert(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int postlikeInsert(PostLikeVO vo) {
		int cnt=0;
		try {
			cnt= dao.postlikeInsert(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int replylikeInsert(ReplyLikeVO vo) {
		int cnt=0;
		try {
			cnt= dao.replylikeInsert(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deletePostLike(PostLikeVO vo) {
		return dao.deletePostLike(vo);
	}

	@Override
	public PostLikeVO cntlike(int post_no) {
		return dao.cntlike(post_no);
	}

	@Override
	public List<SimplePhotoVO> loginUserFriend(String loginUser) {
		List<SimplePhotoVO> list = null;
		try {
			list = dao.loginUserFriend(loginUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}























