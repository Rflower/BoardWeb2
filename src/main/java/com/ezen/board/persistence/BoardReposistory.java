package com.ezen.board.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ezen.board.domain.Board;

public interface BoardReposistory extends CrudRepository<Board, Long> {

	@Query("SELECT b FROM Board b")
	Page<Board> getBoardList(Pageable pageable);
	
}
