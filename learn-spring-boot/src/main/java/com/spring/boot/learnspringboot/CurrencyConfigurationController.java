package com.spring.boot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("configurations")
public class CurrencyConfigurationController {

	@Autowired
	CurrencyServiceConfiguration currencyServiceConfiguration;

	@GetMapping("currency-service")
	public CurrencyServiceConfiguration getCurrencyServiceConfiguration() {
		return currencyServiceConfiguration;
	}

}
