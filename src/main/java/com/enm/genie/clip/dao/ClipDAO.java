package com.enm.genie.clip.dao;

import com.enm.genie.clip.dto.ClipDTO;

import java.util.List;

public interface ClipDAO {

    List<ClipDTO> getClipList(int programseq) throws Exception;

    List<ClipDTO> getClipListDTO(ClipDTO clipDTO) throws Exception;

    List<ClipDTO> getClipList() throws Exception;
}
