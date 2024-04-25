package com.sky.transcription.controller;


import com.sky.transcription.Dto.RecordDto;
import com.sky.transcription.Dto.UserDto;
import com.sky.transcription.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class RecordController {
	@Autowired
	private RecordService recordService;



	@GetMapping("recordList")
	public String recordList(Model model) {
		List<RecordDto> records = recordService.selectAll();
		model.addAttribute("records", records);
		return "recordList";
	}


	@PostMapping("/insertRecord")
	public String insertRecord(@RequestParam("secondTextbox") String content,
							   @RequestParam("randomFairyTaleTitle") String randomFairyTaleTitle,
							   @RequestParam("userNum") Integer userNum,
							   @RequestParam("storyId") Long storyId,
							   Model model) { // Model 객체를 파라미터로 받음

		// 받은 데이터로 RecordDto 객체 생성
		RecordDto record = new RecordDto();
		record.setTitle(randomFairyTaleTitle);
		record.setContent(content);
		record.setUserNum(userNum); // 사용자의 userNum 설정
		record.setStoryId(storyId);
		// RecordService를 통해 데이터베이스에 삽입
		recordService.insert(record);

		// 삽입 후에는 생성된 레코드의 recordNum 값을 ModelAndView에 추가하여 JSP로 전달
		model.addAttribute("recordNum", record.getRecordNum());

		// 삽입 후에는 다시 첫 페이지로 리다이렉트
		return "redirect:/";
	}

	@GetMapping("/personal")
	public String showPersonalRecords(Model model, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login"; // 사용자가 로그인하지 않았을 때 로그인 페이지로 리다이렉트
		}

		// 사용자의 레코드 가져오기
		List<RecordDto> personalRecords = recordService.getRecordsByUserNum(user.getUserNum());
		model.addAttribute("personalRecords", personalRecords);

		return "personal"; // 개인 페이지로 이동
	}
	@PostMapping("/deleteRecords")
	public String deleteRecords(@RequestParam("recordIds") List<Integer> recordIds) {
		recordService.deleteRecords(recordIds);
		return "redirect:/myPage"; // 삭제 후에는 적절한 리다이렉트를 설정합니다.
	}

}
