package com.elior.autoCompletedApp.dto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrefixTree {
	TreeNode root = new TreeNode();

	public void add(String word) {
		word = word.toLowerCase();
		Queue<Character> letters = toCharacterQueue(word);
		root.add(letters);
	}

	public TreeNode getSubTree(String prefix) {
		prefix = prefix.toLowerCase();
		Queue<Character> letters = toCharacterQueue(prefix);
		return root.getSubTree(letters);
	}

	public List<String> getMatches(String prefix) {
		// get the sub tree for the prefix
		TreeNode subTreeRoot = getSubTree(prefix);
		List<String> matches = new ArrayList<>();
		if (subTreeRoot == null) {
			return matches;
		}
		// get all suffixes
		matches = subTreeRoot.getWord();
		prefix = prefix.substring(0, prefix.length() - 1);
		// add prefix to suffix
		for (int i = 0; i < matches.size(); i++) {
			String suffix = matches.get(i);
			matches.set(i, prefix + suffix);
		}
		return matches;
	}

	private Queue<Character> toCharacterQueue(String word) {
		Queue<Character> queue = new LinkedList<Character>();
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			queue.add(letter);
		}
		return queue;
	}

	@Override
	public String toString() {
		return root.toString(0);
	}
}
