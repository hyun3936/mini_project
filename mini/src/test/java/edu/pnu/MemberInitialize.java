package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class MemberInitialize {
	@Autowired
	private MemberRepository memRepo; //Table Member CRUD 인터페이스
	
	PasswordEncoder encoder = new BCryptPasswordEncoder(); //비밀번호 암호화 인터페이스/구현체
	
	@Test
	public void test1() {
		memRepo.save(Member.builder()
				.User_ID("OP")
				.User_PW(encoder.encode("abcd"))
				.User_Name("YOON")
				.User_Role(Role.ROLE_ADMIN)
				.build());
		memRepo.save(Member.builder()
				.User_ID("GG")
				.User_PW(encoder.encode("abcd"))
				.User_Name("SEOK")
				.User_Role(Role.ROLE_MANAGER)
				.build());
		memRepo.save(Member.builder()
				.User_ID("HH")
				.User_PW(encoder.encode("abcd"))
				.User_Name("HYUN")
				.User_Role(Role.ROLE_MEMBER)
				.build());
	}

}

