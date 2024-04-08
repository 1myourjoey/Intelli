package com.sky.transcription2.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor

@ToString
public class FairyTaleDto {

	private long storyId;
	private String title;
	private String content;
	private String rate;
	private String writer;
	public FairyTaleDto(String title, String content, String rate, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.rate = rate;
		this.writer = writer;
	}
	
	
	
}
