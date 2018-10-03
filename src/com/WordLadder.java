package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	Queue<Node> nodeQueue = new LinkedList<Node>();
	HashSet<String> finishedWord = new HashSet<String>();

	public static void main(String args[]) {
		WordLadder wordLadder = new WordLadder();
		String beginWord = "hot";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));
	}

	class Node {
		String label;
		int val;

		public Node(String label, int val) {
			this.label = label;
			this.val = val;
		}
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		if (beginWord.equals(endWord)) {
			return 1;
		}
		List<Node> nodeList = new ArrayList<Node>();
		for (String word : wordList) {
			nodeList.add(new Node(word, -1));
		}
		nodeQueue.add(new Node(beginWord, 1));

		while (!nodeQueue.isEmpty()) {
			Node currentNode = nodeQueue.remove();
			for (Node node : nodeList) {
				if (isDifferenceOne(currentNode.label, node.label) && !node.label.equals(currentNode.label)
						&& !finishedWord.contains(node.label)) {
					if (node.val < currentNode.val + 1) {
						node.val = currentNode.val + 1;
						nodeQueue.add(node);
						finishedWord.add(node.label);
					}
				}
			}
		}
		for (Node node : nodeList) {
			if (node.label.equals(endWord) && node.val >= 0) {
				return node.val;
			}
		}
		return 0;
	}

	public boolean isDifferenceOne(String stringA, String stringB) {
		if (stringA.length() != stringB.length()) {
			return false;
		}
		int differenceCount = 0;
		for (int i = 0; i < stringA.length(); i++) {
			if (stringA.charAt(i) != stringB.charAt(i)) {
				differenceCount++;
			}
			if (differenceCount > 1) {
				return false;
			}
		}

		return true;
	}

}
