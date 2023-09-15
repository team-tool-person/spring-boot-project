package com.teamsea.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsea.mapper.MsgMapper;
import com.teamsea.mapper.StudentMapper;
import com.teamsea.mapper.TeacherMapper;
import com.teamsea.model.Msg;
import com.teamsea.model.MsgShow;
import com.teamsea.model.Student;
import com.teamsea.service.MsgService;

/**
 * 信息业务层
 **/
@Service
public class MsgServiceImpl implements MsgService {

	@Autowired
	MsgMapper mapper;

	@Autowired
	TeacherMapper teacherMapper;

	@Autowired
	StudentMapper studentMapper;

	@Override
	public List<MsgShow> getMsgShows() {

		List<Msg> msgs = mapper.seleteAll();

		List<MsgShow> msgShows = returnTo(msgs);
		return msgShows;

	}

	/**
	 * 将Msg转换为MsgShow
	 * 
	 */
	private List<MsgShow> returnTo(List<Msg> msgs) {
		List<MsgShow> msgShows = new ArrayList();

		for (int i = 0; i < msgs.size(); i++) {

			Msg msg = msgs.get(i);

			MsgShow msgShow = new MsgShow(msg);

			// 获取学生姓名和教师姓名
			Student student = studentMapper.selectByPrimaryKey(msg.getStudentId());

			if (student != null) {
				msgShow.setStudentName(student.getName());
			} else {
				msgShow.setStudentName("无");
			}

			msgShow.setTeacherName(teacherMapper.selectByPrimaryKey(msg.getTeacherId()).getName());

			// 将MsgShow放置到列表中
			msgShows.add(msgShow);
		}

		return msgShows;

	}

	@Override
	public Integer deleteMsg(Integer id) {
	 Integer row =  mapper.deleteMsgById(id);
		return row;
	}
}
