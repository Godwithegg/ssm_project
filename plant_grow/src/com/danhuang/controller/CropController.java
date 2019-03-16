package com.danhuang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView queryStatus(StatusQueryVo statusQueryVo) throws Exception {
		List<StatusCustom> statusList = statusService.findStatusList(statusQueryVo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("statusList", statusList);
		modelAndView.setViewName("crop/cropsList");

		return modelAndView;
	}

	@RequestMapping("/editStatus")
	public String editStatus(Model model, @RequestParam(value = "id", required = true) Integer id) throws Exception {
		StatusCustom statusCustom = statusService.findStatusById(id);
		model.addAttribute("item", statusCustom);

		return "crop/editStatus";
	}

	@RequestMapping("/editStatusSubmit")
	public String editStatusSubmit(HttpServletRequest request, Integer id,
			@ModelAttribute("item") StatusCustom statusCustom) throws Exception {
		statusService.updateStatus(id, statusCustom);
		return "redirect:queryStatus.action";
	}

	@RequestMapping("/deleteStatus")
	public String deleteStatus(Integer id) throws Exception {
		statusService.deleteStatus(id); 
		return "redirect:queryStatus.action";
	}
	
}
