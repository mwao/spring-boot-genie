package com.enm.genie.clip.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClipDTO {
    private int clipseq;
    private int programseq;
    private String thumbnail;
    private String title;
    private String description;
    private String playUrl;
   // private String playTime;

    private String videoId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    //paging
    private int pageNum;
    private int pageSize;
    private String clipType;
}
