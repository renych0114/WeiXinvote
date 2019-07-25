package com.neuedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.model.bean.Gift;
import com.neuedu.model.service.GiftService;

@Controller
public class GiftController {
	@Autowired
	private GiftService giftService;
	
	@RequestMapping("selectGiftsByAid/{aid}")
	@ResponseBody
	public List<Gift> selectGiftsByAid(@PathVariable int aid){
		return giftService.selectGiftsByAid(aid);
	}
	
}
