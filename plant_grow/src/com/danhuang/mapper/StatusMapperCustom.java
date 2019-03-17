package com.danhuang.mapper;

import java.util.List;

import com.danhuang.crop.Status;
import com.danhuang.crop.StatusCustom;
import com.danhuang.crop.StatusQueryVo;

public interface StatusMapperCustom {
	//查找作物列表
	public List<StatusCustom> findStatusList(StatusQueryVo statusQueryVo) throws Exception;
	//新增作物数据
	public void insertStatus(StatusCustom statusCustom) throws Exception;
}
