package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class SecurityController {
	@GetMapping("/") public String index() {return "index"; }
	@GetMapping("/admin") public String admin() {return "admin"; }
	@GetMapping("/manager") public String manager() {return "manager"; }
	@GetMapping("/member") public String member() {return "member"; }
	
}
