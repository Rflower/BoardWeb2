package com.ezen.board.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.ezen.board.domain.Member;

public class UserSecurity extends User {
	
	public UserSecurity(Member member) {
		super(member.getId(), "{noop}"+member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		// TODO Auto-generated constructor stub
	}

}
