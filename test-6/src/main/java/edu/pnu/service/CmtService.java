package edu.pnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.domain.Comment;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.CmtRepository;

@Service
public class CmtService {

	@Autowired
	private CmtRepository cmtRepo;

	@Autowired
	private BoardRepository boardRepo; // 댓글을 생성할 때 대상 게시글의 존재 여부 파악하기 위해

	// 데이터들 전부 불러옴
	public List<Comment> getCmts(Long board_seq) {
		return cmtRepo.findByBoard_seq(board_seq);
	}

	// 데이터 내가 원하는 것만 id로 검색해서 가져옴
	public Comment getCmt(Long cmt_id) {
		return cmtRepo.findById(cmt_id).get();
	}

	// 데이터 추가
	public Comment add(Long board_seq, Comment cmt) {
		Optional<Board> opt = boardRepo.findById(board_seq);
		if (opt.isPresent() == false)
			return null;
		cmt.setBoard(opt.get());
		return cmtRepo.save(cmt);
	}

//	public Comment add(CommentInsertDTO cmt) {
//		return cmtRepo.insertComment(cmt);
//	}

	// 데이터를 수정할껀데 네임만 수정할 수도 있고, 패스만 수정 할 수 있다.
	// 그런데 하나만 수정했을 때 나머지가 null로 되면 안되고 원래값을 유지하도록

	// 데이터 수정 (ex. id=2, name=홍길동)
	public Comment update(Comment cmt) {
		// 겟멈버 해서 일단 불러 온다음에
		Comment m = getCmt(cmt.getCmt_id()); // (seq값은 있는거 입력해줘야 그다음이 수정됨.)
		// 내가 수정할 부분만 변경
		if (cmt.getCmt_content() != null)
			m.setCmt_content(cmt.getCmt_content());

		return cmtRepo.save(m);
	}

	// 삭제 오리지날 버전
//	public String deleteCmt(Long cmt_id) {
//			try {
//					cmtRepo.deleteById(cmt_id);
//					return "삭제 성공";
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return "삭제 실패";
//	}

	// 삭제 - 비번 확인 버전
	
	// 1. id로 일단 찾고 해당 댓글이 있는지 확인
	// 2. 작성자의 비밀번호가 일치한지 확인
	// 3. 일치하면 댓글 삭제
	
	
//	public String deleteCmt(Long cmt_id, String password) {
//		try {
//		//	Comment check = getCmt(cmt.getCmt_id());
//			if (cmt.getPassword() == password) {
//				if(cmtRepo.existsById(cmt_id))
//				cmtRepo.deleteById(cmt_id);
//				return "삭제 성공";
//				
//			} else {
//				return "비밀번호가 틀렸습니다. ";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "삭제 실패";
//		}
		
//		Optional<Comment> comment = cmtRepo.findById(cmt_id);
//	}

}