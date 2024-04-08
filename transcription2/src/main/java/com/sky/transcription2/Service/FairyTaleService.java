package com.sky.transcription2.Service;


import com.sky.transcription2.Dao.FairyTaleDao;
import com.sky.transcription2.Dto.FairyTaleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
