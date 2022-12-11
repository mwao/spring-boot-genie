package com.enm.genie.clip.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
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
}
