package edu.pnu.persistence;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.Comment;
import java.util.List;


public interface CmtRepository extends JpaRepository<Comment, Integer >{

	
	// 네이티브 쿼리 메서드
	
	// 특정 게시글의 모든 댓글 조회
	@Query(value = 
			  "SELECT *" 
			+ "FROM comment "
			+ "WHERE board_seq = :boardSeq",
			nativeQuery = true) //value 속성에 실행하려는 쿼리 작성
	List<Comment> findbyBoardSeq(int boardSeq);


}
