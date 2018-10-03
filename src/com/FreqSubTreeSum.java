package com;

import java.util.HashMap;
import java.util.HashSet;

public class FreqSubTreeSum {

	public static void main(String[] args) {

		HashMap<String, Boolean> m = new HashMap<>();
		HashSet<String> hs = new HashSet<String>();
		String x = "adasd";
		System.out.println(hs.add(x));
		System.out.println(hs.contains(x));
		System.out.println(hs.remove(x));
		System.out.println(hs.remove(x));
		m.put("1", false);
		m.remove("1");
	}

}
