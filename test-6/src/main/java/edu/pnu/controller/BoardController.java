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

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@RestController
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public ResponseEntity<?> getBoard(Integer seq){
		if (seq == null)
			return ResponseEntity.ok(boardService.getbBoards());
		return ResponseEntity.ok(boardService.getBoard(seq));
	}
	
	@PostMapping("/board")
	public ResponseEntity<?> addBoard(@RequestBody Board board) {
		return ResponseEntity.ok(boardService.add(board));
	}
	
	@PutMapping("/board")
	public ResponseEntity<?> updateBoards(@RequestBody Board board) {
		return ResponseEntity.ok(boardService.update(board));
	}
	
	@DeleteMapping("/board/{seq}") // 파라미터로 받아서 하는 방법 // board/4 이런식으로 작성
	public ResponseEntity<?> deleteBoard(@PathVariable Integer seq) {
		return ResponseEntity.ok(boardService.delete(seq));
	}
	
	
	
}
