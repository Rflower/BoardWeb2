package com.ezen.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ezen.board.domain.Board;
import com.ezen.board.persistence.BoardReposistory;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardReposistory boardRepo;

	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);

	}

	@Override
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		
		boardRepo.save(findBoard);

	}

	@Override
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());

	}

	@Override
	public Board getBoard(Board board) {
		// TODO Auto-generated method stub
		return boardRepo.findById(board.getSeq()).get();
	}

	@Override
	public Page<Board> getBoardList() {
		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
		Page<Board> pageList = boardRepo.getBoardList(pageable);
		
		return pageList;
	}

}
