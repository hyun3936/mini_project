package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Comment;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.service.CmtService;

@RestController
public class CmtController {
	@Autowired
	private CmtService cmtService;
	
	// 1. 댓글 조회 : 굳이 필요한가?
	@GetMapping("/board/comments")
	public ResponseEntity<?> getCmt(Long cmt_id){
		if (cmt_id == null)
			return ResponseEntity.ok(cmtService.getbCmts());
		return ResponseEntity.ok(cmtService.getCmt(cmt_id));
	}
	
	// 2. 댓글 작성
	@PostMapping("/board/comments")
	public ResponseEntity<?> addCmt(@RequestBody Comment cmt) {
		return ResponseEntity.ok(cmtService.add(cmt));
	}

	// 3. 댓글 수정
	@PutMapping("/board/comments") 
	public ResponseEntity<?> updateCmts(@RequestBody Comment cmt) {
		return ResponseEntity.ok(cmtService.update(cmt));
	}
	
	// 4. 댓글 삭제
	@DeleteMapping("/board/comments/{cmt_id}") // 파라미터로 받아서 하는 방법 // board/comments/4 이런식으로 작성
	public ResponseEntity<?> deleteCmt(@PathVariable Long cmt_id) {
		return ResponseEntity.ok(cmtService.deleteCmt(cmt_id));
	}
	
}
