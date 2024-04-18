package com.sky.chap11mvc1.controller;

import com.sky.chap11mvc1.entity.MemberEntity;
import com.sky.chap11mvc1.repository.MemberBatisDao;
import com.sky.chap11mvc1.spring.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @Autowired
    MemberBatisDao memberBatisDao;

    @GetMapping("/select")
    @ResponseBody
    public Member select() {
        return memberBatisDao.selectByEmail("admin@korea.com");
    }

    @GetMapping("/count")
    @ResponseBody
    public int count() {
        return memberBatisDao.countDao();
    }

    @GetMapping("/")
    public String main() {
        return "main";
    }
}
