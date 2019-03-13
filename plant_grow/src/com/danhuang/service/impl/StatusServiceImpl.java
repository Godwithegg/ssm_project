package com.danhuang.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.danhuang.crop.Status;
import com.danhuang.crop.StatusCustom;
import com.danhuang.crop.StatusQueryVo;
import com.danhuang.mapper.StatusMapper;
import com.danhuang.mapper.StatusMapperCustom;
import com.danhuang.service.StatusService;
import com.fasterxml.jackson.databind.util.BeanUtil;

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
	public StatusCustom findStatusById(Integer id) throws Exception {
		
		Status status = statusMapper.selectByPrimaryKey(id);
		StatusCustom statusCustom = null;
		if(status != null)
		{
			statusCustom = new StatusCustom();
			BeanUtils.copyProperties(status, statusCustom);
		}

		return statusCustom;
	}
	@Override
	public void updateStatus(Integer id,StatusCustom statusCustom) throws Exception {
		statusCustom.setId(id);
		statusMapper.updateByPrimaryKeySelective(statusCustom);
		
	}
	
	
}
