package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Comment;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.service.CmtService;

@RestController
public class CmtController {
	@Autowired
	private CmtService cmtService;
	
	// 1. 게시판에 달린 모든 댓글 호출 
	
	@GetMapping("/board/{board_seq}/comments")
	public ResponseEntity<?> getCmts(@PathVariable Long board_seq){
			return ResponseEntity.ok(cmtService.getCmts(board_seq));
	}
	
	// 2. 댓글 작성
	@PostMapping("/board/{board_seq}/comments")
	public ResponseEntity<?> addCmt(@RequestBody Comment cmt,@PathVariable Long board_seq) {
		Comment newCmt = cmtService.add(board_seq, cmt);
		// 게시판이 없는데 댓글이 달릴 수는 없음.
		// ex) board_seq가 3이면 3게시판에 댓글이 달리는건데
		if (newCmt != null)
			return ResponseEntity.ok(newCmt);
		return ResponseEntity.badRequest().build();
	}

	// 3. 댓글 수정
	@PutMapping("/board/comments") 
	public ResponseEntity<?> updateCmts(@RequestBody Comment cmt) {
		return ResponseEntity.ok(cmtService.update(cmt));
	}
	
//	// 4. 댓글 삭제 - 오리지날 버전
//	@DeleteMapping("/board/comments/{cmt_id}") // 파라미터로 받아서 하는 방법 // board/comments/4 이런식으로 작성
//	public ResponseEntity<?> deleteCmt(@PathVariable Long cmt_id) {
//		return ResponseEntity.ok(cmtService.deleteCmt(cmt_id));
//	}
	
	// 4. 댓글 삭제 - 비번 확인 버전
	// localhost:8080/board/comments/1?password={password}
		@DeleteMapping("/board/comments/{cmt_id}") // 파라미터로 받아서 하는 방법 // board/comments/4 이런식으로 작성
		public ResponseEntity<?> deleteCmt(@PathVariable Long cmt_id, @RequestParam String password) {
			return ResponseEntity.ok(cmtService.deleteCmt(cmt_id, password));
		}
		
	
}
