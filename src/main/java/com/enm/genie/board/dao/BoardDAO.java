package com.enm.genie.board.dao;


import com.enm.genie.board.dto.BoardDTO;

import java.util.List;

public interface BoardDAO {

    /*게시판 리스트*/
    List<BoardDTO> getBoardList(int programseq) throws Exception;

    List<BoardDTO> getBoardList() throws Exception;
    /*게시판 상세*/
    BoardDTO getBoardView(int boardseq) throws Exception;
/*
    void saveBoard(BoardDTO boardDTO) throws Exception;

    *//*게시판 등록*//*
    BoardDTO saveBoard(int programseq) throws Exception;*/

    /*게시판 등록*/
    void saveBoard(BoardDTO boardDTO) throws Exception;

    void saveBoard() throws Exception;

    void updateBoard(BoardDTO boardDTO)throws Exception;

}
