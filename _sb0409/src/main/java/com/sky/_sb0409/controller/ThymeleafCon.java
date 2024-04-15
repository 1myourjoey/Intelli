package com.sky._sb0409.controller;

import com.sky._sb0409.spring.DuplicateMemberException;
import com.sky._sb0409.spring.MemberRegisterService;
import com.sky._sb0409.spring.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ThymeleafCon {
    @Autowired
    MemberRegisterService memberRegisterService;
    @GetMapping("/")
    public String mainPage() {

        return "main";
    }
    @GetMapping ("/step1")
	public String handleStep1() {
        return "step1";
    }

    @PostMapping("/step2")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		if (!agree) {
			return "/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "/step2";
	}

	@GetMapping("/step2")
	public String handleStep2Get() {
		return "/step1";
	}

	@PostMapping("/step3")
	public String handleStep3(RegisterRequest regReq) {
		try {
			memberRegisterService.regist(regReq);
			return "/step3";
		} catch (DuplicateMemberException ex) {
			System.out.println("DuplicateMemberException 발생!!!");
			return "/step2";
		}
	}

	@ModelAttribute
	public void case1(Model model){
		model.addAttribute("value1", "High High");
	}
	@ModelAttribute("value2")
	public String case2(){
		return "It's glad to see u";
	}
}
