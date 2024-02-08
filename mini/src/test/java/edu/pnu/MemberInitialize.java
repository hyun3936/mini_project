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
	MemberRepository memRepo; //Table Member CRUD 인터페이스
	
	PasswordEncoder encoder = new BCryptPasswordEncoder(); //비밀번호 암호화 인터페이스/구현체
	
	@Test
	public void dowork() {
		memRepo.save(Member.builder()
				.id("member")
				.password(encoder.encode("abcd"))
				.role(Role.ROLE_MEMBER)
				.build());
		memRepo.save(Member.builder()
				.user("manager")
				.password(encoder.encode("abcd"))
				.role(Role.ROLE_MANAGER)
				.name.build());
				
		memRepo.save(Member.builder()
				.username("admin")
				.password(encoder.encode("abcd"))
				.role(Role.ROLE_ADMIN)
				.name.build());	
	}
}
