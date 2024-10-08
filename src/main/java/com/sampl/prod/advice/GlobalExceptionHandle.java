package com.sampl.prod.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sampl.prod.exception.AmountNotLessThanOrEqualToZeroException;
import com.sampl.prod.model.DateValue;

@ControllerAdvice
public class GlobalExceptionHandle {
	
	@ExceptionHandler(AmountNotLessThanOrEqualToZeroException.class)
	public String exception(AmountNotLessThanOrEqualToZeroException ex,Model model) {
		model.addAttribute("errorMsg", ex.getLocalizedMessage());
		model.addAttribute("dateV", new DateValue());
		return "date";
		
	}

}
