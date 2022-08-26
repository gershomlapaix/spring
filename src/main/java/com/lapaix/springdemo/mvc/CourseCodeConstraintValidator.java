package com.lapaix.springdemo.mvc;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapaix.springdemo.mvc.validation.CourseCode;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCode) {
		coursePrefix = theCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result = theCode.startsWith(coursePrefix);

		return result;
	}

}
