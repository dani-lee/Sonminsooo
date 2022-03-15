package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.LocationVo;
import kr.or.ddit.vo.PostLikeVO;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.ReplyLikeVO;
import kr.or.ddit.vo.ReplyVO;
import kr.or.ddit.vo.SimplePhotoVO;

public class PostDaoImpl implements IPostDao{
	
	private static IPostDao dao;
	   
	private SqlMapClient smc;
	
	private PostDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	   
	public static IPostDao getDao() {
		if(dao==null) {
			dao = new PostDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<PostVO> selectPost(String mem_id) {
		List<PostVO> imagesList = null;
		try {
			imagesList = smc.queryForList("post.selectPost", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imagesList;
	}


	@Override
	public List<PostVO> selectMyFollwingNewPost(String mem_id) throws SQLException {
		List<PostVO> postlist = null;
		postlist = smc.queryForList("post.selectMyFollwingNewPost", mem_id);
		return postlist;
	}

	@Override
	public List<PostLikeVO> selectPostLike(String mem_id) throws SQLException {
		List<PostLikeVO> list = null;
		list = smc.queryForList("post.selectPostLike",mem_id);
		return list;
	}

	@Override
	public SimplePhotoVO selectPostImg(int post_no) throws SQLException {
		return (SimplePhotoVO) smc.queryForObject("post.selectPostImg", post_no);
	}
	
	@Override
	public List<PostVO> mypostSelect(String mem_id) throws SQLException {
		List<PostVO> postlist = null;
		postlist = smc.queryForList("post.mypostSelect", mem_id);
		return postlist;
	}

	@Override
	public PostLikeVO cntPostLike(int post_no) {
		PostLikeVO likevo = new PostLikeVO();
		
		try {
			likevo = (PostLikeVO) smc.queryForObject("post.cntPostLike", post_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return likevo;
	}

	
	@Override
	public List<ReplyVO> replySelect(String post_no) throws SQLException {
		List<ReplyVO> replylist = null;
		replylist = smc.queryForList("post.replySelect", post_no);
		return replylist;
	}

	@Override
	public ReplyVO postGetReply(int post_no) {
		ReplyVO replyvo = new ReplyVO();
		
		try {
			replyvo =  (ReplyVO) smc.queryForObject("post.postGetReply", post_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return replyvo;
	}

	@Override
	public LocationVo postGetLocation(int post_no) {
		LocationVo lcvo = new LocationVo();
		
		try {
			lcvo = (LocationVo) smc.queryForObject("post.postGetLocation", post_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lcvo;
	}

	@Override
	public List<PostVO> postGetlikelist(int post_no) {
		List<PostVO> likelist = null;
		
		try {
			likelist = smc.queryForList("post.postGetlikelist", post_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return likelist;
	}

	@Override
	public List<ReplyLikeVO> replylikeSelect(String child_id) throws SQLException {
		List<ReplyLikeVO> likelist = null;
		
		try {
			likelist = smc.queryForList("post.replylikeSelect", child_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return likelist;
	}

	@Override
	public List<PostLikeVO> postlikeSelect(String post_no) throws SQLException {
		List<PostLikeVO> postlist = null;
		postlist = smc.queryForList("post.postlikeSelect", post_no);
		return postlist;
	}

	@Override
	public int replyInsert(ReplyVO vo) throws SQLException {
		int cnt = 0;
		
		try {
			cnt = (int) smc.insert("post.replyInsert", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int postlikeInsert(PostLikeVO vo) throws SQLException {
		int cnt = 0;
		
		try {
			if(smc.insert("post.postlikeInsert", vo)==null)
			 cnt = 1 ;
			else
			 cnt=0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int replylikeInsert(ReplyLikeVO vo) throws SQLException {
		int cnt = 0;
		
		try {
			if(smc.insert("post.replylikeInsert", vo)==null)
			cnt = 1 ;
			else
				cnt=0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deletePostLike(PostLikeVO vo) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("post.deletePostLike", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public PostLikeVO cntlike(int post_no) {
		PostLikeVO cntlike = new PostLikeVO();
		
		try {
			cntlike = (PostLikeVO) smc.queryForObject("post.cntlike", post_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cntlike;
	}

	@Override
	public List<SimplePhotoVO> loginUserFriend(String loginUser) throws SQLException {
		return smc.queryForList("post.loginUserFriend", loginUser);
	}



}


























