package com.ezen.board.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ezen.board.domain.Member;
import com.ezen.board.persistence.MemberRepository;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private MemberRepository memberRepo;
	
	public UserDetailsService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> optional = memberRepo.findById(username);
		
		if(optional.isPresent()) {
			Member member = optional.get();
			return new UserSecurity(member);
		}else {
			throw new UsernameNotFoundException(username+ "사용자 없음");

		}
	}

}
