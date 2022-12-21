package com.enm.genie.clip.controller;

import com.enm.genie.board.dto.BoardDTO;
import com.enm.genie.clip.dto.ClipDTO;
import com.enm.genie.clip.service.ClipService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/page")
    public PageInfo<ClipDTO> findPage(HttpServletRequest request) throws Exception{
        PageHelper.startPage(request);
        System.out.println(request.getParameter("pageNum"));
        System.out.println(request.getParameter("pageSize"));
        System.out.println(request.getParameter("programseq"));
//        System.out.println(request.getParameterValues());
        if(request.getParameter("programseq")!=null){
            int programseq= Integer.parseInt(request.getParameter("programseq"));
            return PageInfo.of(clipService.getClipList(programseq));

        }else{
            return PageInfo.of(clipService.getClipList());

        }
//        return PageInfo.of(clipService.getClipList());
    }
    @GetMapping("/pagetest")
    public PageInfo<ClipDTO> findPageDTO(ClipDTO clipDTO) throws Exception{


        return PageInfo.of(clipService.getClipListDTO(clipDTO));
    }
}
