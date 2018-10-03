package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.google.gson.Gson;

public class Combination {
	private HashSet<List<Integer>> allCombinations = new HashSet<List<Integer>>();

	public static void main(String[] args) {
		Combination combination = new Combination();
		List<List<Integer>> combinationList = combination.combine(5, 3);
		System.out.println(new Gson().toJson(combinationList).toString());
	}

	public List<List<Integer>> combine(int n, int k) {
		if (k > n || n <= 0 || k <= 0) {
			return new ArrayList<>(allCombinations);
		}
		ArrayList<Integer> currentList = new ArrayList<Integer>();
		currentList.add(1);
		insertCombinations(n + 1, k, 2, currentList);
		return new ArrayList<>(allCombinations);
	}

	public void insertCombinations(int n, int k, int currentN, List<Integer> currentList) {
		if (currentList.size() == k) {
			allCombinations.add(currentList);
		}
		if (currentN > n) {
			return;
		}
		for (int i = currentN; i <= n; i++) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			newList.add(i);
			ArrayList<Integer> contiunueList = new ArrayList<Integer>(currentList);
			contiunueList.add(i);
			if (i + 1 <= n) {
				if (contiunueList.size() <= k) {
					insertCombinations(n, k, i + 1, contiunueList);
				}
				if (n - i >= k) {
					insertCombinations(n, k, i + 1, newList);
				}
			}
		}
	}
}
