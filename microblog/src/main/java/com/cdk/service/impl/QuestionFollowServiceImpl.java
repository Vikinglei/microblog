package com.cdk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.entity.FollowDTO;
import com.cdk.entity.QuestionFollow;
import com.cdk.mapper.QuestionFollowMapper;
import com.cdk.service.QuestionFollowService;

@Service
public class QuestionFollowServiceImpl implements QuestionFollowService {
	@Autowired
	private QuestionFollowMapper questionFollowMapper;

	@Override
	public Integer addQuestionFollow(QuestionFollow qf) {
		return questionFollowMapper.addQuestionFollow(qf);
	}

	@Override
	public Integer removeQuestionFollow(QuestionFollow qf) {
		return questionFollowMapper.removeQuestionFollow(qf);
	}

	@Override
	public List<FollowDTO> getFollowByUserId(Integer userId) {
		return questionFollowMapper.getFollowByUserId(userId);
	}

}
