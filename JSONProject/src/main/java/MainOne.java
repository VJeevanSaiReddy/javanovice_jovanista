import org.json.JSONArray;
import org.json.JSONObject;

public class MainOne {
    public static void main(String[] args) {
        JSONObject restaurant = new JSONObject();
        restaurant.put("name", "The Food Place");
        restaurant.put("location", "Downtown");

        JSONArray menu = new JSONArray();

        JSONArray starters = new JSONArray();
        starters.put(createItem("Spring Rolls", 5.99));
        starters.put(createItem("Garlic Bread", 3.99));
        menu.put(createCategory("Starters", starters));

        JSONArray mainCourse = new JSONArray();
        mainCourse.put(createItem("Margherita Pizza", 11.99));
        mainCourse.put(createItem("Veg Burger", 8.99));
        menu.put(createCategory("Main Course", mainCourse));

        restaurant.put("menu", menu);

        System.out.println(restaurant.toString(4));
    }

    public static JSONObject createItem(String name, double price) {
        JSONObject item = new JSONObject();
        item.put("name", name);
        item.put("price", price);
        return item;
    }

    public static JSONObject createCategory(String categoryName, JSONArray items) {
        JSONObject category = new JSONObject();
        category.put("category", categoryName);
        category.put("items", items);
        return category;
    }
}
