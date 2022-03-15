package kr.or.ddit.vo;

public class SimplePhotoVO {
	
	private int post_no;
	private String mem_id;
	private long atch_file_id;
	private int file_sn;
	
	
	public long getAtch_file_id() {
		return atch_file_id;
	}
	public void setAtch_file_id(long atch_file_id) {
		this.atch_file_id = atch_file_id;
	}
	public int getFile_sn() {
		return file_sn;
	}
	public void setFile_sn(int file_sn) {
		this.file_sn = file_sn;
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
	
	
}
