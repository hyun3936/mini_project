package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

	
	// 네이티브 쿼리 메서드	
	// 제목에 포함된 키워드로 게시판 찾기 
	
	
	
	// 키워드에 해당하는 게시글 가져오기
	
	
	
	// 3-1. 가게 이름 title 검색
	@Modifying // @modifying 어노테이션은 트래젝션 내에서 실행 되어야 함. 즉 해당 메서드는 @Transactional 어노테이션을 적용해야됨.
	@Query(value =
			  "SELECT * "
			  + "FROM getfoodkr "
			  + "WHERE title LIKE %:keyword%" ,  // 'LIKE'연산자를 이용하여 부분 일치를 검색
			nativeQuery = true)
	List<Food> foodSearchKeywordTitle(@Param("keyword")String keyword);

	
	// 3-2. 상세 주소 addr1 검색
	@Modifying // @modifying 어노테이션은 트래젝션 내에서 실행 되어야 함. 즉 해당 메서드는 @Transactional 어노테이션을 적용해야됨.
	@Query(value =
			  "SELECT * "
			  + "FROM getfoodkr "
			  + "WHERE addr1 LIKE %:keyword%" ,
			nativeQuery = true)
	List<Food> foodSearchKeywordAddr(@Param("keyword")String keyword);


	// 3-3. 지역 구 검색
	@Modifying // @modifying 어노테이션은 트래젝션 내에서 실행 되어야 함. 즉 해당 메서드는 @Transactional 어노테이션을 적용해야됨.
	@Query(value =
			  "SELECT * "
			  + "FROM getfoodkr "
			  + "WHERE gugun_nm LIKE %:keyword%" ,
			nativeQuery = true)
	List<Food> foodSearchKeywordGugunNum(@Param("keyword")String keyword);


	// 3-4. 가게 소개글
	@Modifying // @modifying 어노테이션은 트래젝션 내에서 실행 되어야 함. 즉 해당 메서드는 @Transactional 어노테이션을 적용해야됨.
	@Query(value =
			  "SELECT * "
			  + "FROM getfoodkr "
			  + "WHERE itemcntnts LIKE %:keyword%" ,
			nativeQuery = true)
	List<Food> foodSearchKeywordDateItemCntnts(@Param("keyword")String keyword);

	
	// 3-5. 대표 메뉴로 검색
	@Modifying // @modifying 어노테이션은 트래젝션 내에서 실행 되어야 함. 즉 해당 메서드는 @Transactional 어노테이션을 적용해야됨.
	@Query(value =
			  "SELECT * "
			  + "FROM getfoodkr "
			  + "WHERE rprsntv_menu LIKE %:keyword%" ,
			nativeQuery = true)
	List<Food> foodSearchKeywordRepresentMenu(@Param("keyword")String keyword);

	
	
	
}
