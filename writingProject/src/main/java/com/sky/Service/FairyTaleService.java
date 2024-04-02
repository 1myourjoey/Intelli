package com.sky.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.Dao.FairyTaleDao;
import com.sky.Dao.UserDao;
import com.sky.Dto.FairyTaleDto;
import com.sky.Dto.UserDto;
@Service
public class FairyTaleService {
	@Autowired
	FairyTaleDao fairyTaleDao;

	public List<FairyTaleDto> selectAll() {
		return fairyTaleDao.selectAll();
	}

	public FairyTaleDto selectRandom() {
		return fairyTaleDao.selectRandom();
	}
	public FairyTaleDto selectByStoryId(long storyId) {
		return fairyTaleDao.selectByStoryId(storyId);
	}
	
}
