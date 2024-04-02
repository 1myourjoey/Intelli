package com.sky.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sky.Dto.RecordDto;

@Repository
public class RecordDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	FairyTaleDao fairyTaleDao;

	public List<RecordDto> selectByUserNum(int userNum) {
		String sql = "SELECT * FROM record WHERE userNum = ?";
		return jdbcTemplate.query(sql, new Object[]{userNum}, new RowMapper<RecordDto>() {
			@Override
			public RecordDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				RecordDto record = new RecordDto(
						rs.getString("content"),
						rs.getString("status"),
						rs.getString("time"),
						rs.getInt("userNum"),
						rs.getInt("storyId")
				);
				return record;
			}
		});
	}

	public List<RecordDto> selectAll() {
		List<RecordDto> results = jdbcTemplate.query("SELECT * FROM record", // 테이블 이름 확인
				new RowMapper<RecordDto>() { // 클래스 이름 수정
					@Override
					public RecordDto mapRow(ResultSet rs, int rowNum) throws SQLException {
						RecordDto record = new RecordDto(

								rs.getString("content"), rs.getString("status"), rs.getString("time"),
								rs.getInt("userNum"), rs.getInt("storyId")

				);

						return record;
					}
				});

		return results; // 결과 반환
	}
//	  public void insertRecord(RecordDto record) {
//	        String sql = "INSERT INTO record (content, status, time, userNum, storyId) VALUES (?, ?, NOW(), ?, ?)";
//	        jdbcTemplate.update(sql, record.getContent(), record.getStatus(), record.getUserNum(), record.getStoryId());
//	    }

	public void insertRecord(RecordDto record) {
		// 랜덤하게 선택된 동화의 제목 가져오기
		String title = fairyTaleDao.selectRandom().getTitle();
		// 레코드 객체에 제목 설정
		record.setTitle(title);
		// DAO에 전달하여 데이터베이스에 저장
		String sql = "INSERT INTO record (content, status, time, userNum, storyId, title) VALUES (?, ?, NOW(), ?, ?, ?)";
		jdbcTemplate.update(sql, record.getContent(), record.getStatus(), record.getUserNum(), record.getStoryId(), record.getTitle());
	}

//	public void insertRecord(RecordDto record) {
//		// 제목 추가
//		String title = getTitleByStoryId(record.getStoryId()); // storyId를 이용하여 제목을 가져오는 로직을 구현해야 함
//		record.setTitle(title);
//		// DAO에 전달하여 데이터베이스에 저장
//		String sql = "INSERT INTO record (content, status, time, userNum, storyId) VALUES (?, ?, NOW(), ?, ?)";
//		jdbcTemplate.update(sql, record.getContent(), record.getStatus(), record.getUserNum(), record.getStoryId());
//	}


	public String getTitleByStoryId(long storyId) {
		String sql = "SELECT title FROM fairytale WHERE storyid = ?";
		return jdbcTemplate.queryForObject(sql, String.class, storyId);
	}
}
