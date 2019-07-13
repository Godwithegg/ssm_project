package com.danhuang.mapper;

import com.danhuang.crop.ClientCustom;

public interface ClientMapperCustom {
	//根据姓名查找密码
	public String findPasswordByName(String username) throws Exception;
	//注册新用户
	public void insertNewUser(ClientCustom clientCustom) throws Exception;
}
