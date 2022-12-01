package com.enm.genie.board.service;

import com.enm.genie.board.dao.BoardDAO;
import com.enm.genie.board.dto.BoardDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@MapperScan(basePackages = "com.enm.genie.board.dao")
@Service
public class BoardService {

    @Autowired
    private BoardDAO boardDAO;

    public List<BoardDTO> getBoardList(int programseq)throws Exception{
        List<BoardDTO> boardList=boardDAO.getBoardList(programseq);
        return boardList;
    }

    public BoardDTO getBoardView(int boardseq)throws Exception{
        BoardDTO boardView=boardDAO.getBoardView(boardseq);
        return boardView;
    }

    public void saveBoard(BoardDTO boardDTO) throws Exception{

        if(boardDTO.getBoardseq()==0) // 신규
        {
            boardDTO.setProgramseq(0);
            boardDTO.setDeleteYn("N");
            boardDAO.saveBoard(boardDTO);
        }
        else //수정
        {
            boardDAO.updateBoard(boardDTO);
        }
    }

}
