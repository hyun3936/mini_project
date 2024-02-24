package edu.pnu.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter // 각 필드 값을 조회할 수 있는 GETTER 메서드 자동 생성
@Setter
@ToString // 모든 필드를 출력할 수 있는 toString 메서드 자동 생성
@Builder
@AllArgsConstructor	// 모든 필드를 매개변수로 갖는 생성자 자동 생성
@NoArgsConstructor // 매개변수가 아예 없는 기본 생성자 자동 생성
@Entity	// 해당 클래스가 엔티티임을 선언, 클래스 필드를 바탕으로 DB에 테이블 생성
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_seq")//데이터베이스에서의 이름을 정의
    private Long seq;	// 번호
    private String title; // 제목
    private String writer; // 작성자
    private String content; // 내용
    private String password; // 게시글 비밀번호
    
    @Builder.Default // 객체에 디폴트값
    @Column(columnDefinition = "TIMESTAMP default current_timestamp") // 디비에 디폴트값 설정, 이 코드 없이 MySQL에서 인서트문으로 데이터 추가하면 null값이 들어감.
//    private Date createDate = new Date(); // 날짜,시간.
    private LocalDateTime createDate = LocalDateTime.now();
    @Builder.Default
    @Column(columnDefinition = "BIGINT default 0")
    private Long cnt = 0L; // 조회수
    
    
    @OneToMany(cascade=CascadeType.ALL) // 게시글 삭제하면 거기 달려있던 댓글도 같이 삭제
    private List<Comment> cmts; 

 
}