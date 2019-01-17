package com.dragon.dao;

import org.apache.ibatis.annotations.Param;

import com.dragon.bean.Member;

public interface MemberDao {
	Member selectMemberByName(@Param("name")String name)throws Exception;

	Member findById(@Param("id")int id)throws Exception;
}
 