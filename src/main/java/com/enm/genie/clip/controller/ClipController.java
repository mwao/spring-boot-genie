package com.enm.genie.clip.controller;

import com.enm.genie.clip.service.ClipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clip")
public class ClipController {
    @Autowired
    private ClipService clipService;

    @GetMapping("/list")
    public List<?> clipList(@RequestParam(value="programseq",defaultValue = "0")int param)throws Exception{
        return clipService.getClipList(param);
    }
}
