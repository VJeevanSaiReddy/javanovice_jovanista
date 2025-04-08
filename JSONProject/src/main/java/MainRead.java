import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainRead {
    public static void main(String[] args) throws IOException {
        try(BufferedReader fileReader = new BufferedReader(new FileReader("employee1.json"))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line=null;
            String ls=System.getProperty("line.separator");
            while ((line=fileReader.readLine())!=null){
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            JSONObject obj1=new JSONObject(stringBuilder.toString());
            String name=obj1.getString("name");
            String title=obj1.getString("title");
            String department=obj1.getString("department");
            System.out.format("\n%s,%s,%s\n",name,title,department);
        }
    }
}
