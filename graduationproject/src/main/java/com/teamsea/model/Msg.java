package com.teamsea.model;

public class Msg {
	
	private Integer id;
	
	private String title;
	
	private String msg;
	
	private Integer teacherId;
	
	private Integer studentId;
	
	private Integer solved;

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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getSolved() {
		return solved;
	}

	public void setSolved(Integer solved) {
		this.solved = solved;
	}

	@Override
	public String toString() {
		return "Msg [id=" + id + ", title=" + title + ", msg=" + msg + ", teacherId=" + teacherId + ", studentId="
				+ studentId + ", solved=" + solved + "]";
	}
	
	
}
