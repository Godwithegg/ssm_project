package com.danhuang.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.danhuang.crop.ClientCustom;
import com.danhuang.crop.ClientQueryVo;
import com.danhuang.crop.KindsCustom;
import com.danhuang.crop.KindsQueryVo;
import com.danhuang.crop.Status;
import com.danhuang.crop.StatusCustom;
import com.danhuang.crop.StatusQueryVo;
import com.danhuang.mapper.ClientMapperCustom;
import com.danhuang.mapper.KindsMapperCustom;
import com.danhuang.mapper.StatusMapper;
import com.danhuang.mapper.StatusMapperCustom;
import com.danhuang.service.StatusService;
import com.fasterxml.jackson.databind.util.BeanUtil;

public class StatusServiceImpl implements StatusService {
	@Autowired
	private StatusMapper statusMapper;
	@Autowired
	private StatusMapperCustom statusMapperCustom;
	@Autowired
	private ClientMapperCustom clientMapperCustom;
	@Autowired
	private KindsMapperCustom kindsMapperCustom;
	@Override
	public List<StatusCustom> findStatusList(StatusQueryVo statusQueryVo) throws Exception {
		return statusMapperCustom.findStatusList(statusQueryVo);
	}

	@Override
	public StatusCustom findStatusById(Integer id) throws Exception {

		Status status = statusMapper.selectByPrimaryKey(id);
		StatusCustom statusCustom = null;
		if (status != null) {
			statusCustom = new StatusCustom();
			BeanUtils.copyProperties(status, statusCustom);
		}

		return statusCustom;
	}

	@Override
	public void updateStatus(Integer id, StatusCustom statusCustom) throws Exception {
		statusCustom.setId(id);
		statusMapper.updateByPrimaryKeySelective(statusCustom);

	}

	@Override
	public void deleteStatus(Integer id) throws Exception {
		statusMapper.deleteByPrimaryKey(id);

	}

	@Override
	public String findPasswordByUsername(String username) throws Exception {
		return clientMapperCustom.findPasswordByName(username);
	}

	@Override
	public void insertNewUser(ClientCustom clientCustom) throws Exception {
		clientMapperCustom.insertNewUser(clientCustom);
	}

	@Override
	public void insertStatus(StatusCustom statusCustom) throws Exception {
		statusMapperCustom.insertStatus(statusCustom);

	}

	@Override
	public boolean isNull(StatusCustom statusCustom) throws Exception {
		if (statusCustom.getName() == null)// || statusCustom.getPrice() == 0
//				|| statusCustom.getTotal() == 0 || statusCustom.getSold() == 0)
			return true;
		return false;
	}

	@Override
	public void updateSoldAndTotal(String name) throws Exception {
		statusMapperCustom.updateStatusForTotal(name);
	}
	
	@Override
	public StatusCustom findStatusByName(String name) throws Exception {
		return statusMapperCustom.findStatusByName(name);
	}

	@Override
	public List<KindsCustom> findKindsList(KindsQueryVo kindsQueryVo) throws Exception {
		return kindsMapperCustom.findKindsList(kindsQueryVo);
	}

}
