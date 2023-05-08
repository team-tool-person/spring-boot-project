package com.teamsea.service.impl;

import java.util.ArrayList; 
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsea.mapper.MsgMapper;
import com.teamsea.model.Msg;
import com.teamsea.model.MsgShow;
import com.teamsea.service.MsgService;

/**
 * 信息业务层
 **/
@Service
public class MsgServiceImpl implements MsgService  {

	@Autowired
	MsgMapper mapper;

	@Override
	public List<MsgShow> getMsgShows() {

		List<Msg> msgs = mapper.seleteAll();

		return returnTo(msgs);

	}

	private List<MsgShow> returnTo(List<Msg> msgs) {
		List<MsgShow> msgShows = new ArrayList();

		for (Iterator iterator = msgs.iterator(); iterator.hasNext();) {

			Msg msgShow = (Msg) iterator.next();

		}

		return msgShows;

	}
}
