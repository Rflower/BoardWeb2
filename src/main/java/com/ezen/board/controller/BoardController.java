package com.ezen.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.board.domain.Board;
import com.ezen.board.domain.Member;
import com.ezen.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model) {
		List<Board> pageList = boardService.getBoardList().getContent();
		model.addAttribute("boardList",  pageList);
		
		return "board/getBoardList";
	}
	
	@RequestMapping("/getBoard")
	public String getBoard(Model model, Board board) {
		model.addAttribute("board", boardService.getBoard(board));
		
		return "board/getBoard";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "board/insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		Member member = new Member();
		
		member.setId("member1");
		//로그인 구현 전이기 떄문에 임이의 멤버 객체에다가 저장해서 새글을 등록
		board.setMember(member);
		
		boardService.insertBoard(board);
		
		return "redirect:getBoardList";
	}
	
	@RequestMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		
		return "redirect:getBoardList";
	}
	
	@RequestMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		System.out.println("seq="+ board.getSeq());
		boardService.deleteBoard(board);
		
		return "redirect:getBoardList";
	}
}
