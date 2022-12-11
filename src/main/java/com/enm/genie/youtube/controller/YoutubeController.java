package com.enm.genie.youtube.controller;

import com.enm.genie.youtube.dto.YoutubeDTO;
import com.enm.genie.youtube.provider.YoutubeProvider;
import com.enm.genie.youtube.service.YoutubeService;
import com.google.api.services.youtube.model.PlaylistItem;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/youtube")
public class YoutubeController {
    private YoutubeProvider youtubeProvider;

    private YoutubeService youtubeService;

    public YoutubeController(final YoutubeProvider youtubeProvider){
        this.youtubeProvider=youtubeProvider;
    }

    @GetMapping("/get")
    public YoutubeDTO Index(){
        System.out.println(youtubeProvider.get());
        return youtubeProvider.get();
    }

    @GetMapping("/getlist")
    public List<PlaylistItem> list(){
        System.out.println(youtubeProvider.getlist());
        return youtubeProvider.getlist();
    }

}
