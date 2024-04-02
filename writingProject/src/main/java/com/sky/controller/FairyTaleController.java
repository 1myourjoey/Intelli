
package com.sky.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sky.Dto.FairyTaleDto;
import com.sky.Service.FairyTaleService;


@Controller
public class FairyTaleController {
	  @Autowired
	    private FairyTaleService fairyTaleService;

//	    @GetMapping("/")
//	    public String home(Model model) {
//	        List<FairyTaleDto> fairyTaleList = fairyTaleService.selectAll();
//	        model.addAttribute("fairyTaleList", fairyTaleList);
//	        return "index";
//	    }

@GetMapping("/")
public String content(Model model) {

	FairyTaleDto randomFairyTale = fairyTaleService.selectRandom();
	model.addAttribute("randomFairyTale", randomFairyTale);

	long randomStoryId = randomFairyTale.getStoryId();

	FairyTaleDto selectedFairyTale = fairyTaleService.selectByStoryId(randomStoryId);
	model.addAttribute("selectedFairyTale", selectedFairyTale);

	return "index";
}
	 
}
