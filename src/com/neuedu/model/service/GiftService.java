package com.neuedu.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.model.bean.Gift;
import com.neuedu.model.mapper.GiftMapper;

@Service
public class GiftService {
	@Autowired
	private GiftMapper giftMapper;
	
	public List<Gift> selectGiftsByAid(int aid){
		return giftMapper.selectGiftsByAid(aid);
	}
	
}
