package json2pojo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonFactory factory = new JsonFactory();
		@SuppressWarnings("deprecation")
		JsonParser parser = factory.createJsonParser(new File("./data/sample.json"));
		City city = objectMapper.readValue(parser, City.class);
		
//		JsonNode json = objectMapper.readTree(Paths.get("./data/sample.json").toFile());
//		for (int i = 1; i <= 47; i++) {
//			String _no = "0" + i;
//			String no = _no.substring(_no.length() - 2);
//			JsonNode todohuken = json.get(no);
//		}
	}

}
