package com.danhuang.mapper;

import java.util.List;

import com.danhuang.crop.Status;
import com.danhuang.crop.StatusCustom;
import com.danhuang.crop.StatusQueryVo;

public interface StatusMapperCustom {
	//查找商品列表
	public List<StatusCustom> findStatusList(StatusQueryVo statusQueryVo) throws Exception;
	//新增商品数据
	public void insertStatus(StatusCustom statusCustom) throws Exception;
	//更新商品数据
	public void updateStatusForTotal(String name) throws Exception;
	//通过名称查找商品信息
	public StatusCustom findStatusByName(String name) throws Exception;
}
