package com.enm.genie.youtube.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class YoutubeDTO {
    private String title; // 동영상 제목
    private String thumbnailPath; //동영상 썸네일 경로
    private String videoId; // 동영상 식별 ID

    private String playUrl; //동영상 재생 url

    private String description;// 동영상 상세설명

//    @Builder(toBuilder = true)
//    public YoutubeDTO(String title, String thumbnailPath, String videoId) {
//        this.title = title;
//        this.thumbnailPath = thumbnailPath;
//        this.videoId = videoId;
//        return YoutubeDTO.builder();
//    }
}
