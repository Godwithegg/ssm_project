package com.danhuang.mapper;

import java.util.List;

import com.danhuang.crop.KindsCustom;
import com.danhuang.crop.KindsQueryVo;

public interface KindsMapperCustom {
    
	//查找商品种类表
	public List<KindsCustom> findKindsList(KindsQueryVo kindsQueryVo) throws Exception;
}
