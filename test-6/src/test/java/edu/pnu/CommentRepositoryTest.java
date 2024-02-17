//package edu.pnu;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import edu.pnu.domain.Board;
//import edu.pnu.domain.Comment;
//import edu.pnu.persistence.CmtRepository;
//
//@DataJpaTest // 해당 클래스를 JPA와 연동해 테스팅
//public class CommentRepositoryTest {
//	@Autowired
//	CmtRepository commentRepository;
//	
//	@Test
//	@DisplayName("특정 게시글의 모든 댓글 조회")
//	void findbyBoardSeq() {
//		/* Case 1: 4번 게시글의 모든 댓글 조회 */
//		// 1. 입력 데이터 준비
//		int boardseq = 1;
//		// 2. 실제 데이터
//		List<Comment> comments = commentRepository.findbyBoardSeq(boardseq);
//		// 3. 예상 데이터
////		Board board = new Board(1,"하하", "헤헤","하하", 1L);
////		Comment a = new Comment(1, "첫번째 댓글입니다.", "짱구", board);
////		Comment b = new Comment(2, "두번째 댓글입니다.", "짱아", board);
////		Comment c = new Comment(3, "세번째 댓글입니다.", "맹구", board);
////		List<Comment> expected = Arrays.asList(a, b, c);
//		
//		// 4. 비교 및 검증
////		assertEquals(expected.toString(), comments.toString(), "1번 글의 모든 댓글을 출력!");
//		
//		
//		
//		
//		
//		
//		
//	}
//}
