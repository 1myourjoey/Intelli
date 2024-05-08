package com.sky._sb0507.controller;


import com.sky._sb0507.spring.TestException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test/{num}")
    public String test(@PathVariable("num") int num) {
            log.info("num: {}", num);
            if(num==1){
                return "test/test1";
            } else if (num==2){
                return "test/test2";
            } else {
                return "redirect:/test";
            }

        }

        @GetMapping("/test")
        public String test() {
            System.out.println("=======test");

            return "test/error";
        }


    @ExceptionHandler(TypeMismatchException.class)
    public String handleTypeMismatchException() {
        return "member/invalidId";
    }

    }

