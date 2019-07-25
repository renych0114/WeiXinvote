package com.neuedu.model.mapper;

import java.util.List;

import com.neuedu.model.bean.Gift;

public interface GiftMapper {
	public List<Gift> selectGiftsByAid(int aid);
}
