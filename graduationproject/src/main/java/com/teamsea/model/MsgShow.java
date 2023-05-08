package com.teamsea.model;

public class MsgShow extends Msg {

	public MsgShow(Msg msg) {
		// 将属性放置到本类中
		super.setId(msg.getId());
		super.setTitle(msg.getTitle());
		super.setMsg(msg.getMsg());
		super.setSolved(msg.getSolved());
		super.setTeacherId(msg.getTeacherId());
		super.setStudentId(msg.getStudentId());
	}

	private String teacherName;

	private String studentName;

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "MsgShow [teacherName=" + teacherName + ", studentName=" + studentName + "]";
	}

}
