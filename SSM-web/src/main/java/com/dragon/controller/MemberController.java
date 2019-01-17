package com.dragon.controller;

import com.dragon.utils.RedisUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dragon.bean.Member;
import com.dragon.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	private Logger logger = Logger.getLogger(MemberController.class);
	
	@RequestMapping(value="/findOne", method=RequestMethod.GET)
	@ResponseBody
	public String findById(@RequestParam(value="id") int id) {
		Member member =  memberService.findById(id);
		logger.debug(member);

		return JSON.toJSONString(member);
	}
}
