package kr.or.ddit.vo;

public class PostLikeVO {
	
	private int post_no;
	private String mem_id;
	private String pl_date;
	private int week;
	private String mem_name;
	private long mem_photo;
	private int file_sn = 1;	
	

	private int cnt_post_like;		//종아요 갯수
	
	public int getCnt_post_like() {
		return cnt_post_like;
	}
	public void setCnt_post_like(int cnt_post_like) {
		this.cnt_post_like = cnt_post_like;
	}
	
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getPl_date() {
		return pl_date;
	}
	public void setPl_date(String pl_date) {
		this.pl_date = pl_date;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public long getMem_photo() {
		return mem_photo;
	}
	public void setMem_photo(long mem_photo) {
		this.mem_photo = mem_photo;
	}
	public int getFile_sn() {
		return file_sn;
	}
	public void setFile_sn(int file_sn) {
		this.file_sn = file_sn;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	
}
