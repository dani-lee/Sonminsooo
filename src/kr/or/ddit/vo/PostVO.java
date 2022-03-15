package kr.or.ddit.vo;

import java.util.Date;

public class PostVO {
	
	private int post_no;			//게시물번호
	private String post_kind;		//게시물종류
	private String post_status;		//게시물상태
	private String mem_id;			//업로드한 사용자
	private Date post_date;			//게시한 날짜
	private String post_content;	//게시글 내용
	private String location_no;		//위치번호
	private long atch_file_id;		//첨부파일id
	
	private String mem_name;		//이름
	private String mem_photo;		//프로필 경로
	private int mem_sn;				//프로필 경로
	private String mem_status; 		//회원종류
	
	private int file_sn;			//파일 순서
	private String file_stre_cours;	//파일 경로
	private String orignl_file_nm;	//오리지널 파일명

	
	public String getMem_status() {
		return mem_status;
	}
	public void setMem_status(String mem_status) {
		this.mem_status = mem_status;
	}
	public int getMem_sn() {
		return mem_sn;
	}
	public void setMem_sn(int mem_sn) {
		this.mem_sn = mem_sn;
	}
	
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getPost_kind() {
		return post_kind;
	}
	public void setPost_kind(String post_kind) {
		this.post_kind = post_kind;
	}
	public String getPost_status() {
		return post_status;
	}
	public void setPost_status(String post_status) {
		this.post_status = post_status;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public String getLocation_no() {
		return location_no;
	}
	public void setLocation_no(String location_no) {
		this.location_no = location_no;
	}
	public long getAtch_file_id() {
		return atch_file_id;
	}
	public void setAtch_file_id(long atch_file_id) {
		this.atch_file_id = atch_file_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_photo() {
		return mem_photo;
	}
	public void setMem_photo(String mem_photo) {
		this.mem_photo = mem_photo;
	}
	public int getFile_sn() {
		return file_sn;
	}
	public void setFile_sn(int file_sn) {
		this.file_sn = file_sn;
	}
	public String getFile_stre_cours() {
		return file_stre_cours;
	}
	public void setFile_stre_cours(String file_stre_cours) {
		this.file_stre_cours = file_stre_cours;
	}
	public String getOrignl_file_nm() {
		return orignl_file_nm;
	}
	public void setOrignl_file_nm(String orignl_file_nm) {
		this.orignl_file_nm = orignl_file_nm;
	}
	
	
	
}
