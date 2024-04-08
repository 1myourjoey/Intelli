package com.sky.transcription2.Service;


import com.sky.transcription2.Dao.UserDao;
import com.sky.transcription2.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	public UserDto findByUserNum(Integer userNum) {
		return userDao.findByUserNum(userNum);
	}

	public void registerUser(String id, String password, String name, String email) {
		UserDto user = new UserDto(id, password, name, email); // 새로운 사용자 객체 생성
		userDao.insert(user); // 사용자 등록 메서드 호출
	}
	public String getUserName(Integer userNum) {
		UserDto user = userDao.findByUserNum(userNum); // 사용자 번호로 사용자 정보를 가져옴
		if (user != null) {
			return user.getName(); // 사용자 이름 반환
		}
		return null; // 사용자 정보가 없는 경우 null 반환
	}

}
