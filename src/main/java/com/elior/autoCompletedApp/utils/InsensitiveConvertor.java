package com.elior.autoCompletedApp.utils;

import org.springframework.core.convert.converter.Converter;

public class InsensitiveConvertor implements Converter<String, String> {

	@Override
	public String convert(String source) {
		try {
			return String.valueOf(source.toLowerCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}
}
