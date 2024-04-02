package com.sky.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sky.Dto.UserDto;
import com.sky.Service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@GetMapping("register")
	public String register() {
		return "register";
	}

	@GetMapping("userList")
	public String userList(Model model) {
		List<UserDto> users = userService.selectAll();
		model.addAttribute("users", users);
		return "userList";
	}
	@PostMapping("/login")
	public String login(@RequestParam String id, @RequestParam String password, HttpSession session) {
	    // 사용자 인증
	    UserDto user = userService.authenticate(id, password);
	    if (user != null) {
	        // 사용자 인증에 성공한 경우 세션에 사용자 정보 저장
	        session.setAttribute("user", user); // 세션에 사용자 정보 저장
	        return "redirect:/"; // 로그인 후 이동할 페이지
	    } else {
	        return "redirect:/login?error=true"; // 인증 실패 시 에러 플래그와 함께 로그인 페이지로 리다이렉트
	    }
	}
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션에서 사용자 정보 제거
        session.removeAttribute("user");
        // 로그아웃 후 리다이렉트할 페이지를 지정 (예: 로그인 페이지)
        return "redirect:/login";
    }
}
