package com.enm.genie.board.controller;

import com.enm.genie.board.dto.BoardDTO;
import com.enm.genie.board.service.BoardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/board")
public class BoardController {

    Logger logger= LoggerFactory.getLogger(getClass());

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

    @GetMapping("/page")
    public PageInfo<BoardDTO> findPage(HttpServletRequest request) throws Exception{
        PageHelper.startPage(request);
        logger.error("error 테스트 : "+logger.getName());
        logger.warn("warn 테스트 : "+logger.getName());
        return PageInfo.of(boardService.getBoardList());
    }

}
