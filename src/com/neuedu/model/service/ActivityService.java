package com.neuedu.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.neuedu.model.bean.Activity;
import com.neuedu.model.mapper.ActivityMapper;

@Service
public class ActivityService {
	@Autowired
	private ActivityMapper activityMapper;
	
	public void updateActivityAccess(int aid){
		activityMapper.updateActivityAccess(aid);
	}
	
	public Activity selectActivityById(int aid){
		return activityMapper.selectActivityById(aid);
	}
	
	
}
