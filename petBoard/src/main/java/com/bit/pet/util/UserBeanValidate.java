package com.bit.pet.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bit.pet.model.dto.UserBean;

public class UserBeanValidate implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "trouble");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPw", "trouble");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail", "trouble");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPhoneNum", "trouble");
	}

}
