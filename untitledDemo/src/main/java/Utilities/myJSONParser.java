package Utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class myJSONParser {

    JSONObject jsonObject;

    public myJSONParser() throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        FileReader reader=new FileReader("src/test/resources/jsonFiles/sampleJSON.json");
        Object obj=jsonParser.parse(reader);
        jsonObject=(JSONObject) obj;
    }

    public String account(String parameter){
        JSONObject accountObj=(JSONObject) jsonObject.get("account");
        return (String)accountObj.get(parameter);
    }

    public String contact(String parameter){
        JSONObject contactObj=(JSONObject) jsonObject.get("contact");
        return (String)contactObj.get(parameter);
    }


}
