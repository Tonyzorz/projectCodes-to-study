package com.bit.pet.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bit.pet.model.dao.UserMapper;
import com.bit.pet.model.dto.UserBean;
import com.bit.pet.model.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	
	@Override
	public void signupCheck(UserBean userBean, BindingResult bindingResult) {
		userMapper.insertUserData(userBean);
	}

	@Override
	public boolean loginCheck(UserBean userBean) {
		
		return userMapper.loginCheck(userBean)!=null;
	}

}