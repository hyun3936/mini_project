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
import edu.pnu.service.CmtService;

@RestController
public class CmtController {
	@Autowired
	private CmtService cmtService;
	
	@GetMapping("/board/{seq}/comments")
	public ResponseEntity<?> getCmt(Integer cmt_id){
		if (cmt_id == null)
			return ResponseEntity.ok(cmtService.getbCmts());
		return ResponseEntity.ok(cmtService.getCmt(cmt_id));
	}
	
	@PostMapping("/board/{seq}/comments")
	public ResponseEntity<?> addCmt(@RequestBody Comment cmt) {
		return ResponseEntity.ok(cmtService.add(cmt));
	}
	
	@PutMapping("/board/{seq}/comments")
	public ResponseEntity<?> updateCmts(@RequestBody Comment cmt) {
		return ResponseEntity.ok(cmtService.update(cmt));
	}
	
	@DeleteMapping("/board/{seq}/comments/{cmt_id}") // 파라미터로 받아서 하는 방법 // board/4 이런식으로 작성
	public ResponseEntity<?> deleteCmt(@PathVariable Integer cmt_id) {
		return ResponseEntity.ok(cmtService.delete(cmt_id));
	}
	
	
	
}
