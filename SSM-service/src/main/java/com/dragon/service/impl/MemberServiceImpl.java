package com.dragon.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.dragon.bean.Member;
import com.dragon.dao.MemberDao;
import com.dragon.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	private Logger logger = Logger.getLogger(MemberServiceImpl.class);

	@Cacheable("findById")
	@Override
	public Member findById(int id){
		try {
			logger.error("start service");
			return memberDao.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
