package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepo;
	
	// 데이터들 전부 불러옴
	public List<Board> getbBoards() {
		return boardRepo.findAll();
	}

	// 데이터 내가 원하는 것만 id로 검색해서 가져옴
	public Board getBoard (Integer seq) {
		return boardRepo.findById(seq).get();
	}

	// 데이터 추가
	public Board add(Board board) {
		return boardRepo.save(board);
	}

	// 데이터를 수정할껀데 네임만 수정할 수도 있고, 패스만 수정 할 수 있다.
	// 그런데 하나만 수정했을 때 나머지가 null로 되면 안되고 원래값을 유지하도록
	
	// 데이터 수정 (ex. id=2, name=홍길동)
	public Board update(Board board) {
		 // 겟멈버 해서 일단 불러 온다음에 
		Board m = getBoard(board.getSeq()); //(seq값은 있는거 입력해줘야 그다음이 수정됨.)
		 // 내가 수정할 부분만 변경
		if (board.getTitle() != null)
				m.setTitle(board.getTitle());
		if (board.getContent() != null)
				m.setContent(board.getContent());
		if (board.getWriter() != null)
				m.setWriter(board.getWriter());

		return boardRepo.save(m);
	}

	public String delete(Integer seq) {
			try {
				if (boardRepo.existsById(seq) ) {
					boardRepo.deleteById(seq);
					return "삭제 성공";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "삭제 실패";
	}
}