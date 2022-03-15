package kr.or.ddit.vo;

public class OptionVO {
	private String mem_id           ;
	private String mem_like         ;
	private String comments         ;
	private String comments_like    ;
	private String follow_request   ;
	private String direct_request   ;
	private String notification     ;
	private String story            ;
	private String video_views      ;
	private String live_show        ;
	private String activities_status;
	private String story_share      ;
	private String mem_status;
	
	public String getMem_status() {
		return mem_status;
	}
	public void setMem_status(String mem_status) {
		this.mem_status = mem_status;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_like() {
		return mem_like;
	}
	public void setMem_like(String mem_like) {
		this.mem_like = mem_like;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getComments_like() {
		return comments_like;
	}
	public void setComments_like(String comments_like) {
		this.comments_like = comments_like;
	}
	public String getFollow_request() {
		return follow_request;
	}
	public void setFollow_request(String follow_request) {
		this.follow_request = follow_request;
	}
	public String getDirect_request() {
		return direct_request;
	}
	public void setDirect_request(String direct_request) {
		this.direct_request = direct_request;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getVideo_views() {
		return video_views;
	}
	public void setVideo_views(String video_views) {
		this.video_views = video_views;
	}
	public String getLive_show() {
		return live_show;
	}
	public void setLive_show(String live_show) {
		this.live_show = live_show;
	}
	public String getActivities_status() {
		return activities_status;
	}
	public void setActivities_status(String activities_status) {
		this.activities_status = activities_status;
	}
	public String getStory_share() {
		return story_share;
	}
	public void setStory_share(String story_share) {
		this.story_share = story_share;
	}
	
	
}
