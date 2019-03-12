package com.danhuang.service;

import java.util.List;

import com.danhuang.crop.Status;
import com.danhuang.crop.StatusCustom;
import com.danhuang.crop.StatusQueryVo;

public interface StatusService {
	//查看所有植物情况
	public List<StatusCustom> findStatusList(StatusQueryVo statusQueryVo) throws Exception;
	//根据名称寻找作物的情况
	public StatusCustom findStatusByName(String name) throws Exception;
	//更新作物的修改情况
	public void updateStatus(String name,StatusCustom statusCustom) throws Exception;
}
