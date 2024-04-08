package com.sky.transcription2.Dao;



import com.sky.transcription2.Dto.RecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
						rs.getString("title"),
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

								rs.getString("title"), rs.getString("content"), rs.getString("status"), rs.getString("time"),
								rs.getLong("userNum"), rs.getInt("storyId")

				);

						return record;
					}
				});

		return results; // 결과 반환
	}


	public void insertRecord(RecordDto record) {
		// DAO에 전달하여 데이터베이스에 저장
		String sql = "INSERT INTO record (content, status, time, userNum, storyId, title) VALUES (?, ?, NOW(), ?, ?, ?)";
		jdbcTemplate.update(sql, record.getContent(), record.getStatus(), record.getUserNum(), record.getStoryId(), record.getTitle());
	}




	public String getTitleByStoryId(long storyId) {
		String sql = "SELECT title FROM fairytale WHERE storyid = ?";
		return jdbcTemplate.queryForObject(sql, String.class, storyId);
	}
}
