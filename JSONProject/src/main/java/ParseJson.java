import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParseJson {
    public static void main(String[] args) throws IOException {
        System.out.println("Parsing JSON Large file");
        JSONParser parser = new JSONParser();
        try(FileReader fileReader = new FileReader("restaurant.json")) {
            Object obj=parser.parse(fileReader);
//            ParsingHandler parsingHandler=new ParsingHandler();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
