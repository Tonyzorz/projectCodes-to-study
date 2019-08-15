package com.bit.pet.model.dao;

import com.bit.pet.model.dto.UserBean;

public interface UserMapper {
	void insertUserData(UserBean userBean);
	UserBean loginCheck(UserBean userBean);
}