package com.sky.chap11mvc1.spring;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime regdate;

	public Member(String email, String password,
			String name, LocalDateTime regdate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.regdate = regdate;
	}

	void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return regdate;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

}
