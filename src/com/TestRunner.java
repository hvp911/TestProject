package com;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.midi.Synthesizer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringEscapeUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

public class TestRunner {

	private static class Test {
		String x = "asdas";

	}

	public static void main(String[] args) throws Exception {
		System.out.println("Hello world");
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><cardDataPayload><schemaVersion><MajorVersion>1</MajorVersion><MinorVersion>1</MinorVersion><Revision>1</Revision></schemaVersion><cardReaderType>Proximity</cardReaderType><cardData><proximityCardData><vendorID>0x0c27</vendorID><productID>0x3bfa</productID><proxDataSize>10</proxDataSize><proxData>1048864924</proxData></proximityCardData></cardData></cardDataPayload>";
		Pattern pattern = Pattern.compile("<\\?xml.*?>");
		Matcher matcher = pattern.matcher(xml);
		if (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println(xml.substring(matcher.end()));
			// do something with matcher.group(1));
		}

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder
				.parse(new InputSource(new StringReader(StringEscapeUtils.unescapeXml(xml))));

		System.out.println(document.getDocumentElement());

		String readString = "pme = pmp";
		readString = readString.replaceAll("\\s=\\s", "=");
		System.out.println(readString);
		System.out.println(new Gson().toJson(null).toString());
		int[] test = { 2, 7, 11, 15 };
		int target = 9;
		HashMap<Integer, Integer> hashMapV = new HashMap<Integer, Integer>();
		for (int x : test) {
			hashMapV.put(x, x);
		}
		for (int x : test) {
			int reducedTarget = target - x;
			if (reducedTarget > 0 && hashMapV.containsKey(reducedTarget)) {
				System.out.println(x + " << == >>" + reducedTarget);
				break;
			}
		}

		String J = "aA";
		String S = "aAAbbb";
		int counter = 0;
		HashMap<Character, Character> jewlSet = new HashMap<Character, Character>();
		for (char c : J.toCharArray()) {
			jewlSet.put(c, c);
		}
		for (char c : S.toCharArray()) {
			if (jewlSet.containsKey(c)) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}
