package com.bit.pet.model.service;

import org.springframework.validation.BindingResult;

import com.bit.pet.model.dto.UserBean;

public interface UserService {
	void signupCheck(UserBean userBean, BindingResult bindingResult);
	boolean loginCheck(UserBean userBean);
}