package com.danhuang.service;

import java.util.List;

import com.danhuang.crop.ClientCustom;
import com.danhuang.crop.ClientQueryVo;
import com.danhuang.crop.KindsCustom;
import com.danhuang.crop.KindsQueryVo;
import com.danhuang.crop.StatusCustom;
import com.danhuang.crop.StatusQueryVo;

public interface StatusService {
	//查看所有商品情况
	public List<StatusCustom> findStatusList(StatusQueryVo statusQueryVo) throws Exception;
	//根据名称寻找商品的情况
	public StatusCustom findStatusById(Integer id) throws Exception;
	//更新商品的修改情况
	public void updateStatus(Integer id,StatusCustom statusCustom) throws Exception;
	//删除商品的信息
	public void deleteStatus(Integer id) throws Exception;
	//根据用户名查找密码
	public String findPasswordByUsername(String username) throws Exception;
	//注册用户
	public void insertNewUser(ClientCustom clientCustom) throws Exception;
	//插入新的商品数据
	public void insertStatus(StatusCustom statusCustom) throws Exception;
	//增加商品是否为空
	public boolean isNull(StatusCustom statusCustom) throws Exception;
	//增加销售量
	public void updateSoldAndTotal(String name) throws Exception;
	//通过名称查找商品信息
	public StatusCustom findStatusByName(String name) throws Exception;
	//查找商品种类集合
	public List<KindsCustom> findKindsList(KindsQueryVo kindsQueryVo) throws Exception;
}
