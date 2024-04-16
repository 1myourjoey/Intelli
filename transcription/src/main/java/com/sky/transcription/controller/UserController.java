package com.sky.transcription.controller;


import com.sky.transcription.Dto.UserDto;
import com.sky.transcription.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

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
	@PostMapping("/registerInput")
	public String register(@RequestParam String id,
						   @RequestParam String password,
						   @RequestParam String name,
						   @RequestParam String email,
						   RedirectAttributes redirectAttributes) {
		// 사용자 등록
		userService.registerUser(id, password, name, email);

		// 등록 후 로그인 페이지로 이동 또는 다른 처리
		redirectAttributes.addFlashAttribute("registrationSuccess", "회원 가입이 완료되었습니다. 로그인 해주세요.");
		return "redirect:/login"; // 등록 후 로그인 페이지로 리다이렉트
	}

	@GetMapping("userList")
	public String userList(Model model) {
		List<UserDto> users = userService.selectAll();
		model.addAttribute("users", users);
		return "userList";
	}
//	@PostMapping("/login")
//	public String login(@RequestParam String id, @RequestParam String password, HttpSession session) {
//	    // 사용자 인증
//	    UserDto user = userService.authenticate(id, password);
//	    if (user != null) {
//	        // 사용자 인증에 성공한 경우 세션에 사용자 정보 저장
//	        session.setAttribute("user", user); // 세션에 사용자 정보 저장
//	        return "redirect:/"; // 로그인 후 이동할 페이지
//	    } else {
//	        return "redirect:/login?error=true"; // 인증 실패 시 에러 플래그와 함께 로그인 페이지로 리다이렉트
//	    }
//	}
@PostMapping("/login")
public String login(@RequestParam String id,
					@RequestParam String password,
					HttpSession session,
					RedirectAttributes redirectAttributes) {
	// 사용자 인증
	UserDto user = userService.authenticate(id, password);
	if (user != null) {
		// 사용자 인증에 성공한 경우 세션에 사용자 정보 저장
		session.setAttribute("user", user); // 세션에 사용자 정보 저장
		session.setAttribute("userId", user.getId()); // 세션에 사용자 ID 저장
		session.setAttribute("userName", user.getName()); // 세션에 사용자 이름 저장
		session.setAttribute("userEmail", user.getEmail()); // 세션에 사용자 이메일 저장
		return "redirect:/"; // 로그인 후 이동할 페이지
	} else {
		// 로그인 실패 시 에러 메시지를 전달하고 로그인 페이지로 리다이렉트
		redirectAttributes.addFlashAttribute("loginError", "로그인에 실패했습니다. 아이디와 비밀번호를 확인하세요.");
		return "redirect:/login";
	}
}
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션에서 사용자 정보 제거
        session.removeAttribute("user");
        // 로그아웃 후 리다이렉트할 페이지를 지정 (예: 로그인 페이지)
        return "redirect:/login";
    }
	@GetMapping("/myPage")
	public String myPage(Model model, HttpSession session) {
		// 세션에서 로그인된 사용자 정보 가져오기
		UserDto loggedInUser = (UserDto) session.getAttribute("user");

		// 세션에 로그인된 사용자 정보가 없으면 로그인 페이지로 이동
		if (loggedInUser == null) {
			return "redirect:/login";
		}

		// 사용자 정보를 모델에 추가
		model.addAttribute("userNum", loggedInUser.getUserNum());
		model.addAttribute("id", loggedInUser.getId());
		model.addAttribute("name", loggedInUser.getName());
		model.addAttribute("email", loggedInUser.getEmail());

		return "myPage";
	}
	@GetMapping("/myPageUpdate")
	public String editPage(Model model, HttpSession session) {
		// 세션에서 로그인된 사용자 정보 가져오기
		UserDto loggedInUser = (UserDto) session.getAttribute("user");

		// 세션에 로그인된 사용자 정보가 없으면 로그인 페이지로 이동
		if (loggedInUser == null) {
			return "redirect:/login";
		}

		// 사용자 정보를 모델에 추가
		model.addAttribute("userNum", loggedInUser.getUserNum());
		model.addAttribute("id", loggedInUser.getId());
		model.addAttribute("name", loggedInUser.getName());
		model.addAttribute("email", loggedInUser.getEmail());

		return "myPageUpdate"; // 수정 페이지로 이동
	}
	@PostMapping("/update")
	public String updateUser(@RequestParam Integer userNum,
							 @RequestParam(required = false) String newPassword,
							 @RequestParam(required = false) String newEmail,
							 HttpSession session,
							 RedirectAttributes redirectAttributes) {
		// 세션에서 로그인된 사용자 정보 가져오기
		UserDto loggedInUser = (UserDto) session.getAttribute("user");

		// 세션에 로그인된 사용자 정보가 없으면 로그인 페이지로 이동
		if (loggedInUser == null) {
			return "redirect:/login";
		}

		// 사용자 정보 업데이트
		userService.updateUser(userNum, newPassword, newEmail);

		// 업데이트 후 세션 정보 갱신
		loggedInUser = userService.findByUserNum(userNum);
		session.setAttribute("user", loggedInUser);
		session.setAttribute("userEmail", loggedInUser.getEmail());

		// 업데이트 성공 메시지 전달
		redirectAttributes.addFlashAttribute("updateSuccess", "정보가 업데이트되었습니다.");

		return "redirect:/myPage"; // 내 정보 페이지로 리다이렉트
	}
	@GetMapping("/checkEmail")
	public boolean checkEmail(@RequestParam String email) {
		// 이메일이 중복되는지 확인하는 서비스 메소드를 호출합니다.
		// 서비스 메소드는 데이터베이스에서 이메일을 검색하여 중복 여부를 확인합니다.
		boolean isEmailAvailable = userService.isEmailAvailable(email);
		return isEmailAvailable;
	}

}
