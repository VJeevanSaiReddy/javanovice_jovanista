import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JSONObject restaurant = new JSONObject();
        restaurant.put("name", "The Food Place");
        restaurant.put("location", "Downtown");

        JSONArray menu = new JSONArray();

        // Starters
        JSONObject starters = new JSONObject();
        starters.put("category", "Starters");

        JSONArray starterItems = new JSONArray();
        JSONObject item1 = new JSONObject();
        item1.put("name", "Spring Rolls");
        item1.put("price", 5.99);

        JSONObject item2 = new JSONObject();
        item2.put("name", "Garlic Bread");
        item2.put("price", 3.99);

        starterItems.put(item1);
        starterItems.put(item2);

        starters.put("items", starterItems);

        // Main Course
        JSONObject mainCourse = new JSONObject();
        mainCourse.put("category", "Main Course");

        JSONArray mainItems = new JSONArray();
        JSONObject item3 = new JSONObject();
        item3.put("name", "Margherita Pizza");
        item3.put("price", 11.99);

        JSONObject item4 = new JSONObject();
        item4.put("name", "Veg Burger");
        item4.put("price", 8.99);

        mainItems.put(item3);
        mainItems.put(item4);

        mainCourse.put("items", mainItems);

        // Add categories to menu
        menu.put(starters);
        menu.put(mainCourse);

        // Add menu to restaurant
        restaurant.put("menu", menu);

        // Print pretty JSON
        System.out.println(restaurant.toString(4));

        // Save to file
        try (FileWriter file = new FileWriter("restaurant.json")) {
            file.write(restaurant.toString(4)); // pretty printing
            System.out.println("Successfully saved to restaurant.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
