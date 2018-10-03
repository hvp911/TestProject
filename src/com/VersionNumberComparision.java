package com;

public class VersionNumberComparision {

	public static void main(String[] args) {
		VersionNumberComparision versionNumberComparision = new VersionNumberComparision();
		String version1 = "1.0.1";
		String version2 = "1";

		System.out.println(versionNumberComparision.compareVersion(version1, version2));
	}

	public int compareVersion(String version1, String version2) {
		int intToRet = 0;
		String[] versionSplit1 = version1.split("\\.");
		String[] versionSplit2 = version2.split("\\.");
		int[] v1Split;
		int[] v2Split;
		if (versionSplit1.length > versionSplit2.length) {
			v1Split = new int[versionSplit1.length];
			v2Split = new int[versionSplit1.length];
		} else {
			v1Split = new int[versionSplit2.length];
			v2Split = new int[versionSplit2.length];
		}
		for (int i = 0; i < v1Split.length; i++) {
			try {
				v1Split[i] = Integer.parseInt(versionSplit1[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				v1Split[i] = 0;
			}
			try {
				v2Split[i] = Integer.parseInt(versionSplit2[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				v2Split[i] = 0;
			}
		}
		for (int i = 0; i < v1Split.length; i++) {
			if (v1Split[i] == v2Split[i]) {
				intToRet = 0;
			} else if (v1Split[i] > v2Split[i]) {
				return 1;
			} else if (v1Split[i] < v2Split[i]) {
				return -1;
			}
		}
		return intToRet;
	}
}
