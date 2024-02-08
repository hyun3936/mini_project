package edu.pnu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder

//@JsonIgnoreProperties("boardList")

public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int User_Code;
	private String User_ID;
	private String User_PW;
	private String User_Name;
	@Enumerated(EnumType.STRING) // 해당 열거형 상수를 문자열로 데이터베이스에 저장하도록 지정하는 옵션
	private Role User_Role;
}
