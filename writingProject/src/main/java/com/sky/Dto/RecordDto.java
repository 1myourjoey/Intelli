package com.sky.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecordDto {
	private String title;
	private long recordNum;
	private String content;
	private String status;
	private String time;
	private long userNum;
	private long storyId;
	public RecordDto(String content, String status, String time, long userNum, long storyId) {
		super();
		this.content = content;
		this.status = status;
		this.time = time;
		this.userNum = userNum;
		this.storyId = storyId;
	}
	
}
