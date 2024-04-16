package com.sky._sb0416.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;

	@ElementCollection
	private List<String> options;
	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}

	public Question(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public Question(String title) {
		this.title = title;
	}
}
