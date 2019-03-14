package com.danhuang.service;

import java.util.List;

import com.danhuang.crop.ClientCustom;
import com.danhuang.crop.ClientQueryVo;
import com.danhuang.crop.StatusCustom;
import com.danhuang.crop.StatusQueryVo;

public interface StatusService {
	//查看所有植物情况
	public List<StatusCustom> findStatusList(StatusQueryVo statusQueryVo) throws Exception;
	//根据名称寻找作物的情况
	public StatusCustom findStatusById(Integer id) throws Exception;
	//更新作物的修改情况
	public void updateStatus(Integer id,StatusCustom statusCustom) throws Exception;
	//删除作物的信息
	public void deleteStatus(Integer id) throws Exception;
	//根据用户名查找密码
	public String findPasswordByUsername(String username) throws Exception;
	//注册用户
	public void insertNewUser(ClientCustom clientCustom) throws Exception;
}
