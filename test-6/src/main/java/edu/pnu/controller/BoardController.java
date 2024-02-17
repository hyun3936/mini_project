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
	
	
	// ResponseEntity는 REST컨트롤러의 반환형, 즉 REST API의 응답을 위해 사용하는 클래스입니다.
	// API 요청을 받아 응답할 때 이 클래스에서 HTTP 상태 코드, 헤더, 본문을 실어 보낼 수 있습니다.
	
	//<?>는 어떤 유형의 데이터든 응답으로 반환될 수 있음을 의미합니다.
	
	// 게시글 목록 가져오기
	@GetMapping("/board")
	public ResponseEntity<?> getBoard(){
			return ResponseEntity.ok(boardService.getBoards());
	}
	
	// 게시글 상세보기
	@GetMapping("/board/{seq}")
	public ResponseEntity<?> getBoard(@PathVariable Long seq){
		return ResponseEntity.ok(boardService.getBoard(seq));
	}

	// 새로운 게시글 작성
	@PostMapping("/board")
	public ResponseEntity<?> addBoard(@RequestBody Board board) {
		return ResponseEntity.ok(boardService.add(board));
	}
	
	// 게시글 수정
	@PutMapping("/board")
	public ResponseEntity<?> updateBoards(@RequestBody Board board) {
		return ResponseEntity.ok(boardService.update(board));
	}
	
	// 게시글 삭제 (+ 그 게시판에 달려있던 댓글도 같이 삭제)
	@DeleteMapping("/board/{seq}") // 파라미터로 받아서 하는 방법 // board/4 이런식으로 작성
	public ResponseEntity<?> deleteBoard(@PathVariable Long seq) {
		return ResponseEntity.ok(boardService.delete(seq));
	}
	
	
	
}
