package com.billies_works.pref_reader;

import java.io.IOException;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode json = objectMapper.readTree(Paths.get("./data/sample.json").toFile());
		// System.out.println(json);

		for (int i = 1; i <= 47; i++) {
			String _no = "0" + i;
			String no = _no.substring(_no.length() - 2);
			JsonNode todohuken = json.get(no);
			System.out.println(todohuken);
			String id = todohuken.get("id").asText();
			String name = todohuken.get("short").asText();
			JsonNode cityNode = todohuken.get("city");
			for (int j = 0; j < cityNode.size(); j++) {
				System.out.println(cityNode.get(j).get("city"));
//				System.out.println("id:" + id + "は" + name + " " + city);
			}
		}
		/*
		JsonNode obj01 = json.get("01");
		System.out.println(obj01);
		JsonNode obj01node = obj01.get("id");
		System.out.println(obj01node);
		*/
	}
}
