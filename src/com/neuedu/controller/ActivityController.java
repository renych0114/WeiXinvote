package com.neuedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.model.bean.Activity;
import com.neuedu.model.service.ActivityService;

@Controller
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping("updateActivityAccess/{aid}")
	@ResponseBody
	public String updateActivityAccess(@PathVariable int aid){
		activityService.updateActivityAccess(aid);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping("selectActivityById/{aid}")
	@ResponseBody
	public Activity selectActivityById(@PathVariable int aid){
		Activity act = activityService.selectActivityById(aid);
		return act;
	}
	
}
