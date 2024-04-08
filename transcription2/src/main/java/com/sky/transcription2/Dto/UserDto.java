package com.sky.transcription2.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
	private Integer userNum;
	private String id;
	private String name;
	private String password;
	private String email;
	
	public UserDto(String id,String password, String name, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
}
