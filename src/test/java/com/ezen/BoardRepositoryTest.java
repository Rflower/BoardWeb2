package com.ezen;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezen.board.domain.Board;
import com.ezen.board.domain.Member;
import com.ezen.board.domain.Role;
import com.ezen.board.persistence.BoardReposistory;
import com.ezen.board.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	 private BoardReposistory boardRepo;
	
//	@Test
//	public void testInsert() {
//		
//		Member member1 = new Member();
//		member1.setId("member1");
//		member1.setPassword("member123");
//		member1.setName("이순신");
//		member1.setRole(Role.ROLE_MEMBER);
//		member1.setEnabled(true);
//		
//		memberRepo.save(member1);
//		
//		Member member2 = new Member();
//		member2.setId("member2");
//		member2.setPassword("member456");
//		member2.setName("장보고");
//		member2.setRole(Role.ROLE_ADMIN);
//		member2.setEnabled(true);
//		
//		memberRepo.save(member2);
//		
//		for(int i=1; i<=3; i++) {
//			
//			Board board = new Board();
//			board.setMember(member1);
//			board.setTitle(member1.getName()+" 글 "+ i);
//			board.setContent(member1.getName()+" 글 내용 "+i);
//			
//			boardRepo.save(board);
//		}
//		
//		for(int i=1; i<=3; i++) {
//			
//			Board board = new Board();
//			board.setMember(member2);
//			board.setTitle(member2.getName()+" 글 "+ i);
//			board.setContent(member2.getName()+" 글 내용 "+i);
//			
//			boardRepo.save(board);
//		}
//	}
	
	@Test
	public void testGetboard() {
	
		Board board = boardRepo.findById(1L).get();
		
		System.out.println(board.toString());
	}
	
	@Test
	public void testGetboardList() {
		Member member = memberRepo.findById("member1").get();
		
		for(Board board : member.getBoardList()) {
			System.out.println(">>>"+ board);
		}
	}
}
