package com.danhuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.danhuang.crop.Status;
import com.danhuang.crop.StatusCustom;
import com.danhuang.crop.StatusQueryVo;
import com.danhuang.mapper.StatusMapper;
import com.danhuang.mapper.StatusMapperCustom;
import com.danhuang.service.StatusService;

public class StatusServiceImpl implements StatusService{
	@Autowired
	private StatusMapper statusMapper;
	@Autowired
	private StatusMapperCustom statusMapperCustom;
	@Override
	public List<StatusCustom> findStatusList(StatusQueryVo statusQueryVo) throws Exception {
		return statusMapperCustom.findStatusList(statusQueryVo);
	}
	@Override
	public StatusCustom findStatusByName(String name) throws Exception {
		
		return statusMapperCustom.findStatusByName(name);
	}
	@Override
	public void updateStatus(String name,StatusCustom statusCustom) throws Exception {
		statusCustom.setName(name);
		statusMapperCustom.updateStatus(statusCustom);
		
	}
	
	
}
