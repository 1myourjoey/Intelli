package com.sky.transcription.Dto;

import lombok.*;

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

	public RecordDto(long recordNum, String title, String content, String status, String time, long userNum, long storyId) {
		this.recordNum = recordNum;
		this.title = title;
		this.content = content;
		this.status = status;
		this.time = time;
		this.userNum = userNum;
		this.storyId = storyId;
	}

	public RecordDto(String title, String content, String status, String time, long userNum, long storyId) {
		this.title = title;
		this.content = content;
		this.status = status;
		this.time = time;
		this.userNum = userNum;
		this.storyId = storyId;
	}

	public void setRecordNum(long recordNum) {
		this.recordNum = recordNum;
	}
}
