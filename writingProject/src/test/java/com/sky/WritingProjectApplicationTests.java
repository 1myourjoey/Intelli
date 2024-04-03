package com.sky;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.sky.Dao.FairyTaleDao;
import com.sky.Dao.RecordDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sky.Dto.FairyTaleDto;

@SpringBootTest
class WritingProjectApplicationTests {

	@Autowired
	private RecordDao recordDao;

	@Autowired
	private FairyTaleDao fairyTaleDao;

//	@Test
//	void testInsertRecord() {
//		// 테스트용 RecordDto 객체 생성
//		RecordDto record = new RecordDto();
//		record.setContent("Test Content");
//		record.setStatus("Test Status");
//		record.setUserNum(1); // 사용자 번호 설정
//
//		// RecordDao의 insertRecord 메서드 호출하여 레코드 삽입
//		recordDao.insertRecord(record);
//		System.out.println(record);
//		// 테스트 결과 확인
//		System.out.println("Record inserted successfully.");
//	}

}
