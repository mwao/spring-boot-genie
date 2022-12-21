package com.enm.genie.clip.service;

import com.enm.genie.clip.dao.ClipDAO;
import com.enm.genie.clip.dto.ClipDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Clip;
import java.util.List;

@MapperScan(basePackages = "com.enm.genie.clip.dao")
@Service
public class ClipService {
    @Autowired
    private ClipDAO clipDAO;

    public List<ClipDTO> getClipList(int programseq) throws Exception{
        List<ClipDTO> clipList = clipDAO.getClipList(programseq);
        return clipList;
    }
    public List<ClipDTO> getClipListDTO(ClipDTO clipDTO) throws Exception{
//        clipDTO.setClipseq(0);
        List<ClipDTO> clipList = clipDAO.getClipListDTO(clipDTO);
        return clipList;
    }
    public List<ClipDTO> getClipList() throws Exception{
        List<ClipDTO> clipList = clipDAO.getClipList();
        return clipList;
    }
}
