package com.enm.genie.youtube.dao;

import com.enm.genie.youtube.dto.YoutubeDTO;

import java.util.List;

public interface YoutubeDAO {


    // youtube playlistitem 등록
//    void saveYoutube(List<PlaylistItem> playlistItems) throws Exception;
    void saveYoutube(List<YoutubeDTO> youtubeDTOS) throws Exception;
}
