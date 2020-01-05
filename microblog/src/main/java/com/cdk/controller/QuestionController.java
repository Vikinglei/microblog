package com.cdk.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdk.entity.FeedObject;

import com.cdk.entity.Question;
import com.cdk.entity.QuestionVO;
import com.cdk.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	/**
	 * 获取分页数据
	 * @return
	 */
	@RequestMapping("/searchQues")
	@ResponseBody
	public FeedObject getQuertionPage(Integer curPage,Integer pageSize,
			String searchInfo) {
		FeedObject fo = new FeedObject();
		
		//封装数据
		Map<String, Object> map = new HashMap<String, Object>();
		//获取分页数据
		List<QuestionVO> list = questionService.getQuertionPage(curPage,pageSize,
				searchInfo);
		//获取总条数
		map.put("data", list);
		map.put("total", questionService.getQuertionPageCount(searchInfo));
		
		fo.setState(true);
		fo.setObj(map);
		
		return fo;
	}
	
	@ResponseBody
	@RequestMapping("getHotInfo")
	public FeedObject getHotInfo() {
		FeedObject fo = new FeedObject();
		
		List<Question> list = questionService.getHotInfo();
		fo.setState(true);
		fo.setObj(list);

		
		return fo;
	}
	/**
	 * 问题详情页面
	 * @return
	 */
	@RequestMapping("questionDetail")
	public String questionDetail(Model model,Integer id) {
		
		QuestionVO qvo = questionService.getQuestionById(id);
		model.addAttribute("dto", qvo);
		
		return "questionDetail";
	}
}
