package com.enm.genie.test.dao;

import java.util.List;

import com.enm.genie.test.dto.UserDTO;

public interface UserDAO {
	List<UserDTO> selectUsers(UserDTO param) throws Exception;
}
