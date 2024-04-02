package com.sky._sb0401;

import com.sky._sb0401.entity.Memo;
import com.sky._sb0401.repository.MemoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@SpringBootTest
class Sb0401ApplicationTests {
	@Autowired
	MemoRepository memoRepository;
	@Test
	void contextLoads() {
		System.out.println(memoRepository.getClass().getName());
	}
	@Test
	@DisplayName("Memo Insert Test")
	void insertMemo(){
	Memo memo = Memo.builder()
			.memoText("this is for test")
			.build();
	memoRepository.save(memo);
	}
	@Test
	@DisplayName("Making Test DATA")
	void insertMemos(){
		IntStream.rangeClosed(1,10).forEach(i->{
			System.out.println(i);
			Memo memo = Memo.builder()
					.memoText("this is for test"+i)
					.build();
		memoRepository.save(memo);
		});


	}
	@Test
	@Transactional
	void selectMemos(){
		Long mno = 10L;
		Memo memo = memoRepository.getOne(mno);
		System.out.println(memo);
	}
}
