//package edu.pnu.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import edu.pnu.domain.User;
//import edu.pnu.persistence.UserRepository;
//
//@Service
//public class UserService {
//
//	@Autowired
//	private UserRepository userRepo;
//	
//	
//	// 1. 유저가 댓글 작성시 임시 비밀번호 설정. (유저네임, 비밀번호)
//	// 2. 댓글 삭제시 비밀번호가 동일하면 삭제 가능
//	// 3. 그러기 위해서는 디비에 검색해서 같은지 확인해야함. 유저네임 = 비밀번호 ?
//	// 4. 유저네임은 기본키
//	// 5. if 조건문으로 같으면 삭제 else 그대로.
//	
//	public User userCheck(String password) {
////		if (userRepo.
////				)
//			return null;
//		
//	}
//	
//	
//}
