package com.sky._sb0419;

import com.sky._sb0419.entity.Notice;
import com.sky._sb0419.repository.NoticeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.stream.IntStream;

@SpringBootTest
class Sb0419ApplicationTests {
    @Autowired
    NoticeRepository noticeRepository;

    @Test
    void contextLoads() {
        IntStream.rangeClosed(1, 100).forEach(i->{
            Notice notice = Notice.builder()
                    .title("제목"+i)
                    .content("내용"+i)
                    .build();
            noticeRepository.save(notice);
        });
        Pageable pageable = PageRequest.of(0,10);
        Page<Notice> result = noticeRepository.findAll(pageable); // 10개씩 해서 페이지에 넣는다

        System.out.println(result);
        System.out.println("---------------------");
        System.out.println("총 페이지 :"+result.getTotalPages());
        System.out.println("현재 페이지 :"+result.getNumber());
        System.out.println("다음 페이지 있나? :"+result.hasNext());
        System.out.println("---------------------");
        System.out.println(noticeRepository.selectCount());
        System.out.println("---------------------");
    }

}
