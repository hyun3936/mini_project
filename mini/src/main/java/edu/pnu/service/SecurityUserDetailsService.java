package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService{
	
	@Autowired private MemberRepository memRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loadUserByUsername(String username) 이게 AuthenticationManager의 authenticate 메소드가 호출되면 실행
		
		
		
		Member member = memRepo.findById(null)
								.orElseThrow(()->new UsernameNotFoundException("Not Found!"));
		
		
		return new User(member.getUser_ID(), member.getUser_PW(),
				AuthorityUtils.createAuthorityList(member.getUser_Role().toString()));}
}
