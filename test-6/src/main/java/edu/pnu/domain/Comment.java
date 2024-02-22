package edu.pnu.domain;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cmt_id; // 댓글 고유 코드
//	@Column // 해당 필드를 테이블의 속성으로 매핑
	private String cmt_content; // 댓글 본문
//	@Column // 해당 필드를 테이블의 속성으로 매핑
	private String cmt_writer; // 댓글 작성자
	@Builder.Default
	@Column(columnDefinition = "TIMESTAMP default current_timestamp")
//	private Date createDate = new Date(); // 날짜,시간.
	private LocalDateTime createDate = LocalDateTime.now();	
	
	// 여기다 cascade = all 하면 댓글 삭제할때 연관되어있는 테이블도 삭제해야 되기 때문에 외래키 참조 에러가 뜸. 그래서 안됨.
	@ManyToOne // Comment 엔티티와 Board 엔티티를 다대일 관계로 설정
	@JoinColumn(name = "board_seq") // Board 엔티티의 seq를 외래키로 지정할 것이므로 외래키 이름을 "board_seq"로 지음.
	private Board board; // 해당 댓글의 부모 게시글

	private String password; // 댓글 삭제전 확인용, 일회성 비밀번호
}
