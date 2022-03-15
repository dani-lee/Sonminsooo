package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.vo.LocationVo;
import kr.or.ddit.vo.PostLikeVO;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.ReplyLikeVO;
import kr.or.ddit.vo.ReplyVO;
import kr.or.ddit.vo.SimplePhotoVO;

public interface IPostService {

	//피드 부분
	//1.로그인 했을때 게시물 피드로 불러오기
	public List<PostVO> selectPost(String mem_id);
	//2.좋아요갯수
	public PostLikeVO cntPostLike(int post_no);
	//3.포스트 댓글 가져오기
	public ReplyVO postGetReply(int post_no);
	//4.위치가져오기
	public LocationVo postGetLocation(int post_no);
	//5.시간가져오기
	//6.좋아요 클릭시 리스트
	public PostLikeVO cntlike(int post_no);
	public List<PostVO> postGetlikelist(int post_no);
	//7.좋아요 취소
	public int deletePostLike(PostLikeVO vo);
	//8.로그인한 사람이 팔로잉한 사람들 가져오기
	public List<SimplePhotoVO> loginUserFriend(String loginUser);
	
	//알림 관련
	// 1. 팔로워의 게시물이 올라오면 알림
	public List<PostVO> selectMyFollwingNewPost(String mem_id);
	
	// 2. 내 게시물에 좋아요가 눌리면 알림
	public List<PostLikeVO> selectPostLike(String mem_id);
	public SimplePhotoVO selectPostImg(int post_no);
	
	// 내 포스트 가져오기
	public List<PostVO> mypostSelect(String mem_id);
	
	// 댓글 가져오기
	public List<ReplyVO> replySelect(String post_no);
	
	// 댓글 좋아요 가져오기
	public List<ReplyLikeVO> replylikeSelect(String child_id);
	
	// 포스트 좋아요 가져오기
	public List<PostLikeVO> postlikeSelect(String post_no);
	
	// 댓글쓰기
	public int replyInsert(ReplyVO vo);
	
	// 포스트 좋아요 누르기
	public int postlikeInsert(PostLikeVO vo);
	
	// 댓글 좋아요 누르기
	public int replylikeInsert(ReplyLikeVO vo);
}
