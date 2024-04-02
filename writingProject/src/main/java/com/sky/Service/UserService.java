package com.sky.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.Dao.UserDao;
import com.sky.Dto.UserDto;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public List<UserDto> selectAll() {
		return userDao.selectAll();
	}

	public UserDto authenticate(String username, String password) {
		UserDto user = userDao.findById(username); // 사용자 아이디로 사용자 정보를 가져옴
		if (user != null && user.getPassword().equals(password)) {
			return user; // 비밀번호 일치 시 사용자 정보 반환
		}
		return null; // 인증 실패
	}
}
