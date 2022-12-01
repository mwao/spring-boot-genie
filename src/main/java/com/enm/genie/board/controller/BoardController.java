package com.enm.genie.board.controller;

import com.enm.genie.board.dto.BoardDTO;
import com.enm.genie.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public List<?> boardList(@RequestParam(value = "programseq",defaultValue = "0")int param)throws Exception{

        return boardService.getBoardList(param);
    }
    @GetMapping("/view")
    public BoardDTO boardView(@RequestParam(value = "boardseq",required = true)int param)throws Exception{

        return boardService.getBoardView(param);
    }

    /*게시판 등록*/
    @PostMapping("/write")
    public void saveBoard(@RequestBody BoardDTO boardDTO) throws Exception{
        boardService.saveBoard(boardDTO);
    }
}
