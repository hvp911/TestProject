package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

public class DigiWatch {
	public static void main(String[] args) {
		DigiWatch digiWatch = new DigiWatch();
		List<String> returnedData = digiWatch.readBinaryWatch(1);
		System.out.println(new Gson().toJson(returnedData));
	}

	private List<String> readBinaryWatch(int num) {
		List<String> returnedData = new ArrayList<String>();

		HashMap<Integer, ArrayList<String>> turnedOnLedHours = new HashMap<Integer, ArrayList<String>>();
		HashMap<Integer, ArrayList<String>> turnedOnLedMinutes = new HashMap<Integer, ArrayList<String>>();

		for (int i = 0; i < 12; i++) {
			updateTurnedOnLedHoursMap(turnedOnLedHours, i);
		}
		for (int i = 0; i < 60; i++) {
			updateTurnedOnLedMinutesMap(turnedOnLedMinutes, i);
		}
		if (num == 0) {
			returnedData.add("0:00");
		}
		for (int i = 1; i <= num; i++) {
			if (num - i >= 0) {
				ArrayList<String> possibleHours = turnedOnLedHours.get(i);
				ArrayList<String> possibleMinutes = turnedOnLedMinutes.get(num - i);
				if (possibleHours != null) {
					for (String possibleHour : possibleHours) {
						if (possibleMinutes != null) {
							for (String possibleMinute : possibleMinutes) {
								returnedData.add(possibleHour + ":" + possibleMinute);
							}
						} else {
							returnedData.add(possibleHour + ":00");
						}
					}
				}
				possibleHours = turnedOnLedHours.get(num - i);
				possibleMinutes = turnedOnLedMinutes.get(i);
				if (possibleMinutes != null) {
					for (String possibleMinute : possibleMinutes) {
						if (possibleHours != null) {
							for (String possibleHour : possibleHours) {
								returnedData.add(possibleHour + ":" + possibleMinute);
							}
						} else {
							returnedData.add("0:" + possibleMinute);
						}
					}
				}
			}
		}

		return returnedData;

	}

	private void updateTurnedOnLedHoursMap(HashMap<Integer, ArrayList<String>> turnedOnLedHours, int i) {
		int occurance = 0;
		for (char c : Integer.toString(i, 2).toCharArray()) {
			if (c == "1".charAt(0)) {
				occurance++;
			}
		}
		ArrayList<String> hoursList = new ArrayList<>();
		if (turnedOnLedHours.containsKey(occurance)) {
			hoursList = turnedOnLedHours.get(occurance);
		} else {
			turnedOnLedHours.put(occurance, hoursList);
		}
		hoursList.add("" + i);
	}

	private void updateTurnedOnLedMinutesMap(HashMap<Integer, ArrayList<String>> turnedOnLedMinutes, int i) {
		int occurance = 0;
		for (char c : Integer.toString(i, 2).toCharArray()) {
			if (c == "1".charAt(0)) {
				occurance++;
			}
		}
		ArrayList<String> minutesList = new ArrayList<>();
		if (turnedOnLedMinutes.containsKey(occurance)) {
			minutesList = turnedOnLedMinutes.get(occurance);
		} else {
			turnedOnLedMinutes.put(occurance, minutesList);
		}
		if (i < 10) {
			minutesList.add("0" + i);
		} else {
			minutesList.add("" + i);
		}
	}
}
