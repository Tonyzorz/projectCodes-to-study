package com.bit.pet.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bit.pet.model.dto.JournalBoardBean;

public class JBoardValid implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return JournalBoardBean.class.isAssignableFrom(clazz) ;
	}

	@Override
	public void validate(Object target, Errors errors) {
		String title = "제목을 입력하세요";
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jbTitle", title);
	}

	
}
