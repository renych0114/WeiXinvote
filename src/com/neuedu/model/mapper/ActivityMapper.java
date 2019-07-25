package com.neuedu.model.mapper;

import com.neuedu.model.bean.Activity;

public interface ActivityMapper {
	
	public void updateActivityAccess(int aid);
	
	public Activity selectActivityById(int aid);
	
	public void updateActivityTotalPeople(int aid);
	
	public void updateActivityTotalTickets(int aid);
}
