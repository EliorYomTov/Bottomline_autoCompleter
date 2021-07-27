package com.elior.autoCompletedApp.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TreeNode {
	private final char nullValue = 0;
	public char value = nullValue;
	private Map<Character, TreeNode> children = new HashMap<>();

	TreeNode(char letter) {
		this.value = letter;
	}

	public void add(Queue<Character> letters) {
		if (letters.isEmpty()) {
			children.put(nullValue, new TreeNode());
			return;
		}
		char nextLetter = letters.remove();
		if (!children.containsKey(nextLetter)) {
			children.put(nextLetter, new TreeNode(nextLetter));
		}
		TreeNode nextNode = children.get(nextLetter);
		nextNode.add(letters);
	}

	public TreeNode getSubTree(Queue<Character> letters) {
		if (letters.isEmpty()) {
			return this;
		}

		char nextLetter = letters.remove();
		if (!children.containsKey(nextLetter)) {
			return null;
		}
		TreeNode nextNode = children.get(nextLetter);
		return nextNode.getSubTree(letters);
	}

	public List<String> getWord() {
		List<String> words = new ArrayList<>();
		if (isALeaf()) {
			words.add("");
			return words;
		}
		for (TreeNode child : children.values()) {
			List<String> childWords = child.getWord();
			for (String childWord : childWords) {
				words.add(value + childWord);
			}
		}
		return words;
	}

	public boolean hashValue() {
		return nullValue != value;
	}

	public boolean isTheRoot() {
		return !hashValue() && children.size() > 0;
	}

	public boolean isALeaf() {
		return !hashValue() && !isTheRoot();
	}

	public String toString(int level) {
		StringBuilder outputString = new StringBuilder();
		for (int i = 0; i < level; i++) {
			outputString.append("   ");
		}
		outputString.append("|--");
		outputString.append(this.value).append(System.lineSeparator());
		for (Map.Entry<Character, TreeNode> entry : children.entrySet()) {
			outputString.append(entry.getValue().toString(level + 1));
		}
		return outputString.toString();
	}
}
