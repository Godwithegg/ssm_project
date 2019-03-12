package com.danhuang.mapper;

import java.util.List;

import com.danhuang.crop.Status;
import com.danhuang.crop.StatusCustom;
import com.danhuang.crop.StatusQueryVo;

public interface StatusMapperCustom {
	//查找商品列表
	public List<StatusCustom> findStatusList(StatusQueryVo statusQueryVo) throws Exception;
	//根据名称查找作物
	public StatusCustom findStatusByName(String name) throws Exception;
	//根据名称更新作物
	public void updateStatus(StatusCustom statusCustom) throws Exception;
}
