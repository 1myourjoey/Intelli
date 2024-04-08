package com.sky.transcription2.Service;



import com.sky.transcription2.Dao.FairyTaleDao;
import com.sky.transcription2.Dao.RecordDao;
import com.sky.transcription2.Dto.RecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    recordDao.insertRecord(record);
}
    public List<RecordDto> getAllRecords() {
        return recordDao.selectAll();
    }

    public List<RecordDto> getRecordsByUserNum(int userNum) {
        return recordDao.selectByUserNum(userNum);
    }
    public void saveRecord(RecordDto record) {
        recordDao.insertRecord(record);
    }



}
