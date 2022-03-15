package kr.or.ddit.vo;

import java.util.Date;

public class ReplyVO {
	private int file_sn    ;
	private String child_id      ;
	private String parent_id     ;
	private String mem_id        ;
	private int post_no       ;
	private String reply_content ;
	private Date reply_date    ;
	private long mem_photo  ;
	

	public String getChild_id() {
		return child_id;
	}
	public void setChild_id(String child_id) {
		this.child_id = child_id;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	public int getFile_sn() {
		return file_sn;
	}
	public void setFile_sn(int file_sn) {
		this.file_sn = file_sn;
	}
	public long getMem_photo() {
		return mem_photo;
	}
	public void setMem_photo(long mem_photo) {
		this.mem_photo = mem_photo;
	}

	
	
}
