package com.sampl.prod.controller;

import java.text.DecimalFormat;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sampl.prod.exception.AmountNotLessThanOrEqualToZeroException;
import com.sampl.prod.model.DateValue;

@Controller
@RequestMapping("/simpleIntrest")
public class SimpleIntrestController {

	@GetMapping("/dateForm")
	public String dates(Model model) {
		model.addAttribute("dateV", new DateValue());
		return "date";
	}

	@PostMapping("/values")
	public String postValue(@ModelAttribute DateValue val, Model model) throws AmountNotLessThanOrEqualToZeroException {
		/*
		 * simple intrest formula si=p*r*t
		 */

		double priciple = val.getAmount();

		double convetDouble = val.getPercent() / 100; // convert double from percentage


		long daysBetwen = ChronoUnit.DAYS.between(val.getDate(), val.getToDates());

		double timeInyears = daysBetwen / 365.0;
		double totally = priciple * convetDouble * timeInyears;
		DecimalFormat deciml = new DecimalFormat("#.#"); // shorted to decimal value
		String formatted = deciml.format(totally);
		
		double convertToDouble= Double.parseDouble(formatted); //convert String to Double
		
         double totalAmount=convertToDouble+priciple; // added double and converted string
         int roundValue=(int) Math.round(totalAmount); //nearest Value print
		if (val.getAmount()> 0) {
			

			model.addAttribute("amt", val.getAmount());
			model.addAttribute("percnt", val.getPercent());
			model.addAttribute("dates", val.getDate());
			model.addAttribute("todat", val.getToDates());
		model.addAttribute("total", formatted);
		model.addAttribute("finalAmount",roundValue+" /-");
		return "makes";
			
		} 
		else {
			
			throw new AmountNotLessThanOrEqualToZeroException("Amount Should Not Be Zero And Less Than Equal To Zero");
		}

			

	}

}
