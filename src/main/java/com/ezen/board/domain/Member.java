package com.ezen.board.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "boardList")
@Entity
public class Member {

	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	private String password;
	private String name;
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<Board> boardList = new ArrayList<Board>();
	//한명의 member는 여러개의 board를 만들 수 있기에 일대 다에서 '다' 에 해당하는 board를 가져올때
	// 리스트로 가져오게된다.
}
