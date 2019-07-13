package com.danhuang.controller;

import com.danhuang.crop.KindsCustom;
import com.danhuang.crop.StatusCustom;
import com.danhuang.crop.StatusQueryVo;
import com.danhuang.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/echarts")
public class RecordController {
	@Autowired
	private StatusService statusService;

	@RequestMapping(value = "/record")
	public @ResponseBody Object getRecord(StatusQueryVo statusQueryVo) throws Exception {
		//System.out.println(statusCustom);
		
		List<StatusCustom> list = statusService.findStatusList(statusQueryVo);
		return list;
	}

	@RequestMapping(value = "/test")
	public String into() {
		return "echarts/showInfoIndex";
	}
	
	@RequestMapping(value = "/showview")
	public @ResponseBody Object getRep(StatusQueryVo statusQueryVo) throws Exception {
		//System.out.println(statusCustom);
		
		List<KindsCustom> list = statusService.findKindsList(null);
		return list;
	}
	
	@RequestMapping(value = "/reposity")
	public String show() {
		return "echarts/reposity";
	}
}