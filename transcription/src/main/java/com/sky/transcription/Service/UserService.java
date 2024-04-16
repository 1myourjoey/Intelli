package com.sky.transcription.Service;


import com.sky.transcription.Dao.UserDao;
import com.sky.transcription.Dto.UserDto;
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
	public void updateUser(Integer userNum, String newPassword, String newEmail) {
		// 사용자 번호로 사용자 정보를 가져옴
		UserDto user = userDao.findByUserNum(userNum);

		// 사용자 정보가 존재하는지 확인
		if (user == null) {
			// 사용자 정보가 없으면 종료
			return;
		}

		// 새로운 비밀번호가 비어 있지 않고 null이 아닌 경우에만 비밀번호를 업데이트함
		if (newPassword != null && !newPassword.isEmpty()) {
			user.setPassword(newPassword);
		}

		// 새로운 이메일이 비어 있지 않고 null이 아닌 경우에만 이메일을 업데이트함
		if (newEmail != null && !newEmail.isEmpty()) {
			// 새로운 이메일이 중복되는지 확인
			if (isEmailAvailable(newEmail)) {
				user.setEmail(newEmail);
			} else {
				// 중복되는 이메일이면 처리
				// 여기서는 예외를 던지거나 적절한 방법으로 처리
			}
		}

		// 변경된 사용자 정보를 데이터베이스에 업데이트함
		userDao.update(user);
	}

	// 이메일이 중복되는지 확인하는 메서드
	public boolean isEmailAvailable(String email) {
		// 이메일이 중복되지 않는지 확인하는 로직 구현
		// 중복되지 않으면 true를 반환, 중복되면 false를 반환
		// 이 예시에서는 userDao에 이메일 중복을 확인하는 메서드가 있다고 가정
		return userDao.isEmailAvailable(email);
	}
}
