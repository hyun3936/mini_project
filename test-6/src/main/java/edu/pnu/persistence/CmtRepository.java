package edu.pnu.persistence;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Comment;


public interface CmtRepository extends JpaRepository<Comment, Long >{

	
	// 게시글 삭제하면 해당 게시글에 달려있던 댓글들도 삭제되는 쿼리
	

	// 네이티브 쿼리 메서드	
	@Modifying // @modifying 어노테이션은 트래젝션 내에서 실행 되어야 함. 즉 해당 메서드는 @Transactional 어노테이션을 적용해야됨.
	@Query(value =
			  "DELETE "
			+ "FROM comment "
			+ "WHERE board_seq = :board_seq",
			nativeQuery = true)
	void deleteCmtToo(@Param("board_seq")Long board_seq);

	//DELETE 쿼리는 결과 세트를 반환하지 않기 때문에 List<Comment>를 반환할 필요가 없습니다. 그러므로 반환 유형을 void로 변경해야 합니다.
	
	
	
	 // 댓글 board_seq로 검색
	@Query(value = 
			"SELECT * "
			+ "FROM comment "
			+ "WHERE board_seq = :board_seq",
			nativeQuery = true)
	List <Comment> findByBoard_seq(@Param("board_seq")Long board_seq); 
	
	Optional<Comment> findByCmt_id(Long cmt_id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Query(value =
//			" INSERT INTO comment(board_seq) values(1) " , 
//			nativeQuery = true)
//	Comment insertComment(CommentInsertDTO cmt);
	
	
	// 특정 게시글의 모든 댓글 조회
//	@Query(value = 
//			  "SELECT *" 
//			+ "FROM comment "
//			+ "WHERE board_seq = :boardSeq",
//			nativeQuery = true) //value 속성에 실행하려는 쿼리 작성
//	List<Comment> findbyBoardSeq(int boardSeq);


	
	
//	@Query(value = 
//			 "DELETE "
//			+ "FROM comment "
//			+ "WHERE board_seq = :board_seq",
//			nativeQuery = true) 	
//	void deleteAllById(int board_seq);


}
