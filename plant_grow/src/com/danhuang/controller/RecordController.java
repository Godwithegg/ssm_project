package com.danhuang.controller;


import com.danhuang.crop.StatusCustom;
import com.danhuang.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/echarts")
public class RecordController {
@Autowired
private StatusService statusService;
    @RequestMapping(value = "/record")
    public @ResponseBody  Object getRecord() throws Exception{
        List<StatusCustom> list=statusService.findStatusList(null);
        return list;
    }
    @RequestMapping(value ="/test")
    public String into(){
        return "echarts/showInfoIndex";
    }
}