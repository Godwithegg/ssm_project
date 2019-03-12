package com.danhuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.danhuang.crop.StatusCustom;
import com.danhuang.crop.StatusQueryVo;
import com.danhuang.service.StatusService;

@Controller
@RequestMapping("/crop")
public class CropController {
	@Autowired
	private StatusService statusService;
	
	@RequestMapping("/queryStatus")
	public ModelAndView queryStatus(StatusQueryVo statusQueryVo) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("statusList",statusService.findStatusList(statusQueryVo));
		modelAndView.setViewName("crop/cropsList");
		
		return modelAndView;
	}
	
	@RequestMapping("/editStatus")
	public String editStatus(Model model,String name) throws Exception
	{
		StatusCustom statusCustom = statusService.findStatusByName(name);
		model.addAttribute("statusCustom", statusCustom);
		
		return "/crop/editStatus";
	}
	
	@RequestMapping("/editStatusSubmit")
	public String editStatusSubmit(String name,StatusCustom statusCustom) throws Exception
	{
		statusService.updateStatus(name,statusCustom);
		return "redirect:queryStatus.action";
	}
}
