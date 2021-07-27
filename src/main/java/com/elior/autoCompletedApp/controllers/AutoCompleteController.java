package com.elior.autoCompletedApp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elior.autoCompletedApp.services.AutoCompletedNamesService;

import lombok.RequiredArgsConstructor;

@RestController // localHost:8080/names
@RequestMapping("/names")
@RequiredArgsConstructor
public class AutoCompleteController {
	private final AutoCompletedNamesService autoCompletedNamesService;

	@GetMapping("/{prefix}")
	public ResponseEntity<?> getAllNamesByPrefix(@PathVariable String prefix) {
		return new ResponseEntity<>(autoCompletedNamesService.getAllMatchingNames(prefix), HttpStatus.OK);
	}
}
