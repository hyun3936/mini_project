package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long > {

	// 쿼리 메소드 : 메소드 이름으로 필요한 쿼리를 만들어주는 기능
//	List<Board> findbyKeyword = null;

	
	
	// 네이티브 쿼리 메서드	
	// 제목에 포함된 키워드로 게시판 찾기 
	@Modifying // @modifying 어노테이션은 트래젝션 내에서 실행 되어야 함. 즉 해당 메서드는 @Transactional 어노테이션을 적용해야됨.
	@Query(value =
			  "SELECT * "
			  + "FROM board "
			  + "WHERE title LIKE %:keyword%" ,  // 'LIKE'연산자를 이용하여 부분 일치를 검색
			nativeQuery = true)
	List<Board> searchKeywordTitle(@Param("keyword")String keyword);

	
	
	@Modifying // @modifying 어노테이션은 트래젝션 내에서 실행 되어야 함. 즉 해당 메서드는 @Transactional 어노테이션을 적용해야됨.
	@Query(value =
			  "SELECT * "
			  + "FROM board "
			  + "WHERE content LIKE %:keyword%" ,
			nativeQuery = true)
	List<Board> searchKeywordContent(@Param("keyword")String keyword);



	@Modifying // @modifying 어노테이션은 트래젝션 내에서 실행 되어야 함. 즉 해당 메서드는 @Transactional 어노테이션을 적용해야됨.
	@Query(value =
			  "SELECT * "
			  + "FROM board "
			  + "WHERE writer LIKE %:keyword%" ,
			nativeQuery = true)
	List<Board> searchKeywordWriter(@Param("keyword")String keyword);


	
	@Modifying // @modifying 어노테이션은 트래젝션 내에서 실행 되어야 함. 즉 해당 메서드는 @Transactional 어노테이션을 적용해야됨.
	@Query(value =
			  "SELECT * "
			  + "FROM board "
			  + "WHERE create_date LIKE %:keyword%" ,
			nativeQuery = true)
	List<Board> getBoardKeywordDate(@Param("keyword")String keyword);



	Page<Board> findAllByOrderBySeqDesc(Pageable pageable);


	
	
	
	
	
	

}
