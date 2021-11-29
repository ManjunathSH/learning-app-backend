package com.virtualschool.learning.controller;

import com.virtualschool.learning.entity.Board;
import com.virtualschool.learning.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @PostMapping(path = "/api/board/save")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public Board saveBoard(@RequestBody Board board) {
        return boardService.saveBoard(board);
    }

    @GetMapping(path = "/api/board/{boardId}")
//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Optional<Board> getBoardById(@PathVariable(name = "boardId") Integer boardId) {
        return boardService.getBoardById(boardId);
    }

    @GetMapping(path = "/api/board/")
//    @PreAuthorize("hasAnyRole('USER')")
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }
}
