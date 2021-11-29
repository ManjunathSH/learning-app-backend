package com.virtualschool.learning.service;

import com.virtualschool.learning.entity.Board;
import com.virtualschool.learning.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public Optional<Board> getBoardById(Integer boardId) {
        return boardRepository.findById(boardId);
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }
}
