package main;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws IOException {
		Map<String, String> cityMap = new LinkedHashMap<>();
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode json = objectMapper.readTree(Paths.get("./data/sample.json").toFile());
		// System.out.println(json);

		for (int i = 1; i <= json.size(); i++) {
			String _no = "0" + i;
			String no = _no.substring(_no.length() - 2);
			JsonNode todohuken = json.get(no);
			System.out.println(todohuken);
			String id = todohuken.get("id").asText();
			String name = todohuken.get("short").asText();
			JsonNode cityNode = todohuken.get("city");
			for (int j = 0; j < cityNode.size(); j++) {
				String _cityno = "0" + j;
				String cityno = _cityno.substring(_cityno.length() - 2);
				String pref = name + cityno;
				String city = cityNode.get(j).get("city").asText();
				cityMap.put(pref, city);
			}
		}
		print(cityMap);
	}

	private static void print(Map<String, String> cityMap) {
		cityMap.forEach((key, value) -> {
			System.out.println(key + ":" + value);
		});
	}
}
