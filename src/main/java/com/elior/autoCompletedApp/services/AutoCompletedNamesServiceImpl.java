package com.elior.autoCompletedApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.elior.autoCompletedApp.dto.PrefixTree;
import com.elior.autoCompletedApp.entities.Name;
import com.elior.autoCompletedApp.repos.NameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutoCompletedNamesServiceImpl implements AutoCompletedNamesService {

	private final NameRepository nameRepository;

	@Override
	public List<String> getAllMatchingNames(String prefix) {
		if (containsNotOnlyLetters(prefix)) {
			throw new IllegalArgumentException();
		}
		List<Name> names = nameRepository.findAll();
		PrefixTree tree = new PrefixTree();
		names.forEach(name -> tree.add(name.getName()));
		List<String> matches = tree.getMatches(prefix);
		List<String> output = new ArrayList<>();
		names.stream().filter(name -> matches.contains(name.getName().toLowerCase())).collect(Collectors.toList())
				.forEach(name -> output.add(name.getName()));
		return output;
	}

	private boolean containsNotOnlyLetters(String str) {
		if (!Pattern.matches("[a-zA-Z]+", str))
			return true;
		return false;
	}
}
