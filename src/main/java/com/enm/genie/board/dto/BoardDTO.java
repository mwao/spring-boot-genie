package com.enm.genie.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BoardDTO {
    private int boardseq;
    private int programseq;
    private String title;
    private String contents;
    private String name;
    private String deleteYn;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private String updateDateStr;
}
