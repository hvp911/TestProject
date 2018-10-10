package com;

import java.util.ArrayList;

public class VersionNumberSort {

	public static void main(String[] args) {
		ArrayList<String> versionNumberStringList = new ArrayList<String>();
		String[] list = new String[] { "1.2.1", "1.2.1.0", "1.2.1", "1.2.53.2", "1.2.2", "1.2.4" };
		/*
		 * 1 1.0 1.0.0.1 1.0.1 1.1.1.1
		 */
		for (String l : list) {
			versionNumberStringList.add(l);
		}
		for (String s : versionNumberStringList) {
			System.out.println(s);
		}
		System.out.println();
		if (versionNumberStringList.size() != 1) {
			sort(versionNumberStringList, 0, versionNumberStringList.size() - 1);
		}
		for (String s : versionNumberStringList) {
			System.out.println(s);
		}
	}

	public static void sort(ArrayList<String> versionNumbers, int left, int right) {
		if (left < right) {
			int partitionIndex = partition(versionNumbers, left, right);
			sort(versionNumbers, left, partitionIndex - 1);
			sort(versionNumbers, partitionIndex + 1, right);
		}
	}

	public static int partition(ArrayList<String> versionNumbers, int left, int right) {
		String pivotValue = versionNumbers.get(left);
		int leftMark = left + 1;
		int rightMark = right;
		boolean done = false;

		while (!done) {
			while (leftMark <= rightMark && compareVersionNumbers(versionNumbers.get(leftMark), pivotValue)) {
				leftMark++;
			}
			while (!compareVersionNumbers(versionNumbers.get(rightMark), pivotValue) && rightMark >= leftMark) {
				rightMark--;
			}
			if (rightMark < leftMark) {
				done = true;
			} else {
				String temp = versionNumbers.get(leftMark);
				versionNumbers.set(leftMark, versionNumbers.get(rightMark));
				versionNumbers.set(rightMark, temp);
			}
		}
		String temp = versionNumbers.get(left);
		versionNumbers.set(left, versionNumbers.get(rightMark));
		versionNumbers.set(rightMark, temp);

		return rightMark;
	}

	private static boolean compareVersionNumbers(String version1, String version2) {
		String[] version1Partition = version1.split("\\.");
		String[] version2Partition = version2.split("\\.");
		int i = 0;
		while (i < version1Partition.length && i < version2Partition.length) {
			if (Integer.parseInt(version1Partition[i]) < Integer.parseInt(version2Partition[i])) {
				return true;
			} else if (Integer.parseInt(version1Partition[i]) > Integer.parseInt(version2Partition[i])) {
				return false;
			}
			i++;
		}
		if (i < version2Partition.length) {
			return true;
		} else {
			return false;
		}
	}
}
