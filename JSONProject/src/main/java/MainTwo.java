import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainTwo {
    public static void main(String[] args)throws IOException {
        JSONObject obj=new JSONObject();
        obj.put("name","peter");
        obj.put("age",23);
        obj.put("id",12134);
        System.out.println(obj+"\tHey\n");
        System.out.println(obj.toString());
        try(FileWriter fileWriter = new FileWriter("employee.json")) {
            obj.write(fileWriter,2,0);
        }
        Map<String,String> map=new HashMap<>();
        map.put("name","peter");
        map.put("title","VicePresident");
        map.put("department","Sales");
        JSONObject obj1=new JSONObject(map);
        System.out.println(obj1.toString());
        try(FileWriter fileWriter = new FileWriter("employee1.json")) {
            obj1.write(fileWriter,2,0);
        }
    }
}
