package com.enm.genie.youtube.provider;

import com.enm.genie.youtube.dto.YoutubeDTO;
import com.google.api.services.youtube.model.PlaylistItem;

import java.util.List;

public interface YoutubeProvider {
    YoutubeDTO get();

    List<PlaylistItem> getlist();
}
