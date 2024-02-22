//package edu.pnu.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import edu.pnu.service.UserService;
//
//@RestController
//public class UserController {
//	@Autowired
//	private UserService userServ;
//	
//	
//	// 작성자의 임시 비밀번호 "체크" 
//	@GetMapping("/userCheck")
//	public ResponseEntity<?> passwordCheck(String password){
//		return ResponseEntity.ok(userServ.userCheck(password));
//	}
//	
//	
//	
//	
//}
