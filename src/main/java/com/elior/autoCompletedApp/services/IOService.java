package com.elior.autoCompletedApp.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class IOService {

	public List<String> getNamesFromTextFile() throws IOException {
		ArrayList<String> list = new ArrayList<>();
		InputStream is = this.getClass().getResourceAsStream("/static/BoyNames.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader buffReader = new BufferedReader(isr);
		buffReader.lines().map(s -> s.split(System.lineSeparator())).flatMap(Arrays::stream)
				.collect(Collectors.toList()).forEach(name -> list.add(name));
		return list;
	}
}
