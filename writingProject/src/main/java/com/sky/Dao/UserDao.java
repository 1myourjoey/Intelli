package com.sky.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sky.Dto.UserDto;




@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserDto> selectAll() {
        List<UserDto> results = jdbcTemplate.query(
                "SELECT * FROM user", // 테이블 이름 확인
                new RowMapper<UserDto>() { // 클래스 이름 수정
                    @Override
                    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        UserDto user = new UserDto(
                                rs.getString("id"),
                                rs.getString("name"),
                                rs.getString("password"),
                                rs.getString("email")
                                
                        );

                        return user;
                    }
                });

        return results; // 결과 반환
    }
    
    public UserDto findById(String userNum) {
        String query = "SELECT * FROM user WHERE id = ?"; // 테이블 이름 수정
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{userNum}, (rs, rowNum) -> {
                UserDto user = new UserDto();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setUserNum(rs.getInt("usernum"));
                return user;
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public UserDto findByUserNum(Integer userNum) {
        String query = "SELECT * FROM user WHERE userNum = ?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{userNum}, (rs, rowNum) -> {
                UserDto user = new UserDto();
                user.setUserNum(rs.getInt("userNum"));
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                return user;
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}

