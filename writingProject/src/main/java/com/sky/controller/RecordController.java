package com.sky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sky.Dto.RecordDto;
import com.sky.Service.RecordService;


@Controller
public class RecordController {
	@Autowired
	RecordService recordService;


	@GetMapping("recordList")
	public String recordList(Model model) {
		List<RecordDto> records = recordService.selectAll();
		model.addAttribute("records", records);
		return "recordList";
	}

	//	@PostMapping("/insertRecord")
//    public String insertRecord(@RequestParam("secondTextbox") String content) {
//        // 받은 데이터로 RecordDto 객체 생성
//        RecordDto record = new RecordDto();
//        record.setContent(content);
//        // RecordService를 통해 데이터베이스에 삽입
//        recordService.insert(record);
//        // 삽입 후에는 다시 첫 페이지로 리다이렉트
//        return "redirect:/";
//    }
	@PostMapping("/insertRecord")
	public String insertRecord(@RequestParam("secondTextbox") String content) {
		// 받은 데이터로 RecordDto 객체 생성
		RecordDto record = new RecordDto();
		record.setContent(content);
		// RecordService를 통해 데이터베이스에 삽입
		recordService.insert(record);
		// 삽입 후에는 다시 첫 페이지로 리다이렉트
		return "redirect:/";
	}
}
