package com.sky.Service;

import java.util.List;

import com.sky.Dao.FairyTaleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sky.Dao.RecordDao;
import com.sky.Dto.RecordDto;
@Service
public class RecordService {
	@Autowired
	RecordDao recordDao;
    @Autowired
    FairyTaleDao fairyTaleDao;

	public List<RecordDto> selectAll() {
        return recordDao.selectAll();
    }
	
//	public void insert(RecordDto record) {
//        recordDao.insertRecord(record);
//    }
public void insert(RecordDto record) {
    // 랜덤하게 선택된 동화의 제목 가져오기
    String title = fairyTaleDao.getTitleByStoryId(record.getStoryId());
    record.setTitle(title);
    // DAO에 전달하여 데이터베이스에 저장
    recordDao.insertRecord(record);
}


    public List<RecordDto> getRecordsByUserNum(int userNum) {
        return recordDao.selectByUserNum(userNum);
    }



}
