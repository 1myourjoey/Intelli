package com.sky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sky.model.Product;
import com.sky.service.ProductService;

@Controller
public class MyController {
	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("userName", "홍길동");
		model.addAttribute("aaa", "가나다");
		model.addAttribute("product", productService.getProductById(1l));
		return "main";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", productService.getAllProducts());
		return "list";
	}

	@GetMapping("/save")
	public String save(@RequestParam String prodName, @RequestParam Integer prodPrice) {
	    // 제품명과 가격을 이용하여 Product 객체 생성
	    Product product = new Product(prodName, prodPrice);
	    
	    // ProductService를 사용하여 생성된 Product 객체를 저장
	    productService.addProduct(product);
	    
	    // 저장된 Product 객체를 모델에 추가하여 뷰로 전달
	    return "save";
	}
	

}
