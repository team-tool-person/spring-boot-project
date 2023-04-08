package com.teamsea.pojo;

import java.time.LocalDateTime;

/**
 * 活动类
 * 
 */
public class Activity {

	private Integer id; // id属性
	private String title; // 标题
	private String category; // 等级

	// 因为Date 是一个过期的类型(有各种个样的问题)
	// 现在使用的日期类型是 JDK8 中出现的 LocalDateTime 工具类
	private LocalDateTime startTime; // 开始时间
	private LocalDateTime endTime; // 结束时间
	private Byte state; // 状态
	private String remark;// 内容正文
	private String createUser; // 创建用户
	private LocalDateTime createdTime; // 创建时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime starTime) {
		this.startTime = starTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createTime) {
		this.createdTime = createTime;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", title=" + title + ", category=" + category + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", state=" + state + ", remark=" + remark + ", createUser=" + createUser
				+ ", createTime=" + createdTime + "]";
	}

}
