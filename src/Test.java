import com.fasterxml.jackson.databind.ObjectMapper;
import common.Cache;
import common.Constants;
import common.Utils;
import entities.templates.FoodTemplate;
import net.sf.json.JSONObject;

import java.util.*;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        manualInit();
        init();
        display();
    }

    public static void init() {
        Utils.init("resources/test.txt");
    }

    public static void manualInit(){
        Utils.initAll(manualConfig());
    }

    public static JSONObject manualConfig(){
        JSONObject jsonObject = new JSONObject();
        List<FoodTemplate> foodTemplates = new ArrayList<>();
        foodTemplates.add(new FoodTemplate(1, "MAOLIANG1", 299, 3, 20, 1));
        foodTemplates.add(new FoodTemplate(1, "MAOLIANG1", 299, 3, 20, 1));
        foodTemplates.add(new FoodTemplate(1, "MAOLIANG1", 299, 3, 20, 1));
        jsonObject.put(Constants.KEY_FOODS, foodTemplates);
        return jsonObject;
    }

    public static void display() throws Exception {
        Map<String, Object> map = Cache.getData();
        SortedMap<String, Object> sortedMap = new TreeMap<>();
        map.forEach(sortedMap::put);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sortedMap);
        System.out.println(s);
    }
}
