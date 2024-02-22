//package edu.pnu.persistence;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import edu.pnu.domain.User;
//
//public interface UserRepository extends JpaRepository<User, String> {
//	
////	@Modifying // @modifying 어노테이션은 트래젝션 내에서 실행 되어야 함. 즉 해당 메서드는 @Transactional 어노테이션을 적용해야됨.
////	@Query(value =
////			  "SELECT "
////			+ "FROM user "
////			+ "WHERE password = :password",
////			nativeQuery = true)
////	User PassWordCheck(@Param("board_seq")String password);
//	
//}
